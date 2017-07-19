package ua.goit.java8.module5.vehicles;

/**
 * Created by t.oleksiv on 19/07/2017.
 */
public class CarDoor {

    // class variables
    private boolean door_opened;
    private boolean window_opened;

    // constructor1
    public CarDoor(){
        door_opened = false;
        window_opened = false;
    }

    // constructor2
    public CarDoor(boolean door_opened, boolean window_opened){
        this.door_opened = door_opened;
        this.window_opened = window_opened;
    }


    // methods
    public void openDoor(){
        door_opened = true;
    }

    public void closeDoor(){
        door_opened = false;
    }

    public void setDoor(){
        door_opened = !door_opened;
    }

    public void openWindow(){
        window_opened = true;
    }

    public void closeWindow(){
        window_opened = false;
    }

    public void setWindow(){
        window_opened = !window_opened;
    }

    public boolean getDoor(){
        return door_opened;
    }

    public boolean getWindow(){
        return window_opened;
    }

    public void showInfo(){
        System.out.println("Двері машини " + ((getDoor()?"відкриті":"закриті")));
        System.out.println("Вікна машини " + ((getWindow()?"відкриті":"закриті")));
    }
}
