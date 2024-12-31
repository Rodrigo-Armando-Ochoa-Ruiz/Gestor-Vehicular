package modelos;

import java.util.Scanner;

public class Lancha extends Vehiculo implements Crear{
    private int cantidadPasajeros;

    public Lancha(){
        setIdVehiculo(getId());
    }
    @Override
    public Vehiculo crear(Scanner scanner) {
        System.out.println("Ingrese cantidad de pasajeros");
        this.cantidadPasajeros = scanner.nextInt();
        scanner.nextLine();

        return new Lancha();
    }

    @Override
    public void cacularImpuesto() {
        if (cantidadPasajeros > 8)
            setImpuesto(getPrecio()*0.3);
        else
            setImpuesto(getPrecio()*0.2);
    }
}
