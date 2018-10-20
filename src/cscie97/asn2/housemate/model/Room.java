package cscie97.asn2.housemate.model;

import java.util.HashMap;
import java.util.Map;


public class Room {
    private String name;
    private int floor;
    private RoomType type;
    private int windows;
    private Map<String, Device> devices = new HashMap<>();

    public String getName() {
        return name;
    }

    public int getFloor() {
        return floor;
    }

    public RoomType getType() {
        return type;
    }

    public int getWindows() {
        return windows;
    }

    public Map<String, Device> getDevices() {
        return devices;
    }

    /**
     * @param name    - the name of the room unique within a house. ex: "house1:room1"
     * @param floor   - the floor of the house. Base level is 0.
     * @param type    - the type of room. ex: Living Room, Bedroom etc.
     * @param windows - the number of windows in the room
     */
    public Room(String name, int floor, RoomType type, int windows) {
        this.name = name;
        this.floor = floor;
        this.type = type;
        this.windows = windows;
    }

    /**
     * @return the amount of energy in Watts of all of the appliances in the room.
     */
    public int getEnergyConsumption() {
        int sum = 0;

        for (var device : devices.values()) {
            if (device instanceof Appliance) {
                sum += ((Appliance) device).getEnergyConsumption();
            }
        }

        return sum;
    }

    public void addDevice(String name, Device device) {
        devices.put(name, device);
    }
}

