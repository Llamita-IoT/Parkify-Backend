package pe.upc.edu.parkifybackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.parkifybackend.models.OwnerModel;
import pe.upc.edu.parkifybackend.repositories.OwnerRepository;

import java.util.ArrayList;

@Service
public class OwnerService{

    @Autowired
    UserRepository userRepository;

    public ArrayList<OwnerModel> getOwner(){
        return (ArrayList<OwnerModel>) userRepository.findAll();
    }

    public OwnerModel saveUser(OwnerModel owner){
        return userRepository.save(owner);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
