package hack.polyus.goldenrush.adapters;

import hack.polyus.goldenrush.models.transport.Transport;

import java.util.List;

public interface ErpAdapter {
    List<Transport> getTransportForShift();
}
