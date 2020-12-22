package Droids;

public class Healer extends Droid {
    private int heal;
    public Healer()
    {
        super();
        heal = 5;
    }
    public Healer(String name, double health, int damage, int heal)
    {
        super(name, health, damage);
        this.heal = heal;
    }

    public void healFriendly(Droid friend)
    {
        friend.setHealth(friend.getHealth() + heal);
        System.out.println("Healing " + friend.getName());
    }

    @Override
    public String toString() {
        return "Healer{" +
                "name=" + name +
                ", health=" + health +
                ", damage=" + damage +
                ", heal='" + heal + '\'' +
                '}';
    }
}
