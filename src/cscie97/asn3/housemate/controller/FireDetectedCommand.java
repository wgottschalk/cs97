package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.*;


/**
 * Sets off a series of tasks if a fire is detected
 * Turn on all lights in the house,
 * Open all windows on the first floor
 * Alert the authorities
 */

public class FireDetectedCommand implements Command {

    private ModelService model;
    private LightsOffCommand lightsOnCommand;

    public FireDetectedCommand(ModelService model) {
        this.model = model;
        this.lightsOnCommand = new LightsOffCommand(model);
    }

    /**
     * @param context
     */
    public void execute(Context context) {
        var house = model.getHouses().get(context.getHouseName());
        turnOnAllLights(context, house);
        openWindowsOnFirstFloor(house);
        askOccupantsToLeave(house);
        callTheFireDepartment(house);
    }

    /**
     * Turns off all of the lights in the house.
     *
     * @param context - any information about the original request
     * @param house   - the house which needs the lights turned off
     */
    private void turnOnAllLights(Context context, House house) {
        var roomNames = house.getRooms().keySet();
        for (var roomName : roomNames) {
            var newCtx = context.copy();
            newCtx.setRoomName(roomName);

            lightsOnCommand.execute(context);
        }
    }

    /**
     * This will open all windows that are located on the first floor (zero indexed)
     *
     * @param house - the house to iterate over
     */
    private void openWindowsOnFirstFloor(House house) {
        var roomNames = house.getRooms().values();
        roomNames
                .stream()
                .filter(room -> room.getFloor() == 0)
                .flatMap(room -> room.getDevices().values().stream()
                        .filter(device -> device.getClass() == Appliance.class)
                        .map(device -> (Appliance) device)
                )
                .filter(appliance -> appliance.getApplianceType() == ApplianceType.WINDOW)
                .forEach(window -> window.setStatus("state", "open"));
    }

    /**
     * Accesses all Ava devices in the house and broadcasts a message to them
     *
     * @param house - the house containing the ava devices
     */
    private void askOccupantsToLeave(House house) {
        var rooms = house.getRooms().values();
        var allAvas = rooms
                .stream()
                .flatMap(room -> room.getDevices().values().stream()
                        .filter(device -> device.getClass() == Sensor.class)
                        .map(device -> (Sensor) device)
                )
                .filter(appliance -> appliance.getSensorType() == SensorType.AVA);
        allAvas.forEach(ava -> ava.setStatus("voiceCommand", "There is a fire. Please exit the house"));

    }

    private void callTheFireDepartment(House house) {
        System.out.println("Calling the fire department. There's a fire at: " + house.getAddress());
    }
}

