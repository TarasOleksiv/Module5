package ua.goit.java8.module5.vehicles;


/**
 * Created by t.oleksiv on 19/07/2017.
 */
public class Car {

    // class variables
    private final int releaseDate;    //дата виробництва, не може бути змінена після створення об'єкта
    private String engineType;      //тип двигуна
    private int maxSpeed;       //максимальна швидкість для нової машини
    private int runupTime;      //час розгону до 100км/год
    private int totalNumberOfPassengers;    //вмістимість пасажирів
    private int currentNumberOfPassengers;  //кількість пасажирів в поточний момент
    private int currentSpeed;       //поточна швидкість
    private CarDoor[] cardoors = new CarDoor[MAX_DOORS - 1];     //масив з 4 дверей
    private CarWheel[] carwheels = new CarWheel[MAX_WHEELS - 1];      //масив з 10 коліс
    private int wheelCounter;       //поточна кількість коліс на машині
    private static final int MAX_DOORS = 4;     //максимальна кількість дверей
    private static final int MAX_WHEELS = 10;     //максимальна кількість дверей

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

    //ініціалізація дверей
    public void setCarDoors(){
        for (CarDoor cardoor : cardoors){
            cardoor = new CarDoor();
        }
    }

    //ініціалізація коліс
    public void setCarWheels(){
        wheelCounter = 4;
        for (int i=0; i <=3; i++){
            carwheels[i] = new CarWheel();
        }
    }

    //отримати двері по індексу
    public CarDoor getCarDoor(int i){
        return cardoors[i];
    }

    //отримати колесо по індексу
    public CarWheel getCarWheel(int i){
        return carwheels[i];
    }

    //зняти всі колеса з машини
    public void getOffAllCarWheels(){
        for (CarWheel carwheel: carwheels){
            carwheel = null;
        }
        wheelCounter = 0;
    }

    //встановити на машину X нових коліс
    public void setNewWheels(int x){
        if (x + wheelCounter > MAX_WHEELS) {
            System.out.println("Неможливо додати " + x + " коліс. Буде перевищено максимальну кількість " + MAX_WHEELS);
        } else {
            for (int i = 0; i < x; i++){
                carwheels[wheelCounter + i] = new CarWheel();
            }
            wheelCounter += x;
        }
    }

    //обчислити поточну можливу максимальну швидкість
    public double getCurrentMaxSpeed(){
        if ((currentNumberOfPassengers == 0) || (wheelCounter == 0)){
            return 0;
        } else {
            return maxSpeed * getMinTireWheel();
        }
    }

    //отримати найбільш стерте колесо
    private double getMinTireWheel(){
        double result = carwheels[0].getTireState();
        for (int i = 0; i < wheelCounter; i++){
            result = (carwheels[i].getTireState() < result)?carwheels[i].getTireState():result;
        }
        return result;
    }

    //отримати поточну кількість коліс
    public int getCurrentNumberOfWheels(){
        return wheelCounter;
    }

    //вивести всю інфу на консоль
    public void showinfo(){
        System.out.println("Дата виробництва машини: " + releaseDate);
        System.out.println("Тип двигуна: " + engineType);
        System.out.println("Максимальна швидкість нової машини: " + maxSpeed);
        System.out.println("Час розгону до 100км/год: " + runupTime);
        System.out.println("Вмістимість пасажирів: " + totalNumberOfPassengers);
        System.out.println("Кількість пасажирів на даний момент: " + currentNumberOfPassengers);
        System.out.println("Поточна кількість коліс: " + wheelCounter);
        System.out.println("Поточна швидкість: " + currentSpeed);
        System.out.println("Поточна можлива максимальна швидкість: " + getCurrentMaxSpeed());
    }
}
