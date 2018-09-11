package cscie97.asn1.knowledge.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KnowledgeGraph {
    private static KnowledgeGraph graph = new KnowledgeGraph();
    private static Map<String, Node> nodeMap = new HashMap<String, Node>();
    private static Map<String, Predicate> predicateMap = new HashMap<String, Predicate>();
    private static Map<String, Triple> tripleMap = new HashMap<String, Triple>();
    private static Map<String, Set<Triple>> queryMapSet = new HashMap<String, Set<Triple>>();

    public static void importTriples(List<Triple> tripleList) {
    }

    public static Set<Triple> executeQuery(Triple query) {
        return null;
    }

    public static KnowledgeGraph getInstance() {
        return null;
    }

    public static Node getNode(String identifier) {
        return null;
    }


    public static Predicate getPredicate(String identifier) {
        return null;
    }

    public static Triple getTriple(Node subject, Predicate predicate, Node object) {
        return null;
    }
}

