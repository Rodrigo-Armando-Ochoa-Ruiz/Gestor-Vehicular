package Operaciones;

import modelos.Vehiculo;
import java.util.List;
import java.util.Scanner;

public class InventarioVehicular {
    private InventarioVehicular(){}

    public static void mostrarVehiculos(final List<Vehiculo> VEHICULOS) {
        if (VEHICULOS.isEmpty())
            System.out.println("No hay vehículos");
        else
            VEHICULOS.forEach(System.out::println);
    }

    public static void buscarPorMarca(Scanner scanner, final List<Vehiculo> VEHICULOS){
        if (VEHICULOS.isEmpty()){
            System.out.println("No hay vehículos");
        }
        else {
            System.out.println("Ingrese la marca del vehículo");
            String marca = scanner.nextLine();
            VEHICULOS.stream().filter(v -> v.getMarca().equalsIgnoreCase(marca)).forEach(System.out::println);
        }
    }
}
