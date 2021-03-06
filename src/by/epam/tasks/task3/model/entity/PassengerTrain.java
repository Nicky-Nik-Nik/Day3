package by.epam.tasks.task3.model.entity;

import java.util.ArrayList;
import java.util.List;

public class PassengerTrain {
    private String destination;
    private int[] departureTime;
    private int num;
    private List<Carriage> carriages;

    public PassengerTrain(String destination, int departureHour, int departureMinute, int num, int carriageCount) {
        setDestination(destination);
        setDepartureTime(departureHour, departureMinute);
        setNum(num);
        setCarriages(carriageCount);
    }

    public int[] getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureHour, int departureMinute) {
        if (departureHour >= 0 && departureHour <= 23 && departureMinute >= 0 && departureMinute < 60) {
            this.departureTime = new int[]{departureHour, departureMinute};
        } else {
            throw new IllegalArgumentException("illegal departure time");
        }
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(int carriageCount) {
        carriages = new ArrayList<>();
        for (int i = 0; i < carriageCount; i++) {
            if (i < carriageCount / 3) {
                carriages.add(new Carriage(i + 1, CarriageTypes.BUSINESS));
            } else {
                carriages.add( new Carriage(i + 1, CarriageTypes.ECONOM));
            }
        }

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PassengerTrain{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", departureTime=").append(departureTime[0]).append(":").append(departureTime[1]);
        sb.append(", num=").append(num);
        sb.append('}');
        return sb.toString();
    }
}
