package exceptions;

import modelos.Vehiculo;

public class IncorrectParameterException extends RuntimeException {
    public IncorrectParameterException(Vehiculo vehiculo) {
        System.err.println("Parámetro incorrecto para el vehículo " + vehiculo);
        System.err.println("Ingrese el parámetro correcto");
    }
}
