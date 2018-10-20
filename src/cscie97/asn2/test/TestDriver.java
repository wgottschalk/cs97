package cscie97.asn2.test;

import cscie97.asn2.housemate.model.ModelCLI;

public class TestDriver {
    public static void main(String[] args) {
        var filename = args[0];
        ModelCLI.importFile(filename);
    }
}

