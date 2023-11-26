package org.example.people;

import lombok.Getter;

public abstract class People {
    @Getter
    protected String name;

    public People(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }
}
