package cruise;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int cabinNumber;
    private List<Excursion> excursions;

    public Passenger(String name, int cabinNumber) {
        this.name = name;
        this.cabinNumber = cabinNumber;
        this.excursions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public void bookExcursion(Excursion excursion) {
        excursions.add(excursion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (Cabin ").append(cabinNumber).append(")");
        if (!excursions.isEmpty()) {
            sb.append("\n  Excursions:\n");
            for (Excursion excursion : excursions) {
                sb.append("    ").append(excursion).append("\n");
            }
        }
        return sb.toString();
    }
}
//This section defines the passenger class