package Steps2;

public class Steps2_Wife {
    private String name;
    private Steps2_Husban husban;

    public Steps2_Wife(String name, Steps2_Husban husban) {
        this.name = name;
        this.husban = husban;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Steps1_Wife{" + "name='" + name + '\'' + ", husban=" + husban.getName() + '}';
    }
}
