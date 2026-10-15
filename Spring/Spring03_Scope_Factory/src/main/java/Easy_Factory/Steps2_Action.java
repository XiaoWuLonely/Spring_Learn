package Easy_Factory;

public class Steps2_Action {
    static void main(String[] args) {
        Steps2_Factory_Weapon tank = Steps2_Factory.get("TANK");
        tank.attack();
        Steps2_Factory_Weapon dagger = Steps2_Factory.get("DAGGER");
        dagger.attack();
        Steps2_Factory_Weapon fighter = Steps2_Factory.get("FIGHTER");
        fighter.attack();
    }
}
