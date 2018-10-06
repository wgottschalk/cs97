package cscie97.asn1.knowledge.engine;

import java.util.*;

/**
 * The KnowledgeGraph manages the set of active Triples.
 * Per the requirements, the active Triples are assumed to fit within available memory, and no persistence is required.
 * The KnowledgeGraph is a singleton, meaning there is only one instance of this class.
 */
public class KnowledgeGraph {
    private static KnowledgeGraph knowledgeGraph;
    private static Map<String, Node> nodeMap;
    private static Map<String, Predicate> predicateMap;
    private static Map<String, Triple> tripleMap;
    private static Map<String, Set<Triple>> queryMapSet;

    private KnowledgeGraph() {
        nodeMap = new HashMap<>();
        predicateMap = new HashMap<>();
        tripleMap = new HashMap<>();
        queryMapSet = new HashMap<>();
    }

    /**
     * getInstance uses the Singleton pattern to create an
     * instance of the knowledge graph and return it.
     * @return KnowledgeGraph
     */
    public static KnowledgeGraph getInstance() {
        if (knowledgeGraph == null) {
            knowledgeGraph = new KnowledgeGraph();
        }
        return knowledgeGraph;
    }

    /**
     * importTriple Public method for adding a Triple to the KnowledgeGraph.
     * @param subject the subject of the query
     * @param predicate the predicate of the query
     * @param object the object which the subject acts on
     */
    public void importTriple(String subject, String predicate, String object) {
        var permutations = new ArrayList<List<String>>(7);
        var originalTriple = getTriple(getNode(subject), getPredicate(predicate), getNode(object));

        // since we're only using triples -> 3! or 6 permutations of ?
        permutations.add(Arrays.asList(subject, predicate, object));
        permutations.add(Arrays.asList("?", predicate, object));
        permutations.add(Arrays.asList(subject, "?", object));
        permutations.add(Arrays.asList(subject, predicate, "?"));
        permutations.add(Arrays.asList("?", "?", object));
        permutations.add(Arrays.asList(subject, "?", "?"));
        permutations.add(Arrays.asList("?", predicate, "?"));
        permutations.add(Arrays.asList("?", "?", "?"));

        for (var permutation : permutations) {
            var subjectNode = getNode(permutation.get(0));
            var predicateNode = getPredicate(permutation.get(1));
            var objectNode = getNode(permutation.get(2));
            var triple = getTriple(subjectNode, predicateNode, objectNode);

            // We'll need to get the set via computeIfAbsent and add the predicate to the set
            // hopefully the set does not get copied on access.
            var tripleSet = queryMapSet.computeIfAbsent(triple.getIdentifier(), _key -> new HashSet<>());
            tripleSet.add(originalTriple);
        }
    }

    /**
     * executeQuery looks up all triples that satisfy a given query
     * @param subject the subject of the query
     * @param predicate the predicate of the query
     * @param object the object which the subject acts on
     * @return a set of Triples which map the the given query
     */
    public Set<Triple> executeQuery(String subject, String predicate, String object) {
        var key = String.format("%s %s %s", subject, predicate, object);
        return queryMapSet.get(key);
    }

    public Node getNode(String identifier) {
        return nodeMap.computeIfAbsent(identifier, Node::new);
    }

    public Predicate getPredicate(String identifier) {
        return predicateMap.computeIfAbsent(identifier, Predicate::new);
    }

    public Triple getTriple(Node subject, Predicate predicate, Node object) {
        var key = String.format("%s %s %s", subject.getIdentifier(), predicate.getIdentifier(), object.getIdentifier());
        return tripleMap.computeIfAbsent(key, _key -> new Triple(subject, predicate, object));
    }
}

