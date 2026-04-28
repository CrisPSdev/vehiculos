package cl.duoc.vehiculo.model;

import java.math.BigDecimal;

import cl.duoc.vehiculo.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;



@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    @NotBlank(message = "El modelo no puede estar vacio")
    @Size(min = 3, max = 30)
    private String modelo;

    @Column(nullable = false, unique = false)
    @NotNull(message = "La marca no puede estar vacia")
    @Enumerated(EnumType.STRING)
    private Marca marca;


    @Column(nullable = false, unique = false)
    @NotNull(message = "El anio no puede ser nulo")
    private Integer anio;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "La patente no puede estar vacia")
    @Size(min = 6, max = 6)
    private String patente;
    
    @Column(nullable = false, unique = false)
    @NotBlank(message = "El color no puede estar vacio")
    private String color;

    @Column(nullable = false, unique = false)
    @NotNull(message = "El kilometraje no puede ser nulo")
    @Min(0)
    private Integer kilometraje;

    @Column(nullable = false, unique = false)
    @NotNull(message = "El tipo de vehiculo debe ser AUTO, CAMIONETA O MOTO")
    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipoVehiculo;

    @Column(nullable = false, unique = false)
    @NotNull(message = "El estado debe ser DISPONIBLE, VENDIDO O EN_MANTENCION")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false, unique = false)
    @NotNull(message = "El precio no puede ser nulo")    
    @DecimalMin("0.0")
    @DecimalMax("999999999.0")
    private BigDecimal precio;

}
