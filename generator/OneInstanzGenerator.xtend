package de.thm.icampus.cjsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import de.thm.icampus.cjsl.cjsl.Application
import java.io.FileReader
import java.io.BufferedReader
import de.thm.icampus.cjsl.cjsl.cJSL_Configuration
import de.thm.icampus.cjsl.cjsl.db_Conf
import java.io.File
import org.eclipse.emf.common.util.EList
import de.thm.icampus.cjsl.cjsl.CoreAccessLevel
import java.util.List
import org.eclipse.emf.ecore.EObject
import java.util.Iterator

class OneInstanzGenerator extends ApplicationGenerator {
	
	public IFileSystemAccess fpa;
	public  Application app;
	public String pathDestinationRoot;
	public cJSL_Configuration config;
	public db_Conf dbconfig
	public UserGenerator users 
	public Installationgen install = new Installationgen
	new (IFileSystemAccess acc, Application app, String appname){
		
		this.fpa = acc;
		this.app = app;
		this.config = app.cjsl_configuration
		dbconfig = config.db_conf
		pathDestinationRoot = app.applicationPath + "/" +appname
		users = new UserGenerator(app)
		}

new(IFileSystemAccess access, Application application) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	
	def generateSQLData() {
		
		fpa.generateFile("mddsql/com/application.sql", contentGen())
		fpa.generateFile("mddsql/com/user.sql", usercontengen())
		deleteFolder(new File(pathDestinationRoot+"/installation"))
		fpa.generateFile("includes/framework.php", install.overWriteFramework)
		fpa.generateFile("mddsql/definemdd.php", install.defineDefine)
		fpa.generateFile("mddsql/com/databasemdd.php",install.defineDatabaseMDD)
		fpa.generateFile("mddsql/login.php",install.defineFormular)
		fpa.generateFile("mddsql/index.php", install.defineIndex(dbconfig, app.cjsl_user.user.get(0)) )
		//fpa.generateFile("mddsql/test.sql", testgen() )
	}
//	def CharSequence testgen(){
//	
//	
//	return users.generateGroupsCoreAcess
//	}

def CharSequence usercontengen()'''
#--------------------------------------------------------------User-----------------------------------------------------------
	« users.generateAllUser»
	
	«users.generateUserProfile»
	
	«users.generateGroups(transformArtefact(app.cjsl_user.usergroups))»
	
	«users.generateUserGroupsMap»
	
	«users.generateViewLevel»
	
	«users.generateGroupsCoreAcess»
'''
	
	
	def CharSequence contentGen()'''
	«if (dbconfig.dbtype.toString.equals("mysql") || dbconfig.dbtype.toString.equals("mysqli")) 
	readSql(pathDestinationRoot+"/installation/sql/mysql/joomla.sql") »
	«if (dbconfig.dbtype.toString.equals("sqlsrv")) 
	readSql(pathDestinationRoot+"/installation/sql/sqlazure/joomla.sql") »
	«IF (config.website_conf.exampledata.equals("yes"))»
	#--------------------------------------------------------------Sample Data ---------------------------------------------------
	«readSql(pathDestinationRoot+"/installation/sql/mysql/sample_data.sql")»
	«ENDIF»
	'''
	
	


	
}