package cl.duoc.vehiculo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

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
@Controller
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @PutMapping("/agregar")
    public ResponseEntity<Vehiculo> addNewVehicle(@PathVariable @Valid @RequestBody Vehiculo v) {
        Vehiculo vehiculo = vehiculoService.addNewVehicle(v);

        return ResponseEntity.status(HttpStatus.CREATED).body(v);

    }

    @GetMapping()
    public ResponseEntity<Long> seeStock() {
        Long stock = vehiculoService.seeStock();

        return ResponseEntity.ok(stock);
    }

    @PutMapping("/vender/{id}")
    public  ResponseEntity<Vehiculo> sellVehicle(@PathVariable Long id) {
        
        Vehiculo v = vehiculoService.sellVehicle(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(v);
    }
    
}
