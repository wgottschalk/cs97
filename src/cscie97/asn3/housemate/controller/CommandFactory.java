package cscie97.asn3.housemate.controller;


import cscie97.asn2.housemate.model.ModelService;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 *
 * @generated
 */

public class CommandFactory {
    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public static Command createCommand(ModelService model, String status) {
        switch (status) {
            case "open_door":
                return new OpenDoorCommand(model);
            case "close_door":
                return new CloseDoorCommand(model);
            case "lights_off":
                return new LightsOffCommand(model);
            case "lights_on":
                return new LightsOnCommand(model);
            case "generic_command":
                return new SetDeviceStatusCommand(model);
            case "question":
                return new LocationQueryCommand(model);
            case "occupant_detected":
                return new OccupantDetectedCommand(model);
            case "occupant_leaving":
                return new OccupantLeavingCommand(model);
            case "occupant_active":
                return new OccupantActiveCommand(model);
            case "occupant_inactive":
                return new OccupantInactiveCommand(model);
            case "mode":
                return new FireDetectedCommand(model);
            case "timer_complete":
                return new TimerCompletedCommand(model);
            case "beer_count":
                return new BeerRestockCommand(model);
            default:
                return new NoOpCommand(model);
        }
    }

}

