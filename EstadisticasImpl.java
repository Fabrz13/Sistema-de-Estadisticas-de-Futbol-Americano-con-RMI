package futbol_americano;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

public class EstadisticasImpl extends UnicastRemoteObject implements EstadisticasInterfaz {
    private final Map<String, EquipoEstadisticas> estadisticasEquipos;
    private final List<EstadisticasClienteInterfaz> clientesRegistrados; // Lista de clientes

    public EstadisticasImpl() throws RemoteException {
        super();
        estadisticasEquipos = new HashMap<>();
        clientesRegistrados = new ArrayList<>();
        estadisticasEquipos.put("Argentina", new EquipoEstadisticas(500, 400, 2));
        estadisticasEquipos.put("Colombia", new EquipoEstadisticas(300, 600, 3));
        estadisticasEquipos.put("Ecuador", new EquipoEstadisticas(160, 240, 25));
    }

    @Override
    public int consultarYardasPorTierra(String equipo) throws RemoteException {
        EquipoEstadisticas est = estadisticasEquipos.getOrDefault(equipo, new EquipoEstadisticas(0, 0, 0));
        return est.yardasPorTierra;
    }

    @Override
    public int consultarYardasPorPase(String equipo) throws RemoteException {
        EquipoEstadisticas est = estadisticasEquipos.getOrDefault(equipo, new EquipoEstadisticas(0, 0, 0));
        return est.yardasPorPase;
    }

    @Override
    public int consultarIntercambios(String equipo) throws RemoteException {
        EquipoEstadisticas est = estadisticasEquipos.getOrDefault(equipo, new EquipoEstadisticas(0, 0, 0));
        return est.intercambios;
    }

    @Override
    public void actualizarEstadisticas(String equipo, int tierra, int pase, int intercambios) throws RemoteException {
        estadisticasEquipos.put(equipo, new EquipoEstadisticas(tierra, pase, intercambios));
        notificarClientes(equipo);
    }

    @Override
    public void registrarNotificación(EstadisticasClienteInterfaz cliente) throws RemoteException {
        clientesRegistrados.add(cliente);
    }

    private void notificarClientes(String equipo) throws RemoteException {
        for (EstadisticasClienteInterfaz cliente : clientesRegistrados) {
            cliente.notificarCambio(equipo);
        }
    }

    @Override
    public Map<String, EquipoEstadisticas> obtenerEstadisticasEquipos() throws RemoteException {
        return estadisticasEquipos;
    }

    public static class EquipoEstadisticas implements Serializable {
        int yardasPorTierra;
        int yardasPorPase;
        int intercambios;

        public EquipoEstadisticas(int tierra, int pase, int intercambios) {
            this.yardasPorTierra = tierra;
            this.yardasPorPase = pase;
            this.intercambios = intercambios;
        }
    }
}
