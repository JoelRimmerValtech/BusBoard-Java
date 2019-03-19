package training.busboard;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Postcode without spaces: ");
        String postcode = scanner.next();
        System.out.println();

        Location location = new GetLocation().getLocation(postcode);
        List<Stop> stops = new GetStops().getStops(Double.toString(location.getLongitude()), Double.toString(location.getLatitude()));
        stops.forEach(stop -> {
            System.out.println("Stop Name: " + stop.getCommonName());
            stop.getArrivals().forEach(arrival -> {
                System.out.print("Bus Number: " + arrival.getLineName());
                System.out.print(", Heading Towards: " + arrival.getDestinationName());
                System.out.println(", Arriving in: " + arrival.getTimeToStation());
            });
            System.out.println();
        });
    }
}	
