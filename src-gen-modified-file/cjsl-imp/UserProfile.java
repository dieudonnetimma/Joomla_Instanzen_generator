/**
 */
package de.thm.icampus.cjsl.cjsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.thm.icampus.cjsl.cjsl.UserProfile#getUserAttribute <em>User Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.thm.icampus.cjsl.cjsl.CjslPackage#getUserProfile()
 * @model
 * @generated
 */
public interface UserProfile extends EObject
{
  /**
   * Returns the value of the '<em><b>User Attribute</b></em>' containment reference list.
   * The list contents are of type {@link de.thm.icampus.cjsl.cjsl.UserProfileAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Attribute</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Attribute</em>' containment reference list.
   * @see de.thm.icampus.cjsl.cjsl.CjslPackage#getUserProfile_UserAttribute()
   * @model containment="true"
   * @generated
   */
  EList<UserProfileAttribute> getUserAttribute();

} // UserProfile
