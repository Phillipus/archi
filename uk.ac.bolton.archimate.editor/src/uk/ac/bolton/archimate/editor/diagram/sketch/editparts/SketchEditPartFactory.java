/*******************************************************************************
 * Copyright (c) 2010 Bolton University, UK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 *******************************************************************************/
package uk.ac.bolton.archimate.editor.diagram.sketch.editparts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import uk.ac.bolton.archimate.editor.diagram.DiagramConstants;
import uk.ac.bolton.archimate.editor.diagram.editparts.diagram.DiagramModelReferenceEditPart;
import uk.ac.bolton.archimate.editor.diagram.editparts.diagram.EmptyEditPart;
import uk.ac.bolton.archimate.model.IDiagramModel;
import uk.ac.bolton.archimate.model.IDiagramModelConnection;
import uk.ac.bolton.archimate.model.IDiagramModelReference;
import uk.ac.bolton.archimate.model.ISketchModelActor;
import uk.ac.bolton.archimate.model.ISketchModelSticky;

/**
 * Factory for creating Edit Parts based on graphical domain model objects
 * 
 * @author Phillip Beauvoir
 */
public class SketchEditPartFactory
implements EditPartFactory {
    
    public EditPart createEditPart(EditPart context, Object model) {
        EditPart child = null;
        
        if(model == null) {
            return null;
        }
        
        // Main Diagram Edit Part
        if(model instanceof IDiagramModel) {
            child = new SketchDiagramPart();
        }
        
        // Actor
        else if(model instanceof ISketchModelActor) {
            child = new SketchActorEditPart();
        }
        
        // Sticky
        else if(model instanceof ISketchModelSticky) {
            child = new StickyEditPart();
        }
        
        // Diagram Model Reference
        else if(model instanceof IDiagramModelReference) {
            child = new DiagramModelReferenceEditPart();
        }
        
        // Connections
        else if(model instanceof IDiagramModelConnection) {
            IDiagramModelConnection connection = (IDiagramModelConnection)model;
            String type = connection.getType();
            if(DiagramConstants.CONNECTION_ARROW.equals(type) || DiagramConstants.CONNECTION_ARROW_OLD.equals(type)) {
                child = new ArrowConnectionEditPart();
            }
            else if(DiagramConstants.CONNECTION_DASHED_ARROW.equals(type) || DiagramConstants.CONNECTION_DASHED_ARROW_OLD.equals(type)) {
                child = new DashedArrowConnectionEditPart();
            }
            else {
                child = new LineConnectionEditPart();
            }
        }
        
        /*
         * It's better to return an Empty Edit Part in case of a corrupt model.
         * Returning null is disastrous and means the Diagram View won't open.
         */
        else {
            child = new EmptyEditPart();
        }
        
        // Set the Model in the Edit part
        child.setModel(model);
        
        return child;
    }

}
