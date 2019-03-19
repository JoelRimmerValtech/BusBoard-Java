package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class GetStops {

    public List<Stop> getStops (String lon, String lat) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        List<Stop> stops = client.target("https://api.tfl.gov.uk/StopPoint?stopTypes=NaptanPublicBusCoachTram&radius=1000&lat=" + lat + "&lon=" + lon)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(StopPoints.class).getStopPoints();
        stops=stops.subList(0,2);

        stops.forEach(stop -> stop.setArrivals(new GetArrivalTime().getTimes(stop.getNaptanId())));
        return stops;
    }

    @JsonIgnoreProperties (ignoreUnknown = true)
    private static class StopPoints {

        private List<Stop> stopPoints;

        public StopPoints() {
        }

        public List<Stop> getStopPoints() {
            return stopPoints;
        }
    }

}
