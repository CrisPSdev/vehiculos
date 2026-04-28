package cl.duoc.vehiculo.exception.custom;

public class VehicleAlreadyExistsException extends RuntimeException {
    
    public VehicleAlreadyExistsException(String message) {
        super(message);
    }

}
