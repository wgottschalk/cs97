package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;


/**
 * When an occupant leaves a room, tell the model that they're no longer in that room
 */

public class OccupantLeavingCommand implements Command {

    private ModelService model;

    public OccupantLeavingCommand(ModelService model) {
        this.model = model;
    }

    /**
     *
     * @param context
     */

    public void execute(Context context) {
        var occupant = model.getOccupants().get(context.getValue());
        model.updateOccupantLocation(occupant, "not_found");
        System.out.printf("Occupant %s is leaving in room %s.\n", occupant.getName(), context.getRoomName());
    }
}

