package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.repo.TransportRepo;
import hack.polyus.goldenrush.services.interfaces.TransportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransportService {

    TransportRepo transportRepo;
    TransportDataService dataService;

    @Autowired
    public TransportService(TransportRepo transportRepo, TransportDataService dataService) {
        this.transportRepo = transportRepo;
        this.dataService = dataService;
    }

    //public void setCoordinates(Coordinate coords, String transportNumber) {
    //    transportRepo.setCoords(coords, transportNumber);
    //}

    public Coordinate getCoordinates(String transportNumber) {

        return transportRepo.getCoords(transportNumber);
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
        transportRepo.setTransportStatus(transportId, DriverStatus.ACCEPT_THE_ORDER);
    }

    public void setStatusInProgress(Long transportId) {
        transportRepo.setTransportStatus(transportId, DriverStatus.IN_PROGRESS);
    }

    public void setStatusFree(Long transportId) {
        transportRepo.setTransportStatus(transportId, DriverStatus.FREE);
    }

}
