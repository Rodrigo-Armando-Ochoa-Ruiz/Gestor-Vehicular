package modelos;

import java.util.Scanner;

public class Camion extends Vehiculo{
    private double carga;

    public Camion() {
        setIdVehiculo(getId());
    }

    @Override
    public void cacularImpuesto() {
        if (carga > 5)
            setImpuesto(0.08*getPrecio());
        else
            setImpuesto(0.06*getPrecio());
    }

    @Override
    public Vehiculo crear(Scanner scanner) {
        System.out.println("Ingrese la carga");
        carga = scanner.nextDouble();
        scanner.nextLine();
        return this;
    }

    @Override
    public String toString() {
        return getIdVehiculo() + ". Camion{" +
                "carga = " + carga +
                super.toString();
    }
}
