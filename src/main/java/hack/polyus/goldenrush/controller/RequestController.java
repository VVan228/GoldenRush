package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.user.SecurityUser;
import hack.polyus.goldenrush.services.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RequestController {

    private RequestService requestService;
    @Autowired
    RequestController(RequestService rS) {
        this.requestService = rS;
    }

    @ResponseBody
    @RequestMapping(
            value = "/api/requests/save",
            produces = "application/json",
            method = RequestMethod.POST
    )
    public void saveRequest(
            @RequestBody Request request
    ) {
        requestService.insert(request);
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
