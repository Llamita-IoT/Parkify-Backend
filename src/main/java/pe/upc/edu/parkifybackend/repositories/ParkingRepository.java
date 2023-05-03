package pe.upc.edu.parkifybackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.upc.edu.parkifybackend.models.ParkingModel;

@Repository
public interface ParkingRepository extends CrudRepository<ParkingModel, Long> {
}
