package basicKnow.reflect;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class Car {
    private String bind;
    private String color;
    private int maxSpeed;

    public Car() {
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String bind, String color, int maxSpeed) {
        this.bind = bind;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println("brand:"+bind+"-color:"+color+"-maxSpeed:"+maxSpeed);
    }
}
