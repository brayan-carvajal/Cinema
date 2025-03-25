package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.dto.employeeDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.model.employee;
import com.sena.crud_basic.repository.Iemployee;

import java.util.List;
import java.util.Optional;

@Service
public class employeeService {

    /*
     * save
     * findAll
     * findById
     * delete
     * update
     */

    @Autowired
    private Iemployee data;

    // Registrar y actualizar
    public responseDTO save(employeeDTO employeeDTO) {
        if (employeeDTO.getName().length() < 1 || employeeDTO.getName().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Los caracteres de nombre deben estar entre 1 y 50");
            return respuesta;
        }
        if (employeeDTO.getPosition().length() < 1 || employeeDTO.getPosition().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Los caracteres de posición deben estar entre 1 y 50");
            return respuesta;
        }

        employee employeeRegister = convertToModel(employeeDTO);
        data.save(employeeRegister);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se guardó correctamente");
        return respuesta;
    }

    public List<employee> findAll() {
        return data.findAll();
    }

    public Optional<employee> findById(int idEmployee) {
        return data.findById(idEmployee);
    }

    public responseDTO deleteEmployee(int idEmployee) {
        if (!findById(idEmployee).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El registro no existe");
            return respuesta;
        }
        data.deleteById(idEmployee);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }

    public responseDTO updateEmployee(int idEmployee, employeeDTO employeeDTO) {
        Optional<employee> existingEmployee = findById(idEmployee);
        if (!existingEmployee.isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "Empleado no encontrado");
            return respuesta;
        }
        if (employeeDTO.getName().length() < 1 || employeeDTO.getName().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Los caracteres de nombre deben estar entre 1 y 50");
            return respuesta;
        }
        if (employeeDTO.getPosition().length() < 1 || employeeDTO.getPosition().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Los caracteres de posición deben estar entre 1 y 50");
            return respuesta;
        }
        employee updatedEmployee = existingEmployee.get();
        updatedEmployee.setName(employeeDTO.getName());
        updatedEmployee.setPosition(employeeDTO.getPosition());
        data.save(updatedEmployee);

        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Empleado actualizado correctamente");
        return respuesta;
    }

    public employeeDTO convertToDTO(employee employee) {
        return new employeeDTO(
                employee.getName(),
                employee.getPosition());
    }

    public employee convertToModel(employeeDTO employeeDTO) {
        return new employee(
                0,
                employeeDTO.getName(),
                employeeDTO.getPosition());
    }
}
