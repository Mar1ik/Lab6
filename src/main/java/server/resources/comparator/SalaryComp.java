package server.resources.comparator;

import server.resources.Worker;

import java.util.Comparator;


public class SalaryComp implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        float salary1 = o1.getSalary();
        float salary2 = o2.getSalary();
        if (salary1 > salary2) {
            return 1;
        } else if (salary1 < salary2) {
            return -1;
        } else {
            return 0;
        }

    }
}
