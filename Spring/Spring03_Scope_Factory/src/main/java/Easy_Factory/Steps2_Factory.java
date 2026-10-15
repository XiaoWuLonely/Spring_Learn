package Easy_Factory;

public class Steps2_Factory {
    /**
     * 静态方法
     *
     * @param weaponType
     * @return
     */
    public static Steps2_Factory_Weapon get(String weaponType) {
        if ("TANK".equals(weaponType)) {
            return new Steps2_Factory_Tank();
        } else if ("DAGGER".equals(weaponType)) {
            return new Steps2_Factory_Dagger();
        } else if ("FIGHTER".equals(weaponType)) {
            return new Steps2_Factory_Fighter();
        } else {
            throw new RuntimeException("不支持该武器的生产");
        }
    }
}
