package de.thm.icampus.cjsl.generator;

import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.cjsl.EditorType;
import de.thm.icampus.cjsl.cjsl.LanguageType;
import de.thm.icampus.cjsl.cjsl.Template;
import de.thm.icampus.cjsl.cjsl.TimeZone;
import de.thm.icampus.cjsl.cjsl.User;
import de.thm.icampus.cjsl.cjsl.UserGroup;
import de.thm.icampus.cjsl.cjsl.UserProfile;
import de.thm.icampus.cjsl.cjsl.UserProfileAttribute;
import de.thm.icampus.cjsl.cjsl.ViewLevel;
import de.thm.icampus.cjsl.cjsl.cJSL_Configuration;
import de.thm.icampus.cjsl.cjsl.cJSL_User;
import de.thm.icampus.cjsl.generator.ApplicationGenerator;
import de.thm.icampus.cjsl.generator.BaumElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class UserGenerator extends ApplicationGenerator {
  private EList<User> allusers;
  
  private cJSL_Configuration conf;
  
  private Application app;
  
  private EList<UserGroup> groups;
  
  private EList<ViewLevel> views;
  
  private int startIndexUser;
  
  private int startIndexGroup;
  
  public UserGenerator(final Application apps) {
    this.app = apps;
    cJSL_User _cjsl_user = apps.getCjsl_user();
    EList<User> _user = _cjsl_user.getUser();
    this.allusers = _user;
    cJSL_Configuration _cjsl_configuration = apps.getCjsl_configuration();
    this.conf = _cjsl_configuration;
    cJSL_User _cjsl_user_1 = apps.getCjsl_user();
    EList<UserGroup> _usergroups = _cjsl_user_1.getUsergroups();
    this.groups = _usergroups;
    cJSL_User _cjsl_user_2 = apps.getCjsl_user();
    EList<ViewLevel> _viewlevel = _cjsl_user_2.getViewlevel();
    this.views = _viewlevel;
  }
  
  public CharSequence generateAllUser() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("INSERT INTO `#__users` (`id`, `name`, `username`, `email`, `password`, `usertype`, `block`, `sendEmail`, `registerDate`, `lastvisitDate`, `activation`, `params`, `lastResetTime`, `resetCount`) VALUES");
    _builder.newLine();
    {
      for(final User user : this.allusers) {
        {
          int _size = this.allusers.size();
          int _minus = (_size - 1);
          User _get = this.allusers.get(_minus);
          boolean _equals = user.equals(_get);
          if (_equals) {
            _builder.append("(");
            int _indexOf = this.indexOf(user, this.allusers, 200, 0);
            _builder.append(_indexOf, "");
            _builder.append(",\'");
            String _fullname = user.getFullname();
            _builder.append(_fullname, "");
            _builder.append("\', \'");
            String _name = user.getName();
            _builder.append(_name, "");
            _builder.append("\', \'");
            String _email = user.getEmail();
            _builder.append(_email, "");
            _builder.append("\', \'");
            String _genaratePass = this.genaratePass();
            _builder.append(_genaratePass, "");
            _builder.append("\', \' \', \'");
            String _blocked = user.getBlocked();
            String _isEmpty = this.isEmpty(_blocked, "no");
            String _valueParser = this.valueParser(_isEmpty);
            _builder.append(_valueParser, "");
            _builder.append("\', \'");
            String _receiveSystemMail = user.getReceiveSystemMail();
            String _isEmpty_1 = this.isEmpty(_receiveSystemMail, "no");
            String _valueParser_1 = this.valueParser(_isEmpty_1);
            _builder.append(_valueParser_1, "");
            _builder.append("\', \'");
            String _searchDateTime = this.searchDateTime();
            _builder.append(_searchDateTime, "");
            _builder.append("\', \'0000-00-00 00:00:00\',\'0\',\'{\"admin_style\":\"");
            Template _backendTemplateStyle = user.getBackendTemplateStyle();
            EList<Template> _template = this.conf.getTemplate();
            int _templateid = this.getTemplateid(_backendTemplateStyle, _template);
            _builder.append(_templateid, "");
            _builder.append("\",\"admin_language\":\"");
            LanguageType _backendLanguage = user.getBackendLanguage();
            String _selectedLanguage = this.selectedLanguage(_backendLanguage);
            _builder.append(_selectedLanguage, "");
            _builder.append("\",\"language\":\"");
            LanguageType _frontendLanguage = user.getFrontendLanguage();
            String _selectedLanguage_1 = this.selectedLanguage(_frontendLanguage);
            _builder.append(_selectedLanguage_1, "");
            _builder.append("\",\"editor\":\"");
            EditorType _editor = user.getEditor();
            String _selectedEdit = this.selectedEdit(_editor);
            _builder.append(_selectedEdit, "");
            _builder.append("\",\"helpsite\":\"http:\\/\\/help.joomla.org\\/proxy\\/index.php?option=com_help&keyref=Help{major}{minor}:{keyref}\",\"timezone\":\"");
            TimeZone _time_zone = user.getTime_zone();
            String _searchattribut = this.searchattribut(_time_zone, "continent");
            String _isEmpty_2 = this.isEmpty(_searchattribut, "de");
            _builder.append(_isEmpty_2, "");
            _builder.append("\"\\\\/\"");
            TimeZone _time_zone_1 = user.getTime_zone();
            String _searchattribut_1 = this.searchattribut(_time_zone_1, "country");
            String _isEmpty_3 = this.isEmpty(_searchattribut_1, "DE");
            _builder.append(_isEmpty_3, "");
            _builder.append("\"}\',\'0000-00-00 00:00:00\',\'0\');");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("(");
            int _indexOf_1 = this.indexOf(user, this.allusers, 200, 0);
            _builder.append(_indexOf_1, "");
            _builder.append(",\'");
            String _fullname_1 = user.getFullname();
            _builder.append(_fullname_1, "");
            _builder.append("\', \'");
            String _name_1 = user.getName();
            _builder.append(_name_1, "");
            _builder.append("\', \'");
            String _email_1 = user.getEmail();
            _builder.append(_email_1, "");
            _builder.append("\', \'");
            String _genaratePass_1 = this.genaratePass();
            _builder.append(_genaratePass_1, "");
            _builder.append("\', \' \', \'");
            String _blocked_1 = user.getBlocked();
            String _isEmpty_4 = this.isEmpty(_blocked_1, "no");
            String _valueParser_2 = this.valueParser(_isEmpty_4);
            _builder.append(_valueParser_2, "");
            _builder.append("\', \'");
            String _receiveSystemMail_1 = user.getReceiveSystemMail();
            String _isEmpty_5 = this.isEmpty(_receiveSystemMail_1, "no");
            String _valueParser_3 = this.valueParser(_isEmpty_5);
            _builder.append(_valueParser_3, "");
            _builder.append("\', \'");
            String _searchDateTime_1 = this.searchDateTime();
            _builder.append(_searchDateTime_1, "");
            _builder.append("\', \'0000-00-00 00:00:00\',\'0\',\'{\"admin_style\":\"");
            Template _backendTemplateStyle_1 = user.getBackendTemplateStyle();
            EList<Template> _template_1 = this.conf.getTemplate();
            int _templateid_1 = this.getTemplateid(_backendTemplateStyle_1, _template_1);
            _builder.append(_templateid_1, "");
            _builder.append("\",\"admin_language\":\"");
            LanguageType _backendLanguage_1 = user.getBackendLanguage();
            String _selectedLanguage_2 = this.selectedLanguage(_backendLanguage_1);
            _builder.append(_selectedLanguage_2, "");
            _builder.append("\",\"language\":\"");
            LanguageType _frontendLanguage_1 = user.getFrontendLanguage();
            String _selectedLanguage_3 = this.selectedLanguage(_frontendLanguage_1);
            _builder.append(_selectedLanguage_3, "");
            _builder.append("\",\"editor\":\"");
            EditorType _editor_1 = user.getEditor();
            String _selectedEdit_1 = this.selectedEdit(_editor_1);
            _builder.append(_selectedEdit_1, "");
            _builder.append("\",\"helpsite\":\"http:\\/\\/help.joomla.org\\/proxy\\/index.php?option=com_help&keyref=Help{major}{minor}:{keyref}\",\"timezone\":\"");
            TimeZone _time_zone_2 = user.getTime_zone();
            String _searchattribut_2 = this.searchattribut(_time_zone_2, "continent");
            String _isEmpty_6 = this.isEmpty(_searchattribut_2, "de");
            _builder.append(_isEmpty_6, "");
            _builder.append("\"\\\\/\"");
            TimeZone _time_zone_3 = user.getTime_zone();
            String _searchattribut_3 = this.searchattribut(_time_zone_3, "country");
            String _isEmpty_7 = this.isEmpty(_searchattribut_3, "DE");
            _builder.append(_isEmpty_7, "");
            _builder.append("\"}\',\'0000-00-00 00:00:00\',\'0\'),");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateUserProfile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("INSERT INTO `#__user_profiles` (`user_id`, `profile_key`, `profile_value`, `ordering`) VALUES");
    _builder.newLine();
    {
      for(final User user : this.allusers) {
        _builder.append(" ");
        _builder.append(" ");
        int counter = 0;
        _builder.newLineIfNotEmpty();
        {
          UserProfile _userProfile = user.getUserProfile();
          EList<UserProfileAttribute> _userAttribute = _userProfile.getUserAttribute();
          for(final UserProfileAttribute attribut : _userAttribute) {
            {
              UserProfile _userProfile_1 = user.getUserProfile();
              EList<UserProfileAttribute> _userAttribute_1 = _userProfile_1.getUserAttribute();
              UserProfile _userProfile_2 = user.getUserProfile();
              EList<UserProfileAttribute> _userAttribute_2 = _userProfile_2.getUserAttribute();
              int _size = _userAttribute_2.size();
              int _minus = (_size - 1);
              UserProfileAttribute _get = _userAttribute_1.get(_minus);
              boolean _equals = attribut.equals(_get);
              if (_equals) {
                _builder.append(" ");
                _builder.append("(\'");
                int _indexOf = this.indexOf(user, this.allusers, 200, 0);
                _builder.append(_indexOf, " ");
                _builder.append("\', \'profile.");
                String _name = attribut.getName();
                _builder.append(_name, " ");
                _builder.append("\', \'");
                String _value = attribut.getValue();
                _builder.append(_value, " ");
                _builder.append("\', \'");
                int _counter = counter = (counter + 1);
                _builder.append(_counter, " ");
                _builder.append("\');");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append(" ");
                _builder.append("(\'");
                int _indexOf_1 = this.indexOf(user, this.allusers, 200, 0);
                _builder.append(_indexOf_1, " ");
                _builder.append("\', \'profile.");
                String _name_1 = attribut.getName();
                _builder.append(_name_1, " ");
                _builder.append("\', \'");
                String _value_1 = attribut.getValue();
                _builder.append(_value_1, " ");
                _builder.append("\', \'");
                int _counter_1 = counter = (counter + 1);
                _builder.append(_counter_1, " ");
                _builder.append("\'),");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append(" ");
      }
    }
    return _builder;
  }
  
  public CharSequence generateGroups(final EList<BaumElement> baum) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("UPDATE `#__usergroups` SET `rgt` = ");
    BaumElement _searchElem = this.searchElem(baum, (-1));
    _builder.append(_searchElem.parent, "");
    _builder.append(" WHERE `id` =1;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("INSERT INTO `#__usergroups` ( `parent_id`, `lft`, `rgt`, `title`) VALUES ");
    _builder.newLine();
    {
      for(final UserGroup group : this.groups) {
        {
          int _size = this.groups.size();
          int _minus = (_size - 1);
          UserGroup _get = this.groups.get(_minus);
          boolean _equals = group.equals(_get);
          if (_equals) {
            _builder.append("(\'");
            UserGroup _parent = group.getParent();
            int _indexOf = this.indexOf(_parent, this.groups, 9, 1);
            _builder.append(_indexOf, "");
            _builder.append("\', \'");
            int _indexOf_1 = this.groups.indexOf(group);
            BaumElement _searchElem_1 = this.searchElem(baum, _indexOf_1);
            _builder.append(_searchElem_1.lft, "");
            _builder.append("\', \'");
            int _indexOf_2 = this.groups.indexOf(group);
            BaumElement _searchElem_2 = this.searchElem(baum, _indexOf_2);
            _builder.append(_searchElem_2.rgt, "");
            _builder.append("\', \'");
            String _name = group.getName();
            _builder.append(_name, "");
            _builder.append("\');");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("(\'");
            UserGroup _parent_1 = group.getParent();
            int _indexOf_3 = this.indexOf(_parent_1, this.groups, 9, 1);
            _builder.append(_indexOf_3, "");
            _builder.append("\', \'");
            int _indexOf_4 = this.groups.indexOf(group);
            BaumElement _searchElem_3 = this.searchElem(baum, _indexOf_4);
            _builder.append(_searchElem_3.lft, "");
            _builder.append("\', \'");
            int _indexOf_5 = this.groups.indexOf(group);
            BaumElement _searchElem_4 = this.searchElem(baum, _indexOf_5);
            _builder.append(_searchElem_4.rgt, "");
            _builder.append("\', \'");
            String _name_1 = group.getName();
            _builder.append(_name_1, "");
            _builder.append("\'),");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateUserGroupsMap() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("INSERT INTO `#__user_usergroup_map` (`user_id`, `group_id`) VALUES ");
    _builder.newLine();
    {
      for(final User user : this.allusers) {
        {
          for(final UserGroup group : this.groups) {
            {
              EList<UserGroup> _usergroup = user.getUsergroup();
              boolean _contains = _usergroup.contains(group);
              if (_contains) {
                {
                  int _size = this.allusers.size();
                  int _minus = (_size - 1);
                  User _get = this.allusers.get(_minus);
                  boolean _equals = user.equals(_get);
                  if (_equals) {
                    _builder.append(" ");
                    _builder.append("(\'");
                    int _indexOf = this.indexOf(user, this.allusers, 200, 0);
                    _builder.append(_indexOf, " ");
                    _builder.append("\', \'");
                    int _indexOf_1 = this.indexOf(group, this.groups, 9, 1);
                    _builder.append(_indexOf_1, " ");
                    _builder.append("\');");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append(" ");
                    _builder.append("(\'");
                    int _indexOf_2 = this.indexOf(user, this.allusers, 200, 0);
                    _builder.append(_indexOf_2, " ");
                    _builder.append("\', \'");
                    int _indexOf_3 = this.indexOf(group, this.groups, 9, 1);
                    _builder.append(_indexOf_3, " ");
                    _builder.append("\'),");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder.append("   ");
      }
    }
    return _builder;
  }
  
  public CharSequence generateViewLevel() {
    StringConcatenation _builder = new StringConcatenation();
    int count = 3;
    _builder.newLineIfNotEmpty();
    _builder.append("INSERT INTO `#__viewlevels` (`title`, `ordering`, `rules`) VALUES ");
    _builder.newLine();
    {
      for(final ViewLevel view : this.views) {
        {
          int _size = this.views.size();
          int _minus = (_size - 1);
          ViewLevel _get = this.views.get(_minus);
          boolean _equals = view.equals(_get);
          if (_equals) {
            _builder.append("(\'");
            String _name = view.getName();
            _builder.append(_name, "");
            _builder.append("\', \'");
            int _count = count = (count + 1);
            _builder.append(_count, "");
            _builder.append("\', \'[");
            String _searchGroupsIDForViewLevel = this.searchGroupsIDForViewLevel(view);
            _builder.append(_searchGroupsIDForViewLevel, "");
            _builder.append("]\');");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("(\'");
            String _name_1 = view.getName();
            _builder.append(_name_1, "");
            _builder.append("\', \'");
            int _count_1 = count = (count + 1);
            _builder.append(_count_1, "");
            _builder.append("\', \'[");
            String _searchGroupsIDForViewLevel_1 = this.searchGroupsIDForViewLevel(view);
            _builder.append(_searchGroupsIDForViewLevel_1, "");
            _builder.append("]\'),");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateGroupsCoreAcess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("UPDATE `#__assets` SET ");
    _builder.newLine();
    _builder.append("`rules` = ");
    _builder.newLine();
    return _builder;
  }
  
  public String searchGroupsIDForViewLevel(final ViewLevel level) {
    String result = new String();
    int counter = 0;
    for (final UserGroup group : this.groups) {
      {
        int in = 0;
        EList<UserGroup> _usergroup = level.getUsergroup();
        boolean _contains = _usergroup.contains(group);
        if (_contains) {
          counter = (counter + 1);
          int _indexOf = this.indexOf(group, this.groups, 9, 1);
          in = _indexOf;
          EList<UserGroup> _usergroup_1 = level.getUsergroup();
          int _size = _usergroup_1.size();
          boolean _greaterEqualsThan = (counter >= _size);
          if (_greaterEqualsThan) {
            result = (result + Integer.valueOf(in));
          } else {
            result = ((result + Integer.valueOf(in)) + ",");
          }
        }
      }
    }
    return result;
  }
}
