package server.resources.randomizer;

import server.exceptions.*;
import server.managers.Validator;
import server.resources.*;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class WorkerGenerator {

    public static Worker createWorker(Long id, Scanner scanner) throws WrongArgEX, BuildWorkerEX, IdCopyEX {
        System.out.println("Let's create your resume");
        String input, a, b, zip, town;
        Coordinates coordinates;
        Address address;

        Worker worker;
        if (id == 0) {
            worker = new Worker();
        } else {
            worker = new Worker(id);
        }

        System.out.println("Hello, please, enter your name  (String) : ");
        input = scanner.nextLine();
        Validator.InputIsNotEmpty(input, "NAME");
        worker.setName(input);

        System.out.println("Enter coordinate x  (Integer) : ");
        input = scanner.nextLine();
        Validator.CoordinatesXIsValid(input);
        a = input;

        System.out.println("Enter coordinate y  (Integer) : ");
        input = scanner.nextLine();
        Validator.CoordinatesYIsValid(input);
        b = input;

        coordinates = new Coordinates(Integer.parseInt(a), Float.parseFloat(b));
        worker.setCoordinates(coordinates);

        System.out.println("Enter salary int (of course, limits are 'your input' > 0 and )  :   ");
        input = scanner.nextLine();
        Validator.salaryIsValid(input);
        worker.setSalary(Float.parseFloat(input));

        System.out.println("Enter your prefered Organization  (String) : ");
        input = scanner.nextLine();
        Validator.InputIsNotEmpty(input, "NAME");
        worker.setOrganization(input);

        System.out.println("Enter your OrganizationType (String)  : COMMERCIAL, GOVERNMENT, TRUST ");
        input = scanner.next();
        Validator.InputIsNotEmpty(input, "POSITION");
        OrganizationType organizationType = OrganizationType.valueOf(input.toUpperCase());
        worker.setOrgtype(String.valueOf(organizationType));

        System.out.println("Enter your position in Organization (String)  : DIRECTOR, MANAGER, CLEANER, MANAGER_OF_CLEANING ");
        input = scanner.next();
        Validator.InputIsNotEmpty(input, "POSITION");
        Position position = Position.valueOf(input.toUpperCase());
        worker.setPosition(position);

        System.out.println("Enter your position in Organization (String)  : FIRED, HIRED, RECOMMENDED_FOR_PROMOTION, REGULAR");
        input = scanner.next();
        Validator.InputIsNotEmpty(input, "POSITION");
        Status status = Status.valueOf(input.toUpperCase());
        if(status.equals(Status.FIRED) && worker.getEndDate() == null){
            worker.setEndDate(Date.from(Instant.now()));
            worker.setStatus(status);
        }else{
            worker.setStatus(status);
        }

        System.out.println("Enter your zipcode (int or string) :  ");
        input = scanner.next();
        Validator.zipIsValid(input);
        zip = input;

        System.out.println("Enter your town  (String) : ");
        input = scanner.next();
        Validator.NameIsValid(input);
        town = input;

        address = new Address(zip, town);
        worker.setAdress(String.valueOf(address));

        return worker;
    }
}