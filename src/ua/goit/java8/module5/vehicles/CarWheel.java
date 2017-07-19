package ua.goit.java8.module5.vehicles;

/**
 * Created by t.oleksiv on 19/07/2017.
 */
public class CarWheel {

    // class variables
    private double tirestate;    // [0,1]; 0 - out-of-date, 1 - new
    private static final double TIRESTATE_NEW = 1;
    private static final double TIRESTATE_OLD = 0;

    // constructor 1
    public CarWheel(){
        tirestate = 1;
    }

    // constructor2
    public CarWheel(double tirestate){
        if (checkTirestate(tirestate)){
            this.tirestate = tirestate;
        } else {
            System.out.println("Неможливо створити об'єкт класу CarWheel");
        }
    }

    // method to check that value is inside of [0,1]
    private boolean checkTirestate(double tirestate){
        boolean result = ((tirestate >= TIRESTATE_OLD) && (tirestate <= TIRESTATE_NEW));
        if (!result) System.out.println("Неправильне значення зношеності шини. \n" +
                "Це значення повинно бути в межах між 0 та 1 включно.");
        return result;
    }

    //methods
    public void setNewTire(){
        tirestate = TIRESTATE_NEW;
    }

    public void abradeTire(double x){
        tirestate = tirestate * (1 - (x / 100));
    }

    public double getTireState(){
        return tirestate;
    }

    public void showInfo(){
        System.out.println("Стан шини - " + getTireState());
    }
}
