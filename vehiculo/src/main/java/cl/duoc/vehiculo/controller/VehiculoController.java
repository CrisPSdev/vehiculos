package cl.duoc.vehiculo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import cl.duoc.vehiculo.dto.ApiResponse;
import cl.duoc.vehiculo.dto.VehiculoDTO;
import cl.duoc.vehiculo.model.Vehiculo;
import cl.duoc.vehiculo.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/v1/concesionaria")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @PostMapping("/agregar")
    public ResponseEntity<ApiResponse<VehiculoDTO>> addNewVehicle(@Valid @RequestBody Vehiculo v) {
        Vehiculo vehiculo = vehiculoService.addNewVehicle(v);

        VehiculoDTO vDTO = vehiculoService.vehiculoDTO(vehiculo);


        ApiResponse<VehiculoDTO> response = new ApiResponse<>(201, "Vehiculo añadido", vDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping()
    public ResponseEntity<ApiResponse<Long>> seeStock() {
        Long stock = vehiculoService.seeStock();


        ApiResponse<Long> response = new ApiResponse<>(200, "total de vehiculos en stock", stock);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/vender/{id}")
    public  ResponseEntity<ApiResponse<VehiculoDTO>> sellVehicle(@PathVariable Long id) {
        
        Vehiculo v = vehiculoService.sellVehicle(id);

        VehiculoDTO vDTO = vehiculoService.vehiculoDTO(v);

        ApiResponse<VehiculoDTO> response = new ApiResponse<>(200, "Vehiculo vendido", vDTO);
        return ResponseEntity.ok(response);
    }
    
}
