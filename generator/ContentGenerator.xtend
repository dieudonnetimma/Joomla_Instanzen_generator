package de.thm.icampus.cjsl.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import de.thm.icampus.cjsl.cjsl.Application
import de.thm.icampus.cjsl.cjsl.cJSL_Content

class ContentGenerator extends SQLGenerator {
	cJSL_Content contents
	
	new(IFileSystemAccess acc, Application app) {
		super(acc, app)
		contents = app.cjsl_content
	}
	
}