package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.ModelService;


/**
 * Sets off a series of tasks if a fire is detected
 * All doors will open, the fire department will also be alerted
 */

public class FireDetectedCommand implements Command {

    private ModelService model;

    public FireDetectedCommand(ModelService model) {
        this.model = model;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public void execute() {
        // TODO implement me
    }

}

