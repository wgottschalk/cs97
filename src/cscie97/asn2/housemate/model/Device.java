package cscie97.asn2.housemate.model;

import java.util.HashMap;
import java.util.Map;


public abstract class Device {
    private String name;
    private Map<String, String> status = new HashMap<>();
    public Room room;

    public String getName() {
        return name;
    }

    public Map<String, String> getStatus() {
        return status;
    }

    public String getStatus(String statusName) {
        return status.get(statusName);
    }

    public void setStatus(String statusName, String statusValue) {
        status.put(statusName, statusValue);
    }

    /**
     * @param name - the name of the device. Must be unique
     * @param room - the room in which the device is located
     */
    public Device(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    /**
     * method is implemented by devices and sensors to capture data
     */
    public abstract void captureData();
}

