package enumtype.lib;

public enum Type {
    FIRE(0.5F, 2F),
    WATER(1F, 0.75F),
    EARTH(0.75F, 1.5F),
    WIND(0.5F, 1.25F),
    LIGHT(1.25f, 0.25F),
    DARK(0.25F, 2F);

    private float support;
    private float offense;

    Type(float support, float offense) {
        this.support = support;
        this.offense = offense;
    }

    public float getSupport() {
        return support;
    }

    public float getOffense() {
        return offense;
    }    
}
