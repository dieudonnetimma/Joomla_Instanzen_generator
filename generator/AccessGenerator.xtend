package de.thm.icampus.cjsl.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import de.thm.icampus.cjsl.cjsl.Application

class AccessGenerator extends SQLGenerator  {
	
	
	new(IFileSystemAccess acc, Application app) {
		super(acc, app)
	}
	
}