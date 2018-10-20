package cscie97.asn2.housemate.model;

public class EntityNotFoundException extends Exception {
    EntityNotFoundException(String entity, String id) {
        super(String.format("entity %s could not be found with id=%s", entity, id));
    }
}
