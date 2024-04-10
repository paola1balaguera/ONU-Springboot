package com.Proyecto.ONU.Service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.ONU.Configuration.CuotaConversion;
import com.Proyecto.ONU.Exceptions.NotFoundElementsException;
import com.Proyecto.ONU.Exceptions.TipoDatoIncorrectoException;
import com.Proyecto.ONU.Repository.CuotaRepository;
import com.Proyecto.ONU.Repository.Entities.Cuota;
import com.Proyecto.ONU.Repository.EntitiesDTO.CuotaDTO;
import com.Proyecto.ONU.Service.CuotaService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CuotaImplService implements CuotaService {
    
    @Autowired
    private CuotaRepository cuotaRepository;
    private CuotaConversion cuotaConversion;

    @Override
    @Transactional
    public CuotaDTO save(CuotaDTO cuotaDTO) {
        try {
            Cuota cuota = cuotaConversion.convertirDTOACuota(cuotaDTO);
            cuotaRepository.save(cuota);
            return cuotaConversion.convertirCuotaADto(cuota);
        } catch (NumberFormatException e) {
            throw new TipoDatoIncorrectoException("El tipo de dato en CuotaDTO no coincide con el de la entidad Cuota");
        }
    }
    


    public CuotaDTO update(Long id, CuotaDTO cuotaDTO){

        //busca el id de la cuota en la bd
        Optional<Cuota> cuotaCurrentOptional = cuotaRepository.findById(id);

        //valida si la cuota existe
        if(cuotaCurrentOptional.isPresent()){

            Cuota cuotaCurrent = cuotaConversion.convertirDTOACuota(cuotaDTO);
            cuotaCurrent.setId(id);
            cuotaCurrent.setValor(cuotaDTO.getValor());
            cuotaCurrent.setFechaPago(cuotaDTO.getFechaPago());
            cuotaCurrent.setTipoCuota(cuotaDTO.getTipoCuota());
            /* cuotaCurrent.setSocio(cuotaDTO.getSocio()); */


            cuotaRepository.save(cuotaCurrent);

            return cuotaConversion.convertirCuotaADto(cuotaCurrent);

        }
        return null;
    }

    @Override
    public void deleteById(Long id){
        cuotaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CuotaDTO> findAll(){
        List<Cuota> cuotas = (List<Cuota>) cuotaRepository.findAll();
        
        if (cuotas.isEmpty()) {
            throw new NotFoundElementsException("No se encontraron elementos en la lista de cuotas");
        }
        
        return cuotas.stream()
                     .map(cuotita -> cuotaConversion.convertirCuotaADto(cuotita))
                     .toList();
    }
    

}
