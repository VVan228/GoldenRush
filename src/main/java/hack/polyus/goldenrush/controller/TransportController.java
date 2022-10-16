package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.adapters.ErpAdapter;
import hack.polyus.goldenrush.adapters.ErpAdapterImpl;
import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.Role;
import hack.polyus.goldenrush.models.user.SecurityUser;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.services.TransportService;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
public class TransportController {

    TransportService transportService;
    MessagingService messagingService;
    ErpAdapter erpAdapter;

    @Autowired
    public TransportController(TransportService transportService, MessagingService messagingService, ErpAdapter erpAdapter) {
        this.transportService = transportService;
        this.messagingService = messagingService;
        this.erpAdapter = erpAdapter;
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/transport/coords/set/{transportId}",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    void setTransportCoords(@RequestBody Coordinate coords, @PathVariable Long transportId) {
        transportService.setCoordinates(coords, transportId);
    }


    //@ResponseBody
    //@RequestMapping(
    //        value = "/api/transport/coords/get/{number}",
    //        method = RequestMethod.GET,
    //        produces = "application/json"
    //)
    //void getTransportCoords(@PathVariable int number) {
    //    transportService.getCoordinates(number);
    //}

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
            value = "/api/transport/get/forClient",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    List<Transport> getForClient() {
        SecurityUser securityUser = SecurityUser.getCurrent();
        if(securityUser.getUser().getRole()!= Role.CLIENT){
            return null;
        }
        return transportService.getTransportClient(LocalDate.now(), securityUser.getUser().getId());
    }


    @ResponseBody
    @RequestMapping(
            value = "/api/transport/param/getParams/{typeId}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    List<TransportParamElement> getParams(@PathVariable Long typeId) {
        /*Request r = new Request();
        r.setDate(Date.valueOf(LocalDate.now()));
        r.setStart(LocalDateTime.now());
        r.setEnd(LocalDateTime.now().plusHours(1));
        r.setClientId(2L);
        return r;*/
        //messagingService.sendStatusChangedNotification(0L,DriverStatus.ACCEPT_THE_ORDER);
        transportService.getTransportClient(LocalDate.now(), 0L);
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
