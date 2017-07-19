package ua.goit.java8.module5.vehicles;


/**
 * Created by t.oleksiv on 19/07/2017.
 */
public class Car {

    // class variables
    private final int releaseDate;    //дата виробництва, не може бути змінена після створення об'єкта
    private String engineType;      //тип двигуна
    private int maxSpeed;       //максимальна швидкість для нової машини
    private int runupTime;      //час розгону до 100км.год
    private int totalNumberOfPassengers;    //вмістимість пасажирів
    private int currentNumberOfPassengers;  //кількість пасажирів в поточний момент
    private int currentSpeed;       //поточна швидкість
    private CarDoor[] cardoor = new CarDoor[4];     //масив з 5 дверей
    private CarWheel[] carwheel = new CarWheel[3];      //масив з 4 коліс

    // constructor1
    public Car(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    // constructor2
    public Car(int releaseDate, String engineType, int maxSpeed, int runupTime,
               int totalNumberOfPassengers, int currentNumberOfPassengers, int currentSpeed){
        this.releaseDate = releaseDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.runupTime = runupTime;
        this.totalNumberOfPassengers = totalNumberOfPassengers;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.currentSpeed = currentSpeed;
    }

    //methods
    //змінити поточну швидкість(встановити конкретну)
    public void setCurrentSpeed(int currentSpeed){
        if ((currentSpeed <= maxSpeed) && (currentSpeed >= 0)) {
            this.currentSpeed = currentSpeed;
        } else {
            System.out.println("Неможливо встановити дану швидкість. Вона не входить у проміжок [0," + maxSpeed + "]");
        }
    }

    //посадити 1 пасажира в машину
    public void takeOnePassenger(){
        if (currentNumberOfPassengers >= totalNumberOfPassengers){
            System.out.println("Неможливо взяти пасажирів. Машина заповнена.");
        } else {
            currentNumberOfPassengers++;
        }
    }

    //метод для перевірки присутності пасажирів у машині
    private boolean checkPassengers(){
        return (currentNumberOfPassengers > 0);
    }

    //висадити 1 пасажира з машини
    public void getoffOnePassenger(){
        if (checkPassengers()) {
            currentNumberOfPassengers--;
        } else {
            System.out.println("Неможливо висадити пасажирів. Вони відсутні в машині");
        }
    }

    //висадити всіх пасажирів
    public void getoffAllPassengers(){
        if (checkPassengers()) {
            currentNumberOfPassengers = 0;
        } else {
            System.out.println("Неможливо висадити пасажирів. Вони відсутні в машині");
        }
    }


}
