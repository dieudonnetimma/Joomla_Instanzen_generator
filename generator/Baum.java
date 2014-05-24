package de.thm.icampus.cjsl.generator;

import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;

import de.thm.icampus.cjsl.cjsl.UserGroup;

public class Baum {
	
	public  int inkrementAll(BaumElement g, int rgt){
		g.setLft(rgt);
		g.setRgt(rgt+1);
		
		
		return rgt+2;
	}


	public  int inkrementLgt(BaumElement g, int rgt){
		g.setLft(rgt);	
		return rgt+1;
	}
	public  int inkrementRgt(BaumElement g, int rgt){
		g.setRgt(rgt);	
		return rgt+1;
	}
	public  LinkedList<BaumElement> searchAllkids(EList<BaumElement>groups, BaumElement parent){
		
		 LinkedList<BaumElement> result = new LinkedList<BaumElement>();
		
		if(groups == null)
		return result;
		
		for(BaumElement g: groups ){
			if(g.getParent() != -1){
				if(g.getParent() == parent.getId())
			      result.add(g);
			  
			  }
		}
		
		return result;
		
	}


	public  int buildthegroups(EList<BaumElement> groups, BaumElement parent,LinkedList<BaumElement> kids, int rgt, int index){
		
	if (kids.size() <= index)
		return rgt;
	
	return (searchAllkids(groups, kids.get(index)).isEmpty()==false) ? 
	 buildthegroups(groups,  parent,  kids ,  inkrementRgt(kids.get(index), buildthegroups(groups,  kids.get(index), searchAllkids(groups, kids.get(index)), inkrementLgt(kids.get(index), rgt), 0)), index +1 ) :
	 	buildthegroups(groups,  parent,  kids ,  inkrementAll(kids.get(index), rgt), index +1 ) ;
	}
	 

	

}
