package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.ModelService;

/**
 * The NoOp Command do nothing to modify the state of the program
 * It will log a message that the service is unable to complete the
 * request.
 * This is used as a fallback for actions which can't be understood by
 * the system.
 */
public class NoOpCommand implements Command {
    private ModelService model;

    public NoOpCommand(ModelService model) {
        this.model = model;
    }

    @Override
    public void execute() {
        System.out.println("I'm sorry. I was unable to process your request.");
    }
}
