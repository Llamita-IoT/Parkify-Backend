package pe.upc.edu.parkifybackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.parkifybackend.models.parkingModel;
import pe.upc.edu.parkifybackend.services.parkingService;

import java.util.ArrayList;

@RestController
@RequestMapping("/parkingspots")
public class parkingController {
    @Autowired
    parkingService parkingService;

   @GetMapping()
   public ArrayList<parkingModel> getparking(){
       return parkingService.getparking();
   }

   @PostMapping()
    public parkingModel saveparking(@RequestBody parkingModel parking){
       return this.parkingService.saveparking(parking);
   }

   @DeleteMapping(path = "/{id}")
    public String deleteparking(@PathVariable("id") Long id){
       boolean ok = this.parkingService.deleteparking(id);
       if (ok){
           return "Parking spot with id: " + id + " was deleted";
       }else{
           return "Can´t delete parking spot with id: " + id;
       }
   }

}
