package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.destination_point.DestinationPoint;
import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.services.DestinationPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DestinationPointController {

    DestinationPointService destinationPointService;

    @Autowired
    DestinationPointController(DestinationPointService destinationPointService) {
        this.destinationPointService = destinationPointService;
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/destinationPoint/getAll",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    List<DestinationPoint> getAllDestinationPoints() {
        return destinationPointService.getAllDestinationPoints();
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/destinationPoint/add",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void addDestinationPoint(@RequestBody DestinationPoint point) {
        destinationPointService.addDestinationPoint(point);
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/destinationPoint/delete/{id}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void deleteDestinationPoint(@PathVariable Long id) {
        destinationPointService.deleteDestinationPoint(id);
    }


}
