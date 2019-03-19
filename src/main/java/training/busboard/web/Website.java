package training.busboard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.busboard.GetLocation;
import training.busboard.GetStops;
import training.busboard.Location;

@Controller
@EnableAutoConfiguration
public class Website {

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/loading")
    ModelAndView loading() {
        return new ModelAndView("loading");
    }

    @RequestMapping("/busInfo")
    ModelAndView busInfo(@RequestParam("postcode") String postcode) {
        Location location = new GetLocation().getLocation(postcode);
        return new ModelAndView("info", "busInfo", new BusInfo(postcode,
                new GetStops().getStops(location.getLongitude(), location.getLatitude())));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

}