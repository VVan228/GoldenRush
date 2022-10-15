package hack.polyus.goldenrush.services;


import hack.polyus.goldenrush.models.destination_point.DestinationPoint;
import hack.polyus.goldenrush.repo.DestinationPointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationPointService {

    DestinationPointRepo destinationPointRepo;

    @Autowired
    DestinationPointService(DestinationPointRepo destinationPointRepo) {
        this.destinationPointRepo = destinationPointRepo;
    }

    public List<DestinationPoint> getAllDestinationPoints() {
        return destinationPointRepo.findAll();
    }

    public void addDestinationPoint(DestinationPoint point) {
        destinationPointRepo.save(point);
    }

    public void deleteDestinationPoint(Long id) {
        destinationPointRepo.deleteById(id);
    }


}
