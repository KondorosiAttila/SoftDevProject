import java.io.Serializable;

public class Driver implements Serializable {
    String name;
    Car car;
    int number;

    public Driver(String name, Car car, int number) {
        this.name = name;
        this.car = car;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("(").append(this.number).append(")").append(", ").append(this.car.toString());
        return sb.toString();
    }
}
