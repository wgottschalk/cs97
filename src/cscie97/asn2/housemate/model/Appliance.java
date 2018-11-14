package cscie97.asn2.housemate.model;


public class Appliance extends Device {

    private int energyConsumption;
    private ApplianceType applianceType;

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    /**
     *
     * @param name - name of the appliance. Must be unique
     * @param room - the room which the appliance is located
     * @param type - the type of Appliance
     * @param energyUse - the amount of energy in Watts that the appliance consumes
     */
    public Appliance(String name, Room room, ApplianceType type, int energyUse) {
        super(name, room);
        this.applianceType = type;
        this.energyConsumption = energyUse;
    }

    @Override
    public void captureData() {
        System.out.println(String.format("%s is capturing data...", getName()));
    }

    public ApplianceType getApplianceType() {
        return applianceType;
    }
}

