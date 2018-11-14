package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;

/**
 * Updates the location of the occupant in the house
 */

public class OccupantDetectedCommand implements Command
{

	private ModelService model;

	public OccupantDetectedCommand(ModelService model){
		this.model = model;
	}

	/**
     * @param context - information about the original request
	 */
	public void execute(Context context) {
	    var occupant = model.getOccupants().get(context.getValue());
	    model.updateOccupantLocation(occupant, context.getRoomName());
        System.out.printf("Occupant %s is detected in room %s.\n", occupant.getName(), context.getRoomName());
	}

}

