package cscie97.asn2.housemate.model;


public class Sensor extends Device {
    private SensorType sensorType;

    public SensorType getSensorType() {
        return sensorType;
    }

    /**
     *
     * @param name - name of the sensor. must be unique
     * @param room - room in which the sensor is located
     * @param type - the type of sensor
     */
    public Sensor(String name, Room room, SensorType type) {
        super(name, room);
        this.sensorType = type;
    }

    @Override
    public void captureData() {
        System.out.println(String.format("%s is capturing data...", getName()));
    }
}

