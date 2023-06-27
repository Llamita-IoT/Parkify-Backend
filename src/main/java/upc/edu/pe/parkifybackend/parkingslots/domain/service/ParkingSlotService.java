package upc.edu.pe.parkifybackend.parkingslots.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.parkingslots.domain.model.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {

    List<ParkingSlot> getAll();

    Page<ParkingSlot> getAll(Pageable pageable);

    ParkingSlot getById(Long ParkingSlotId);

    ParkingSlot create(ParkingSlot parkingSlot);
}
