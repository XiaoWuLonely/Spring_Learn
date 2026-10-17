public class Steps1_Husban {
    private String name;
    private Steps1_Wife wife;

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Steps1_Wife wife) {
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
