package upc.edu.pe.parkifybackend.owners.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.parkifybackend.owners.domain.service.OwnerService;
import upc.edu.pe.parkifybackend.owners.mapping.OwnerMapper;
import upc.edu.pe.parkifybackend.owners.resource.CreationOwnerResource;
import upc.edu.pe.parkifybackend.owners.resource.OwnerResource;

@Tag(name = "Owner", description = "Owner account")
@RestController
@RequestMapping(value = "api/v1/real_estates")
public class OwnerController {

    private final OwnerService service;
    private final OwnerMapper mapper;

    public OwnerController(OwnerService service, OwnerMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<OwnerResource> getAllOwners(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{ownerId}")
    public OwnerResource getOwnerById(@PathVariable("ownerId") Long ownerId){
        return mapper.toResource(service.getById(ownerId));
    }

    @PostMapping
    public ResponseEntity<OwnerResource> createOwner(CreationOwnerResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
