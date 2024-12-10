package futbol_americano;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EstadisticasClienteInterfaz extends Remote {
    void notificarCambio(String equipo) throws RemoteException;
}
