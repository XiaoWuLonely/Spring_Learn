package oolong.heist.sp003_config_bean.bean;

public class MyAddress {
    private String city;
    private String street;

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "MyAddress{" + "city='" + city + '\'' + ", street='" + street + '\'' + '}';
    }
}
