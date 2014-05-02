package de.thm.icampus.cjsl.generator;

import de.thm.icampus.cjsl.cjsl.Application;
import de.thm.icampus.cjsl.generator.SQLGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;

@SuppressWarnings("all")
public class AccessGenerator extends SQLGenerator {
  public AccessGenerator(final IFileSystemAccess acc, final Application app) {
    super(acc, app);
  }
}
