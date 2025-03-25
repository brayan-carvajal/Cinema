package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crud_basic.dto.reservationDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.service.reservationService;

@RestController
@RequestMapping("/api/v1/reservation")
public class reservationController {

    /*
     * POST (Registrar)
     * GET (Obtener todos)
     * GET (Obtener por ID)
     * PUT (Actualizar)
     * DELETE (Eliminar)
     */

    @Autowired
    private reservationService reservationService;

    // POST - Registrar reservación
    @PostMapping("/post")
    public ResponseEntity<Object> registerReservation(@RequestBody reservationDTO reservation) {
        responseDTO respuesta = reservationService.save(reservation);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET - Obtener todas las reservaciones
    @GetMapping("/get")
    public ResponseEntity<Object> getAllReservations() {
        var listaReservations = reservationService.findAll();
        return new ResponseEntity<>(listaReservations, HttpStatus.OK);
    }

    // GET - Obtener una reservación por ID
    @GetMapping("/{idReservation}")
    public ResponseEntity<Object> getOneReservation(@PathVariable int idReservation) {
        var reservation = reservationService.findById(idReservation);
        if (!reservation.isPresent()) {
            return new ResponseEntity<>("Reservación no encontrada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    // PUT - Actualizar reservación
    @PutMapping("/{idReservation}")
    public ResponseEntity<Object> updateReservation(@PathVariable int idReservation, @RequestBody reservationDTO reservation) {
        responseDTO respuesta = reservationService.updateReservation(idReservation, reservation);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // DELETE - Eliminar reservación
    @DeleteMapping("/{idReservation}")
    public ResponseEntity<Object> deleteReservation(@PathVariable int idReservation) {
        responseDTO mensaje = reservationService.deleteReservation(idReservation);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
