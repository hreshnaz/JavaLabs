package Weapons;
import Droids.Droid;

public class Blaster {
    private int damage;

    public Blaster()
    {
        damage = 20;
    }

    public Blaster(int damage)
    {
        this.damage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    void shoot(Droid target)
    {
        target.setHealth(target.getHealth()-damage);
    }

}
