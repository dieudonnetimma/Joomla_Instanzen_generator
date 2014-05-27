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

class SQLGenerator extends ApplicationGenerator {
	
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
		fpa.generateFile("mddsql/index.php", defineIndex )
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

def CharSequence defineIndex()'''
<?php

require_once 'definemdd.php';
require_once 'com/databasemdd.php';

if (!file_exists(JPATH_MDD.'/com/application.sql')) {
   header('Location:'.substr($_SERVER['REQUEST_URI'], 0, strpos($_SERVER['REQUEST_URI'], 'mddsql/index.php')).'index.php');
		exit();
}


$classData = new DatabaseMdd();

$options =  array(
		'db_type' =>'«dbconfig.dbtype.toString»',
		'db_host' => '«dbconfig.host»',
		'db_name' => '«dbconfig.database»',
		'db_prefix' => '«dbconfig.prefix»_',
		'db_created' => null,
		'db_user' => '«dbconfig.user»',
		'db_pass' => '«dbconfig.password»',
		'schema' => 'com/application.sql',
		'user_schema' => 'com/user.sql'
);



if(!empty($_GET['username'] ) && !empty($_GET['pass'])){

	$userpass = $_GET['pass'];
	$salt = sha1(32);
	$passmD5 = md5($userpass.$salt);

$pass = $passmD5.':'.$salt;

$classData->initialise($options);


$newdb = DatabaseMdd::getDbo($options->db_type, $options->db_host, $options->db_user, $options->db_pass, null, $options->db_prefix, false);
$newdb->setQuery("update  #__users set password='$pass'where username= '«app.cjsl_user.user.get(0).name»'" );
$re = $newdb->execute();

echo '<h3 style="color:green;"> Der neue Passwort wurde gespeichert</h3>';
sleep(10);
while(JFolder::delete(JPATH_MDD."/com")){};
header('Location:'.substr($_SERVER['REQUEST_URI'], 0, strpos($_SERVER['REQUEST_URI'], 'mddsql/index.php')).'index.php');
exit();
}else{
	header('Location: '.substr($_SERVER['REQUEST_URI'], 0, strpos($_SERVER['REQUEST_URI'], 'index.php')).'login.php');
	exit();

}
'''
	
}