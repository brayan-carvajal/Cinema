package com.sena.crud_basic.controller;

import com.sena.crud_basic.dto.employeeshiftDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.service.employeeshiftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employeeshift")
public class employeeshiftController {

    /*
     * POST
     * GET
     * PUT
     * DELETE
     */

    @Autowired
    private employeeshiftService employeeshiftService;

    // POST
    @PostMapping("/post")
    public ResponseEntity<Object> registerEmployeeShift(@RequestBody employeeshiftDTO employeeshift) {
        responseDTO respuesta = employeeshiftService.save(employeeshift);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET
    @GetMapping("/get")
    public ResponseEntity<Object> getAllEmployeeShifts() {
        var listaEmployeeShifts = employeeshiftService.findAll();
        return new ResponseEntity<>(listaEmployeeShifts, HttpStatus.OK);
    }

    // GET:id
    @GetMapping("/{idEmployeeShift}")
    public ResponseEntity<Object> getOneEmployeeShift(@PathVariable int idEmployeeShift) {
        var employeeshift = employeeshiftService.findById(idEmployeeShift);
        if (!employeeshift.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employeeshift, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{idEmployeeShift}")
    public ResponseEntity<Object> deleteEmployeeShift(@PathVariable int idEmployeeShift) {
        var message = employeeshiftService.deleteEmployeeshift(idEmployeeShift);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // PUT
    @PutMapping("/{idEmployeeShift}")
    public ResponseEntity<Object> updateEmployeeShift(@PathVariable int idEmployeeShift, @RequestBody employeeshiftDTO employeeshift) {
        responseDTO respuesta = employeeshiftService.updateEmployeeshift(idEmployeeShift, employeeshift);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
