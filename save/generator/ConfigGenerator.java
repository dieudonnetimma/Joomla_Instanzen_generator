package de.thm.icampus.cjsl.generator;

import com.google.common.base.Objects;
import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.cjsl.Editor;
import de.thm.icampus.cjsl.cjsl.EditorType;
import de.thm.icampus.cjsl.cjsl.Language;
import de.thm.icampus.cjsl.cjsl.TimeZone;
import de.thm.icampus.cjsl.cjsl.ViewLevel;
import de.thm.icampus.cjsl.cjsl.ViewLevelRights;
import de.thm.icampus.cjsl.cjsl.cJSL_Configuration;
import de.thm.icampus.cjsl.cjsl.cJSL_User;
import de.thm.icampus.cjsl.cjsl.cacheHandlerKind;
import de.thm.icampus.cjsl.cjsl.cachingKind;
import de.thm.icampus.cjsl.cjsl.databaseKind;
import de.thm.icampus.cjsl.cjsl.db_Conf;
import de.thm.icampus.cjsl.cjsl.errorReportingKind;
import de.thm.icampus.cjsl.cjsl.forceSslKind;
import de.thm.icampus.cjsl.cjsl.ftp_Conf;
import de.thm.icampus.cjsl.cjsl.inclSiteNameInPTKind;
import de.thm.icampus.cjsl.cjsl.mailerKind;
import de.thm.icampus.cjsl.cjsl.mailer_Conf;
import de.thm.icampus.cjsl.cjsl.robotKind;
import de.thm.icampus.cjsl.cjsl.smtpSecurityKind;
import de.thm.icampus.cjsl.cjsl.smtp_Conf;
import de.thm.icampus.cjsl.cjsl.system_Conf;
import de.thm.icampus.cjsl.cjsl.website_Conf;
import de.thm.icampus.cjsl.generator.ApplicationGenerator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;

@SuppressWarnings("all")
public class ConfigGenerator extends ApplicationGenerator {
  private IFileSystemAccess fpa;
  
  private cJSL_Configuration config;
  
  private Application app;
  
  public ConfigGenerator(final IFileSystemAccess acc, final Application apps) {
    this.fpa = acc;
    cJSL_Configuration _cjsl_configuration = apps.getCjsl_configuration();
    this.config = _cjsl_configuration;
    this.app = apps;
  }
  
  public void generateConfig() {
    CharSequence _contentGen = this.contentGen(this.config);
    this.fpa.generateFile("configuration.php", _contentGen);
  }
  
  public CharSequence contentGen(final cJSL_Configuration configuration) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?php");
    _builder.newLine();
    _builder.append("class JConfig {");
    _builder.newLine();
    _builder.newLine();
    website_Conf _website_conf = configuration.getWebsite_conf();
    CharSequence _genWebsite_Conf = this.genWebsite_Conf(_website_conf);
    _builder.append(_genWebsite_Conf, "");
    _builder.newLineIfNotEmpty();
    db_Conf _db_conf = configuration.getDb_conf();
    CharSequence _genDB_Conf = this.genDB_Conf(_db_conf);
    _builder.append(_genDB_Conf, "");
    _builder.newLineIfNotEmpty();
    CharSequence _xifexpression = null;
    system_Conf _system_conf = configuration.getSystem_conf();
    boolean _notEquals = (!Objects.equal(_system_conf, null));
    if (_notEquals) {
      system_Conf _system_conf_1 = configuration.getSystem_conf();
      _xifexpression = this.genSystem_Conf(_system_conf_1);
    } else {
      _xifexpression = this.genDefaultSystem_conf();
    }
    _builder.append(_xifexpression, "");
    _builder.newLineIfNotEmpty();
    CharSequence _xifexpression_1 = null;
    ftp_Conf _ftp_conf = configuration.getFtp_conf();
    boolean _notEquals_1 = (!Objects.equal(_ftp_conf, null));
    if (_notEquals_1) {
      ftp_Conf _ftp_conf_1 = configuration.getFtp_conf();
      _xifexpression_1 = this.genFTP_Conf(_ftp_conf_1);
    } else {
      _xifexpression_1 = this.genDefaultFTP_Conf();
    }
    _builder.append(_xifexpression_1, "");
    _builder.newLineIfNotEmpty();
    CharSequence _xifexpression_2 = null;
    mailer_Conf _mailer_conf = configuration.getMailer_conf();
    boolean _notEquals_2 = (!Objects.equal(_mailer_conf, null));
    if (_notEquals_2) {
      mailer_Conf _mailer_conf_1 = configuration.getMailer_conf();
      _xifexpression_2 = this.genMailer_Conf(_mailer_conf_1);
    } else {
      _xifexpression_2 = this.genDefaultMailer_Conf();
    }
    _builder.append(_xifexpression_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genDefaultSystem_conf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public $secret = \'FBVtggIk5lAzEU9H\'; \t\t// Change this to something more secure");
    _builder.newLine();
    _builder.append("public $gzip = \'0\';");
    _builder.newLine();
    _builder.append("public $error_reporting = \'default\';");
    _builder.newLine();
    _builder.append("public $helpurl = \'http://help.joomla.org/proxy/index.php?option=com_help&amp;keyref=Help{major}{minor}:{keyref}\';");
    _builder.newLine();
    _builder.append("public $tmp_path = \'/tmp\';");
    _builder.newLine();
    _builder.append("public $log_path = \'/var/logs\';");
    _builder.newLine();
    _builder.append("public $live_site = \'\'; \t\t\t\t\t");
    _builder.newLine();
    _builder.append("public $force_ssl = 0;");
    _builder.newLine();
    _builder.append("public $lifetime = \'15\';\t\t\t\t\t// Session time");
    _builder.newLine();
    _builder.append("public $session_handler = \'database\';\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("public $offset = \'UTC\';");
    _builder.newLine();
    _builder.append("public $caching = \'0\';");
    _builder.newLine();
    _builder.append("public $cachetime = \'15\';");
    _builder.newLine();
    _builder.append("public $cache_handler = \'file\';");
    _builder.newLine();
    _builder.append("public $debug = \'0\';");
    _builder.newLine();
    _builder.append("public $debug_lang = \'0\';");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genDefaultFTP_Conf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public $ftp_host = \'\';");
    _builder.newLine();
    _builder.append("public $ftp_port = \'\';");
    _builder.newLine();
    _builder.append("public $ftp_user = \'\';");
    _builder.newLine();
    _builder.append("public $ftp_pass = \'\';");
    _builder.newLine();
    _builder.append("public $ftp_root = \'\';");
    _builder.newLine();
    _builder.append("public $ftp_enable = \'\';");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genDefaultMailer_Conf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public $mailer = \'mail\';");
    _builder.newLine();
    _builder.append("public $mailfrom = \'\';");
    _builder.newLine();
    _builder.append("public $fromname = \'\';");
    _builder.newLine();
    _builder.append("public $sendmail = \'/usr/sbin/sendmail\';");
    _builder.newLine();
    _builder.append("public $smtpauth = \'0\';");
    _builder.newLine();
    _builder.append("public $smtpuser = \'\';");
    _builder.newLine();
    _builder.append("public $smtppass = \'\';");
    _builder.newLine();
    _builder.append("public $smtphost = \'localhost\';");
    _builder.newLine();
    _builder.append("public $smtpsecure = \'ssl\';");
    _builder.newLine();
    _builder.append("public $smtpport = \'25\';");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence paramConfig(final String name, final String value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public $");
    _builder.append(name, "");
    _builder.append(" = \'");
    _builder.append(value, "");
    _builder.append("\';");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence paramConfig(final String name, final int value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public $");
    _builder.append(name, "");
    _builder.append(" = \'");
    _builder.append(value, "");
    _builder.append("\';");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence genWebsite_Conf(final website_Conf website) {
    StringConcatenation _builder = new StringConcatenation();
    String _pagetitle = website.getPagetitle();
    CharSequence _paramConfig = this.paramConfig("sitename", _pagetitle);
    _builder.append(_paramConfig, "");
    _builder.newLineIfNotEmpty();
    String _offline = website.getOffline();
    String _plus = (_offline + "");
    String _valueParser = this.valueParser(_plus);
    String _isEmpty = this.isEmpty(_valueParser, "0");
    CharSequence _paramConfig_1 = this.paramConfig("offline", _isEmpty);
    _builder.append(_paramConfig_1, "");
    _builder.newLineIfNotEmpty();
    String _offline_message = website.getOffline_message();
    String _isEmpty_1 = this.isEmpty(_offline_message, "Diese Website ist zurzeit im Wartungsmodus.<br />Bitte später wiederkommen.");
    CharSequence _paramConfig_2 = this.paramConfig("offline_message", _isEmpty_1);
    _builder.append(_paramConfig_2, "");
    _builder.newLineIfNotEmpty();
    String _offline_image = website.getOffline_image();
    CharSequence _paramConfig_3 = this.paramConfig("offline_image", _offline_image);
    _builder.append(_paramConfig_3, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_4 = this.paramConfig("captcha", "0");
    _builder.append(_paramConfig_4, "");
    _builder.newLineIfNotEmpty();
    EditorType _editor = website.getEditor();
    String _selectedEdit = this.selectedEdit(_editor);
    CharSequence _paramConfig_5 = this.paramConfig("editor", _selectedEdit);
    _builder.append(_paramConfig_5, "");
    _builder.newLineIfNotEmpty();
    String _offline_message_1 = website.getOffline_message();
    String _isEmpty_2 = this.isEmpty(_offline_message_1);
    CharSequence _paramConfig_6 = this.paramConfig("display_offline_message", _isEmpty_2);
    _builder.append(_paramConfig_6, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_7 = this.paramConfig("list_limit", 0);
    _builder.append(_paramConfig_7, "");
    _builder.newLineIfNotEmpty();
    ViewLevelRights _site_access = website.getSite_access();
    cJSL_User _cjsl_user = this.app.getCjsl_user();
    EList<ViewLevel> _viewlevel = _cjsl_user.getViewlevel();
    String _selectedSiteacess = this.selectedSiteacess(_site_access, _viewlevel);
    String _isEmpty_3 = this.isEmpty(_selectedSiteacess, "1");
    CharSequence _paramConfig_8 = this.paramConfig("access", _isEmpty_3);
    _builder.append(_paramConfig_8, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_9 = this.paramConfig("feed_email", "site");
    _builder.append(_paramConfig_9, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_10 = this.paramConfig("cookie_domain", "");
    _builder.append(_paramConfig_10, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_11 = this.paramConfig("cookie_path", "");
    _builder.append(_paramConfig_11, "");
    _builder.newLineIfNotEmpty();
    String _description = website.getDescription();
    CharSequence _paramConfig_12 = this.paramConfig("MetaDesc", _description);
    _builder.append(_paramConfig_12, "");
    _builder.newLineIfNotEmpty();
    EList<String> _keyword = website.getKeyword();
    String _string = _keyword.toString();
    CharSequence _paramConfig_13 = this.paramConfig("MetaKeys", _string);
    _builder.append(_paramConfig_13, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public $MetaTitle = \'1\';");
    _builder.newLine();
    String _show_author_meta_tag = website.getShow_author_meta_tag();
    String _isEmpty_4 = this.isEmpty(_show_author_meta_tag, "yes");
    String _string_1 = _isEmpty_4.toString();
    String _valueParser_1 = this.valueParser(_string_1);
    CharSequence _paramConfig_14 = this.paramConfig("MetaAuthor", _valueParser_1);
    _builder.append(_paramConfig_14, "");
    _builder.newLineIfNotEmpty();
    String _show_joomla_version = website.getShow_joomla_version();
    String _isEmpty_5 = this.isEmpty(_show_joomla_version, "no");
    String _string_2 = _isEmpty_5.toString();
    String _valueParser_2 = this.valueParser(_string_2);
    CharSequence _paramConfig_15 = this.paramConfig("MetaVersion", _valueParser_2);
    _builder.append(_paramConfig_15, "");
    _builder.newLineIfNotEmpty();
    robotKind _robot = website.getRobot();
    String _string_3 = _robot.toString();
    String _isEmpty_6 = this.isEmpty(_string_3, "index, follow");
    String _string_4 = _isEmpty_6.toString();
    String _valueParser_3 = this.valueParser(_string_4);
    CharSequence _paramConfig_16 = this.paramConfig("robots", _valueParser_3);
    _builder.append(_paramConfig_16, "");
    _builder.newLineIfNotEmpty();
    String _use_sef = website.getUse_sef();
    String _isEmpty_7 = this.isEmpty(_use_sef, "1");
    CharSequence _paramConfig_17 = this.paramConfig("sef", _isEmpty_7);
    _builder.append(_paramConfig_17, "");
    _builder.newLineIfNotEmpty();
    String _url_rewrite = website.getUrl_rewrite();
    String _isEmpty_8 = this.isEmpty(_url_rewrite, "0");
    String _valueParser_4 = this.valueParser(_isEmpty_8);
    CharSequence _paramConfig_18 = this.paramConfig("sef_rewrite", _valueParser_4);
    _builder.append(_paramConfig_18, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_19 = this.paramConfig("sef_suffix", "0");
    _builder.append(_paramConfig_19, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_20 = this.paramConfig("unicodeslugs", "0");
    _builder.append(_paramConfig_20, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_21 = this.paramConfig("feed_limit", 10);
    _builder.append(_paramConfig_21, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_22 = this.paramConfig("MetaRights", "");
    _builder.append(_paramConfig_22, "");
    _builder.newLineIfNotEmpty();
    inclSiteNameInPTKind _include_site_name_in_page_titles = website.getInclude_site_name_in_page_titles();
    String _string_5 = _include_site_name_in_page_titles.toString();
    String _isEmpty_9 = this.isEmpty(_string_5, "no");
    String _string_6 = _isEmpty_9.toString();
    String _valueParser_5 = this.valueParser(_string_6);
    CharSequence _paramConfig_23 = this.paramConfig("sitename_pagetitles", _valueParser_5);
    _builder.append(_paramConfig_23, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence genDB_Conf(final db_Conf dbconf) {
    StringConcatenation _builder = new StringConcatenation();
    databaseKind _dbtype = dbconf.getDbtype();
    String _string = _dbtype.toString();
    CharSequence _paramConfig = this.paramConfig("dbtype", _string);
    _builder.append(_paramConfig, "");
    _builder.newLineIfNotEmpty();
    String _host = dbconf.getHost();
    String _string_1 = _host.toString();
    String _isEmpty = this.isEmpty(_string_1, "localhost");
    CharSequence _paramConfig_1 = this.paramConfig("host", _isEmpty);
    _builder.append(_paramConfig_1, "");
    _builder.newLineIfNotEmpty();
    String _user = dbconf.getUser();
    String _isEmpty_1 = this.isEmpty(_user, "root");
    CharSequence _paramConfig_2 = this.paramConfig("user", _isEmpty_1);
    _builder.append(_paramConfig_2, "");
    _builder.newLineIfNotEmpty();
    String _password = dbconf.getPassword();
    String _string_2 = _password.toString();
    CharSequence _paramConfig_3 = this.paramConfig("password", _string_2);
    _builder.append(_paramConfig_3, "");
    _builder.newLineIfNotEmpty();
    String _database = dbconf.getDatabase();
    CharSequence _paramConfig_4 = this.paramConfig("db", _database);
    _builder.append(_paramConfig_4, "");
    _builder.newLineIfNotEmpty();
    String _prefix = dbconf.getPrefix();
    CharSequence _paramConfig_5 = this.paramConfig("dbprefix", _prefix);
    _builder.append(_paramConfig_5, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence genFTP_Conf(final ftp_Conf ftpconf) {
    StringConcatenation _builder = new StringConcatenation();
    String _host = ftpconf.getHost();
    String _string = _host.toString();
    CharSequence _paramConfig = this.paramConfig("ftp_host", _string);
    _builder.append(_paramConfig, "");
    _builder.newLineIfNotEmpty();
    int _port = ftpconf.getPort();
    CharSequence _paramConfig_1 = this.paramConfig("ftp_port", _port);
    _builder.append(_paramConfig_1, "");
    _builder.newLineIfNotEmpty();
    String _ftp_user = ftpconf.getFtp_user();
    CharSequence _paramConfig_2 = this.paramConfig("ftp_user", _ftp_user);
    _builder.append(_paramConfig_2, "");
    _builder.newLineIfNotEmpty();
    String _ftp_pass = ftpconf.getFtp_pass();
    CharSequence _paramConfig_3 = this.paramConfig("ftp_pass", _ftp_pass);
    _builder.append(_paramConfig_3, "");
    _builder.newLineIfNotEmpty();
    String _root_path = ftpconf.getRoot_path();
    String _isEmpty = this.isEmpty(_root_path, "root");
    CharSequence _paramConfig_4 = this.paramConfig("ftp_root", _isEmpty);
    _builder.append(_paramConfig_4, "");
    _builder.newLineIfNotEmpty();
    String _host_1 = ftpconf.getHost();
    String _isEmpty_1 = this.isEmpty(_host_1);
    String _valueParser = this.valueParser(_isEmpty_1);
    CharSequence _paramConfig_5 = this.paramConfig("ftp_enable", _valueParser);
    _builder.append(_paramConfig_5, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence genMailer_Conf(final mailer_Conf mailerconf) {
    StringConcatenation _builder = new StringConcatenation();
    mailerKind _mailer = mailerconf.getMailer();
    String _name = _mailer.getName();
    String _isEmpty = this.isEmpty(_name, "php mail");
    String _valueParser = this.valueParser(_isEmpty);
    CharSequence _paramConfig = this.paramConfig("mailer", _valueParser);
    _builder.append(_paramConfig, "");
    _builder.newLineIfNotEmpty();
    String _mail_from = mailerconf.getMail_from();
    CharSequence _paramConfig_1 = this.paramConfig("mailfrom", _mail_from);
    _builder.append(_paramConfig_1, "");
    _builder.newLineIfNotEmpty();
    String _name_from = mailerconf.getName_from();
    CharSequence _paramConfig_2 = this.paramConfig("fromname", _name_from);
    _builder.append(_paramConfig_2, "");
    _builder.newLineIfNotEmpty();
    String _sendmail_path = mailerconf.getSendmail_path();
    String _isEmpty_1 = this.isEmpty(_sendmail_path, "/usr/sbin/sendmail");
    CharSequence _paramConfig_3 = this.paramConfig("sendmail", _isEmpty_1);
    _builder.append(_paramConfig_3, "");
    _builder.newLineIfNotEmpty();
    CharSequence _xifexpression = null;
    smtp_Conf _smtpconfig = mailerconf.getSmtpconfig();
    boolean _notEquals = (!Objects.equal(_smtpconfig, null));
    if (_notEquals) {
      smtp_Conf _smtpconfig_1 = mailerconf.getSmtpconfig();
      _xifexpression = this.genSMTP_conf(_smtpconfig_1);
    } else {
      _xifexpression = this.genDefaultSMTP_conf();
    }
    _builder.append(_xifexpression, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence genDefaultSMTP_conf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public $smtpauth = \'0\';");
    _builder.newLine();
    _builder.append("public $smtpuser = \'\';");
    _builder.newLine();
    _builder.append("public $smtppass = \'\';");
    _builder.newLine();
    _builder.append("public $smtphost = \'localhost\';");
    _builder.newLine();
    _builder.append("public $smtpsecure = \'ssl\';");
    _builder.newLine();
    _builder.append("public $smtpport = \'25\';");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genSMTP_conf(final smtp_Conf conf) {
    StringConcatenation _builder = new StringConcatenation();
    String _smtp_auth = conf.getSmtp_auth();
    String _isEmpty = this.isEmpty(_smtp_auth, "no");
    String _valueParser = this.valueParser(_isEmpty);
    CharSequence _paramConfig = this.paramConfig("smtpauth", _valueParser);
    _builder.append(_paramConfig, "");
    _builder.newLineIfNotEmpty();
    String _smtp_username = conf.getSmtp_username();
    CharSequence _paramConfig_1 = this.paramConfig("smtpuser", _smtp_username);
    _builder.append(_paramConfig_1, "");
    _builder.newLineIfNotEmpty();
    String _smtp_password = conf.getSmtp_password();
    CharSequence _paramConfig_2 = this.paramConfig("smtppass", _smtp_password);
    _builder.append(_paramConfig_2, "");
    _builder.newLineIfNotEmpty();
    String _smtp_host = conf.getSmtp_host();
    String _string = _smtp_host.toString();
    String _isEmpty_1 = this.isEmpty(_string, "localhost");
    CharSequence _paramConfig_3 = this.paramConfig("smtphost", _isEmpty_1);
    _builder.append(_paramConfig_3, "");
    _builder.newLineIfNotEmpty();
    int _smtp_port = conf.getSmtp_port();
    int _isEmpty_2 = this.isEmpty(_smtp_port, 25);
    CharSequence _paramConfig_4 = this.paramConfig("smtpport", _isEmpty_2);
    _builder.append(_paramConfig_4, "");
    _builder.newLineIfNotEmpty();
    smtpSecurityKind _smtp_security = conf.getSmtp_security();
    String _name = _smtp_security.getName();
    String _isEmpty_3 = this.isEmpty(_name, "ssl");
    CharSequence _paramConfig_5 = this.paramConfig("smtpsecure", _isEmpty_3);
    _builder.append(_paramConfig_5, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence genSystem_Conf(final system_Conf systemconf) {
    StringConcatenation _builder = new StringConcatenation();
    String _debug_system = systemconf.getDebug_system();
    String _isEmpty = this.isEmpty(_debug_system, "no");
    String _valueParser = this.valueParser(_isEmpty);
    CharSequence _paramConfig = this.paramConfig("debug", _valueParser);
    _builder.append(_paramConfig, "");
    _builder.newLineIfNotEmpty();
    String _debug_language = systemconf.getDebug_language();
    String _isEmpty_1 = this.isEmpty(_debug_language, "no");
    String _valueParser_1 = this.valueParser(_isEmpty_1);
    CharSequence _paramConfig_1 = this.paramConfig("debug_lang", _valueParser_1);
    _builder.append(_paramConfig_1, "");
    _builder.newLineIfNotEmpty();
    cachingKind _caching = systemconf.getCaching();
    String _string = _caching.toString();
    String _isEmpty_2 = this.isEmpty(_string, "off-caching disabled");
    String _valueParser_2 = this.valueParser(_isEmpty_2);
    CharSequence _paramConfig_2 = this.paramConfig("caching", _valueParser_2);
    _builder.append(_paramConfig_2, "");
    _builder.newLineIfNotEmpty();
    cacheHandlerKind _cache_handler = systemconf.getCache_handler();
    String _string_1 = _cache_handler.toString();
    String _isEmpty_3 = this.isEmpty(_string_1, "file");
    String _valueParser_3 = this.valueParser(_isEmpty_3);
    CharSequence _paramConfig_3 = this.paramConfig("cache_handler", _valueParser_3);
    _builder.append(_paramConfig_3, "");
    _builder.newLineIfNotEmpty();
    int _cache_time = systemconf.getCache_time();
    int _isEmpty_4 = this.isEmpty(_cache_time, 150);
    CharSequence _paramConfig_4 = this.paramConfig("cachetime", _isEmpty_4);
    _builder.append(_paramConfig_4, "");
    _builder.newLineIfNotEmpty();
    int _session_lifetime = systemconf.getSession_lifetime();
    int _isEmpty_5 = this.isEmpty(_session_lifetime, 150);
    CharSequence _paramConfig_5 = this.paramConfig("lifetime", _isEmpty_5);
    _builder.append(_paramConfig_5, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_6 = this.paramConfig("session_handler", "database");
    _builder.append(_paramConfig_6, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_7 = this.paramConfig("log_path", "/var/logs");
    _builder.append(_paramConfig_7, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_8 = this.paramConfig("helpurl", "http://help.joomla.org/proxy/index.php?option=com_help&keyref=Help{major}{minor}:{keyref}");
    _builder.append(_paramConfig_8, "");
    _builder.newLineIfNotEmpty();
    forceSslKind _force_ssl = systemconf.getForce_ssl();
    String _string_2 = _force_ssl.toString();
    String _isEmpty_6 = this.isEmpty(_string_2, "none");
    String _valueParser_4 = this.valueParser(_isEmpty_6);
    CharSequence _paramConfig_9 = this.paramConfig("force_ssl", _valueParser_4);
    _builder.append(_paramConfig_9, "");
    _builder.newLineIfNotEmpty();
    TimeZone _server_time_zone = systemconf.getServer_time_zone();
    String _searchattribut = this.searchattribut(_server_time_zone, "country");
    String _isEmpty_7 = this.isEmpty(_searchattribut, "UTC");
    CharSequence _paramConfig_10 = this.paramConfig("offset", _isEmpty_7);
    _builder.append(_paramConfig_10, "");
    _builder.newLineIfNotEmpty();
    CharSequence _paramConfig_11 = this.paramConfig("tmp_path", "/tmp");
    _builder.append(_paramConfig_11, "");
    _builder.newLineIfNotEmpty();
    String _valueParser_5 = this.valueParser("no");
    CharSequence _paramConfig_12 = this.paramConfig("gzip", _valueParser_5);
    _builder.append(_paramConfig_12, "");
    _builder.newLineIfNotEmpty();
    errorReportingKind _error_reporting_type = systemconf.getError_reporting_type();
    String _string_3 = _error_reporting_type.toString();
    String _isEmpty_8 = this.isEmpty(_string_3, "default");
    String _valueParser_6 = this.valueParser(_isEmpty_8);
    CharSequence _paramConfig_13 = this.paramConfig("error_reporting", _valueParser_6);
    _builder.append(_paramConfig_13, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public $live_site = \'\';");
    _builder.newLine();
    _builder.append("public $secret = \'DZk2H9y3q3eYDYob\';");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genEditor(final Editor editorconf) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence genLanguage(final Language langconf) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence genTimeZone(final TimeZone time) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
}
