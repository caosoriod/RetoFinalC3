
package com.usa.ciclo3.retociclo3.repository;


import com.usa.ciclo3.retociclo3.crudrepository.BoatCrudRepository;
import com.usa.ciclo3.retociclo3.model.Boat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoatRepository {
    @Autowired
    private BoatCrudRepository boatCrudRepository;

    public List<Boat> getAll() {
        return (List<Boat>)  boatCrudRepository.findAll();
    }

    public Optional<Boat> getBoat(int id){
        return boatCrudRepository.findById(id);
    }

    public Boat save(Boat boat){
        return boatCrudRepository.save(boat);
    }

    public void delete(Boat boat){boatCrudRepository.delete(boat);}
    
}
