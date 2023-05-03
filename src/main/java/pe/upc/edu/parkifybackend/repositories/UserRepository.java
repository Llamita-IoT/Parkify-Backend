package pe.upc.edu.parkifybackend.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.upc.edu.parkifybackend.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
}

