package java_interface.lib.element;

public class LightElement implements Element {
    public final String name = "Light";
    
    public LightElement() { }

    @Override
    public String getElement() {
        return name;
    }
}
