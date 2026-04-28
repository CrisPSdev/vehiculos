package cl.duoc.vehiculo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.vehiculo.enums.*;
import cl.duoc.vehiculo.model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    //contar stock -- count hace referencia a COUNT EN SQL -> cuenta la cantidad por estado
    long countByEstado(Estado e);

    // Retorna true si existe un vehiculo con el id ingresado, retorna falso sino
    boolean existsById(Long id);

    boolean existsByPatente(String patente);
    // seccion para buscar por tipos //
    
    Optional<Vehiculo> findByPatente(String patente);
    
    Optional<Vehiculo> findById(Long Id);

    Optional<List<Vehiculo>> findByMarca(Marca m);

    Optional<List<Vehiculo>> findByTipoVehiculo(TipoVehiculo t);

    Optional<List<Vehiculo>> findByEstado(Estado e);

}
