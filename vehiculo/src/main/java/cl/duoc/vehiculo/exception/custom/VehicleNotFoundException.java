package cl.duoc.vehiculo.exception.custom;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(String message) {
        super(message);
    }

}
