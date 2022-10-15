package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.repo.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService {

    TransportRepo transportRepo;

    @Autowired
    TransportService(TransportRepo transportRepo) {
        this.transportRepo = transportRepo;
    }

    public void setCoordinates(Coordinate coords, String transportNumber) {
        transportRepo.setCoords(coords, transportNumber);
    }

    public Coordinate getCoordinates(String transportNumber) {

        return transportRepo.getCoords(transportNumber);
    }

    public void setDriver(User driver, String transportNumber) {
        transportRepo.setDriver(driver, transportNumber);
    }

}
