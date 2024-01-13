package enumtype.lib;

public class Healer {

    private Job job;
    private Type element;
    private float power;

    public Healer(Job job, Type element, int power) {
        this.job = job;
        this.element = element;
        this.power = power;
    }

    public void heal() {
        int healing = Math.round(element.getSupport() * power);
        String msg = String.format("%s healed %d HP",job, healing);
        System.out.println(msg);
    }

    public void attack() {
        int damage = Math.round(element.getOffense() * power * 1.2F);
        String msg = String.format("%s dealt %d damage",job, damage);
        System.out.println(msg);
    }

    public Type getElement() {
        return element;
    }
}
