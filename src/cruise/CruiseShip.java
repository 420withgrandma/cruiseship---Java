package cruise;

import java.util.ArrayList;
import java.util.List;

public class CruiseShip {
    private String name;
    private int passengerCapacity;
    private List<Cabin> cabins;
    private List<Passenger> passengers;
    private List<Excursion> excursions;
    //In this section the cruise ship info is detailed
    public CruiseShip(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.cabins = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.excursions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cabin> getCabins() {
        return cabins;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void addExcursion(Excursion excursion) {
        excursions.add(excursion);
    }
    //In this section it returns some variables and also adds objects to variables
    public List<Cabin> getVacantCabins() {
        List<Cabin> vacantCabins = new ArrayList<>();
        for (Cabin cabin : cabins) {
            boolean isOccupied = passengers.stream().anyMatch(p -> p.getCabinNumber() == cabin.getNumber());
            if (!isOccupied) {
                vacantCabins.add(cabin);
            }
        }
        return vacantCabins;
    }
    //In this section a list of all vacant cabins is identified

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cruise Ship: ").append(name).append("\n");
        sb.append("Passenger Capacity: ").append(passengerCapacity).append("\n");
        sb.append("Cabins:\n");
        for (Cabin cabin : cabins) {
            sb.append("  ").append(cabin).append("\n");
        }
        sb.append("Excursions:\n");
        for (Excursion excursion : excursions) {
            sb.append("  ").append(excursion).append("\n");
        }
        return sb.toString();
    }
}
//This section overrides the default string and shows a more detailed and readable string for the user