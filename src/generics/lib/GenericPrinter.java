package generics.lib;

public class GenericPrinter<T> {
    public T arg;

    public GenericPrinter(T arg) {
        this.arg = arg;
    }

    public void print() {
        System.out.println(arg);
    }

    public final void sum() {}

    public T getArg() {
        return arg;
    }
}
