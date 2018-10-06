package cscie97.asn1.test;

import cscie97.asn1.knowledge.engine.ImportException;
import cscie97.asn1.knowledge.engine.Importer;
import cscie97.asn1.knowledge.engine.QueryEngine;
import cscie97.asn1.knowledge.engine.QueryEngineException;

public class TestDriver {

    public static void main(String[] args) {
        var importFilename = args[0];
        var queryFilename = args[1];
        var importer = new Importer();
        var queryEngine = new QueryEngine();

        try {
            importer.importTripleFile(importFilename);
        } catch (ImportException e) {
            System.out.println(e.getMessage());
        }

        try {
            queryEngine.executeQueryFile(queryFilename);
        } catch (QueryEngineException e) {
            System.out.println(e.getMessage());
        }
    }
}
