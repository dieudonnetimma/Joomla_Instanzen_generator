package de.thm.icampus.cjsl.generator

import de.thm.icampus.cjsl.cjsl.User
import org.eclipse.emf.common.util.EList
import de.thm.icampus.cjsl.cjsl.Application
import de.thm.icampus.cjsl.cjsl.cJSL_Configuration
import org.eclipse.xtext.generator.IFileSystemAccess

class UserGenerator extends SQLGenerator {
	
	
	EList<User> allusers
	cJSL_Configuration conf

new(IFileSystemAccess acc, Application app) {
		super(acc, app)
		allusers = app.cjsl_user.user
	}
	 
	

  public def CharSequence generateAllUser ()'''
  INSERT INTO `#__users` (`id`, `name`, `username`, `email`, `password`, `usertype`, `block`, `sendEmail`, `registerDate`, `lastvisitDate`, `activation`, `params`, `lastResetTime`, `resetCount`) VALUES
  «FOR user : allusers»
  («allusers.indexOf(user)»,'«user.fullname»', '«user.name»', '«user.email»', '«genaratePass»', ' ', '«valueParser(isEmpty(user.blocked,'no'))»', '«valueParser(isEmpty(user.receiveSystemMail,'no'))
  	», '«searchDateTime»', '0000-00-00 00:00:00','0','{"admin_style":"«getTemplateid(user.backendTemplateStyle, conf.template)»","admin_language":"«selectedLanguage(user.backendLanguage)»","language":"«selectedLanguage(user.frontendLanguage)»","editor":"«selectedEdit(user.editor)»","helpsite":"http:\/\/help.joomla.org\/proxy\/index.php?option=com_help&keyref=Help{major}{minor}:{keyref}","timezone":"«user.time_zone.country»"\\/"«user.time_zone.country»"},'0000-00-00 00:00:00','0')
  «ENDFOR»
  '''
	
}