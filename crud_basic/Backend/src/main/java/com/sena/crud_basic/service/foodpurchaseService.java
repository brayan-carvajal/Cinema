package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.dto.foodpurchaseDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.model.foodpurchase;
import com.sena.crud_basic.repository.Ifoodpurchase;

@Service
public class foodpurchaseService {

    /* Establecer conexión con el repositorio */
    @Autowired
    private Ifoodpurchase data;

    // Registrar y actualizar
    public responseDTO save(foodpurchaseDTO foodpurchaseDTO) {
        if (foodpurchaseDTO.getQuantity() <= 0) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La cantidad debe ser mayor a 0");
            return respuesta;
        }

        foodpurchase foodpurchaseRegister = convertToModel(foodpurchaseDTO);
        data.save(foodpurchaseRegister);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se guardó correctamente");
        return respuesta;
    }

    // Encontrar todos los registros
    public List<foodpurchase> findAll() {
        return data.findAll();
    }

    // Encontrar registros por id
    public Optional<foodpurchase> findById(int idFoodPurchase) {
        return data.findById(idFoodPurchase);
    }

    // Eliminar registros por id
    public responseDTO deleteFoodPurchase(int idFoodPurchase) {
        if (!findById(idFoodPurchase).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El registro no existe");
            return respuesta;
        }

        data.deleteById(idFoodPurchase);
        
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }

    // Actualizar compra de comida
    public responseDTO updateFoodPurchase(int idFoodPurchase, foodpurchaseDTO foodpurchaseDTO) {
        Optional<foodpurchase> foodpurchaseOptional = data.findById(idFoodPurchase);

        if (!foodpurchaseOptional.isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "La compra con ID " + idFoodPurchase + " no existe");
            return respuesta;
        }

        if (foodpurchaseDTO.getQuantity() <= 0) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La cantidad debe ser mayor a 0");
            return respuesta;
        }

        foodpurchase existingFoodPurchase = foodpurchaseOptional.get();
        existingFoodPurchase.setCustomer(foodpurchaseDTO.getCustomer());
        existingFoodPurchase.setFood(foodpurchaseDTO.getFood());
        existingFoodPurchase.setQuantity(foodpurchaseDTO.getQuantity());

        data.save(existingFoodPurchase);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Compra actualizada correctamente");
        return respuesta;
    }

    public foodpurchaseDTO convertToDTO(foodpurchase foodpurchase) {
        return new foodpurchaseDTO(
                foodpurchase.getCustomer(),
                foodpurchase.getFood(),
                foodpurchase.getQuantity());
    }

    public foodpurchase convertToModel(foodpurchaseDTO foodpurchaseDTO) {
        return new foodpurchase(
                0, // ID autogenerado
                foodpurchaseDTO.getCustomer(),
                foodpurchaseDTO.getFood(),
                foodpurchaseDTO.getQuantity());
    }
}
