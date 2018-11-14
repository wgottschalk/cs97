package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.EntityNotFoundException;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Shuts off the oven when the timer is complete
 */

public class TimerCompletedCommand implements Command {

    private ModelService model;

    public TimerCompletedCommand(ModelService model) {
        this.model = model;
    }

    /**
     * sets the oven's mode to off. Ovens can have more than one mode: off, bake, broil, etc..
     * @param context
     */
    public void execute(Context context) {
        try{
            model.setDeviceStatus(context.getDevicePath(), context.getValue(), "off", false);
        } catch (EntityNotFoundException e) {
            System.out.println("Could not shut off oven: " +  context.getDevicePath());
        }
    }

}

