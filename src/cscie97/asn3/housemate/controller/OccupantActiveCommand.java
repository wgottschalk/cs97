package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;
import cscie97.asn2.housemate.model.OccupantStatus;


/**
 * Sets an occupants status to active if they become active
 */
public class OccupantActiveCommand implements Command {

    private ModelService model;

    public OccupantActiveCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context - information about the original request
     */
    public void execute(Context context) {
        var occupant = model.getOccupants().get(context.getValue());
        occupant.setStatus(OccupantStatus.ACTIVE);
        System.out.printf("Occupant %s is now active.\n", occupant.getName());
    }

}

