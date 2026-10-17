package Steps2;

public class Steps2_Husban {
    private String name;
    private Steps2_Wife wife;

    public Steps2_Husban(String name, Steps2_Wife wife) {
        this.name = name;
        this.wife = wife;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Steps1_Husban{" +
                "name='" + name + '\'' +
                ", Wife=" + wife.getName() +
                '}';
    }
}
