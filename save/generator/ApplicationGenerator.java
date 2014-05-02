package de.thm.icampus.cjsl.generator;

import com.google.common.base.Objects;
import de.thm.icampus.cjsl.cjsl.DefaultEditor;
import de.thm.icampus.cjsl.cjsl.DefaultLanguage;
import de.thm.icampus.cjsl.cjsl.DefaultViewLevelReference;
import de.thm.icampus.cjsl.cjsl.Editor;
import de.thm.icampus.cjsl.cjsl.EditorReference;
import de.thm.icampus.cjsl.cjsl.EditorType;
import de.thm.icampus.cjsl.cjsl.Language;
import de.thm.icampus.cjsl.cjsl.LanguageReference;
import de.thm.icampus.cjsl.cjsl.LanguageType;
import de.thm.icampus.cjsl.cjsl.Template;
import de.thm.icampus.cjsl.cjsl.TimeZone;
import de.thm.icampus.cjsl.cjsl.UserGroup;
import de.thm.icampus.cjsl.cjsl.ViewLevel;
import de.thm.icampus.cjsl.cjsl.ViewLevelRights;
import de.thm.icampus.cjsl.cjsl.defaultEditorKind;
import de.thm.icampus.cjsl.cjsl.defaultLanguageKind;
import de.thm.icampus.cjsl.cjsl.defaultViewLevel;
import de.thm.icampus.cjsl.generator.BaumElement;
import de.thm.icampus.cjsl.generator.Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public abstract class ApplicationGenerator {
  private Util uti = new Util();
  
  public String isEmpty(final String paramsValue, final String defaultval) {
    boolean _or = false;
    boolean _equals = Objects.equal(paramsValue, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _isEmpty = paramsValue.isEmpty();
      _or = _isEmpty;
    }
    if (_or) {
      return defaultval;
    }
    return paramsValue;
  }
  
  public String isEmpty(final EObject obj, final String paramsValue, final String defaultval) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _equals = Objects.equal(obj, null);
    if (_equals) {
      _or_1 = true;
    } else {
      boolean _equals_1 = Objects.equal(paramsValue, null);
      _or_1 = _equals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _isEmpty = paramsValue.isEmpty();
      _or = _isEmpty;
    }
    if (_or) {
      return defaultval;
    }
    return paramsValue;
  }
  
  public int isEmpty(final int paramsValue, final int defaultval) {
    if ((paramsValue == 0)) {
      return defaultval;
    }
    return paramsValue;
  }
  
  public String isEmpty(final String paramsValue) {
    boolean _equals = Objects.equal(paramsValue, null);
    if (_equals) {
      return "0";
    }
    return "1";
  }
  
  public int getTemplateid(final Template temp, final EList<Template> listTemplate) {
    boolean _or = false;
    boolean _equals = Objects.equal(listTemplate, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(temp, null);
      _or = _equals_1;
    }
    if (_or) {
      return 0;
    }
    int id = 0;
    for (final Template t : listTemplate) {
      {
        String _name = temp.getName();
        String _name_1 = t.getName();
        boolean _equals_2 = _name.equals(_name_1);
        if (_equals_2) {
          return id;
        }
        id = (id + 1);
      }
    }
    return 0;
  }
  
  public String valueParser(final String value) {
    String _lowerCase = value.toLowerCase();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_lowerCase,"yes")) {
        _matched=true;
        return (Integer.valueOf(1) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"custom")) {
        _matched=true;
        return (Integer.valueOf(1) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"hide")) {
        _matched=true;
        return (Integer.valueOf(0) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"no")) {
        _matched=true;
        return (Integer.valueOf(0) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"custom")) {
        _matched=true;
        return (Integer.valueOf(2) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"after")) {
        _matched=true;
        return (Integer.valueOf(2) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"before")) {
        _matched=true;
        return (Integer.valueOf(1) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"index, follow")) {
        _matched=true;
        return " ";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"index, no follow")) {
        _matched=true;
        return value.toLowerCase();
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"no index, follow")) {
        _matched=true;
        return value.toLowerCase();
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"no index, no follow")) {
        _matched=true;
        return value.toLowerCase();
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"off-caching disabled")) {
        _matched=true;
        return (Integer.valueOf(0) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"on-conservative caching")) {
        _matched=true;
        return (Integer.valueOf(1) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"on-progressive caching")) {
        _matched=true;
        return (Integer.valueOf(2) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"file")) {
        _matched=true;
        return value.toLowerCase();
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"cache_lite")) {
        _matched=true;
        return "cachelite";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"system default")) {
        _matched=true;
        return "default";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"none")) {
        _matched=true;
        return "none";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"simple")) {
        _matched=true;
        return "simple";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"maximum")) {
        _matched=true;
        return "maximum";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"development")) {
        _matched=true;
        return "development";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"php mail")) {
        _matched=true;
        return "mail";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"sendmail")) {
        _matched=true;
        return "sendmail";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"smtp")) {
        _matched=true;
        return "smtp";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"inherited")) {
        _matched=true;
        return " ";
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"accepted")) {
        _matched=true;
        return (Integer.valueOf(1) + "");
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"denied")) {
        _matched=true;
        return (Integer.valueOf(0) + "");
      }
    }
    return (Integer.valueOf(0) + "");
  }
  
  public int valueParserint(final String value) {
    String _lowerCase = value.toLowerCase();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_lowerCase,"none")) {
        _matched=true;
        return 0;
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"administrator only")) {
        _matched=true;
        return 1;
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase,"entire site")) {
        _matched=true;
        return 2;
      }
    }
    return 0;
  }
  
  public String selectedEdit(final EditorType editTyp) {
    boolean _equals = Objects.equal(editTyp, null);
    if (_equals) {
      return "tinymce";
    }
    EClass _eClass = editTyp.eClass();
    String _name = _eClass.getName();
    boolean _equals_1 = _name.equals("EditorReference");
    if (_equals_1) {
      EditorReference te = ((EditorReference) editTyp);
      Editor _reference = te.getReference();
      String _name_1 = _reference.getName();
      return _name_1.toLowerCase();
    }
    EClass _eClass_1 = editTyp.eClass();
    String _name_2 = _eClass_1.getName();
    boolean _equals_2 = _name_2.equals("DefaultEditorReference");
    if (_equals_2) {
      DefaultEditor te_1 = ((DefaultEditor) editTyp);
      defaultEditorKind _reference_1 = te_1.getReference();
      String _name_3 = _reference_1.getName();
      return _name_3.toLowerCase();
    }
    return "tinymce";
  }
  
  public String selectedSiteacess(final ViewLevelRights siteacessTyp, final EList<ViewLevel> config) {
    boolean _equals = Objects.equal(siteacessTyp, null);
    if (_equals) {
      return "1";
    }
    EClass _eClass = siteacessTyp.eClass();
    String _name = _eClass.getName();
    boolean _equals_1 = _name.equals("ViewLevelReference");
    if (_equals_1) {
      int count = 4;
      ViewLevel ref = ((ViewLevel) siteacessTyp);
      for (final ViewLevel acess : config) {
        {
          boolean _equals_2 = acess.equals(ref);
          if (_equals_2) {
            return (Integer.valueOf(count) + "");
          }
          count = (count + 1);
        }
      }
    }
    EClass _eClass_1 = siteacessTyp.eClass();
    String _name_1 = _eClass_1.getName();
    boolean _equals_2 = _name_1.equals("DefaultViewLevelReference");
    if (_equals_2) {
      DefaultViewLevelReference te = ((DefaultViewLevelReference) siteacessTyp);
      defaultViewLevel _ref = te.getRef();
      String _name_2 = _ref.getName();
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_name_2,"public")) {
          _matched=true;
          return (Integer.valueOf(1) + "");
        }
      }
      if (!_matched) {
        if (Objects.equal(_name_2,"registered")) {
          _matched=true;
          return (Integer.valueOf(2) + "");
        }
      }
      if (!_matched) {
        if (Objects.equal(_name_2,"special")) {
          _matched=true;
          return (Integer.valueOf(3) + "");
        }
      }
    }
    return "1";
  }
  
  public String selectedLanguage(final LanguageType lang) {
    boolean _equals = Objects.equal(lang, null);
    if (_equals) {
      return " ";
    }
    EClass _eClass = lang.eClass();
    String _name = _eClass.getName();
    boolean _equalsIgnoreCase = _name.equalsIgnoreCase("LanguageTypeReference");
    if (_equalsIgnoreCase) {
      LanguageReference refLang = ((LanguageReference) lang);
      EClass _eClass_1 = refLang.eClass();
      String _name_1 = _eClass_1.getName();
      boolean _equalsIgnoreCase_1 = _name_1.equalsIgnoreCase("LanguageReference");
      if (_equalsIgnoreCase_1) {
        LanguageReference newlang = ((LanguageReference) refLang);
        Language _reference = newlang.getReference();
        return _reference.getName();
      }
      EClass _eClass_2 = refLang.eClass();
      String _name_2 = _eClass_2.getName();
      boolean _equalsIgnoreCase_2 = _name_2.equalsIgnoreCase("DefaultLanguageReference");
      if (_equalsIgnoreCase_2) {
        DefaultLanguage newlang_1 = ((DefaultLanguage) refLang);
        defaultLanguageKind _reference_1 = newlang_1.getReference();
        return _reference_1.name();
      }
    }
    return " ";
  }
  
  public void extractArchive(final File archive, final File destDir) throws Exception {
    boolean _exists = destDir.exists();
    boolean _not = (!_exists);
    if (_not) {
      destDir.mkdir();
    }
    ZipFile zipFile = new ZipFile(archive);
    Enumeration entries = zipFile.entries();
    byte[] buffer = new byte[16384];
    int len = 0;
    boolean _hasMoreElements = entries.hasMoreElements();
    boolean _while = _hasMoreElements;
    while (_while) {
      {
        Object _nextElement = entries.nextElement();
        ZipEntry entry = ((ZipEntry) _nextElement);
        String entryFileName = entry.getName();
        File dir = this.buildDirectoryHierarchyFor(entryFileName, destDir);
        boolean _exists_1 = dir.exists();
        boolean _not_1 = (!_exists_1);
        if (_not_1) {
          dir.mkdirs();
        }
        boolean _isDirectory = entry.isDirectory();
        boolean _not_2 = (!_isDirectory);
        if (_not_2) {
          File _file = new File(destDir, entryFileName);
          FileOutputStream _fileOutputStream = new FileOutputStream(_file);
          BufferedOutputStream bos = new BufferedOutputStream(_fileOutputStream);
          InputStream _inputStream = zipFile.getInputStream(entry);
          BufferedInputStream bis = new BufferedInputStream(_inputStream);
          int _read = bis.read(buffer);
          int _len = len = _read;
          boolean _greaterThan = (_len > 0);
          boolean _while_1 = _greaterThan;
          while (_while_1) {
            bos.write(buffer, 0, len);
            int _read_1 = bis.read(buffer);
            int _len_1 = len = _read_1;
            boolean _greaterThan_1 = (_len_1 > 0);
            _while_1 = _greaterThan_1;
          }
          bos.flush();
          bos.close();
          bis.close();
        }
      }
      boolean _hasMoreElements_1 = entries.hasMoreElements();
      _while = _hasMoreElements_1;
    }
    zipFile.close();
  }
  
  public boolean deleteFolder(final File folder) {
    boolean _xblockexpression = false;
    {
      File[] files = folder.listFiles();
      boolean _notEquals = (!Objects.equal(files, null));
      if (_notEquals) {
        for (final File f : files) {
          boolean _isDirectory = f.isDirectory();
          if (_isDirectory) {
            this.deleteFolder(f);
          } else {
            f.delete();
          }
        }
      }
      _xblockexpression = folder.delete();
    }
    return _xblockexpression;
  }
  
  public File buildDirectoryHierarchyFor(final String entryName, final File destDir) {
    int lastIndex = entryName.lastIndexOf("/");
    String entryFileName = entryName.substring((lastIndex + 1));
    String internalPathToEntry = entryName.substring(0, (lastIndex + 1));
    return new File(destDir, internalPathToEntry);
  }
  
  public String searchDateTime() {
    String _searchDate = this.searchDate();
    String _plus = (_searchDate + " ");
    String _searchTime = this.searchTime();
    return (_plus + _searchTime);
  }
  
  public String searchDate() {
    Calendar cal = Calendar.getInstance();
    int _get = cal.get(Calendar.MONTH);
    int m = (_get + 1);
    String monat = null;
    if ((m < 10)) {
      monat = ("0" + Integer.valueOf(m));
    } else {
      String _plus = (Integer.valueOf((m + 1)) + "");
      monat = _plus;
    }
    int _get_1 = cal.get(Calendar.DATE);
    m = _get_1;
    String date = null;
    if ((m < 10)) {
      int _get_2 = cal.get(Calendar.DATE);
      String _plus_1 = ("0" + Integer.valueOf(_get_2));
      date = _plus_1;
    } else {
      int _get_3 = cal.get(Calendar.DATE);
      String _plus_2 = (Integer.valueOf(_get_3) + "");
      date = _plus_2;
    }
    int _get_4 = cal.get(Calendar.YEAR);
    String _plus_3 = (Integer.valueOf(_get_4) + "-");
    String _plus_4 = (_plus_3 + monat);
    String _plus_5 = (_plus_4 + "-");
    String result = (_plus_5 + date);
    return result;
  }
  
  public String searchTime() {
    Calendar cal = Calendar.getInstance();
    int i = cal.get(Calendar.HOUR_OF_DAY);
    String std = null;
    String min = null;
    String sec = null;
    if ((i < 10)) {
      int _get = cal.get(Calendar.HOUR_OF_DAY);
      String _plus = ("0" + Integer.valueOf(_get));
      std = _plus;
    } else {
      int _get_1 = cal.get(Calendar.HOUR_OF_DAY);
      String _plus_1 = (Integer.valueOf(_get_1) + "");
      std = _plus_1;
    }
    int _get_2 = cal.get(Calendar.MINUTE);
    i = _get_2;
    if ((i < 10)) {
      int _get_3 = cal.get(Calendar.MINUTE);
      String _plus_2 = ("0" + Integer.valueOf(_get_3));
      min = _plus_2;
    } else {
      int _get_4 = cal.get(Calendar.MINUTE);
      String _plus_3 = (Integer.valueOf(_get_4) + "");
      min = _plus_3;
    }
    int _get_5 = cal.get(Calendar.SECOND);
    i = _get_5;
    if ((i < 10)) {
      int _get_6 = cal.get(Calendar.SECOND);
      String _plus_4 = ("0" + Integer.valueOf(_get_6));
      sec = _plus_4;
    } else {
      int _get_7 = cal.get(Calendar.SECOND);
      String _plus_5 = (Integer.valueOf(_get_7) + "");
      sec = _plus_5;
    }
    String date = ((((std + ":") + min) + ":") + sec);
    return date;
  }
  
  public String genaratePass() {
    String result = new String();
    Random ran = new Random();
    String letter = "abcdefghijklmnopqrstuvwxyz0123456789";
    char[] arr = letter.toCharArray();
    IntegerRange _upTo = new IntegerRange(1, 8);
    for (final Integer i : _upTo) {
      {
        int in = ran.nextInt(34);
        char _get = arr[in];
        String _plus = (Character.valueOf(_get) + result);
        result = _plus;
      }
    }
    return result;
  }
  
  public String searchattribut(final EObject element, final String attribut) {
    boolean _equals = Objects.equal(element, null);
    if (_equals) {
      return new String();
    }
    EClass _eClass = element.eClass();
    String _name = _eClass.getName();
    String _string = _name.toString();
    String _lowerCase = _string.toLowerCase();
    boolean _equals_1 = _lowerCase.equals("timezone");
    if (_equals_1) {
      TimeZone elem = ((TimeZone) element);
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(attribut,"country")) {
          _matched=true;
          return elem.getCountry();
        }
      }
      if (!_matched) {
        if (Objects.equal(attribut,"continent")) {
          _matched=true;
          return elem.getContinent();
        }
      }
      return elem.getName();
    }
    EClass _eClass_1 = element.eClass();
    String _name_1 = _eClass_1.getName();
    String _string_1 = _name_1.toString();
    String _lowerCase_1 = _string_1.toLowerCase();
    boolean _equals_2 = _lowerCase_1.equals("usergroup");
    if (_equals_2) {
      UserGroup elem_1 = ((UserGroup) element);
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (Objects.equal(attribut,"name")) {
          _matched_1=true;
          return elem_1.getName();
        }
      }
      return " ";
    }
    return null;
  }
  
  public EList<BaumElement> transformArtefact(final EList<? extends EObject> artefact) {
    boolean _equals = Objects.equal(artefact, null);
    if (_equals) {
      return null;
    }
    EList<BaumElement> result = new BasicEList<BaumElement>();
    EObject _get = artefact.get(0);
    EClass _eClass = _get.eClass();
    String _name = _eClass.getName();
    String _string = _name.toString();
    String _lowerCase = _string.toLowerCase();
    boolean _equals_1 = _lowerCase.equals("usergroup");
    if (_equals_1) {
      EList<UserGroup> groups = ((EList<UserGroup>) artefact);
      for (final UserGroup g : groups) {
        UserGroup _parent = g.getParent();
        boolean _notEquals = (!Objects.equal(_parent, null));
        if (_notEquals) {
          int _indexOf = groups.indexOf(g);
          UserGroup _parent_1 = g.getParent();
          int _indexOf_1 = groups.indexOf(_parent_1);
          BaumElement _baumElement = new BaumElement(_indexOf, _indexOf_1);
          CollectionExtensions.<BaumElement>addAll(result, _baumElement);
        } else {
          int _indexOf_2 = groups.indexOf(g);
          BaumElement _baumElement_1 = new BaumElement(_indexOf_2, (-1));
          CollectionExtensions.<BaumElement>addAll(result, _baumElement_1);
        }
      }
    }
    int max = this.orderGroup(result);
    BaumElement maxrgt = new BaumElement((-1), max);
    result.add(maxrgt);
    return result;
  }
  
  public int orderGroup(final EList<BaumElement> groups) {
    int maxrgt = 16;
    for (final BaumElement g : groups) {
      if ((g.parent == (-1))) {
        g.setLft(maxrgt);
        LinkedList<BaumElement> _searchAllkids = this.uti.searchAllkids(groups, g);
        int _buildthegroups = this.uti.buildthegroups(groups, g, _searchAllkids, (maxrgt + 1), 0);
        maxrgt = _buildthegroups;
        g.setRgt(maxrgt);
        maxrgt = (maxrgt + 1);
      }
    }
    return maxrgt;
  }
  
  public BaumElement searchElem(final EList<BaumElement> list, final int id) {
    BaumElement result = new BaumElement();
    for (final BaumElement b : list) {
      if ((b.id == id)) {
        result = b;
      }
    }
    return result;
  }
  
  public int indexOf(final EObject e, final EList<?> list, final int startValue, final int defaultValue) {
    boolean _equals = Objects.equal(e, null);
    if (_equals) {
      return defaultValue;
    }
    int _indexOf = list.indexOf(e);
    boolean _equals_1 = (_indexOf == (-1));
    if (_equals_1) {
      return defaultValue;
    }
    int _indexOf_1 = list.indexOf(e);
    return (_indexOf_1 + startValue);
  }
}
