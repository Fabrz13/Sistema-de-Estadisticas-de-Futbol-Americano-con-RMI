package futbol_americano;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class EstadisticasCliente extends UnicastRemoteObject implements EstadisticasClienteInterfaz {

    public EstadisticasCliente() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el nombre del nodo del registro RMI:");
            String nombreNodo = scanner.nextLine();
            System.out.println("Ingrese el puerto del registro RMI:");
            int puerto = scanner.nextInt();
            scanner.nextLine(); 

            String urlRegistro = "rmi://" + nombreNodo + ":" + puerto + "/estadisticas";
            EstadisticasInterfaz servidor = (EstadisticasInterfaz) Naming.lookup(urlRegistro);
            System.out.println("Conexion exitosa al servidor de estadisticas.");

            EstadisticasCliente cliente = new EstadisticasCliente();
            servidor.registrarNotificación(cliente);

            while (true) {
                try {
                    System.out.println("\nOpciones:");
                    System.out.println("1. Consultar estadisticas de un equipo.");
                    System.out.println("2. Actualizar estadisticas de un equipo.");
                    System.out.println("3. Tabla de equipos.");
                    System.out.println("4. Salir.");
                    System.out.print("Seleccione una opcion: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el nombre del equipo: ");
                            String equipo = scanner.nextLine();
                            System.out.println("Yardas por tierra: " + servidor.consultarYardasPorTierra(equipo));
                            System.out.println("Yardas por pase: " + servidor.consultarYardasPorPase(equipo));
                            System.out.println("Intercambios: " + servidor.consultarIntercambios(equipo));
                            break;
                        case 2:
                            System.out.print("Ingrese el nombre del equipo: ");
                            String equipoActualizar = scanner.nextLine();
                            System.out.print("Ingrese yardas por tierra: ");
                            int tierra = scanner.nextInt();
                            System.out.print("Ingrese yardas por pase: ");
                            int pase = scanner.nextInt();
                            System.out.print("Ingrese intercambios: ");
                            int intercambios = scanner.nextInt();
                            servidor.actualizarEstadisticas(equipoActualizar, tierra, pase, intercambios);
                            System.out.println("Estadisticas actualizadas.");
                            break;
                        case 3:

                            mostrarTablaEquipos(servidor);
                            break;
                        case 4:
                            System.out.println("Saliendo del cliente...");
                            return;
                        default:
                            System.out.println("Opción invalida. Intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no valida. Por favor, ingrese un número.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarTablaEquipos(EstadisticasInterfaz servidor) throws RemoteException {
        System.out.println("\nTabla de Equipos:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Equipo", "Yardas por Tierra", "Yardas por Pase", "Intercambios");
        System.out.println("-------------------------------------------------");

        Map<String, EstadisticasImpl.EquipoEstadisticas> equipos = servidor.obtenerEstadisticasEquipos();

        for (Map.Entry<String, EstadisticasImpl.EquipoEstadisticas> entry : equipos.entrySet()) {
            String equipo = entry.getKey();
            EstadisticasImpl.EquipoEstadisticas stats = entry.getValue();
            System.out.printf("%-20s %-20d %-20d %-20d\n", equipo, stats.yardasPorTierra, stats.yardasPorPase, stats.intercambios);
        }

        System.out.println("-------------------------------------------------");
    }

    @Override
    public void notificarCambio(String equipo) throws RemoteException {
        System.out.println("\nLas estadisticas del equipo " + equipo + " han cambiado.");
    }
}
