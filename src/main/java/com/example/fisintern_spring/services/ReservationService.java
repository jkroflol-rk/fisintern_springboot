package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Reservation;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import com.example.fisintern_spring.repositories.CustomerRepository;
import com.example.fisintern_spring.repositories.ReservationRepository;
import com.example.fisintern_spring.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ReservationService extends GenericService<Reservation, Integer>{
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BilliardTableRepository billiardTableRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        super(reservationRepository);
    }

    public String updateEndTime(Integer id, LocalDateTime endTime) {
        Reservation reservation = reservationRepository.findById(id).get();
        boolean wasNull = reservation.getEndTime() == null;

        reservationRepository.updateEndTime(endTime, id);
        reservationRepository.updateTotalTime(id);

        Integer zoneId = billiardTableRepository.findZoneIdByTableId(findById(id, "").getBtableId());
        reservationRepository.updateTotalCost(zoneRepository.findHourlyPriceById(zoneId), id);

        reservationRepository.flush();
        return updateCustomerDebt(reservation, id, wasNull);
    }

    private String updateCustomerDebt(Reservation reservation, Integer id, boolean wasNull) {
        Reservation newReservation = reservationRepository.findById(id).get();
        BigDecimal oldPrice = customerRepository.findDebtById(reservation.getCustomerId());
        if (wasNull) {
            customerRepository.updateDebt(
                customerRepository.findDebtById(reservation.getCustomerId()).add(newReservation.getTotalPrice()),
                reservation.getCustomerId()
            );
            return newReservation.getTotalPrice() + " added to customer debt for reservation with id " + reservation.getId() + " and updated reservation end time";
        } else {
            customerRepository.updateDebt(
                    customerRepository.findDebtById(reservation.getCustomerId())
                            .add(newReservation.getTotalPrice())
                            .subtract(oldPrice),
                    reservation.getCustomerId()
            );
            return "the old price was " + oldPrice + " and the new price is " + newReservation.getTotalPrice();
        }
    }


    public String updateStatus(Reservation.Status status, Integer id) {
        Reservation reservation = reservationRepository.findById(id).get();
        if (reservation.getStatus() == status) {
            return "Reservation status with id " + id + " is already " + status + ".";
        }
        if (status == Reservation.Status.paid) {
            BigDecimal totalPrice = reservationRepository.findById(id).get().getTotalPrice();
            customerRepository.updateTotal(
                    customerRepository.findTotalById(reservation.getCustomerId()).add(totalPrice),
                    reservation.getCustomerId()
            );
            customerRepository.updateDebt(
                    customerRepository.findDebtById(reservation.getCustomerId()).subtract(totalPrice),
                    reservation.getCustomerId()
            );
        } else if (status == Reservation.Status.unpaid) {
            BigDecimal totalPrice = reservation.getTotalPrice();
            customerRepository.updateDebt(
                    customerRepository.findDebtById(reservation.getCustomerId()).add(totalPrice),
                    reservation.getCustomerId()
            );
            customerRepository.updateTotal(
                    customerRepository.findTotalById(reservation.getCustomerId()).subtract(totalPrice),
                    reservation.getCustomerId()
            );
        }
        reservationRepository.updateStatus(status, id);
        return "Updated reservation status with id " + id + " to " + status + ".";
    }
}
