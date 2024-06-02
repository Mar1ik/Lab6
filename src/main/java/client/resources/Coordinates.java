package client.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x; //Максимальное значение поля: 830, Поле не может быть null
    private float y; //Максимальное значение поля: 490
    public Coordinates(){
        super();
    }
    public Coordinates(int x, float y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates(int x, double y){
        this.x = x;
        this.y = (float)y;
    }

    public int getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String
    toString() {
        return
                "x=" + x +
                ", y=" + y ;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
