package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QueryEngine {
    /**
     * Public method for executing a set of queries read from a file. Checks for valid file name.
     * Delegates to executeQuery for processing individual queries.
     *
     * @param filename the name/path of the file containing the queries
     * @throws QueryEngineException thrown if the queries are malformed in the file
     */
    public void executeQueryFile(String filename) throws QueryEngineException {
        try {
            var lines = Files.readAllLines(Paths.get(filename));
            for (var line : lines) {
                executeQuery(line);
            }
        } catch (IOException e) {
            throw new QueryEngineException("Could not read file: " + filename);
        }
    }

    /**
     * Executes a single query on the knowledge graph. Checks for non null and well formed query string
     *
     * @param query the subject-predicate-object triple to query the graph
     * @throws QueryEngineException if the query is malformed
     */
    public void executeQuery(String query) throws QueryEngineException {
        query = query.trim();
        var parsedQuery = query.toLowerCase().replace(".", "").split("[\\s]");
        var knowledgeGraph = KnowledgeGraph.getInstance();

        if (parsedQuery.length != 3 || query.charAt(query.length()-1) != '.') {
            throw new QueryEngineException(String.format("Malformed query: %s", query));
        }

        var results = knowledgeGraph.executeQuery(parsedQuery[0], parsedQuery[1], parsedQuery[2]);
        if (results == null) {
            System.out.println("<null>");
        } else {
            results.forEach(key -> System.out.println(key.getIdentifier()));
        }

    }
}
