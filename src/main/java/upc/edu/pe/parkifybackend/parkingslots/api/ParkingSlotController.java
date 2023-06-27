package upc.edu.pe.parkifybackend.parkingslots.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.parkifybackend.parkingslots.domain.service.ParkingSlotService;
import upc.edu.pe.parkifybackend.parkingslots.mapping.ParkingSlotMapper;
import upc.edu.pe.parkifybackend.parkingslots.resource.CreationParkingSlotResource;
import upc.edu.pe.parkifybackend.parkingslots.resource.ParkingSlotResource;

@Tag(name = "ParkingSlot", description = "Parking slot information")
@RestController
@RequestMapping(value = "api/v1/parkingslots")
public class ParkingSlotController {

    private final ParkingSlotService service;
    private final ParkingSlotMapper mapper;

    public ParkingSlotController(ParkingSlotService service, ParkingSlotMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<ParkingSlotResource> getAllParkingSlots(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{parkingSlotId}")
    public ParkingSlotResource getParkingSlotById(@PathVariable("parkingSlotId") Long parkingSlotId){
        return mapper.toResource(service.getById(parkingSlotId));
    }

    @PostMapping
    public ResponseEntity<ParkingSlotResource> createParkingSlot(CreationParkingSlotResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
