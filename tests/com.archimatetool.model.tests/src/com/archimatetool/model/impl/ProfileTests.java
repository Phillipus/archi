/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.IProfile;

import junit.framework.JUnit4TestAdapter;



@SuppressWarnings("nls")
public class ProfileTests {
    
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ProfileTests.class);
    }
    
    IArchimateModel model;
    IProfile profile;
    
    // ---------------------------------------------------------------------------------------------
    // BEFORE AND AFTER METHODS GO HERE 
    // ---------------------------------------------------------------------------------------------
    
    @Before
    public void runBeforeEachTest() {
        model = IArchimateFactory.eINSTANCE.createArchimateModel();
        profile = IArchimateFactory.eINSTANCE.createProfile();
    }
    
    // ---------------------------------------------------------------------------------------------
    // Tests
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void isMember() {
        assertEquals(0, model.getProfiles().size());
        model.getProfiles().add(profile);
        assertSame(profile, model.getProfiles().get(0));
    }

    @Test
    public void getName() {
        CommonTests.testGetName(profile);
    }

    @Test
    public void getID() {
        assertNotNull(profile.getId());
    }

    @Test
    public void getAdapter() {
        CommonTests.testGetAdapter(profile);
    }
        
    @Test
    public void getArchimateModel() {
        assertNull(profile.getArchimateModel());
        model.getProfiles().add(profile);
        assertSame(model, profile.getArchimateModel());
    }

    @Test
    public void isSpecialization() {
        assertTrue(profile.isSpecialization());
        profile.setSpecialization(false);
        assertFalse(profile.isSpecialization());
    }
    
    @Test
    public void getConceptType() {
        assertNull(profile.getConceptType());
        profile.setConceptType(IArchimatePackage.eINSTANCE.getBusinessActor().getName());
        assertEquals("BusinessActor", profile.getConceptType());
    }
    
    @Test
    public void getConceptClass() {
        assertNull(profile.getConceptClass());
        profile.setConceptType(IArchimatePackage.eINSTANCE.getBusinessActor().getName());
        assertEquals(IArchimatePackage.eINSTANCE.getBusinessActor(), profile.getConceptClass());
    }

    @Test
    public void getImagePath() {
        assertNull(profile.getImagePath());
        profile.setImagePath("somePath");
        assertEquals("somePath", profile.getImagePath());
    }
}
