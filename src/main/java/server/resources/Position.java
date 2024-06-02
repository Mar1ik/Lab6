package server.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public enum Position {
    DIRECTOR(1),
    MANAGER(2),
    CLEANER(3),
    MANAGER_OF_CLEANING(4);
    private final int value;

    Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
