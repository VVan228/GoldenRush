package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.transport.TransportData;

import java.util.List;

public interface RequestDataService {

    TransportData getTransportData(Long transportId);
}
