package upc.edu.pe.parkifybackend.parkingslots.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.parkifybackend.parkingslots.domain.model.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long>{
    @Override
    List<ParkingSlot> findAll();
}
