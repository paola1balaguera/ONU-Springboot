package com.Proyecto.ONU.Service.Impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.MaterialConversion;
import com.Proyecto.ONU.Repository.MaterialRepository;
import com.Proyecto.ONU.Repository.Entities.Material;
import com.Proyecto.ONU.Repository.EntitiesDTO.MaterialDTO;
import com.Proyecto.ONU.Service.MaterialService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaterialImplService implements MaterialService{
    @Autowired
    private MaterialRepository materialRepository;
    private MaterialConversion materialConversion;

@Override
@Transactional
public MaterialDTO save(MaterialDTO materialDTO) {
    Material material = materialConversion.convertirDTOAMaterial(materialDTO);
    materialRepository.save(material);
    return materialConversion.convertirMaterialADto(material);
}

public MaterialDTO update(BigInteger id, MaterialDTO materialDTO){
    Optional<Material> materialCurrentOptional = materialRepository.findById(id);
    if(materialCurrentOptional.isPresent()){
        Material materialCurrent = materialConversion.convertirDTOAMaterial(materialDTO);

        materialCurrent.setId(id);
        materialCurrent.setNombre(materialDTO.getNombre());
        materialCurrent.setTipo(materialDTO.getTipo());

        materialRepository.save(materialCurrent);
        return materialConversion.convertirMaterialADto(materialCurrent);
    }
    return null;
}

@Override
public void deleteById(BigInteger id){
    materialRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<MaterialDTO> findAll(){
    List<Material> materiales = (List<Material>) materialRepository.findAll();
    return materiales.stream()
                   .map(materialiito -> materialConversion.convertirMaterialADto(materialiito))
                   .toList();
}

}
