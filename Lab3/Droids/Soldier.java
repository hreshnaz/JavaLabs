package Droids;
import Weapons.*;

public class Soldier extends Droid {
    private Blaster blaster;
    public Soldier()
    {
        super();
        blaster = null;
    }
    public Soldier(String name, double health, int damage, Blaster blaster)
    {
        super(name, health, damage);
        this.blaster = blaster;
    }

    @Override
    public void attack(Droid target) {
        printDmgMsg(name, health, target, damage, 1);
        target.health -= blaster.getDamage()-(0.2 * damage);
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name=" + name +
                ", health=" + health +
                ", damage='" + damage + '\'' +
                '}';
    }
}
