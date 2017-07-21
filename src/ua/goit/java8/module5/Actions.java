package ua.goit.java8.module5;

import ua.goit.java8.module5.vehicles.Car;
import ua.goit.java8.module5.vehicles.CarDoor;
import ua.goit.java8.module5.vehicles.CarWheel;

import java.util.Scanner;

/**
 * Created by t.oleksiv on 19/07/2017.
 */
public class Actions {
    private static Scanner sc = new Scanner(System.in);
    private static CarWheel carWheel = new CarWheel();
    private static CarDoor cardoor = new CarDoor();
    private static Car car = new Car(2017,"External",180,10,5,1,0);
    private static double minTireState = 1;     //мінімум по стертості серед шин

    public static double getMinTireState(){
        return minTireState;
    }

    public static void main(String[] args) {
        chooseMainTask();
    }

    public static void chooseMainTask(){
        System.out.println();
        System.out.println("Головне меню.");
        System.out.println("З яким об'єктом працюєм? (1 - Машина, 2 - Двері, 3 - Колеса, інший символ - Вихід з програми)");
        System.out.print("Введіть символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                chooseCarTask();
                break;
            case "2":
                chooseCarDoorTask();
                break;
            case "3":
                chooseCarWheelTask();
                break;
            default:
                System.out.println("Ви закінчили виконання програми.");
                return;
        }
        chooseMainTask();
    }

    public static void chooseCarTask(){
        System.out.println();
        System.out.println("Меню \"Машина\".");
        System.out.println("Яке завдання виконуєм? (1 - Змінити поточну швидкість, 2 - Посадити 1 пасажира, 3 - Висадити 1 пасажира, 4 - Висадити всіх пасажирів, ");
        System.out.println("                        5 - Отримати двері по індексу, 6 - Отримати колесо по індексу, 7 - Зняти всі колеса з машини, 8 - Встановити на машину нові колеса, ");
        System.out.println("                        9 - Обчислити поточну можливу максимальну швидкість, 10 - Вивести інформацію про об'єкт, інший символ - Вихід в головне меню.)");
        System.out.print("Введіть символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                System.out.print("Яку поточну швидкість встановити? Введіть ціле число: ");
                int x = sc.nextInt();
                sc.nextLine();
                car.setCurrentSpeed(x);
                System.out.println("Поточна швидкість: " + car.getCurrentSpeed());
                break;
            case "2":
                car.takeOnePassenger();
                System.out.println("Поточна кількість пасажирів у машині: " + car.getCurrentNumberOfPassengers());
                break;
            case "3":
                car.getoffOnePassenger();
                System.out.println("Поточна кількість пасажирів у машині: " + car.getCurrentNumberOfPassengers());
                break;
            case "4":
                car.getoffAllPassengers();
                System.out.println("Поточна кількість пасажирів у машині: " + car.getCurrentNumberOfPassengers());
                break;
            case "5":
                System.out.print("Які двері отримати? введіть індекс: ");
                int i = sc.nextInt();
                sc.nextLine();
                CarDoor cd = car.getCarDoor(i);
                if (cd != null){
                    System.out.println("Отримали двері по індексу " + i + " : " + car.getCarDoor(i));
                    cd.showInfo();
                }
                break;
            case "6":
                System.out.print("Яке колесо отримати? введіть індекс: ");
                int j = sc.nextInt();
                sc.nextLine();
                CarWheel cw = car.getCarWheel(j);
                if (cw != null) {
                    System.out.println("Отримали колесо по індексу " + j + " : " + cw);
                    cw.showInfo();
                }
                break;
            case "7":
                car.getOffAllCarWheels();
                System.out.println("Всі колеса зняті.");
                System.out.println("Поточна кількість коліс на машині: " + car.getCurrentNumberOfWheels());
                break;
            case "8":
                System.out.print("Скільки коліс ви хотіли б встановити? введіть ціле число: ");
                int k = sc.nextInt();
                sc.nextLine();
                System.out.println("Кількість коліс до встановлення нових: " + car.getCurrentNumberOfWheels());
                car.setNewWheels(k);
                System.out.println("Поточна кількість коліс на машині: " + car.getCurrentNumberOfWheels());
                break;
            case "9":
                System.out.println("поточна можлива максимальна швидкість: " + car.getCurrentMaxSpeed(minTireState));
                break;
            case "10":
                car.showInfoShort();
                System.out.println("поточна можлива максимальна швидкість: " + car.getCurrentMaxSpeed(minTireState));
                break;
            default:
                return;
        }
        chooseCarTask();
    }

    public static void chooseCarDoorTask(){

        System.out.println();
        System.out.println("Меню \"Двері\".");
        System.out.println("Яке завдання виконуєм? (1 - Відкрити двері, 2 - Закрити двері, 3 - Інверснути стан дверей, " +
                        "4 - Відкрити вікно, 5 - Закрити вікно, 6 - Інверснути стан вікна, " +
                        "7 - Вивести інформацію про об'єкт, інший символ - Вихід в головне меню.)");
        System.out.print("Введіть символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                cardoor.openDoor();
                System.out.println("Відкрили двері.");
                break;
            case "2":
                cardoor.closeDoor();
                System.out.println("Закрили двері.");
                break;
            case "3":
                System.out.println("Стан дверей перед проведенням операції: " + ((cardoor.getDoor())?"відкриті":"закриті"));
                cardoor.setDoor();
                System.out.println("Стан дверей після проведення операції: " + ((cardoor.getDoor())?"відкриті":"закриті"));
                break;
            case "4":
                cardoor.openWindow();
                System.out.println("Відкрили вікно.");
                break;
            case "5":
                cardoor.closeWindow();
                System.out.println("закрили вікно.");
                break;
            case "6":
                System.out.println("Стан вікна перед проведенням операції: " + ((cardoor.getWindow())?"відкриті":"закриті"));
                cardoor.setWindow();
                System.out.println("Стан вікна після проведення операції: " + ((cardoor.getWindow())?"відкриті":"закриті"));
                break;
            case "7":
                cardoor.showInfo();
                break;
            default:
                return;
        }
        chooseCarDoorTask();
    }

    public static void chooseCarWheelTask(){

        System.out.println();
        System.out.println("Меню \"Колеса\".");
        System.out.println("Яке завдання виконуєм? (1 - Поставити нову шину, 2 - Стерти шину на Х%, " +
                            "3 - Вивести стан шини, 4 - Вивести інформацію про об'єкт, інший символ - Вихід в головне меню.)");
        System.out.print("Введіть символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                carWheel.setNewTire();
                System.out.println("Нову шину встановлено");
                break;
            case "2":
                System.out.print("На скільки відсотків стерти шину? Введіть число від 0 до 100: ");
                double x = sc.nextDouble();
                sc.nextLine();
                carWheel.abradeTire(x);
                minTireState = (minTireState <= carWheel.getTireState())?minTireState:carWheel.getTireState();
                System.out.println("Шину стерто на " + x + "%");
                carWheel.showInfo();
                break;
            case "3":
                System.out.println("Стан шини - " + carWheel.getTireState() + " від нової.");
                break;
            case "4":
                carWheel.showInfo();
                break;
            default:
                return;
        }
        chooseCarWheelTask();
    }
}
