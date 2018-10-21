package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.ModelService;


/**
 * Shuts off the oven when the timer is complete
 */

public class TimerCompletedCommand implements Command {

    private ModelService model;

    public TimerCompletedCommand(ModelService model){
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

