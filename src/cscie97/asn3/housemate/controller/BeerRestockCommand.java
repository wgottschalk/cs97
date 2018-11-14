package cscie97.asn3.housemate.controller;


import cscie97.asn2.housemate.model.Context;
import cscie97.asn2.housemate.model.ModelService;

import java.util.Scanner;

/**
 * This command will ask the user if they would like their beer
 * restocked if it gets low.
 */
public class BeerRestockCommand implements Command {

    private ModelService model;

    public BeerRestockCommand(ModelService model) {
        this.model = model;
    }

    /**
     * @param context - information about the previous request
     */
    public void execute(Context context) {
        var fridge = model.getDevices(context.getRoomPath()).get(context.getDeviceName());
        if (fridge == null) return;

        try {
            var currentAmount = Integer.parseInt(context.getValue());
            var alertCapacity = Integer.parseInt(fridge.getStatus("alertCapacity"));

            if (currentAmount > alertCapacity) return;
        } catch (NumberFormatException e) {
            System.out.println("Could not update fridge, please use an integer.");
            return;
        }


        System.out.println("Would you like to order more beer? (y/n)");
        var scanner = new Scanner(System.in);
        var response = scanner.next();

        if (response.equals("y")) {
            System.out.println("Ordering more beer for you.");
        } else {
            System.out.println("No worries!");
        }
    }

}

