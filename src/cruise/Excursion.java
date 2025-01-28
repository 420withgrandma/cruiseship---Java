package cruise;

public class Excursion {
    private String port;
    private String day;
    private int capacity;
    private int bookedPassengers;

    public Excursion(String port, String day, int capacity) {
        this.port = port;
        this.day = day;
        this.capacity = capacity;
        this.bookedPassengers = 0;
    }

    public String getPort() {
        return port;
    }

    public String getDay() {
        return day;
    }

    public int getAvailableSpaces() {
        return capacity - bookedPassengers;
    }

    public boolean isFullyBooked() {
        return bookedPassengers >= capacity;
    }

    public void bookPassenger() {
        if (!isFullyBooked()) {
            bookedPassengers++;
        }
    }

    @Override
    public String toString() {
        return port + " (" + day + ", " + (isFullyBooked() ? "Fully Booked" : "Spaces: " + getAvailableSpaces()) + ")";
    }
}
//This section is the information for the excursions