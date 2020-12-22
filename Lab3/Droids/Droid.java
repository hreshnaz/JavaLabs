package Droids;

public abstract class Droid {
    private double preFighthealth;
    protected double health;
    protected int damage;
    protected String name;

    Droid()
    {
        name = "None";
        health = 100;
        preFighthealth = health;
        damage = 10;
    }
    Droid(String name, double health, int damage)
    {
        this.name = name;
        this.health = health;
        preFighthealth = this.health;
        this.damage = damage;
    }


    public void attack(Droid target)
    {
        printDmgMsg(name, health, target, damage, 1);
        target.health -= damage;
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    public static void printDmgMsg(String aname, double ahealth, Droid target, double damage, int toPrint){
        if(toPrint==1){
            System.out.printf("%s(%.2f) set %s(%.2f)    %.2f dmg.\n", aname, ahealth, target.getName(), target.getHealth(), damage);
            for (int i = 0; i < 40; i++) {
                System.out.print("-");
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("");
        }
        return;
    }

    public double getPreFighthealth() {
        return preFighthealth;
    }
    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getHealth() {
        return health;
    }

    public String getName()
    {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
