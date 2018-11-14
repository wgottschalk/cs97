package cscie97.asn2.housemate.model;

/**
 * The Context class contains all of the information that gets
 * transfered from the model class to it's observers
 */
public class Context {
    private String houseName;
    private String roomName;
    private String deviceName;
    private String status;
    private String value;

    public Context(String houseName, String roomName, String deviceName, String status, String value) {
        this.houseName = houseName;
        this.roomName = roomName;
        this.deviceName = deviceName;
        this.status = status;
        this.value = value;
    }

    /**
     * Returns the concatenated path of the device. This is useful when running commands
     * and you need to know which device issued the command
     * @return the full path of the device
     */
    public String getDevicePath() {
        return String.format("%s:%s:%s", houseName, roomName, deviceName);
    }

    /**
     * Returns the concatenated path of the room that the device is located.
     * @return the full path to the room
     */
    public String getRoomPath() {
        return String.format("%s:%s", houseName, roomName);
    }

    /**
     * Creates a copy of the context. This is useful when running subcommnads
     * @return a copy of the Context instance
     */
    public Context copy() {
        return new Context(houseName, roomName, deviceName, status, value);
    }


    /* Getters and Setters */

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
