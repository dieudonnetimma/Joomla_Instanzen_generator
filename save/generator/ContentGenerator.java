package de.thm.icampus.cjsl.generator;

import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.cjsl.cJSL_Content;
import de.thm.icampus.cjsl.generator.SQLGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;

@SuppressWarnings("all")
public class ContentGenerator extends SQLGenerator {
  private cJSL_Content contents;
  
  public ContentGenerator(final IFileSystemAccess acc, final Application app) {
    super(acc, app);
    cJSL_Content _cjsl_content = app.getCjsl_content();
    this.contents = _cjsl_content;
  }
}
