package com.luminahi.apicall;

public record Product(long id, String title, String description, float price ) {
    @Override
    public final String toString() {
        return String.format(
            "id: %s\ntitle: %s\ndescription: %s\nprice: %s\n", id, title, description, price
        );
    }
}
