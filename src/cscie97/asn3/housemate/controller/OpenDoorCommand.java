package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.ModelService;


/**
 * Commmand used to open a door in an given room.
 * A Door must be present in the room.
 * Only one door in a room is allowed to be open at a time.
 */
public class OpenDoorCommand implements Command {

    private ModelService model;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     */
    public OpenDoorCommand(ModelService model) {
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

