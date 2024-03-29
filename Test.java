import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle("car", VehicleType.PRIVATE));
        vehicleList.add(new Vehicle("scooter", VehicleType.PRIVATE));
        vehicleList.add(new Vehicle("bus", VehicleType.PUBLIC));
        vehicleList.add(new Vehicle("plane", VehicleType.PUBLIC));

        

        Map<VehicleType, List<Vehicle>> vehicleMap = vehicleList.stream().collect(Collectors.groupingBy(Vehicle::getType, Collectors.toList()));System.out.print(vehicleMap.get(vehicleMap).iterator().next().getName());
        vehicleMap.entrySet().stream().peek(System.out::println);

       
    }
    
// public <R> add(<T> t, <S> r){
// return t+r;
// }
// MVP: minimal vibale product;
// back ordering

class Vehicle {
    private String name;
    private VehicleType type;

    public Vehicle(String name, VehicleType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}

enum VehicleType {
    PRIVATE, PUBLIC
}