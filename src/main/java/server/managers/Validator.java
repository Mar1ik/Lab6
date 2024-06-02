package server.managers;

import server.exceptions.*;
import server.resources.*;
import server.resources.randomizer.IdRandomizer;

public class Validator {
    public static void idIsOK(String arg) throws IdCopyEX, WrongArgEX {
        long id;
        try {
            id = Long.parseLong(arg);
        } catch (Exception e) {
            throw new WrongArgEX("ID");
        }
        if (!IdRandomizer.IDisUnic(id)) {
            throw new IdCopyEX(id);
        }
    }

    public static void InputIsNotEmpty(String arg, String data) throws WrongArgEX {
        if (arg.isEmpty()) {
            throw new WrongArgEX(data);
        }
    }

    public static void CoordinatesXIsValid(String arg) throws WrongArgEX {
        try {
            Integer.parseInt(arg);
            if(Integer.parseInt(arg) > 830){
                throw new WrongArgEX("Too much");
            }
        } catch (Exception e) {
            throw new WrongArgEX("Coordinates isn't valid");
        }
    }
    public static void CoordinatesYIsValid(String arg) throws WrongArgEX {
        try {
            Integer.parseInt(arg);
            if(Integer.parseInt(arg) > 430){
                throw new WrongArgEX("Too much");
            }
        } catch (Exception e) {
            throw new WrongArgEX("Coordinates isn't valid");
        }
    }
    public static void salaryIsValid(String arg) throws WrongArgEX {
        try {
            float z = Float.parseFloat(arg);
            if (0 > z) {
                throw new MoneyMakerEX("Chet v minus rabotaesh");
            }
            if(2000000 < z){
                throw new MoneyMakerEX("It's a little bit mnogo, please pay all your fees");
            }
        } catch (Exception e) {
            throw new WrongArgEX("salary error, invalid values");
        }
    }

    public static void PostionIsVaild(String arg) throws WrongArgEX {
        try {
            Position.valueOf(arg);
        } catch (Exception e) {
            throw new WrongArgEX("Position error, please choose another");
        }
    }

    public static void StatusIsValid(String arg) throws WrongArgEX {
        try {
            Status.valueOf(arg);
        } catch (Exception e) {
            throw new WrongArgEX("OrganizationType error, please choose another");
        }
    }

    public static void NameIsValid(String arg) {

    }
    public static void WorkerISValid(Worker worker) throws  WrongArgEX{
        try{
            Validator.NameIsValid(worker.getName());
            Validator.salaryIsValid(String.valueOf(worker.getSalary()));
            Validator.StatusIsValid(String.valueOf(worker.getStatus()));
            Validator.PostionIsVaild(String.valueOf(worker.getPosition()));
            Validator.idIsOK(String.valueOf(worker.getId()));

        }catch (Exception e){
            throw new WrongArgEX("Worker Error");
        }
    }
    public static void zipIsValid(String arg) throws WrongArgEX {
        try {
            int length = arg.length();
            if (length > 17) {
                throw new MoneyMakerEX("Doesn't correct, too long");
            }
            if(length < 0){
                throw new MoneyMakerEX("Doesn't correct, to small");
            }
        } catch (Exception e) {
            throw new WrongArgEX("Wrong zipcode");
        }
    }


}
