package com.usa.ciclo3.prueba_ciclo3_reto3.service;

import com.usa.ciclo3.prueba_ciclo3_reto3.model.Reservation;
import com.usa.ciclo3.prueba_ciclo3_reto3.reports.CountClient;
import com.usa.ciclo3.prueba_ciclo3_reto3.reports.ReservationStatus;
import com.usa.ciclo3.prueba_ciclo3_reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdeReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> tmpReservation = reservationRepository.getReservation(reservation.getIdeReservation());
            if(tmpReservation.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdeReservation() != null) {
            Optional<Reservation> tmpReservation = reservationRepository.getReservation(reservation.getIdeReservation());
            if (!tmpReservation.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    tmpReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    tmpReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    tmpReservation.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(tmpReservation.get());
                return tmpReservation.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int id){
        Boolean aBoolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ReservationStatus   getReservationStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(),cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateOne, String dateTwo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if(startDate.before(endDate)){
                return reservationRepository.getReservationPeriod(startDate,endDate);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClient();
    }
}
