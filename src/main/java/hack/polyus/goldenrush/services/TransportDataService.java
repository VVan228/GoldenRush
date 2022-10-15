package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.TransportParam;
import hack.polyus.goldenrush.models.transport.TransportParamValueEnum;
import hack.polyus.goldenrush.models.transport.TransportType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransportDataService {
    List<TransportParam> getParams(TransportType type);
    List<TransportType> getTypes();
    List<TransportParamValueEnum> getParamValueEnums(TransportParam param);

    TransportType getType(Long typeId);

    TransportParam getParam(Long paramId);

}
