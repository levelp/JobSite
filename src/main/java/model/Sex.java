package model;

/**
 * Created by dimashilin on 26.09.14.
 */
public enum Sex {
    MAN("Мужской"),
    WOMAN("Женский");

    private final String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
