package racingcar.model;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void advance() {
        this.distance += 1;
    }

    public int getDistance() {
        return this.distance;
    }

}
