package Operaciones;

import modelos.Camion;
import modelos.Coche;
import modelos.Moto;
import modelos.Vehiculo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdministradorVehicular {
    private AdministradorVehicular(){}
    public static void agregarVehiculo(Scanner scanner, List<Vehiculo> VEHICULOS) {
        int anio;
        double precio;
        String modelo;
        String marca;
        int opcion;
        boolean continuar = true;

        while (continuar) {
            System.out.println("Elija el vehículo a agregar");
            System.out.println("1. Moto");
            System.out.println("2. Coche");
            System.out.println("3. Camión");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            System.out.println("Ingrese el año");
            anio = scanner.nextInt();

            System.out.println("Ingrese el precio");
            precio = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingrese la marca");
            marca = scanner.nextLine();

            System.out.println("Ingrese el modelo");
            modelo = scanner.nextLine();

            Vehiculo vehiculo;

            switch (opcion) {//switch expression
                case 1 -> vehiculo = new Moto();
                case 2 -> vehiculo = new Coche();
                case 3 -> vehiculo = new Camion();
                case 4 -> {
                    return;
                }
                default ->{
                    System.out.println("Opción no válida");
                    return;
                }
            }

            vehiculo.setAnio(anio);
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setPrecio(precio);
            VEHICULOS.add(vehiculo.crear(scanner));

            System.out.println("¿Desea agregar otro vehículo? Y/N");
            continuar = scanner.nextLine().equalsIgnoreCase("y");
        }
    }

    public static void eliminarVehiculo(Scanner scanner, List<Vehiculo> VEHICULOS) {
        boolean continuar = true;

        while (continuar) {
            if (VEHICULOS.isEmpty()){
                System.out.println("No hay vehículos");
                break;
            }

            else {
                VEHICULOS.forEach(System.out::println);
                System.out.println("Ingrese el ID del vehículo a eliminar");
                int eliminar = scanner.nextInt();
                scanner.nextLine();

                Optional<Vehiculo> vehiculoAEliminar = VEHICULOS.stream()
                        .filter(v -> v.getIdVehiculo() == eliminar)
                        .findFirst();

                if (vehiculoAEliminar.isPresent()) {
                    VEHICULOS.remove(vehiculoAEliminar.get());
                    System.out.println("Vehículo eliminado correctamente");
                } else
                    System.out.println("No se encontró un vehículo con ese ID");
            }

            System.out.println("¿Desea eliminar otro vehículo? Y/N");
            continuar = scanner.nextLine().equalsIgnoreCase("y");
        }
    }

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
                //El cálculo de impuestos tiene que ver al momento de vender el vehiculo
                //Clase para registrar los vehículos vendidos con su precio impuesto
                //Nombres de métodos y clases
                //Revisar los ID si no se rompen al regresar a una instancia
                if (vehiculoVendido.isPresent()) {
                    Vehiculo vehiculoAVender = vehiculoVendido.get();
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
}
