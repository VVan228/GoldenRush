package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.repo.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
