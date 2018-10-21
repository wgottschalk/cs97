package cscie97.asn2.housemate.model;

/**
 * The Message class contains all of the information that gets
 * transfered from the model class to it's observers
 */
public class Message {
    public String houseName;
    public String roomName;
    public String deviceName;
    public String status;
    public String value;

    public Message(String houseName, String roomName, String deviceName, String status, String value) {
        this.houseName = houseName;
        this.roomName = roomName;
        this.deviceName = deviceName;
        this.status = status;
        this.value = value;
    }
}
