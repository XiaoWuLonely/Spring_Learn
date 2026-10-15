package bean;

import java.util.Arrays;

public class Steps4_Set_Women {
    private String[] women;

    public void setWomen(String[] women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "Steps4_Set_Women{" +
                "women=" + Arrays.toString(women) +
                '}';
    }
}
