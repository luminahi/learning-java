package enumtype.lib;

public enum Job {
    CLERIC,
    PRIEST,
    KABBALIST,
    MIKO,
    ORACLE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}