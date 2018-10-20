package cscie97.asn2.housemate.model;

import java.util.HashMap;
import java.util.Map;


public class House {
    private String name;
    private String address;
    private Map<String, Room> rooms = new HashMap<>();
    private Map<String, Occupant> occupants = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Room> rooms) {
        this.rooms = rooms;
    }

    public Map<String, Occupant> getOccupants() {
        return occupants;
    }

    public void setOccupants(Map<String, Occupant> occupants) {
        this.occupants = occupants;
    }


    /**
     *
     * @param name - the name of the house. Must be unique.
     * @param address - the address of the house. street, city, state
     */
    public House(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     *
     * @return the sum of all energy consumptions in all rooms
     */
    public int getEnergyConsumption() {
        var sum = 0;
        for (var room : rooms.values()) {
            sum += room.getEnergyConsumption();
        }
        return sum;
    }

}

