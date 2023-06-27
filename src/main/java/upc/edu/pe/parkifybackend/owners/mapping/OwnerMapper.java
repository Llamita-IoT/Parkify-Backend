package upc.edu.pe.parkifybackend.owners.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.owners.domain.model.entity.Owner;
import upc.edu.pe.parkifybackend.owners.resource.UpdateOwnerResource;
import upc.edu.pe.parkifybackend.shared.mapping.EnhancedModelMapper;
import upc.edu.pe.parkifybackend.owners.resource.CreationOwnerResource;
import upc.edu.pe.parkifybackend.owners.resource.OwnerResource;

import java.io.Serializable;
import java.util.List;

public class OwnerMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public OwnerResource toResource(Owner model){
        return mapper.map(model, OwnerResource.class);
    }

    public Page<OwnerResource> modelListPage(List<Owner> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, OwnerResource.class), pageable, modelList.size());
    }

    public Owner toModel(CreationOwnerResource resource){
        return mapper.map(resource, Owner.class);
    }

    public Owner toModel(UpdateOwnerResource resource){
        return mapper.map(resource, Owner.class);
    }
}
