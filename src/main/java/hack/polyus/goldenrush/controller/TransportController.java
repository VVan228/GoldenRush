package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TransportController {

    TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @ResponseBody
    @RequestMapping(
            value = "/transport/coords/set/{number}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void setTransportCoords(@RequestParam Coordinate coords, @PathVariable String number) {
        transportService.setCoordinates(coords, number);
    }


    @ResponseBody
    @RequestMapping(
            value = "/transport/coords/get/{number}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    void getTransportCoords(@PathVariable String number) {
        transportService.getCoordinates(number);
    }

    @ResponseBody
    @RequestMapping(
            value = "/transport/driver/set/{number}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void setTransportDriver(@RequestParam User driver, @PathVariable String number) {
        transportService.setDriver(driver, number);
    }


}
