package cscie97.asn1.knowledge.engine;

public class Triple {
    private String identifier;
    private Node subject;
    private Predicate predicate;
    private Node object;

    public Triple(Node subject, Predicate predicate, Node object) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
        this.identifier = String.join("-", subject.getIdentifier(), predicate.getIdentifier(), object.getIdentifier());
    }

    public Node getSubject() {
        return subject;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public Node getObject() {
        return object;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}

