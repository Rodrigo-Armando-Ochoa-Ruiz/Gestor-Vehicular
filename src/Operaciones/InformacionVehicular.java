package Operaciones;

import modelos.Vehiculo;
import java.util.List;
import java.util.Scanner;

public class InformacionVehicular {
    private InformacionVehicular(){}
    public static void mostrarVentas(final List<Vehiculo> VEHICULOS_VENDIDOS){
        if (VEHICULOS_VENDIDOS.isEmpty())
            System.out.println("No hay ventas");
        else{
            VEHICULOS_VENDIDOS.forEach(System.out::println);
            System.out.println("TOTAL: " + VEHICULOS_VENDIDOS.stream()
                    .map(v -> v.getImpuesto()+v.getPrecio())
                    .reduce(0.0, Double::sum));
        }
    }

    public static void mostrarVehiculos(final List<Vehiculo> VEHICULOS) {
        if (VEHICULOS.isEmpty())
            System.out.println("No hay vehículos");
        else
            VEHICULOS.forEach(System.out::println);
    }

    public static void buscarPorMarca(final List<Vehiculo> VEHICULOS, Scanner scanner) {
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
