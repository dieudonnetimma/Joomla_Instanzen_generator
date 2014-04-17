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

class SQLGenerator extends ApplicationGenerator {
	
	public IFileSystemAccess fpa;
	public  Application app;
	public String pathDestinationRoot;
	public cJSL_Configuration config;
	public db_Conf dbconfig
	public UserGenerator users 
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
		
		fpa.generateFile("mddsql/application.sql", contentGen())
		fpa.generateFile("mddsql/user.sql", usercontengen())
		deleteFolder(new File(pathDestinationRoot+"/installation"))
	}

def CharSequence usercontengen()'''
#--------------------------------------------------------------User-----------------------------------------------------------
	« users.generateAllUser»
	
	«users.generateUserProfile»
	«users.generateGroups(orderGroup(app.cjsl_user.usergroups))»
	«users.generateUserGroupsMap»
	«users.generateViewLevel»
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
	»
	'''
	
	def String readSql( String path){
	var FileReader fr = new FileReader(path);
    var BufferedReader br = new BufferedReader(fr);
    
    var StringBuffer result = new StringBuffer()
    var String line = br.readLine
    while(line != null){
    	result.append(line +"\n")
    	line = br.readLine
    }

    br.close();
    
    return result.toString
	}
	
}