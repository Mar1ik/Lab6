package client.resources;

public class Address {
    private String zipCode; //Длина строки не должна быть больше 17, Поле не может быть null
    private String town; //Поле может быть null



    public Address(String zipCode, String  town) {
        this.zipCode = zipCode;
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getTown() {
        return town;
    }
    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
