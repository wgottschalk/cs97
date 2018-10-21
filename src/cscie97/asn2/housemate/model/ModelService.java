package cscie97.asn2.housemate.model;

import java.util.Map;

public interface ModelService {
     void addOccupantToHouse(String occupantName, String houseName)
        throws EntityNotFoundException;

     String createAppliance(String name, ApplianceType type, String room, int energyUsage)
        throws EntityAlreadyExistsException, EntityNotFoundException;
     String createHouse(String name, String address)
        throws EntityAlreadyExistsException;
     String createOccupant(String name, OccupantType type)
        throws EntityAlreadyExistsException;
     String createRoom(String name, int floor, RoomType type, String houseName, int windows)
        throws EntityAlreadyExistsException, EntityNotFoundException;
     String createSensor(String name, SensorType type, String room)
        throws EntityAlreadyExistsException, EntityNotFoundException;

     boolean setDeviceStatus(String name, String status, String value, boolean shouldNotify)
        throws EntityNotFoundException;
     Map<String, String> showDeviceStatus(String name)
        throws EntityNotFoundException;
     String showDeviceStatus(String name, String status)
        throws EntityNotFoundException;

    // should this be Map<String, String>? or just String?
     Map<String, String> showConfiguration();
     Map<String, String> showConfiguration(String houseName)
        throws EntityNotFoundException;
     Map<String, String> showConfiguration(String houseName, String roomName)
        throws EntityNotFoundException;
     Map<String, String> showConfiguration(String houseName, String roomName, String applianceName)
        throws EntityNotFoundException;


     int showEnergyUsage();
     int showEnergyUsage(String houseName)
        throws EntityNotFoundException;
     int showEnergyUsage(String houseName, String roomName)
        throws EntityNotFoundException;
     int showEnergyUsage(String houseName, String roomName, String applianceName)
        throws EntityNotFoundException;
}

