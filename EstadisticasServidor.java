package futbol_americano;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EstadisticasServidor  {
    public static void main(String[] args) {
        try {

            System.out.println("Ingrese el puerto para el registro RMI:");
            int puerto = new java.util.Scanner(System.in).nextInt();

            arrancarRegistro(puerto);

            EstadisticasImpl objetoExportado = new EstadisticasImpl();
            String urlRegistro = "rmi://localhost:" + puerto + "/estadisticas";
            Naming.rebind(urlRegistro, objetoExportado);

            System.out.println("Servidor iniciado. Estadisticas disponibles en: " + urlRegistro);
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void arrancarRegistro(int puerto) {
        try {
            Registry registro = LocateRegistry.getRegistry(puerto);
            registro.list(); 
        } catch (Exception e) {
            try {
                System.out.println("Registro no encontrado en el puerto " + puerto + ". Creando uno nuevo...");
                LocateRegistry.createRegistry(puerto);
                System.out.println("Registro creado en el puerto " + puerto);
            } catch (Exception ex) {
                System.err.println("Error al crear el registro RMI: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
