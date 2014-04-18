/**
 */
package de.thm.icampus.cjsl.cjsl.impl;

import de.thm.icampus.cjsl.cjsl.CjslPackage;
import de.thm.icampus.cjsl.cjsl.CoreAccessLevel;
import de.thm.icampus.cjsl.cjsl.UserGroup;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.thm.icampus.cjsl.cjsl.impl.UserGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.icampus.cjsl.cjsl.impl.UserGroupImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link de.thm.icampus.cjsl.cjsl.impl.UserGroupImpl#getGlobalAccess_level <em>Global Access level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserGroupImpl extends MinimalEObjectImpl.Container implements UserGroup
{
	
	 int lft=1;
		int rgt=2;
		
		@Override
	  public void setLft(int lft) {
			this.lft = lft;
		}
		
	  @Override
		public void setRgt(int rgt) {
			this.rgt = rgt;
		}
	  
		@Override
		public int getLft() {
			// TODO Auto-generated method stub
			return this.lft;
		}

		@Override
		public int getRgt() {
			// TODO Auto-generated method stub
			return this.rgt;
		}
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParent()
   * @generated
   * @ordered
   */
  protected UserGroup parent;

  /**
   * The cached value of the '{@link #getGlobalAccess_level() <em>Global Access level</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalAccess_level()
   * @generated
   * @ordered
   */
  protected CoreAccessLevel globalAccess_level;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserGroupImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CjslPackage.eINSTANCE.getUserGroup();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CjslPackage.USER_GROUP__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserGroup getParent()
  {
    if (parent != null && parent.eIsProxy())
    {
      InternalEObject oldParent = (InternalEObject)parent;
      parent = (UserGroup)eResolveProxy(oldParent);
      if (parent != oldParent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CjslPackage.USER_GROUP__PARENT, oldParent, parent));
      }
    }
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserGroup basicGetParent()
  {
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(UserGroup newParent)
  {
    UserGroup oldParent = parent;
    parent = newParent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CjslPackage.USER_GROUP__PARENT, oldParent, parent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoreAccessLevel getGlobalAccess_level()
  {
    return globalAccess_level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGlobalAccess_level(CoreAccessLevel newGlobalAccess_level, NotificationChain msgs)
  {
    CoreAccessLevel oldGlobalAccess_level = globalAccess_level;
    globalAccess_level = newGlobalAccess_level;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL, oldGlobalAccess_level, newGlobalAccess_level);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobalAccess_level(CoreAccessLevel newGlobalAccess_level)
  {
    if (newGlobalAccess_level != globalAccess_level)
    {
      NotificationChain msgs = null;
      if (globalAccess_level != null)
        msgs = ((InternalEObject)globalAccess_level).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL, null, msgs);
      if (newGlobalAccess_level != null)
        msgs = ((InternalEObject)newGlobalAccess_level).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL, null, msgs);
      msgs = basicSetGlobalAccess_level(newGlobalAccess_level, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL, newGlobalAccess_level, newGlobalAccess_level));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL:
        return basicSetGlobalAccess_level(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CjslPackage.USER_GROUP__NAME:
        return getName();
      case CjslPackage.USER_GROUP__PARENT:
        if (resolve) return getParent();
        return basicGetParent();
      case CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL:
        return getGlobalAccess_level();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CjslPackage.USER_GROUP__NAME:
        setName((String)newValue);
        return;
      case CjslPackage.USER_GROUP__PARENT:
        setParent((UserGroup)newValue);
        return;
      case CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL:
        setGlobalAccess_level((CoreAccessLevel)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CjslPackage.USER_GROUP__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CjslPackage.USER_GROUP__PARENT:
        setParent((UserGroup)null);
        return;
      case CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL:
        setGlobalAccess_level((CoreAccessLevel)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CjslPackage.USER_GROUP__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CjslPackage.USER_GROUP__PARENT:
        return parent != null;
      case CjslPackage.USER_GROUP__GLOBAL_ACCESS_LEVEL:
        return globalAccess_level != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //UserGroupImpl
