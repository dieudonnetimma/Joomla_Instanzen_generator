package de.thm.icampus.cjsl.generator;

import com.google.common.base.Objects;
import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.cjsl.UserGroup;
import de.thm.icampus.cjsl.cjsl.cJSL_Configuration;
import de.thm.icampus.cjsl.cjsl.cJSL_User;
import de.thm.icampus.cjsl.cjsl.databaseKind;
import de.thm.icampus.cjsl.cjsl.db_Conf;
import de.thm.icampus.cjsl.cjsl.website_Conf;
import de.thm.icampus.cjsl.generator.ApplicationGenerator;
import de.thm.icampus.cjsl.generator.BaumElement;
import de.thm.icampus.cjsl.generator.UserGenerator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class SQLGenerator extends ApplicationGenerator {
  public IFileSystemAccess fpa;
  
  public Application app;
  
  public String pathDestinationRoot;
  
  public cJSL_Configuration config;
  
  public db_Conf dbconfig;
  
  public UserGenerator users;
  
  public SQLGenerator(final IFileSystemAccess acc, final Application app, final String appname) {
    this.fpa = acc;
    this.app = app;
    cJSL_Configuration _cjsl_configuration = app.getCjsl_configuration();
    this.config = _cjsl_configuration;
    db_Conf _db_conf = this.config.getDb_conf();
    this.dbconfig = _db_conf;
    String _applicationPath = app.getApplicationPath();
    String _plus = (_applicationPath + "/");
    String _plus_1 = (_plus + appname);
    this.pathDestinationRoot = _plus_1;
    UserGenerator _userGenerator = new UserGenerator(app);
    this.users = _userGenerator;
  }
  
  public SQLGenerator(final IFileSystemAccess access, final Application application) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean generateSQLData() {
    boolean _xblockexpression = false;
    {
      CharSequence _contentGen = this.contentGen();
      this.fpa.generateFile("mddsql/application.sql", _contentGen);
      CharSequence _usercontengen = this.usercontengen();
      this.fpa.generateFile("mddsql/user.sql", _usercontengen);
      File _file = new File((this.pathDestinationRoot + "/installation"));
      _xblockexpression = this.deleteFolder(_file);
    }
    return _xblockexpression;
  }
  
  public CharSequence usercontengen() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#--------------------------------------------------------------User-----------------------------------------------------------");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateAllUser = this.users.generateAllUser();
    _builder.append(_generateAllUser, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateUserProfile = this.users.generateUserProfile();
    _builder.append(_generateUserProfile, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    cJSL_User _cjsl_user = this.app.getCjsl_user();
    EList<UserGroup> _usergroups = _cjsl_user.getUsergroups();
    EList<BaumElement> _transformArtefact = this.transformArtefact(_usergroups);
    CharSequence _generateGroups = this.users.generateGroups(_transformArtefact);
    _builder.append(_generateGroups, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateUserGroupsMap = this.users.generateUserGroupsMap();
    _builder.append(_generateUserGroupsMap, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateViewLevel = this.users.generateViewLevel();
    _builder.append(_generateViewLevel, "\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence contentGen() {
    StringConcatenation _builder = new StringConcatenation();
    String _xifexpression = null;
    boolean _or = false;
    databaseKind _dbtype = this.dbconfig.getDbtype();
    String _string = _dbtype.toString();
    boolean _equals = _string.equals("mysql");
    if (_equals) {
      _or = true;
    } else {
      databaseKind _dbtype_1 = this.dbconfig.getDbtype();
      String _string_1 = _dbtype_1.toString();
      boolean _equals_1 = _string_1.equals("mysqli");
      _or = _equals_1;
    }
    if (_or) {
      _xifexpression = this.readSql((this.pathDestinationRoot + "/installation/sql/mysql/joomla.sql"));
    }
    _builder.append(_xifexpression, "");
    _builder.newLineIfNotEmpty();
    String _xifexpression_1 = null;
    databaseKind _dbtype_2 = this.dbconfig.getDbtype();
    String _string_2 = _dbtype_2.toString();
    boolean _equals_2 = _string_2.equals("sqlsrv");
    if (_equals_2) {
      _xifexpression_1 = this.readSql((this.pathDestinationRoot + "/installation/sql/sqlazure/joomla.sql"));
    }
    _builder.append(_xifexpression_1, "");
    _builder.newLineIfNotEmpty();
    {
      website_Conf _website_conf = this.config.getWebsite_conf();
      String _exampledata = _website_conf.getExampledata();
      boolean _equals_3 = _exampledata.equals("yes");
      if (_equals_3) {
        _builder.append("#--------------------------------------------------------------Sample Data ---------------------------------------------------");
        _builder.newLine();
        String _readSql = this.readSql((this.pathDestinationRoot + "/installation/sql/mysql/sample_data.sql"));
        _builder.append(_readSql, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("»");
    _builder.newLine();
    return _builder;
  }
  
  public String readSql(final String path) {
    try {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      StringBuffer result = new StringBuffer();
      String line = br.readLine();
      boolean _notEquals = (!Objects.equal(line, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          result.append((line + "\n"));
          String _readLine = br.readLine();
          line = _readLine;
        }
        boolean _notEquals_1 = (!Objects.equal(line, null));
        _while = _notEquals_1;
      }
      br.close();
      return result.toString();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
