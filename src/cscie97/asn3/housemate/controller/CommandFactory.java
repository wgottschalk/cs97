package cscie97.asn3.housemate.controller;


import cscie97.asn2.housemate.model.Message;
import cscie97.asn2.housemate.model.ModelService;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class CommandFactory
{
    /**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static Command createCommand(ModelService model, Message msg) {
	    switch (msg.status) {
            case "open door":
                return new OpenDoorCommand(model);
            case "close door":
                return new CloseDoorCommand(model);
            case "lights off":
                return new LightsOffCommand(model);
            case "lights on":
                return new LightsOnCommand(model);
            case "generic":
                return new SetDeviceStatusCommand(model);
            case "question":
                return new LocationQueryCommand(model);
            case "occupant detected":
                return new OccupantDetectedCommand(model);
            case "occupant leaving":
                return new OccupantLeavingCommand(model);
            case "occupant active":
                return new OccupantActiveCommand(model);
            case "occupant inactive":
                return new OccupantInactiveCommand(model);
            case "fire":
                return new FireDetectedCommand(model);
            case "timer complete":
                return new TimerCompletedCommand(model);
            case "beer count":
                return new BeerRestockCommand(model);
            default:
                return new NoOpCommand(model);

        }
	}

}

