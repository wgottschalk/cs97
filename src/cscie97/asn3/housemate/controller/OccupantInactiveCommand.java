package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;
import cscie97.asn2.housemate.model.OccupantStatus;


/**
 * Sets an occupants status to inactive if they become inactive (sleep)
 */
public class OccupantInactiveCommand implements Command {

    private ModelService model;

    public OccupantInactiveCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context - information about the original request
     */
    public void execute(Context context) {
        var occupant = model.getOccupants().get(context.getValue());
        occupant.setStatus(OccupantStatus.SLEEPING);
        System.out.printf("Occupant %s is now sleeping.\n", occupant.getName());
    }
}

