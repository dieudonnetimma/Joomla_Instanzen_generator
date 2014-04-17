package de.thm.icampus.cjsl.generator;

import de.thm.icampus.cjsl.cjsl.DefaultEditor;
import de.thm.icampus.cjsl.cjsl.DefaultLanguage;
import de.thm.icampus.cjsl.cjsl.DefaultViewLevelReference;
import de.thm.icampus.cjsl.cjsl.EditorReference;
import de.thm.icampus.cjsl.cjsl.EditorType;
import de.thm.icampus.cjsl.cjsl.LanguageReference;
import de.thm.icampus.cjsl.cjsl.LanguageType;
import de.thm.icampus.cjsl.cjsl.Template;
import de.thm.icampus.cjsl.cjsl.TimeZone;
import de.thm.icampus.cjsl.cjsl.UserGroup;
import de.thm.icampus.cjsl.cjsl.ViewLevel;
import de.thm.icampus.cjsl.cjsl.ViewLevelRights;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class Util {
	
	public  int inkrementAll(UserGroup g, int rgt){
		g.setLft(rgt);
		g.setRgt(rgt+1);
		
		
		return rgt+2;
	}


	public  int inkrementLgt(UserGroup g, int rgt){
		g.setLft(rgt);	
		return rgt+1;
	}
	public  int inkrementRgt(UserGroup g, int rgt){
		g.setRgt(rgt);	
		return rgt+1;
	}
	public  LinkedList<UserGroup> searchAllkids(EList<UserGroup>groups, UserGroup parent){
		
		 LinkedList<UserGroup> result = new LinkedList<UserGroup>();
		
		if(groups == null)
		return result;
		
		for(UserGroup g: groups ){
			if(g.getParent() != null){
				if(g.getParent() .getName().equals(parent.getName()))
			      result.add(g);
			  
			  }
		}
		
		return result;
		
	}


	public  int buildthegroups(EList<UserGroup> groups, UserGroup parent,LinkedList<UserGroup> kids, int rgt, int index){
		
	if (kids.size() <= index)
		return rgt;
	
	return (searchAllkids(groups, kids.get(index)).isEmpty()==false) ? 
	 buildthegroups(groups,  parent,  kids ,  inkrementRgt(kids.get(index), buildthegroups(groups,  kids.get(index), searchAllkids(groups, kids.get(index)), inkrementLgt(kids.get(index), rgt), 0)), index +1 ) :
	 	buildthegroups(groups,  parent,  kids ,  inkrementAll(kids.get(index), rgt), index +1 ) ;
	}
	 

	

}
