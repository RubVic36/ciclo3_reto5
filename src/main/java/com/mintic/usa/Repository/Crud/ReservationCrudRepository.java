package com.mintic.usa.Repository.Crud;

import com.mintic.usa.Modelo.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {


    @Query("select c.client, count(c.client) from Reservation  as c group by c.client order by count(c.client) desc")
    public List<Object[]> countTotalReservationsByClients();

    // SELECT * FROM Reservation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo;
    public  List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    // SELECT * FROM Reservation WHERE status = "cancelled"
    public List<Reservation> findAllByStatus(String status);
}
