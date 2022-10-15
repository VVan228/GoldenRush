package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.TransportParam;
import hack.polyus.goldenrush.models.transport.TransportType;

import java.util.List;

public interface TransportDataService {
    List<TransportParam> getParams(TransportType type);
    List<TransportType> getTypes();
}
