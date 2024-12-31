package modelos;


import exceptions.IncorrectParameterException;

import java.util.Scanner;

public class Moto extends Vehiculo{
    private String motor;

    public Moto() {
        setIdVehiculo(getId());
    }

    public String getMotor() {
        return motor;
    }

    public Vehiculo setMotor(String motor) {
        this.motor = motor;
        return this;
    }

    @Override
    public void cacularImpuesto() {
        if (getMotor().equalsIgnoreCase("2 tiempos"))//ENUM
            setImpuesto(0.03*getPrecio());
        else
            setImpuesto(0.04*getPrecio());
    }

    @Override
    public Vehiculo crear(Scanner scanner) {
        boolean continuar = true;
        System.out.println("Ingrese el tipo de motor");

        while (continuar) {//Recursividad al tirar la excepción cachearla y volver a llamar al método
            try {
                motor = scanner.nextLine();
                if (!(motor.equalsIgnoreCase("2 tiempos") || motor.equalsIgnoreCase("4 tiempos")))
                    throw new IncorrectParameterException(this);
                this.cacularImpuesto();
                continuar = false;
            }catch (IncorrectParameterException e){}
        }
        return this;
    }

    @Override
    public String toString() {
        return getIdVehiculo() + ". Moto{" +
                "motor = '" + motor + '\'' +
                super.toString();
    }
}
