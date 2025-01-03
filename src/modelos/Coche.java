package modelos;

import java.util.InputMismatchException;
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
    public Vehiculo crear() {
        System.out.println("Ingrese número de puertas");

        try(Scanner scanner = new Scanner(System.in)){
            numeroPuertas = scanner.nextInt();
            this.cacularImpuesto();
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.err.println("Ingrese el número de puertas como número entero");
            crear();
        }
        return this;
    }

    @Override
    public String toString() {
        return  getIdVehiculo() + ". Coche{" +
                "numeroPuertas = " + numeroPuertas +
                super.toString();
    }


}
