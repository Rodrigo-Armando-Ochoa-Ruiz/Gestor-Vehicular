package modelos;

import java.util.Scanner;

public class Coche extends Vehiculo{
    private int numeroPuertas;

    public Coche() {
        setIdVehiculo(getId());
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void cacularImpuesto() {
        setImpuesto(0.05*getPrecio());
    }

    @Override
    public Vehiculo crear(Scanner scanner) {
        System.out.println("Ingrese número de puertas");
        numeroPuertas = scanner.nextInt();
        scanner.nextLine();
        return this;
    }

    @Override
    public String toString() {
        return  getIdVehiculo() + ". Coche{" +
                "numeroPuertas = " + numeroPuertas +
                super.toString();
    }


}
