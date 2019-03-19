package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Arrival {

    private String lineName;
    private String destinationName;
    private int timeToStation;

    private Arrival () {

    }

    public String getLineName() {
        return lineName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getTimeToStation() {
        return timeToStation;
    }
}
