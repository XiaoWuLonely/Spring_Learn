package Factory;

public class Action {
    static void main(String[] args) {
        Steps2_Factory_Weapon_Factory weaponFactory = new Steps2_Factory_Dagger_Factory();
        Steps2_Factory_Weapon dagger = weaponFactory.get();
        dagger.attack();
        Steps2_Factory_Weapon_Factory weaponFactory1 = new Steps2_Factory_Gun_Factory();
        Steps2_Factory_Weapon gun = weaponFactory1.get();
        gun.attack();
    }
}
