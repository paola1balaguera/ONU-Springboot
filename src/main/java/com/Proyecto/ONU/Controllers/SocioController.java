package com.Proyecto.ONU.Controllers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Proyecto.ONU.Repository.EntitiesDTO.SocioDTO;
import com.Proyecto.ONU.Service.SocioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/socios")
public class SocioController {
    
    @Autowired
    private SocioService socioService;
    
    @GetMapping("/")
    public List<SocioDTO> findAll() {
        return socioService.findAll();
    }


    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Validated @RequestBody SocioDTO socioDTO, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        try {

            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            SocioDTO socioSave = null;
            socioSave = socioService.save(socioDTO);

            response.put("mensaje", "El socio ha sido creado con éxito");
            response.put("Socio", socioSave);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el guardado en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable BigInteger id, @Validated @RequestBody SocioDTO socioDTO, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        try {

            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            SocioDTO socioUpdate = null;
            socioUpdate = socioService.update(id, socioDTO);

            response.put("mensaje", "La persona ha sido actualizado con éxito");
            response.put("Persona", socioUpdate);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable BigInteger id){
        socioService.deleteById(id);
    } 

    
    @GetMapping("/socioTipoCuota/{tipoCuotaid}")
    List<SocioDTO> findAllSocioByTipoCuota(@PathVariable("tipoCuotaid") BigInteger tipoCuotaid){
        return socioService.findAllSocioByTipoCuota(tipoCuotaid);
    }

    @GetMapping("/informeCuotaPorSocio")
    List<SocioDTO> InformeCuotaPorSocio(){
        return socioService.InformeCuotaPorSocio();
    }



}
