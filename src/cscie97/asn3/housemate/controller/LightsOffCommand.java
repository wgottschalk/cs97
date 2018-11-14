package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Appliance;
import cscie97.asn2.housemate.model.ApplianceType;
import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;


/**
 * This command turns off all of the lights in a given room.
 * If no light are present then nothing happens. And the system prints that there were no
 * lights to turn off.
 */

public class LightsOffCommand implements Command {
    private ModelService model;

    public LightsOffCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context
     */
    public void execute(Context context) {
        var room = context.getRoomPath();
        var devices = model.getDevices(room);
        var foundLight = false;

        for (var device : devices.values()) {
            if (!(device instanceof Appliance)) continue;

            var light = (Appliance) device;
            if (light.getApplianceType() != ApplianceType.LIGHT) continue;
            if (light.getStatus("state") == "off") continue;

            var lightPath = room + light.getName();
            try {
                model.setDeviceStatus(lightPath, "state", "off", false);
                foundLight = true;
            } catch (Exception e) {
                // The device should always exist since we need it to set its status
                continue;
            }

            if (foundLight) {
                System.out.println("The all lights are off in room: " + room);
            } else {
                System.out.println("Could not find lights in room: " + room);
            }
        }
    }

}

