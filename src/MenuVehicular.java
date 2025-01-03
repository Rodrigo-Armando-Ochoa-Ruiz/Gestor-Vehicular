import Operaciones.AdministradorVehicular;
import Operaciones.InformacionVehicular;
import modelos.Vehiculo;
import java.util.*;

public class MenuVehicular {
    private static final List<Vehiculo> VEHICULOS = new ArrayList<>();
    private static final List<Vehiculo> VEHICULOS_VENDIDOS = new ArrayList<>();

    private MenuVehicular() {
    }

    public static void ejecutar() {
        boolean continuar = true;

        try(Scanner scanner = new Scanner(System.in)) {
            while (continuar) {
                switch (obtenerOpcionDeMenu(scanner)) {
                    case 1 -> AdministradorVehicular.agregarVehiculo(VEHICULOS);//abrir scanner en los métodos
                    case 2 -> AdministradorVehicular.eliminarVehiculo(VEHICULOS);
                    case 3 -> InformacionVehicular.mostrarVehiculos(VEHICULOS);
                    case 4 -> InformacionVehicular.buscarPorMarca(VEHICULOS);
                    case 5 -> AdministradorVehicular.vender(VEHICULOS, VEHICULOS_VENDIDOS);
                    case 6 -> InformacionVehicular.mostrarVentas(VEHICULOS_VENDIDOS);
                    case 7 -> {
                        System.out.println("Excelente día");
                        continuar = false;
                    }
                    default -> System.out.println("Opción inválida, intente nuevamente");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Opción no válida, ingrese un número entero");
        }
    }

    private static int obtenerOpcionDeMenu(Scanner scanner) {
        System.out.println("================================================================");
        System.out.println("Bienvenido al gestor vehicular");
        System.out.println("================================================================");
        System.out.println("1. Agregar vehículo");
        System.out.println("2. Eliminar vehículo");
        System.out.println("3. Mostrar vehículos");
        System.out.println("4. Buscar por marca");
        System.out.println("5. Vender");
        System.out.println("6. Mostrar ventas");
        System.out.println("7. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}



