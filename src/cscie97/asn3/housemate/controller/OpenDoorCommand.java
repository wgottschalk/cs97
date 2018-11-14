package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.*;


/**
 * Commmand used to open a door in an given room.
 * A Door must be present in the room.
 * Only one door in a room is allowed to be open at a time.
 */
public class OpenDoorCommand implements Command {

    private ModelService model;

    public OpenDoorCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context
     */
    public void execute(Context context) {
        var room = context.getRoomPath();
        var devices = model.getDevices(room);

        for (var device : devices.values()) {
            if (!(device instanceof Appliance))  continue;

            var door = (Appliance) device;
            if (door.getApplianceType() != ApplianceType.DOOR) continue;
            if (door.getStatus("state") == "open") continue;

            var doorPath = room + door.getName();
            try {
                model.setDeviceStatus(doorPath, "state", "open", false);

            } catch (Exception e) {
                // The device should always exist since we need it to set its status
                continue;
            }

            System.out.println("The door is open in room: " + room);
        }
    }
}

