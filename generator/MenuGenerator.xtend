package de.thm.icampus.cjsl.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import de.thm.icampus.cjsl.cjsl.Application
import de.thm.icampus.cjsl.cjsl.cJSL_Menu

class MenuGenerator extends SQLGenerator {
	
	cJSL_Menu menus
	new(IFileSystemAccess acc, Application app) {
		super(acc, app)
		menus = app.cjsl_menu
	}
	
	
}