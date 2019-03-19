package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class GetLocation {

    public Location getLocation (String postcode) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        Location location = client.target("https://api.postcodes.io/postcodes/" + postcode)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(PostcodeLocation.class).getResult();

        return location;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class PostcodeLocation {

        private Location result;

        public PostcodeLocation() {
        }

        public Location getResult() {
            return result;
        }
    }
}
