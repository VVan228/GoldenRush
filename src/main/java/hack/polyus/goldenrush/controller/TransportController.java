package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.services.TransportService;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class TransportController {

    TransportService transportService;
    MessagingService messagingService;

    @Autowired
    public TransportController(TransportService transportService, MessagingService messagingService) {
        this.transportService = transportService;
        this.messagingService = messagingService;
    }

    //@ResponseBody
    //@RequestMapping(
    //        value = "/transport/coords/set/{number}",
    //        method = RequestMethod.POST,
    //        consumes = "application/json"
    //)
    //void setTransportCoords(@RequestParam Coordinate coords, @PathVariable String number) {
    //    transportService.setCoordinates(coords, number);
    //}


    @ResponseBody
    @RequestMapping(
            value = "/api/transport/coords/get/{number}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    void getTransportCoords(@PathVariable String number) {
        transportService.getCoordinates(number);
    }

    //@ResponseBody
    //@RequestMapping(
    //        value = "/transport/driver/set/{number}",
    //        method = RequestMethod.POST,
    //        consumes = "application/json"
    //)
    //void setTransportDriver(@RequestParam User driver, @PathVariable String number) {
    //    transportService.setDriver(driver, number);
    //}

    @ResponseBody
    @RequestMapping(
            value = "api/transport/setStatus/accept/{transportId}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void setStatusAcceptOrder(@PathVariable Long transportId) {
        transportService.setStatusAcceptOrder(transportId);
    }

    @ResponseBody
    @RequestMapping(
            value = "api/transport/setStatus/inProgress/{transportId}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void setStatusInProgress(@PathVariable Long transportId) {
        transportService.setStatusInProgress(transportId);
    }

    @ResponseBody
    @RequestMapping(
            value = "api/transport/setStatus/free/{transportId}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void setStatusFree(@PathVariable Long transportId) {
        transportService.setStatusFree(transportId);
    }


    @ResponseBody
    @RequestMapping(
            value = "/api/transport/param/getParams/{typeId}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    List<TransportParamElement> getParams(@PathVariable Long typeId) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLat(11);
        coordinate.setLon(12);
        messagingService.sendLocationNotification(0L, coordinate);
        return transportService.getParams(typeId);
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/transport/type/getTypes",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    List<TransportType> getTypes() {
        return transportService.getTypes();
    }


}
