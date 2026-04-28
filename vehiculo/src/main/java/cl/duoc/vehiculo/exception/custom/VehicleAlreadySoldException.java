package cl.duoc.vehiculo.exception.custom;

public class VehicleAlreadySoldException extends RuntimeException{

    public VehicleAlreadySoldException(String message) {
        super(message);
    }

}
