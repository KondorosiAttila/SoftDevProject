import java.io.Serializable;

public class Car implements Serializable {
    String teamname;
    String engine;
    int horsepower;

    public Car(String teamname, String engine, int horsepower) {
        this.teamname = teamname;
        this.engine = engine;
        this.horsepower = horsepower;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(this.teamname).append(" (Engine supplier: ").append(this.engine).append(", ").append(this.horsepower).append(" horsepower)");
        return sb.toString();
    }
}
