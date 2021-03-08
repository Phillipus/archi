/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model;

import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.archimatetool.model.IArchimateConcept#getProfiles <em>Profiles</em>}</li>
 * </ul>
 *
 * @see com.archimatetool.model.IArchimatePackage#getArchimateConcept()
 * @model abstract="true"
 * @generated
 */
public interface IArchimateConcept extends IArchimateModelObject, ICloneable, IDocumentable, IProperties {
    
    /**
     * Returns the value of the '<em><b>Profiles</b></em>' reference list.
     * The list contents are of type {@link com.archimatetool.model.IProfile}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profiles</em>' reference list.
     * @see com.archimatetool.model.IArchimatePackage#getArchimateConcept_Profiles()
     * @model resolveProxies="false"
     * @generated
     */
    EList<IProfile> getProfiles();

    /**
     * @return A list of source relationships connected to this concept - this is a live list so don't change it!
     */
    EList<IArchimateRelationship> getSourceRelationships();

    /**
     * @return A list of target relationships connected to this concept - this is a live list so don't change it!
     */
    EList<IArchimateRelationship> getTargetRelationships();
    
    /**
     * @return A list of diagram components that reference this concept
     */
    List<? extends IDiagramModelArchimateComponent> getReferencingDiagramComponents();

} // IArchimateConcept
