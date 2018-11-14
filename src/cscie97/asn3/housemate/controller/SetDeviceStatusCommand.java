package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.EntityNotFoundException;
import cscie97.asn2.housemate.model.ModelService;


/**
 * This can arbitarily set the status on any device.
 * This command will NOT trigger notifyObservers
 */

public class SetDeviceStatusCommand implements Command {
    private ModelService model;

    public SetDeviceStatusCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context - any information about the original request
     */
    public void execute(Context context) {
        try {
            model.setDeviceStatus(context.getDevicePath(), context.getStatus(), context.getValue(), false);
        } catch (EntityNotFoundException e) {
            System.out.println("Could not locate device: " + context.getDevicePath());
        }
    }

}

