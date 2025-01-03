package modelos;

import java.util.InputMismatchException;
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
    public Vehiculo crear() {
        System.out.println("Ingrese la carga");

        try(Scanner scanner = new Scanner(System.in)){
            carga = scanner.nextDouble();
            this.cacularImpuesto();
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Ingrese la carga numérica");
            crear();
        }
        return this;
    }

    @Override
    public String toString() {
        return getIdVehiculo() + ". Camion{" +
                "carga = " + carga +
                super.toString();
    }
}
