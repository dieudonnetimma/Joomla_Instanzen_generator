/**
 * 
 */
package de.thm.icampus.cjsl.generator;

/**
 * @author timma
 *
 */
public class BaumElement {
int id;
int parent;
int lft;
int rgt;

public BaumElement(int elemId, int elemParent){
	
	this.id= elemId;
	this.parent = elemParent;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getParent() {
	return parent;
}

public void setParent(int parentid) {
	this.parent = parentid;
}

public int getLft() {
	return lft;
}

public void setLft(int lft) {
	this.lft = lft;
}

public int getRgt() {
	return rgt;
}

public void setRgt(int rgt) {
	this.rgt = rgt;
}

BaumElement() {
 
}

}
