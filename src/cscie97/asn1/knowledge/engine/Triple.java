package cscie97.asn1.knowledge.engine;

/**
 * The Triple class represents a unique Triple (Subject, Predicate, Object) within the KnowledgeGraph.
 * A Triple contains 3 references: Subject, Predicate and Object.
 * The Triple is uniquely identified as the concatenation of the identifiers for
 * the associated Subject, Predicate and Object.
 */
public class Triple {
    private String identifier;
    private Node subject;
    private Predicate predicate;
    private Node object;
    private long createDate;

    public Triple(Node subject, Predicate predicate, Node object) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
        this.identifier = String.join(" ", subject.getIdentifier(), predicate.getIdentifier(), object.getIdentifier());
    }

    public String getIdentifier() {
        return identifier;
    }

    public long getCreateDate() {
        return createDate;
    }
}

