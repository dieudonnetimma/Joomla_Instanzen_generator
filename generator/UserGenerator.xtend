package de.thm.icampus.cjsl.generator

import de.thm.icampus.cjsl.cjsl.User
import org.eclipse.emf.common.util.EList
import de.thm.icampus.cjsl.cjsl.Application
import de.thm.icampus.cjsl.cjsl.cJSL_Configuration
import de.thm.icampus.cjsl.cjsl.UserGroup
import de.thm.icampus.cjsl.cjsl.ViewLevel
import java.util.logging.Handler
import java.util.HashMap

class UserGenerator extends ApplicationGenerator {
	
	
	EList<User> allusers
	cJSL_Configuration conf
	Application app
	EList<UserGroup> groups
	EList<ViewLevel> views
	int startIndexUser
	int startIndexGroup

new( Application apps) {
		
		app = apps
		allusers = apps.cjsl_user.user
		conf= apps.cjsl_configuration
		groups = apps.cjsl_user.usergroups
		views= apps.cjsl_user.viewlevel
		
	}
	 
	

  public def CharSequence generateAllUser ()'''
  INSERT INTO `#__users` (`id`, `name`, `username`, `email`, `password`, `usertype`, `block`, `sendEmail`, `registerDate`, `lastvisitDate`, `activation`, `params`, `lastResetTime`, `resetCount`) VALUES
  «FOR user : allusers»
  «IF(user.equals(allusers.get(allusers.size-1)))»
  (« indexOf(user,allusers,200,0)»,'«user.fullname»', '«user.name»', '«user.email»', '«genaratePass»', ' ', '«valueParser(isEmpty(user.blocked,'no'))»', '«valueParser(isEmpty(user.receiveSystemMail,'no'))
  	»', '«searchDateTime()»', '0000-00-00 00:00:00','0','{"admin_style":"«getTemplateid(user.backendTemplateStyle, conf.template)»","admin_language":"«selectedLanguage(user.backendLanguage)»","language":"«selectedLanguage(user.frontendLanguage)»","editor":"«selectedEdit(user.editor)»","helpsite":"http:\/\/help.joomla.org\/proxy\/index.php?option=com_help&keyref=Help{major}{minor}:{keyref}","timezone":"«isEmpty(searchattribut(user.time_zone,"continent"),"de")»"\\/"«isEmpty(searchattribut(user.time_zone,"country"),"DE")»"}','0000-00-00 00:00:00','0');
  «ELSE»
   («indexOf(user,allusers,200,0)»,'«user.fullname»', '«user.name»', '«user.email»', '«genaratePass»', ' ', '«valueParser(isEmpty(user.blocked,'no'))»', '«valueParser(isEmpty(user.receiveSystemMail,'no'))
  	»', '«searchDateTime()»', '0000-00-00 00:00:00','0','{"admin_style":"«getTemplateid(user.backendTemplateStyle, conf.template)»","admin_language":"«selectedLanguage(user.backendLanguage)»","language":"«selectedLanguage(user.frontendLanguage)»","editor":"«selectedEdit(user.editor)»","helpsite":"http:\/\/help.joomla.org\/proxy\/index.php?option=com_help&keyref=Help{major}{minor}:{keyref}","timezone":"«isEmpty(searchattribut(user.time_zone,"continent"),"de")»"\\/"«isEmpty(searchattribut(user.time_zone,"country"),"DE")»"}','0000-00-00 00:00:00','0'),
  «ENDIF»
  «ENDFOR»'''
  
  public def CharSequence generateUserProfile()'''
  
  INSERT INTO `#__user_profiles` (`user_id`, `profile_key`, `profile_value`, `ordering`) VALUES
   «FOR user : allusers»
    «var int counter =0»
   «FOR attribut: user.userProfile.userAttribute»
   «IF(attribut.equals(user.userProfile.userAttribute.get(user.userProfile.userAttribute.size -1)))»
   ('«indexOf(user,allusers,200,0)»', 'profile.«attribut.name»', '«attribut.value»', '«counter=counter+1»');
   «ELSE»
    ('«indexOf(user,allusers,200,0)»', 'profile.«attribut.name»', '«attribut.value»', '«counter=counter+1»'),
   «ENDIF»
   «ENDFOR»
   «ENDFOR»'''
   
   public def CharSequence generateGroups(EList<BaumElement> baum)'''
   
   UPDATE `#__usergroups` SET `rgt` = «searchElem(baum, -1).parent» WHERE `id` =1;
   
   INSERT INTO `#__usergroups` ( `parent_id`, `lft`, `rgt`, `title`) VALUES 
   «FOR group: groups»
   «IF(group.equals(groups.get(groups.size-1)))»
   ('«indexOf(group.parent,groups,9,1)»', '«searchElem(baum, groups.indexOf(group)).lft»', '«searchElem(baum, groups.indexOf(group)).rgt»', '«group.name»');
   «ELSE»
   ('«indexOf(group.parent,groups,9,1)»', '«searchElem(baum, groups.indexOf(group)).lft»', '«searchElem(baum, groups.indexOf(group)).rgt»', '«group.name»'),
   «ENDIF»
   «ENDFOR»'''
   
   public def CharSequence generateUserGroupsMap()'''
   
   INSERT INTO `#__user_usergroup_map` (`user_id`, `group_id`) VALUES 
    «FOR user : allusers»
    «FOR group: groups»
    «IF user.usergroup.contains(group)»
    «IF(user.equals(allusers.get(allusers.size-1)))»
    ('«indexOf(user,allusers,200,0)»', '«indexOf(group,groups,9,1)»');
  	«ELSE»
    ('«indexOf(user,allusers,200,0)»', '«indexOf(group,groups,9,1)»'),
  	«ENDIF»
   «ENDIF»
   «ENDFOR»
   «ENDFOR»'''
   
   public def CharSequence generateViewLevel()'''
   «var int count = 3»
   INSERT INTO `#__viewlevels` (`title`, `ordering`, `rules`) VALUES 
   «FOR ViewLevel view: views»
   «IF(view.equals(views.get(views.size-1)))»
   ('«view.name»', '«count=count+1»', '[«searchGroupsIDForViewLevel(view)»]');
   «ELSE»
   ('«view.name»', '«count=count+1»', '[«searchGroupsIDForViewLevel(view)»]'),
   «ENDIF»
   «ENDFOR»'''
   
   public def CharSequence generateGroupsCoreAcess()'''
   UPDATE `#__assets` SET 
   `rules` = 
   '''
   
   public def String searchGroupsIDForViewLevel(ViewLevel level){
   	
   	var String result = new String()
   	var int counter =0;
   	for(UserGroup group: groups){
   		var int in
   		if(level.usergroup.contains(group)){
   			counter = counter +1 
   			in  = indexOf(group,groups,9,1);
   			if(counter >= level.usergroup.size ){
   			  result = result + in;
   			  }else{
   			  	 result = result + in+",";
   			  }
   		}
   	}
   
   	return result
   }
   
   
	
}