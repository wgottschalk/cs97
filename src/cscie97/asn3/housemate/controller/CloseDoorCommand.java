package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Appliance;
import cscie97.asn2.housemate.model.ApplianceType;
import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Closes a door in a given room.
 * Only one door in a room can be closed at a time.
 * If all of the doors are already closed then no additional actions need to be taken
 */

public class CloseDoorCommand implements Command {
    private ModelService model;

    public CloseDoorCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context
     */
    public void execute(Context context) {
        var room = context.getRoomPath();
        var devices = model.getDevices(room);

        for (var device : devices.values()) {
            if (!(device instanceof Appliance)) continue;

            var door = (Appliance) device;
            if (door.getApplianceType() != ApplianceType.DOOR) continue;
            if (door.getStatus("state") == "closed") continue;

            var doorPath = room + door.getName();
            try {
                model.setDeviceStatus(doorPath, "state", "closed", false);

            } catch (Exception e) {
                // The device should always exist since we need it to set its status
                continue;
            }

            System.out.println("The door is closed in room: " + room);
        }
    }
}

