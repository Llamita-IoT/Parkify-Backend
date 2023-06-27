package upc.edu.pe.parkifybackend.parkingslots.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.parkingslots.domain.model.entity.ParkingSlot;
import upc.edu.pe.parkifybackend.parkingslots.resource.CreationParkingSlotResource;
import upc.edu.pe.parkifybackend.parkingslots.resource.ParkingSlotResource;
import upc.edu.pe.parkifybackend.parkingslots.resource.UpdateParkingSlotResource;
import upc.edu.pe.parkifybackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class ParkingSlotMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ParkingSlotResource toResource(ParkingSlot model){
        return mapper.map(model, ParkingSlotResource.class);
    }

    public Page<ParkingSlotResource> modelListPage(List<ParkingSlot> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ParkingSlotResource.class), pageable, modelList.size());
    }

    public ParkingSlot toModel(CreationParkingSlotResource resource){
        return mapper.map(resource, ParkingSlot.class);
    }

    public ParkingSlot toModel(UpdateParkingSlotResource resource){
        return mapper.map(resource, ParkingSlot.class);
    }
}
