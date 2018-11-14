package cscie97.asn2.housemate.model;

import cscie97.asn1.knowledge.engine.KnowledgeGraph;
import cscie97.asn1.knowledge.engine.Triple;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;


/**
 * This is the service which controls all of the business objects in the bounded context.
 * It implements the ModelService interface.
 */

public class HouseMateModelService extends Observable implements ModelService {

    private KnowledgeGraph knowledgeGraph = KnowledgeGraph.getInstance();
    private String authToken;
    private Map<String, House> houses = new HashMap<>();
    private Map<String, Occupant> occupants = new HashMap<>();
    private static ModelService instance;

    private HouseMateModelService() {
    }

    public static ModelService getInstance() {
        if (instance == null) {
            instance = new HouseMateModelService();
        }
        return instance;
    }

    public void addOccupantToHouse(String occupantName, String houseName)
        throws EntityNotFoundException
    {
        if (!occupants.containsKey(occupantName))  {
            throw new EntityNotFoundException("occupant", occupantName);
        }

        if(!houses.containsKey(houseName)) {
            throw new EntityNotFoundException("house", houseName);
        }

        var house = houses.get(houseName);
        var occupant = occupants.get(occupantName);

        var occupantMap = house.getOccupants();
        occupantMap.put(occupantName, occupant);
        house.setOccupants(occupantMap);

        var houseMap = occupant.getHouses();
        houseMap.put(houseName, house);
        occupant.setHouses(houseMap);

        return;
    }

    @Override
    public String createAppliance(String name, ApplianceType type, String roomPath, int energyUsage)
        throws EntityNotFoundException, EntityAlreadyExistsException
    {
        var path = roomPath.split(":");
        var house = houses.get(path[0]);
        if (house == null) throw new EntityNotFoundException("house", path[0]);

        var room = house.getRooms().get(path[1]);
        if (room == null) throw new EntityNotFoundException("room", path[1]);

        var appliance = new Appliance(name, room, type, energyUsage);
        room.addDevice(name, appliance);

        return appliance.getName();
    }

    @Override
    public String createHouse(String name, String address) throws EntityAlreadyExistsException {
        if (houses.containsKey(name)) {
            throw new EntityAlreadyExistsException("house", name);
        }
        var house = new House(name, address);
        houses.put(name, house);
        return house.getName();
    }

    @Override
    public String createOccupant(String name, OccupantType type) throws EntityAlreadyExistsException {
        if (occupants.containsKey(name)) {
            throw new EntityAlreadyExistsException("occupant", name);
        }
        var occupant = new Occupant(name, type);
        occupants.put(name, occupant);

        return occupant.getName();
    }

    @Override
    public String createRoom(String name, int floor, RoomType type, String houseName, int windows)
            throws EntityNotFoundException, EntityAlreadyExistsException {
        if (!houses.containsKey(houseName)) {
            throw new EntityNotFoundException("house", houseName);
        }

        var house = houses.get(houseName);
        var rooms = house.getRooms();
        if (rooms.containsKey(name)) {
            throw new EntityAlreadyExistsException("room", name);
        }

        var room = new Room(name, floor, type, windows);
        rooms.put(name, room);
        house.setRooms(rooms);

        return room.getName();
    }

    @Override
    public String createSensor(String name, SensorType type, String roomPath)
        throws EntityNotFoundException, EntityAlreadyExistsException
    {
        var path = roomPath.split(":");
        var house = houses.get(path[0]);
        if (house == null) {
            throw new EntityNotFoundException("house", path[0]);
        }
        var room = house.getRooms().get(path[1]);
        if (room == null) {
            throw new EntityNotFoundException("room", path[1]);
        }

        if (room.getDevices().containsKey(name)) {
            throw new EntityAlreadyExistsException("sensor", name);
        }

        var sensor = new Sensor(name, room, type);
        room.addDevice(name, sensor);

        return sensor.getName();
    }

    @Override
    public boolean setDeviceStatus(String name, String status, String value, boolean shouldNotify)
        throws EntityNotFoundException
    {
        var path = name.split(":");
        var house = houses.get(path[0]);
        if (house == null) throw new EntityNotFoundException("house", path[0]);

        var room = house.getRooms().get(path[1]);
        if (room == null) throw new EntityNotFoundException("room", path[1]);

        var device = room.getDevices().get(path[2]);
        if (device == null) throw new EntityNotFoundException("device", path[2]);

        device.setStatus(status, value);
        var message = new Context(
            house.getName(),
            room.getName(),
            device.getName(),
            status,
            value
        );

        if (shouldNotify) {
            setChanged();
            notifyObservers(message);
        }
        return true;
    }

    @Override
    public Map<String, String> showDeviceStatus(String name)
        throws EntityNotFoundException
    {
        var path = name.split(":");
        var house = houses.get(path[0]);
        if (house == null) throw new EntityNotFoundException("house", path[0]);

        var room = house.getRooms().get(path[1]);
        if (room == null) throw new EntityNotFoundException("room", path[1]);

        var device = room.getDevices().get(path[2]);
        if (device == null) throw new EntityNotFoundException("device", path[2]);

        return device.getStatus();
    }

    @Override
    public String showDeviceStatus(String name, String status)
        throws EntityNotFoundException
    {
        var path = name.split(":");
        var house = houses.get(path[0]);
        if (house == null) throw new EntityNotFoundException("house", path[0]);

        var room = house.getRooms().get(path[1]);
        if (room == null) throw new EntityNotFoundException("room", path[1]);

        var device = room.getDevices().get(path[2]);
        if (device == null) throw new EntityNotFoundException("device", path[2]);

        return device.getStatus(status);
    }

    // should this be Map<String, String>? or just String?
    public Map<String, String> showConfiguration() {
        // TODO: implement me
        System.out.println("show config");
        return new HashMap<>();
    }

    public Map<String, String> showConfiguration(String houseName) {
        // TODO: implement me
        System.out.println(String.format("show config %s", houseName));
        return new HashMap<>();
    }

    public Map<String, String> showConfiguration(String houseName, String roomName) {
        // TODO: implement me
        System.out.println(String.format("show config %s %s", houseName, roomName));
        return new HashMap<>();
    }

    public Map<String, String> showConfiguration(String houseName, String roomName, String applianceName) {
        // TODO: implement me
        System.out.println(String.format("show config %s %s %s", houseName, roomName, applianceName));
        return new HashMap<>();
    }

    @Override
    public int showEnergyUsage() {
        return houses.values().stream()
                .map(house -> house.getEnergyConsumption())
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public int showEnergyUsage(String houseName)
        throws EntityNotFoundException
    {
        var house = houses.get(houseName);
        if (house == null) throw new EntityNotFoundException("house", houseName);

        return house.getEnergyConsumption();
    }

    @Override
    public int showEnergyUsage(String houseName, String roomName)
        throws EntityNotFoundException
    {
        var house = houses.get(houseName);
        if (house == null) throw new EntityNotFoundException("house", houseName);

        var room = house.getRooms().get(roomName);
        if (room == null) throw new EntityNotFoundException("room", roomName);

        return room.getEnergyConsumption();
    }

    @Override
    public int showEnergyUsage(String houseName, String roomName, String applianceName)
        throws EntityNotFoundException
    {
        var house = houses.get(houseName);
        if (house == null) throw new EntityNotFoundException("house", houseName);

        var room = house.getRooms().get(roomName);
        if (room == null) throw new EntityNotFoundException("room", roomName);

        var appliance = room.getDevices().get(applianceName);
        if (appliance == null || appliance instanceof Sensor) throw new EntityNotFoundException("appliance", applianceName);

        return ((Appliance) appliance).getEnergyConsumption();
    }

    @Override
    public Map<String, House> getHouses() {
        return houses;
    }

    @Override
    public Map<String, Occupant> getOccupants() {
        return occupants;
    }

    @Override
    public Map<String, Device> getDevices(String roomPath) {
        var path = roomPath.split(":");
        var house = houses.get(path[0]);
        if (house == null) {
            return null;
        }

        var room = house.getRooms().get(path[1]);
        if (room == null) {
            return null;
        }

        return room.getDevices();
    }

    @Override
    public void updateOccupantLocation(Occupant occupant, String roomName) {
        knowledgeGraph.importTriple(occupant.getName(), "is_located_in", roomName);
    }

    @Override
    public Set<Triple> findOccupant(String occupantName) {
        return knowledgeGraph.executeQuery(occupantName, "is_located_in", "?");
    }
}

