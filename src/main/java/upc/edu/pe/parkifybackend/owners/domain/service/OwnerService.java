package upc.edu.pe.parkifybackend.owners.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.owners.domain.model.entity.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAll();

    Page<Owner> getAll(Pageable pageable);

    Owner getById(Long OwnerId);

    Owner create(Owner owner);
}
