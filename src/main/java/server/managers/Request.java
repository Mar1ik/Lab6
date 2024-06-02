package server.managers;

import server.resources.Worker;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 5760575944040770153L;
    private String message = null;
    private Worker worker = null;
    private String key = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Request(String message, Worker worker, String key) {
        this.message = message;
        this.worker = worker;
        this.key = key;
    }
}
