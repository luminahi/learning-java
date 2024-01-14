package com.luminahi.java_interface.lib.element;

public class DarkElement implements Element {
    public final String name = "Dark";
    
    public DarkElement() { }

    @Override
    public String getElement() {
        return name;
    }
}
