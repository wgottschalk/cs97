package cscie97.asn2.housemate.model;

public class EntityAlreadyExistsException extends Exception {
    EntityAlreadyExistsException(String entity, String id) {
        super(String.format("entity %s already exists with id=%s", entity, id));
    }
}
