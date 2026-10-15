package Factory;

public class Steps2_Factory_Dagger_Factory extends Steps2_Factory_Weapon_Factory {
    @Override
    public Steps2_Factory_Weapon get() {
        return new Steps2_Factory_Dagger();
    }
}
