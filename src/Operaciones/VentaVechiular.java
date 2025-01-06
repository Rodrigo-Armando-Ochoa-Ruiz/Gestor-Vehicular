package Operaciones;

import modelos.Vehiculo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VentaVechiular {

    private VentaVechiular(){}

    public static void vender(Scanner scanner, List<Vehiculo> VEHICULOS, List<Vehiculo> VEHICULOS_VENDIDOS){
        boolean continuar = true;

        while (continuar) {
            if (VEHICULOS.isEmpty())
                System.out.println("No hay vehículos");
            else {
                VEHICULOS.forEach(System.out::println);
                System.out.println("Ingrese el ID del vehículo a vender");
                int idAVender = scanner.nextInt();
                scanner.nextLine();

                Optional<Vehiculo> vehiculoVendido = VEHICULOS.stream()
                        .filter(v -> v.getIdVehiculo() == idAVender)
                        .findFirst();

                if (vehiculoVendido.isPresent()) {
                    Vehiculo vehiculoAVender = vehiculoVendido.get();
                    vehiculoAVender.cacularImpuesto();
                    System.out.println(vehiculoAVender);
                    VEHICULOS_VENDIDOS.add(vehiculoAVender);
                    VEHICULOS.remove(vehiculoAVender);
                    System.out.println("Vehículo vendido correctamente");
                } else
                    System.out.println("No se encontró un vehículo con ese ID");
            }
            System.out.println("¿Desea vender otro vehículo? Y/N");
            continuar = scanner.nextLine().equalsIgnoreCase("y");
        }
    }

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
}
