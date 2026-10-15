package bean;

import java.util.Arrays;

public class Steps4_Set_Array {
    private String[] aiHaos;
    private Steps4_Set_Women[] Women;

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    public void setWomen(Steps4_Set_Women[] women) {
        Women = women;
    }

    @Override
    public String toString() {
        return "Steps4_Set_Array{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", Women=" + Arrays.toString(Women) +
                '}';
    }


}
