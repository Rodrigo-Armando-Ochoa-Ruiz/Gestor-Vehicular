package modelos;


import exceptions.IncorrectParameterException;

import java.util.Scanner;

public class Moto extends Vehiculo {
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
            setImpuesto(0.03 * getPrecio());
        else
            setImpuesto(0.04 * getPrecio());
    }

    @Override
    public Vehiculo crear() {
        System.out.println("Ingrese el tipo de motor");


        try (Scanner scanner = new Scanner(System.in)){
            motor = scanner.nextLine();
            if (!(motor.equalsIgnoreCase("2 tiempos") || motor.equalsIgnoreCase("4 tiempos")))
                throw new IncorrectParameterException(this);
            this.cacularImpuesto();
        } catch (IncorrectParameterException e) {
            crear();
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
