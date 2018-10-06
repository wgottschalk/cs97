package cscie97.asn1.knowledge.engine;

/**
 * The Node class represents instances of Subjects and Objects.
 * A Node has a unique String identifier (e.g. “Bill”, or “Ultimate_Frisbee”).
 * Note that a single instance of a Node can represent both a Subject and an Object within the Knowledge Graph.
 */
public class Node {
    private String identifier;
    private long createDate;

    public Node(String identifier) {
        this.identifier = identifier;
        this.createDate = System.currentTimeMillis();
    }

    public String getIdentifier() {
        return identifier;
    }

    public long getCreateDate() {
        return createDate;
    }
}
