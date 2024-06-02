package server.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Location {
    private Long x; //Поле не может быть null
    private double y;
    private Long z; //Поле не может быть null
    private String name; //Поле может быть null
}
