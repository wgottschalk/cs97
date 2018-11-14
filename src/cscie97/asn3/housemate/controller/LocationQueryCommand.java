package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Finds the location of an occupant via the knowledge graph
 * if no occupant is present, a message is logged.
 */

public class LocationQueryCommand implements Command {

    private ModelService model;

    public LocationQueryCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context - information about the original request
     */
    public void execute(Context context) {
        var locations = model.findOccupant(context.getValue());
        if (locations == null) {
            System.out.println("Could not find Occupant: " + context.getValue());
            return;
        }

        locations.stream().forEach(triple -> {
            var parts = triple.getIdentifier().split(" ");
            System.out.printf("Occupant: %s %s %s\n", parts[0], parts[1], parts[2]);
        });
    }
}

