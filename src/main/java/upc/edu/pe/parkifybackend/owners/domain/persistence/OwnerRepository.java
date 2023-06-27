package upc.edu.pe.parkifybackend.owners.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.parkifybackend.owners.domain.model.entity.Owner;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long>{
    @Override
    List<Owner> findAll();
}
