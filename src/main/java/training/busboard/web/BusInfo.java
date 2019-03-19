package training.busboard.web;

import training.busboard.Stop;
import java.util.List;

public class BusInfo {
    private final String postcode;
    private List<Stop> stopList;

    public BusInfo(String postcode, List<Stop> stopList) {
        this.postcode = postcode;
        this.stopList = stopList;
    }

    public String getPostcode() {
        return postcode;
    }

    public List<Stop> getStopList() {
        return stopList;
    }
}
