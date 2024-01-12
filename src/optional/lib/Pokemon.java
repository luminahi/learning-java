package optional.lib;

public class Pokemon {
    private String name;

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon() {
        this.name = "UNKNOWN";
    }

    public void attack() {
        System.out.println(name + " attacked!");
    }

    public boolean isPokemon() {
        return false;
    }

    public String getName() {
        return name;
    }
}
