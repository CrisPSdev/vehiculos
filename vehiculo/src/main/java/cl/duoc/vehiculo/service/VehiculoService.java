package cl.duoc.vehiculo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.duoc.vehiculo.dto.VehiculoDTO;
import cl.duoc.vehiculo.enums.Estado;
import cl.duoc.vehiculo.exception.custom.VehicleAlreadyExistsException;
import cl.duoc.vehiculo.exception.custom.VehicleAlreadySoldException;
import cl.duoc.vehiculo.exception.custom.VehicleNotFoundException;
import cl.duoc.vehiculo.model.Vehiculo;
import cl.duoc.vehiculo.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    // Agregar nuevo vehiculo
    public Vehiculo addNewVehicle(Vehiculo v) {
        
        if (vehiculoRepository.existsByPatente(v.getPatente())) {
        throw new VehicleAlreadyExistsException("La patente ingresada ya se encuentra registrada.");
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
        orElseThrow(() -> new VehicleNotFoundException("No se encontro ningun vehiculo con id " + id)); // crear excepcion personalizada

        if (v.getEstado() != Estado.DISPONIBLE) {
            throw new VehicleAlreadySoldException("El vehiculo con id " + id + " ya se encuentra vendido");
        }
        

        v.setEstado(Estado.VENDIDO);

        
        return vehiculoRepository.save(v);
    }


    // datos a dto
    public VehiculoDTO vehiculoDTO(Vehiculo v) {
        return new VehiculoDTO(
            v.getModelo(),
            v.getMarca(),
            v.getAnio(),
            v.getPatente(),
            v.getColor(),
            v.getKilometraje(),
            v.getTipoVehiculo(),
            v.getEstado(),
            v.getPrecio()
        );
    } 
}
