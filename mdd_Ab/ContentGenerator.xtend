package de.thm.icampus.cjsl.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import de.thm.icampus.cjsl.cjsl.Application
import de.thm.icampus.cjsl.cjsl.cJSL_Content

class ContentGenerator extends ApplicationLibrary {
	IFileSystemAccess acc
	 Application app
	cJSL_Content contents
	
	new(IFileSystemAccess newacc, Application newapp) {
		
		app= newapp
		acc= newacc
		
		contents = app.cjsl_content
	}
	
}