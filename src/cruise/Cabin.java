package cruise;

public class Cabin {
    private int number;
    private String type; 
    private boolean specialFeature; 

    public Cabin(int number, String type, boolean specialFeature) {
        this.number = number;
        this.type = type;
        this.specialFeature = specialFeature;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public boolean hasSpecialFeature() {
        return specialFeature;
    }

    @Override
    public String toString() {
        return "Cabin " + number + " (" + type + (specialFeature ? ", Special Feature" : "") + ")";
    }
}
//In this section it is the cabin information