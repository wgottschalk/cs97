package cscie97.asn2.housemate.model;


import java.util.HashMap;
import java.util.Map;

/**
 * Occupant represents an Adult, Child or Pet.
 * Occupants are recognized by the HouseMate system through facial and voice recognition.
 * Cameras and Microphones located in each room of the house monitor the location of all occupants.
 */
public class Occupant {
    private String name;
    private OccupantType type;
    private OccupantStatus status;
    private Map<String, House> houses = new HashMap<>();

    public String getName() {
        return name;
    }

    public OccupantType getType() {
        return type;
    }

    public OccupantStatus getStatus() {
        return status;
    }

    public void setStatus(OccupantStatus status) {
        this.status = status;
    }

    public Map<String, House> getHouses() {
        return houses;
    }

    public void setHouses(Map<String, House> houses) {
        this.houses = houses;
    }

    public Occupant(String name, OccupantType type) {
        this.name = name;
        this.type = type;
        this.status = OccupantStatus.ACTIVE;
    }
}

