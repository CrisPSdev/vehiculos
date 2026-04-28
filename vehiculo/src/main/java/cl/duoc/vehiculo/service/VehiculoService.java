package cl.duoc.vehiculo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.duoc.vehiculo.enums.Estado;
import cl.duoc.vehiculo.model.Vehiculo;
import cl.duoc.vehiculo.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    // Agregar nuevo vehiculo
    public Vehiculo addNewVehicle(Vehiculo v) {
        
        if (vehiculoRepository.existByPatente(v.getPatente())) {
        throw new RuntimeException("La patente ya existe.");
    }
        return vehiculoRepository.save(v);
    }

    // Ver stock disponible 
    public long seeStock() {
        return vehiculoRepository.countByEstado(Estado.DISPONIBLE);
    }

    //vender vehiculo -> cambiar estado a VENDIDO
    public Vehiculo sellVehicle(Long id) {
        Vehiculo v = vehiculoRepository.findById(id).
        orElseThrow(() -> new RuntimeException("No se encontro ningun vehiculo")); // crear excepcion personalizada

        if (v.getEstado() != Estado.DISPONIBLE) {
            throw new RuntimeException("El vehiculo ya se encuentra vendido");
        }
        

        v.setEstado(Estado.VENDIDO);

        return vehiculoRepository.save(v);
    }


}
