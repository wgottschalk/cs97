package cscie97.asn3.test;

import cscie97.asn2.housemate.model.HouseMateModelService;
import cscie97.asn2.housemate.model.ModelCLI;
import cscie97.asn2.housemate.model.ModelService;
import cscie97.asn3.housemate.controller.ControllerService;
import cscie97.asn3.housemate.controller.HousemateControllerService;

public class TestRunner {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a file");
            return;
        }

        var filename = args[0];
        ModelService model = HouseMateModelService.getInstance();
        ControllerService controller = HousemateControllerService.createController((HouseMateModelService)model);
        ModelCLI.importFile(filename);
    }
}
