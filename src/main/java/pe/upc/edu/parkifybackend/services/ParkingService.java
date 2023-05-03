package pe.upc.edu.parkifybackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.parkifybackend.models.ParkingModel;
import pe.upc.edu.parkifybackend.repositories.ParkingRepository;

import java.util.ArrayList;

@Service
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;

    public ArrayList<ParkingModel> getparking(){
        return (ArrayList<ParkingModel>) parkingRepository.findAll();
    }

    public parkingModel saveparking(parkingModel parking){
        return parkingRepository.save(parking);
    }

    public boolean deleteparking(Long id){
        try {
            parkingRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
