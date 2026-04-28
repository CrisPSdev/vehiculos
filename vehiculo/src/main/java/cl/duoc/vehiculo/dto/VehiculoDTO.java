package cl.duoc.vehiculo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import cl.duoc.vehiculo.enums.*;;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private String modelo;
    private Marca marca;
    private Integer anio;
    private String patente;
    private String color;
    private Integer kilometraje;
    private TipoVehiculo tipoVehiculo;
    private Estado estado;
    private BigDecimal precio;
}
