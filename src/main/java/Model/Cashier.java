package Model;

import View.Observer;

import java.util.ArrayList;
import java.util.List;


public class Cashier {
    private int id;
    private Status status;
    private List<Observer> observerList;

    public Cashier(int id) {
        this.id = id;
        status=Status.CLOSED;
        observerList=new ArrayList<Observer>();
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observerList){
            observer.update();
        }
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        notifyObservers();
    }
}
