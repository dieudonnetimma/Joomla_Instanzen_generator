package de.thm.icampus.cjsl.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import de.thm.icampus.cjsl.cjsl.Application
import de.thm.icampus.cjsl.cjsl.cJSL_Page

class PageGenerator extends SQLGenerator {
	
	cJSL_Page pages 
	new(IFileSystemAccess acc, Application app) {
		super(acc, app)
		pages = app.cjsl_page
	}
	
}