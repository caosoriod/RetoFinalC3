
package com.usa.ciclo3.retociclo3.crudrepository;

import java.util.Date;
import java.util.List;
import com.usa.ciclo3.retociclo3.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository <Reservation,Integer>{
    public List<Reservation> findAllByStatus(String status);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore (Date dateOne, Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient ();
    
    
    
}
