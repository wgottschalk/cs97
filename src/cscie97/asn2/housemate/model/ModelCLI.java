package cscie97.asn2.housemate.model;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ModelCLI {
    public ModelCLI() {
    }

    public static void importFile(String filename) {
        try {
            var lines = Files.readAllLines(Paths.get(filename));
            for (var line : lines) {
                line = line.replaceAll("\\s", " ").trim();

                // skip blank lines and comments
                if (line.length() == 0 || line.charAt(0) == '#') continue;

                ModelCLI.executeQuery(line);
            }

        } catch (IOException | EntityAlreadyExistsException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> splitAndIgnoreQuotes(String query) {
        var results = new ArrayList<String>();
        var splitSpace = true;
        var startIndex = 0;
        for (var i = 0; i < query.length(); i++) {
            var letter = query.charAt(i);
            if (letter == '"') {
                splitSpace = !splitSpace;
                continue;
            }
            if (letter == ' ' && splitSpace) {
                var word = query.substring(startIndex, i);
                results.add(word.replaceAll("\"", ""));
                startIndex = i+1;
            }
        }
        results.add(query.substring(startIndex).replaceAll("\"", ""));
        return results;
    }

    private static void executeQuery(String query)
            throws EntityAlreadyExistsException, EntityNotFoundException
    {
        ModelService modelService = HouseMateModelService.getInstance();
        var args = ModelCLI.splitAndIgnoreQuotes(query);
        String[] parts = args.toArray(new String[args.size()]);
        switch (parts[0]) {
            case "define":
                switch (parts[1]) {
                    case "house": {
                        var name = parts[2];
                        var address = parts[4];

                        modelService.createHouse(name, address);
                        break;
                    }
                    case "room": {
                        var roomName = parts[2];
                        var floor = Integer.parseInt(parts[4]);
                        var type = RoomType.valueOf(parts[6].toUpperCase());
                        var houseName = parts[8];
                        var windows = Integer.parseInt(parts[10]);
                        modelService.createRoom(roomName, floor, type, houseName, windows);
                        break;
                    }
                    case "occupant": {
                        var occupantName = parts[2];
                        var occupantType = OccupantType.valueOf(parts[4].toUpperCase());
                        modelService.createOccupant(occupantName, occupantType);
                        break;
                    }
                    case "sensor": {
                        var name = parts[2];
                        var sensorType = SensorType.valueOf(parts[4].toUpperCase());
                        var roomPath = parts[6];
                        modelService.createSensor(name, sensorType, roomPath);
                        break;
                    }
                    case "appliance": {
                        var name = parts[2];
                        var applianceType = ApplianceType.valueOf(parts[4].toUpperCase());
                        var roomPath = parts[6];
                        var energyUsage = Integer.parseInt(parts[8]);
                        modelService.createAppliance(name, applianceType, roomPath, energyUsage);
                        break;
                    }
                }
                break;
            case "add": {
                var occupantName = parts[2];
                var houseName = parts[4];
                modelService.addOccupantToHouse(occupantName, houseName);
                break;
            }
            case "set": {
                var devicePath = parts[2];
                var statusName = parts[4];
                var value = parts[6];
                modelService.setDeviceStatus(devicePath, statusName, value);
                break;
            }
            case "show":
                switch (parts[1]) {
                    case "appliance":
                    case "sensor":
                        var devicePath = parts[2];
                        if (parts.length == 3) {
                            var deviceStatuses = modelService.showDeviceStatus(devicePath);
                            deviceStatuses.entrySet().forEach(entry -> {
                                System.out.println(String.format("%s - %s: %s", devicePath, entry.getKey(), entry.getValue()));
                            });
                        } else if (parts.length == 5) {
                            var status = parts[4];
                            var deviceStatus = modelService.showDeviceStatus(devicePath, status);
                            System.out.println(String.format("%s - %s: %s", devicePath, status, deviceStatus));
                        }
                        break;
                    case "configuration":
                        if (parts.length == 2) {
                            modelService.showConfiguration();
                        } else {
                            var path = parts[2];
                            var pathParts = path.split(":");
                            switch (pathParts.length) {
                                case 1:
                                    modelService.showConfiguration(pathParts[0]);
                                    break;
                                case 2:
                                    modelService.showConfiguration(pathParts[0], pathParts[1]);
                                    break;
                                case 3:
                                    modelService.showConfiguration(pathParts[0], pathParts[1], pathParts[2]);
                                    break;
                            }
                        }
                        break;
                    case "energy-use":
                        if (parts.length == 2) {
                            var energy = modelService.showEnergyUsage();
                            System.out.println("Total Energy Usage: " + Integer.toString(energy));
                        } else {
                            var path = parts[2];
                            var pathParts = path.split(":");
                            int energy = 0;
                            switch (pathParts.length) {
                                case 1:
                                    energy = modelService.showEnergyUsage(pathParts[0]);
                                    break;
                                case 2:
                                    energy = modelService.showEnergyUsage(pathParts[0], pathParts[1]);
                                    break;
                                case 3:
                                    energy = modelService.showEnergyUsage(pathParts[0], pathParts[1], pathParts[2]);
                                    break;
                            }
                            System.out.println(String.format("Energy Usage for %s: %d", path, energy));
                        }
                        break;
                }
                break;

            default:
                System.out.println("not a valid command");
        }

    }


}

