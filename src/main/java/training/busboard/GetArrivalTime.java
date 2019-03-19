package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.List;

public class GetArrivalTime {

    public List<Arrival> getTimes(String stopID) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        List<Arrival> arrivals = client.target("https://api.tfl.gov.uk/StopPoint")
                .path(stopID)
                .path("Arrivals")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Arrival>>() {
                });

        arrivals.sort(Comparator.comparing(Arrival::getTimeToStation));
        return arrivals.size() < 5 ? arrivals : arrivals.subList(0, 5);
    }

}
