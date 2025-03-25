package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.dto.ticketDTO;
import com.sena.crud_basic.model.ticket;
import com.sena.crud_basic.repository.Iticket;

@Service
public class ticketService {

    @Autowired
    private Iticket data;

    // Registrar un ticket
    public responseDTO save(ticketDTO ticketDTO) {
        // Validaciones
        if (ticketDTO.getPrice() <= 0) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El precio del boleto debe ser mayor a 0.");
            return respuesta;
        }

        ticket ticketRegister = convertToModel(ticketDTO);
        data.save(ticketRegister);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Boleto registrado correctamente.");
        return respuesta;
    }

    // Obtener todos los boletos
    public List<ticket> findAll() {
        return data.findAll();
    }

    // Obtener un boleto por ID
    public Optional<ticket> findById(int idTicket) {
        return data.findById(idTicket);
    }

    // Eliminar un boleto
    public responseDTO deleteTicket(int idTicket) {
        if (!findById(idTicket).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El boleto no existe.");
            return respuesta;
        }

        data.deleteById(idTicket);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Boleto eliminado correctamente.");
        return respuesta;
    }

    // Actualizar un boleto
    public responseDTO updateTicket(int idTicket, ticketDTO ticketDTO) {
        Optional<ticket> ticketOptional = data.findById(idTicket);

        if (!ticketOptional.isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El boleto con ID " + idTicket + " no existe.");
            return respuesta;
        }

        // Validaciones
        if (ticketDTO.getPrice() <= 0) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El precio del boleto debe ser mayor a 0.");
            return respuesta;
        }

        ticket existingTicket = ticketOptional.get();
        existingTicket.setCustomer(ticketDTO.getCustomer());
        existingTicket.setScreening(ticketDTO.getScreening());
        existingTicket.setPrice(ticketDTO.getPrice());

        data.save(existingTicket);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Boleto actualizado correctamente.");
        return respuesta;
    }

    // Conversión a DTO
    public ticketDTO convertToDTO(ticket ticket) {
        return new ticketDTO(
                ticket.getCustomer(),
                ticket.getScreening(),
                ticket.getPrice());
    }

    // Conversión a modelo
    public ticket convertToModel(ticketDTO ticketDTO) {
        return new ticket(
                0, // ID autogenerado
                ticketDTO.getCustomer(),
                ticketDTO.getScreening(),
                ticketDTO.getPrice());
    }
}
