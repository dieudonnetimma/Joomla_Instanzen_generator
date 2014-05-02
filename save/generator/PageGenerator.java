package de.thm.icampus.cjsl.generator;

import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.cjsl.cJSL_Page;
import de.thm.icampus.cjsl.generator.SQLGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;

@SuppressWarnings("all")
public class PageGenerator extends SQLGenerator {
  private cJSL_Page pages;
  
  public PageGenerator(final IFileSystemAccess acc, final Application app) {
    super(acc, app);
    cJSL_Page _cjsl_page = app.getCjsl_page();
    this.pages = _cjsl_page;
  }
}
