package upc.edu.pe.parkifybackend.parkingslots.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import upc.edu.pe.parkifybackend.parkingslots.domain.model.entity.ParkingSlot;
import upc.edu.pe.parkifybackend.parkingslots.domain.persistence.ParkingSlotRepository;
import upc.edu.pe.parkifybackend.parkingslots.domain.service.ParkingSlotService;
import upc.edu.pe.parkifybackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.parkifybackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    private static final String ENTITY = "ParkingSlot";

    private final ParkingSlotRepository parkingSlotRepository;

    private final Validator validator;

    public ParkingSlotServiceImpl(ParkingSlotRepository parkingSlotRepository, Validator validator){
        this.parkingSlotRepository = parkingSlotRepository;
        this.validator = validator;
    }

    @Override
    public List<ParkingSlot> getAll(){
        return parkingSlotRepository.findAll();
    }

    @Override
    public Page<ParkingSlot> getAll(Pageable pageable){
        return parkingSlotRepository.findAll(pageable);
    }

    @Override
    public ParkingSlot getById(Long id){
        return parkingSlotRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ParkingSlot create(ParkingSlot parkingSlot){
        Set<ConstraintViolation<ParkingSlot>> violations = validator.validate(parkingSlot);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return parkingSlotRepository.save(parkingSlot);
    }
}
