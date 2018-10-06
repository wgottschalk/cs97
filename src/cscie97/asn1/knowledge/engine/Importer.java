package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Importer {
    /**
     * Public method for importing triples from N_Triple formatted file into the KnowledgeGraph.
     *
     * @param filename the name of the file containing the queries. Must be a valid file.
     * @throws ImportException if any of the queries in the file is malformed
     */
    public void importTripleFile(String filename) throws ImportException {
        try {
            var lines = Files.readAllLines(Paths.get(filename));
            var knowledgeGraph = KnowledgeGraph.getInstance();

            for (var line : lines) {
                if (line.trim().length() == 0) continue;

                var tripleIds = line.toLowerCase().replace(".", "").split("[\\s]");
                if (tripleIds.length != 3 || line.charAt(line.length() - 1) != '.') {
                    throw new ImportException("Error Importing Triple. Could not process: " + line);
                }

                knowledgeGraph.importTriple(tripleIds[0], tripleIds[1], tripleIds[2]);
            }
        } catch (IOException e) {
            throw new ImportException("Could not read file: " + filename);
        }
    }
}
