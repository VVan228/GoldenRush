package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.repo.TransportRepo;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import hack.polyus.goldenrush.services.interfaces.TransportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    TransportRepo transportRepo;
    TransportDataService dataService;
    MessagingService messagingService;

    private boolean getNightShift(){
        LocalTime time = LocalTime.now();
        return time.isAfter(LocalTime.of(20,0));
    }

    @Autowired
    public TransportService(TransportRepo transportRepo, TransportDataService dataService, MessagingService messagingService) {
        this.transportRepo = transportRepo;
        this.dataService = dataService;
        this.messagingService = messagingService;
    }


    public void setCoordinates(Coordinate coords, Long transportId) {
        Optional<Transport> t = transportRepo.findById(transportId);
        System.out.println(t.isPresent());
        if(t.isPresent()){
            Transport transport = t.get();
            transport.setCoord(coords);
            transportRepo.save(transport);
            messagingService.sendLocationChangedNotification(transportId, coords);
        }
    }


    //public void setDriver(User driver, String transportNumber) {
    //    transportRepo.setDriver(driver, transportNumber);
    //}


    public List<TransportParamElement> getParams(Long typeId){
        TransportType type = dataService.getType(typeId);
        List<TransportParam> params = dataService.getParams(type);
        List<TransportParamElement> res = new ArrayList<>();
        for(TransportParam p: params){
            List<TransportParamValueEnum> enums = dataService.getParamValueEnums(p);
            res.add(new TransportParamElement(p.getName(),p.getId(), enums));
        }
        return res;

    }
    public List<TransportType> getTypes(){
        return dataService.getTypes();
    }


    public void setStatusAcceptOrder(Long transportId) {
        messagingService.sendStatusChangedNotification(transportId, DriverStatus.ACCEPT_THE_ORDER);
        transportRepo.setTransportStatus(transportId, DriverStatus.ACCEPT_THE_ORDER);
    }

    public void setStatusInProgress(Long transportId) {
        messagingService.sendStatusChangedNotification(transportId, DriverStatus.IN_PROGRESS);
        transportRepo.setTransportStatus(transportId, DriverStatus.IN_PROGRESS);
    }

    public void setStatusFree(Long transportId) {
        messagingService.sendStatusChangedNotification(transportId, DriverStatus.FREE);
        transportRepo.setTransportStatus(transportId, DriverStatus.FREE);
    }

    public List<Transport> getTransportClient(LocalDate date, Long id){
        return transportRepo.getClientTransport(date, getNightShift(), id);
    }

    public TransportParam getParam(Long paramId){
        return dataService.getParam(paramId);
    }

    public TransportType getType(Long typeId){
        return dataService.getType(typeId);
    }
}
