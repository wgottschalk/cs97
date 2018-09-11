package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ImportException extends Exception {
    ImportException(String msg) {
        super(msg);
    }
}

public class Importer {

    public static void importTripleFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            List<Triple> tripleList = new ArrayList<>();

            for (String line : lines) {
                if (line.trim().length() == 0) continue;

                String[] tripleIds = line.replace(".", "").split("[\\s]");
                if (tripleIds.length != 3) {
                    throw new ImportException("could not process: " + line);
                }

                Node subject = KnowledgeGraph.getNode(tripleIds[0]);
                Predicate predicate = KnowledgeGraph.getPredicate(tripleIds[1]);
                Node object = KnowledgeGraph.getNode(tripleIds[2]);
                tripleList.add(KnowledgeGraph.getTriple(subject, predicate, object));
            }

            // KnowledgeGraph.getInstance().importTriples(tripleList);

        } catch (IOException e) {
            System.out.println("Could not read file " + filename);
        } catch (ImportException e) {
            System.out.println(e.getMessage());
        }
    }
}
