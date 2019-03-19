package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Stop {

    private String naptanId;
    private String commonName;
    private double distance;
    private List<Arrival> arrivals;

    public Stop() {
    }

    public String getNaptanId() {
        return naptanId;
    }

    public String getCommonName() {
        return commonName;
    }

    public double getDistance() {
        return distance;
    }

    public List<Arrival> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Arrival> arrivals) {
        this.arrivals = arrivals;
    }
}
