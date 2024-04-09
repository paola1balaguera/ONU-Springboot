package com.Proyecto.ONU.Controllers;



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

import com.Proyecto.ONU.Configuration.EnvioMaterialConversion;
import com.Proyecto.ONU.Repository.EntitiesDTO.EnvioMaterialDTO;
import com.Proyecto.ONU.Service.EnvioMaterialService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/envioMateriales")
public class EnvioMaterialController {
    @Autowired
    private EnvioMaterialService envioMaterialService;
    private EnvioMaterialConversion envioMaterialConversion;
    
    @GetMapping("/")
    public List<EnvioMaterialDTO> findAll() {
        return envioMaterialService.findAll();
    }


    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Validated @RequestBody EnvioMaterialDTO envioMaterialDTO, BindingResult result) {
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

            EnvioMaterialDTO envioMaterialSave = null;
           envioMaterialSave = envioMaterialService.save(envioMaterialDTO);

            response.put("mensaje", "Envio material ha sido creado con éxito");
            response.put("Envio material", envioMaterialSave);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el guardado en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Validated @RequestBody EnvioMaterialDTO envioMaterialDTO, BindingResult result) {

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

            EnvioMaterialDTO envioMaterialUpdate = null;
            envioMaterialUpdate = envioMaterialService.update(id, envioMaterialDTO);

            response.put("mensaje", "El envio material ha sido actualizado con éxito");
            response.put("Envio material", envioMaterialUpdate);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        envioMaterialService.deleteById(id);
    } 

    @GetMapping("/{id}")
    public EnvioMaterialDTO findById(@PathVariable Long id){
       return envioMaterialService.findById(id);
    }
}