package com.mintic.usa.Web;

import com.mintic.usa.Modelo.DTOs.CountClient;
import com.mintic.usa.Modelo.DTOs.CountStatus;
import com.mintic.usa.Modelo.Reservation;
import com.mintic.usa.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idResevation){
        return reservationService.getReservation(idResevation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation r){
        return reservationService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation){
        return reservationService.delete(idReservation);
    }


    @GetMapping("/report-clients")
    public List<CountClient> getReportTopClients(){
        return reservationService.getTotalClients();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReportReservationsDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }
    @GetMapping("/report-status")
    public CountStatus getReservationStatus(){
        return reservationService.getReservationStatus();
    }
}
