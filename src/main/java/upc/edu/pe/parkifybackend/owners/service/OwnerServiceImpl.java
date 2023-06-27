package upc.edu.pe.parkifybackend.owners.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import upc.edu.pe.parkifybackend.owners.domain.model.entity.Owner;
import upc.edu.pe.parkifybackend.owners.domain.persistence.OwnerRepository;
import upc.edu.pe.parkifybackend.owners.domain.service.OwnerService;
import upc.edu.pe.parkifybackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.parkifybackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService {

    private static final String ENTITY = "Owner";

    private final OwnerRepository ownerRepository;

    private final Validator validator;

    public OwnerServiceImpl(OwnerRepository ownerRepository, Validator validator){
        this.ownerRepository = ownerRepository;
        this.validator = validator;
    }

    @Override
    public List<Owner> getAll(){
        return ownerRepository.findAll();
    }

    @Override
    public Page<Owner> getAll(Pageable pageable){
        return ownerRepository.findAll(pageable);
    }

    @Override
    public Owner getById(Long id){
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Owner create(Owner owner){
        Set<ConstraintViolation<Owner>> violations = validator.validate(owner);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return ownerRepository.save(owner);
    }
}
