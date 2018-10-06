package cscie97.asn1.knowledge.engine;

/**
 * The Predicate class represents the predicate portion of a Triple.
 * Like Node, the Predicate includes a unique String identifier that uniquely
 * identifies the predicate (e.g. “has_friend”).
 */
public class Predicate {
    private String identifier;
    private long createDate;

    public Predicate(String identifier) {
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

