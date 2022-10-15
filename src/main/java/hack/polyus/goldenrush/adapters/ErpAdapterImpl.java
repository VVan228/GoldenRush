package hack.polyus.goldenrush.adapters;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.services.TransportService;
import hack.polyus.goldenrush.services.interfaces.TransportDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ErpAdapterImpl implements ErpAdapter{

    TransportDataService transportDataService;
    TransportService transportService;

    double base_lon;
    double base_lat;

    public ErpAdapterImpl(TransportDataService transportDataService, TransportService transportService) {
        this.transportDataService = transportDataService;
        this.transportService = transportService;
    }

    @Override
    public List<Transport> getTransportForShift() {
        //User user = new User();
        List<TransportType> types = transportService.getTypes();

        Random random = new Random();
        List<Transport> res = new ArrayList<>();
        for(int i = 0; i<10; i++){
            User user = new User();
            user.setId((long) i);
            Transport transport = new Transport();
            transport.setId(((long) i));
            transport.setUser(user);
            transport.setNumber("A" + random.nextInt(10,99) + "AA");
            transport.setModel("transport model");
            Coordinate coordinate = new Coordinate();
            coordinate.setLon(base_lon + random.nextDouble(-1,1));
            coordinate.setLat(base_lat + random.nextDouble(-1,1));
            transport.setCoord(coordinate);
            TransportType type = types.get(random.nextInt(types.size()));
            List<TransportParamElement> params = transportService.getParams(type.getId());
            TransportParamElement paramElement;
            if(type.getId()==2L){
                paramElement = params.get(1);
            }else{
                paramElement = params.get(0);
            }
            TransportData transportData = new TransportData();
            transportData.setId(random.nextLong());
            transportData.setTransportType(type);
            List<TransportParam> listParams = new ArrayList<>();
            List<TransportParamValue> listParamValues = new ArrayList<>();
            TransportParam param = transportDataService.getParam(paramElement.getId());
            listParams.add(param);
            transportData.setParams(listParams);
            TransportParamValueEnum transportParamValueEnum = paramElement.getValues().get(random.nextInt(paramElement.getValues().size()));
            transportParamValueEnum.setId(random.nextLong());
            TransportParamValue transportParamValue = new TransportParamValue();
            transportParamValue.setId(random.nextLong());
            transportParamValue.setValueId(transportParamValueEnum);
            listParamValues.add(transportParamValue);
            transportData.setParam_values(listParamValues);
            transport.setTransportData(transportData);
            res.add(transport);
        }
        return res;
    }
}
