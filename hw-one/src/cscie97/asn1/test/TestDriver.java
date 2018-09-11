package cscie97.asn1.test;

import cscie97.asn1.knowledge.engine.Importer;

public class TestDriver {

    public static void main(String[] args) {
        String importFilename = args[0];
        String queryFilename = args[1];
        Importer.importTripleFile(importFilename);
    }
}
