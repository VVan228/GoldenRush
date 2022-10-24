package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.schedule.Request;
import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.SecurityUser;
import hack.polyus.goldenrush.repo.*;
import hack.polyus.goldenrush.services.TransportService;
import hack.polyus.goldenrush.services.UserService;
import hack.polyus.goldenrush.services.interfaces.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RequestController {

    private TransportService transportService;
    private RequestService requestService;
    private UserService userService;
    TransportParamRepo transportParamRepo;
    TransportParamValueRepo transportParamValueRepo;
    TransportDataRepo transportDataRepo;
    TransportTypeRepo transportTypeRepo;
    TransportParamValueEnumRepo transportParamValueEnumRepo;

    public RequestController(TransportService transportService, RequestService requestService, UserService userService, TransportParamRepo transportParamRepo, TransportParamValueRepo transportParamValueRepo, TransportDataRepo transportDataRepo, TransportTypeRepo transportTypeRepo, TransportParamValueEnumRepo transportParamValueEnumRepo) {
        this.transportService = transportService;
        this.requestService = requestService;
        this.userService = userService;
        this.transportParamRepo = transportParamRepo;
        this.transportParamValueRepo = transportParamValueRepo;
        this.transportDataRepo = transportDataRepo;
        this.transportTypeRepo = transportTypeRepo;
        this.transportParamValueEnumRepo = transportParamValueEnumRepo;
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/requests/save",
            produces = "application/json",
            method = RequestMethod.POST
    )
    public void saveRequest(
            @RequestBody /*Map<String, Object> res*/ TransportParse transportParse
            ) {
        //Gson gson = new Gson();
        //System.out.println(gson.toJson(res));
        List<TransportParamElement> transportParamElement = transportService.getParams(transportParse.getTransport_data_id());
        String[] data = transportParse.getTransport_data();
        TransportData transportData = new TransportData();
        transportTypeRepo.save(transportService.getType(transportParse.getTransport_data_id()));
        transportData.setTransportType(transportService.getType(transportParse.getTransport_data_id()));
        int i = 0;
        for(TransportParamElement tpe: transportParamElement){
            for(TransportParamValueEnum tpve: tpe.getValues()){
                transportParamValueEnumRepo.save(tpve);
                if(data[i].equals(tpve.getName())){
                    transportData.getParams().add(transportService.getParam(tpve.getParamId()));
                    TransportParamValue value = new TransportParamValue();
                    value.setValueId(tpve);
                    transportData.getParam_values().add(value);
                    transportParamRepo.save(transportService.getParam(tpve.getParamId()));
                    transportParamValueRepo.save(value);
                }
            }
            i++;
        }
        transportDataRepo.save(transportData);
        Request request = new Request();
        request.setClientId(transportParse.getClient_id());
        request.setLon(transportParse.getLon());
        request.setLat(transportParse.getLat());
        request.setTransportData(transportData);
        request.setDate(transportParse.getDate());
        request.setEnd(transportParse.getEnd());
        request.setStart(transportParse.getStart());
        requestService.insert(request);
        //requestService.insert(request);

    }

    @ResponseBody
    @RequestMapping(
            value = "/api/requests/get/{id}/",
            method = RequestMethod.POST
    )
    public Request getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/requests/getMy/",
            method = RequestMethod.POST
    )
    public List<Request> getRequestsMy() {
        SecurityUser ud = SecurityUser.getCurrent();
        switch (ud.getUser().getRole()){
            case CLIENT -> {
                return requestService.getRequestsClient(LocalDate.now(), ud.getUser().getId());
            }case SUPERVISOR -> {
                return requestService.getRequests(LocalDate.now());
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/requests/update/{id}/",
            method = RequestMethod.POST
    )
    public void updateRequest(@PathVariable Long id) {
        requestService.getRequestById(id);
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/requests/delete/{id}/",
            method = RequestMethod.POST
    )
    public void deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
    }

}
