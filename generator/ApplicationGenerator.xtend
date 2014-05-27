package de.thm.icampus.cjsl.generator

import de.thm.icampus.cjsl.cjsl.DefaultEditor
import de.thm.icampus.cjsl.cjsl.DefaultLanguage
import de.thm.icampus.cjsl.cjsl.DefaultViewLevelReference
import de.thm.icampus.cjsl.cjsl.EditorReference
import de.thm.icampus.cjsl.cjsl.EditorType
import de.thm.icampus.cjsl.cjsl.LanguageReference
import de.thm.icampus.cjsl.cjsl.LanguageType
import de.thm.icampus.cjsl.cjsl.Template
import de.thm.icampus.cjsl.cjsl.TimeZone
import de.thm.icampus.cjsl.cjsl.UserGroup
import de.thm.icampus.cjsl.cjsl.ViewLevel
import de.thm.icampus.cjsl.cjsl.ViewLevelRights

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.Calendar
import java.util.Collection
import java.util.Enumeration
import java.util.HashMap
import java.util.LinkedList
import java.util.Random
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObjectimport java.io.FileReader
import java.io.BufferedReader

abstract class ApplicationGenerator {
	
var Baum uti = new Baum

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
	
	def String isEmpty(String paramsValue, String defaultval){
		
		if(paramsValue == null || paramsValue.empty)
		return defaultval
		
		return paramsValue
		
	}
	
	def String isEmpty(EObject obj, String paramsValue, String defaultval){
		
		if(obj == null || paramsValue == null || paramsValue.empty)
		return defaultval
		
		return paramsValue
		
	}
	
	def int isEmpty(int paramsValue, int defaultval){
		
		if(paramsValue == 0)
		return defaultval
		
		return paramsValue
		
	}
	
	def String  isEmpty(String paramsValue){
		
		if(paramsValue == null)
		return "0"
		
		return "1"
		
	}
	
def  int getTemplateid(Template temp, EList<Template> listTemplate){
	// TODO Auto-generated method stub
	if(listTemplate == null || temp == null)
	return 0
	var int id =0
	for(Template t: listTemplate){
		if(temp.name.equals(t.name)){
			return id
		}
		id= id +1
	}
	return 0
}
	def String valueParser(String value){
		
		switch(value.toLowerCase){
			case "yes" :
				  return  1 +""
			case "custom":
				  return  1 + ""
			case "hide":
				return 0 +""
			case "no":
			      return 0 +""
			case "custom":
			     return 2 +""
			     
			 case "after":
			      return 2 + ""
			      
			 case "before":
			      return 1 + ""
			     
			case "index, follow":
				return " "
				
			case "index, no follow":
				return value.toLowerCase
				
			case "no index, follow":
				return value.toLowerCase
				
			case "no index, no follow":
				return value.toLowerCase
				
			case "off-caching disabled":
				 return 0+""
				 
			case "on-conservative caching":
				return 1+""
				
			case "on-progressive caching":
					return 2 +""
			case "file":
			   return  value.toLowerCase
			   
			case "cache_lite":
					return "cachelite"
			case "system default":
					return "default"
			case "none":
				 return "none"
				 
			case "simple":
				return "simple"
				
			case "maximum":
				 return "maximum"
				 
			case "development":
				 return "development"
				 
			case"php mail":
				return "mail"
				
			case"sendmail":
				return "sendmail"
			
			case "smtp":
					return "smtp"
			case "inherited":
					return " "
			case "accepted":
		  		return 1 +""
		   case "denied":
		      return 0 +""
		}
		return 0 +""
	}
	
	def int valueParserint(String value){
		
		switch(value.toLowerCase){
			case "none" :
				  return  0
			case "administrator only":
				  return 1
			case "entire site":
				 return 2
					
				  }
				  
		return 0
	}
	
	def String selectedEdit(EditorType editTyp){
	
	if(editTyp == null)
	 return "tinymce"
		
		if(editTyp.eClass.name.equals("EditorReference")){
			
			var EditorReference te =  editTyp as EditorReference
			return te.reference.name.toLowerCase
		}
		if(editTyp.eClass.name.equals("DefaultEditorReference")){
			
			var DefaultEditor te =  editTyp as DefaultEditor
			return te.reference.getName().toLowerCase
		}	
		
		return "tinymce"
		

	
	}
	
	
	def String selectedSiteacess(ViewLevelRights siteacessTyp, EList<ViewLevel> config){
	
	if(siteacessTyp == null)
	 	return "1"
		
		if(siteacessTyp.eClass.name.equals("ViewLevelReference")){
			var int count = 4
			var ViewLevel ref =  siteacessTyp as ViewLevel
			for(acess: config ){
				if(acess.equals(ref)){
					return count + ""
				}
			count = count + 1
			}
			
		}
		if(siteacessTyp.eClass.name.equals("DefaultViewLevelReference")){
			
			
			var DefaultViewLevelReference te =  siteacessTyp as DefaultViewLevelReference
			
		switch(te.ref.getName()){
			case "public":
						return 1 +""
			case "registered":
						return 2 + ""
			case "special":
						return 3 + ""
			}
		}	
		
		return "1"
		
	}
	
	
	
	def String selectedLanguage(LanguageType lang ){
		if(lang == null)
		return " "
		
		if(lang.eClass.name.equalsIgnoreCase("LanguageTypeReference")){
			
			var LanguageReference refLang = lang as LanguageReference
			if( refLang.eClass.name.equalsIgnoreCase("LanguageReference")){
				var LanguageReference newlang = refLang as LanguageReference
				return newlang.reference.name
			}
			
			if( refLang.eClass.name.equalsIgnoreCase("DefaultLanguageReference")){
				var DefaultLanguage newlang = refLang as DefaultLanguage
				return newlang.reference.name()
			}
		}
		return " "
	}
	
	def  extractArchive(File archive, File destDir) throws Exception {
	        if (!destDir.exists()) {
	            destDir.mkdir();
	        }
	 
	       var ZipFile zipFile = new ZipFile(archive);
	       var Enumeration entries = zipFile.entries();
	 
	       var byte[] buffer = newByteArrayOfSize(16384);
	       var  int len;
	        while (entries.hasMoreElements()) {
	           var ZipEntry entry = entries.nextElement() as ZipEntry;
	 
	           var String entryFileName = entry.getName();
	 
	           var File dir  = buildDirectoryHierarchyFor(entryFileName, destDir);
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }
	 
	            if (!entry.isDirectory()) {
	              var  BufferedOutputStream bos = new BufferedOutputStream(
	                        new FileOutputStream(new File(destDir, entryFileName)));
	 
	               var BufferedInputStream bis = new BufferedInputStream(zipFile
	                        .getInputStream(entry));
	 
	                while ((len = bis.read(buffer)) > 0) {
	                    bos.write(buffer, 0, len);
	                }
	 
	                bos.flush();
	                bos.close();
	                bis.close();
	            }
	        }
	                zipFile.close();
	    }
	    
public def  deleteFolder(File folder) {
   var  File[] files = folder.listFiles();
    if(files!=null) { //some JVMs return null for empty dirs
        for(File f: files) {
            if(f.isDirectory()) {
                deleteFolder(f);
            } else {
                f.delete();
            }
        }
    }
    folder.delete();
}
 def File buildDirectoryHierarchyFor(String entryName, File destDir) {
	      var  int lastIndex = entryName.lastIndexOf('/');
	      var  String entryFileName = entryName.substring(lastIndex + 1);
	      var  String internalPathToEntry = entryName.substring(0, lastIndex + 1);
	        return new File(destDir, internalPathToEntry);
	    }
	    

public def String searchDateTime(){
	
	return searchDate() + " " + searchTime();
}

public def String searchDate(){
	var Calendar cal = Calendar.getInstance();
	var int m = cal.get(Calendar.MONTH)+1;
	var String monat;
	if(m < 10){
		monat = "0"+ m;
		}
	else{ monat = (m +1) +"";}
	
	m= cal.get(Calendar.DATE) ;
	var String date;
	if(m<10){
		date = "0" + cal.get(Calendar.DATE);
	}
	else{
		date = cal.get(Calendar.DATE) + "";
	}
	var	 String result = cal.get(Calendar.YEAR) + "-" + monat + "-" + date;
	
	return result;
				 		
	
}

public def String searchTime(){
	var Calendar cal = Calendar.getInstance();
	var int i =  cal.get(Calendar.HOUR_OF_DAY);
	var String std;
	var String  min;
	var String  sec;
	
	if(i<10){
		std = "0" + cal.get(Calendar.HOUR_OF_DAY);
	}
	else{
		std=  cal.get(Calendar.HOUR_OF_DAY)+"";
	}
	i = cal.get(Calendar.MINUTE);
	
	if(i<10){
		min = "0"+cal.get(Calendar.MINUTE);
	}
	else{
		min = cal.get(Calendar.MINUTE)+"";
	}
	 i=cal.get(Calendar.SECOND);
	 
	 if(i<10){
	 	sec = "0"+cal.get(Calendar.SECOND);
	 }
	 else{
	 	sec = cal.get(Calendar.SECOND)+"";
	 }
	var	 String date = std+ ":" +min+ ":" +sec;
	return date;
}
public def  String genaratePass(){
		var String result = new String() ;
		var Random ran = new Random();
		var String letter = "abcdefghijklmnopqrstuvwxyz0123456789";
		var char[] arr = letter.toCharArray;
		
		for(Integer i: 1..8){
			var int in = ran.nextInt(34);
			result =  arr.get(in) + result;
			
		
		}
		
		return result;
	}
	

 def  String searchattribut (EObject element, String attribut){
	// TODO Auto-generated method stub
	
	if(element==null)
	return new String;
	
	if (element.eClass.name.toString.toLowerCase.equals("timezone")) {
	 	var TimeZone elem = element as TimeZone;
		
			switch (attribut) {
			case "country":
			  return elem.country
			case "continent":
				return elem.continent
			default  :
				return elem.getName()
				
			}	
		
	}
	if (element.eClass.name.toString.toLowerCase.equals("usergroup")) {
	 	var UserGroup elem = element as UserGroup;
		
			switch (attribut) {
			case "name":
			  return elem.name
			default  :
				return " "
				
			}	
		
	}
	return null;
}

public def  EList<BaumElement> transformArtefact(EList<? extends EObject> artefact){
	
	if(artefact == null)
	 return null
	 
	 var EList<BaumElement> result = new BasicEList<BaumElement>()
	 
	 if( artefact.get(0).eClass.name.toString.toLowerCase.equals("usergroup")){
	   var EList<UserGroup> groups = artefact as EList<UserGroup>
	   
		 for(UserGroup g: groups){
		 	if(g.parent != null){
	 	   result.addAll(new BaumElement(groups.indexOf(g),groups.indexOf(g.parent)))
	 	   
	 	   }else{
	 	   	 result.addAll(new BaumElement(groups.indexOf(g),-1))
	 	   	
	 	   }
		 }
		 }
		 var int max = orderGroup(result);
		 var BaumElement maxrgt = new BaumElement(-1,max);
		 result.add(maxrgt);
	 return  result ;
}
  public def int orderGroup(EList<BaumElement> groups) {
	
	var int maxrgt = 16
	
	for(BaumElement g: groups){
		if(g.parent == -1){
			
			g.setLft(maxrgt)
			maxrgt = uti.buildthegroups(groups, g, uti.searchAllkids(groups, g), maxrgt+1 ,0) 
			g.setRgt(maxrgt);
			maxrgt = maxrgt +1
		
		}
	}
   
   return maxrgt
  
}

public def BaumElement searchElem(EList<BaumElement> list, int id){
	var BaumElement result = new BaumElement()
	for(BaumElement b : list){
		if(b.id == id)
		result = b
	}
	return result
}
 
 public def int indexOf(EObject e, EList<?> list, int startValue, int defaultValue){
 	if(e == null)
 	return defaultValue
 	
 	if(list.indexOf(e) == -1)
 	return defaultValue
 	
 	return list.indexOf(e)+startValue
 }

	
}