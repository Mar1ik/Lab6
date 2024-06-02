package server.resources;

import server.exceptions.IdCopyEX;
import server.exceptions.WrongArgEX;
import server.managers.Validator;
import server.resources.randomizer.IdRandomizer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Worker implements Comparable<Worker>, Serializable {
    private static final long serialVersionUID = 228L;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    //@JsonIgnore

    private Coordinates coordinates; //Поле не может быть null
    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    //@JsonSerialize(using = LocalDateTimeSerializer.class)
    //@JsonProperty("coordinates")

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm-ss")
    //@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    //@JsonIgnore
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Date endDate; //Поле может быть null
    private Position position; //Поле не может быть null
    private Status status; //Поле может быть null
    private String organization; //Поле не может быть null



    private String orgtype;



    private String adress;

    public Worker(long id, String name, Coordinates coordinates, LocalDateTime creationDate, float salary, Date endDate, Position position, Status status, String organization, String orgtype) {
        this.id = IdRandomizer.generatedID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
        this.orgtype = orgtype;
    }

    public Worker(Long id) {
        this.id = IdRandomizer.generatedID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.salary = salary;

    }

    public Worker() {
        this.id = IdRandomizer.generatedID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    public Worker(String[] data) throws WrongArgEX, IdCopyEX {
        Validator.idIsOK(data[1]);
        Validator.NameIsValid(data[2]);
        Validator.CoordinatesXIsValid(data[3]);
        Validator.CoordinatesYIsValid(data[4]);
        Validator.salaryIsValid(data[6]);
        Validator.StatusIsValid(data[8]);


        this.id = Long.parseLong(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Integer.parseInt(data[3]), Float.parseFloat(data[4]));
        this.creationDate = LocalDateTime.parse(data[5]);
        this.salary = Integer.parseInt(data[6]);
        this.position = Position.valueOf(data[7]);
        this.status = Status.valueOf(data[8]);
        this.organization = data[9];
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public float getSalary() {
        return salary;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Position getPosition() {
        return position;
    }

    public Status getStatus() {
        return status;
    }

    public String getOrganization() {
        return organization;
    }
    public String getOrgtype() {
        return orgtype;
    }
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = LocalDateTime.from(creationDate);
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                ":\n name='" + name + '\'' +
                ",\n coordinates =" + coordinates +
                ",\n creationDate=" + creationDate +
                ",\n salary=" + salary +
                ",\n endDate=" + endDate +
                ",\n position=" + position +
                ",\n status=" + status +
                ",\n organization=" + organization +
                ",\n ortType=" + orgtype + ",\n Adress=" + adress
                ;
    }

    @Override
    public int compareTo(Worker o) {
        return (int) (this.id - o.getId());
    }
}
