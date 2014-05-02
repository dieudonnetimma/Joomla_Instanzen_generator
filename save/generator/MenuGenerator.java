package de.thm.icampus.cjsl.generator;

import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.cjsl.cJSL_Menu;
import de.thm.icampus.cjsl.generator.SQLGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;

@SuppressWarnings("all")
public class MenuGenerator extends SQLGenerator {
  private cJSL_Menu menus;
  
  public MenuGenerator(final IFileSystemAccess acc, final Application app) {
    super(acc, app);
    cJSL_Menu _cjsl_menu = app.getCjsl_menu();
    this.menus = _cjsl_menu;
  }
}
