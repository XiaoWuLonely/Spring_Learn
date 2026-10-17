public class Steps1_Wife {
    private String name;
    private Steps1_Husban husban;

    public void setName(String name) {
        this.name = name;
    }

    public void setHusban(Steps1_Husban husban) {
        this.husban = husban;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Steps1_Wife{" +
                "name='" + name + '\'' +
                ", husban=" + husban.getName() +
                '}';
    }
}
