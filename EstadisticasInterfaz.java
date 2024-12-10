package futbol_americano;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface EstadisticasInterfaz extends Remote {
    int consultarYardasPorTierra(String equipo) throws RemoteException;
    int consultarYardasPorPase(String equipo) throws RemoteException;
    int consultarIntercambios(String equipo) throws RemoteException;
    void actualizarEstadisticas(String equipo, int tierra, int pase, int intercambios) throws RemoteException;
    void registrarNotificación(EstadisticasClienteInterfaz cliente) throws RemoteException;

    Map<String, EstadisticasImpl.EquipoEstadisticas> obtenerEstadisticasEquipos() throws RemoteException;
}
