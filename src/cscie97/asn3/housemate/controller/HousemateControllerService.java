package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.Message;
import cscie97.asn2.housemate.model.ModelService;

import java.util.Observable;
import java.util.Observer;


/**
 * The HousemateControllerService is responsible for responding to any events from sensors or devices.
 * The HousemateModelService is responsible for notifying the Controller when events occur to
 * enforce domain boundaries.
 */
public class HousemateControllerService implements ControllerService, Observer {
    private HousemateControllerService() { }

    /**
     * registers the Controller Service with the model service before returning the instance
     *
     * @param model - the ModelService which publishes changes to the controller
     * @returns a new instance of the controller service which
     */
    public static <T extends Observable> ControllerService createController(T model) {
        ControllerService controller = new HousemateControllerService();
        model.addObserver((Observer) controller);
        return controller;
    }

    /**
     * update will trigger when an appliance or sensor triggers and event
     * @param obs - the observable which triggered the event (Housemate Model Service)
     * @param data - Any additional info that a device needs to send to the controller
     */
    @Override
    public void update(Observable obs, Object data) {
        var model = (ModelService)obs;
        var msg = (Message)data;
        var command = CommandFactory.createCommand(model, msg);

    }

}

