package client.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public enum Status {
    FIRED(0),
    HIRED(3),
    RECOMMENDED_FOR_PROMOTION(2),
    REGULAR(1);
    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

