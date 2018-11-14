package cscie97.asn3.housemate.controller;


import cscie97.asn2.housemate.model.Context;

/**
 * Interface for all Commands to implement.
 * Commands are generated by the Controller Service to
 * to perform a sequence of tasks in the home
 */
public interface Command {

    /**
     *
     * @param context - any information about the original action that the
     *                Model Service used to update a device.
     */
    public void execute(Context context);


}

