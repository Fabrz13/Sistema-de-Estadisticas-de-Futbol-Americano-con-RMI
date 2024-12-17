# Sistema de Gestión de Estadísticas de Equipos con RMI

## Descripción
**Proyecto Creado Por:** Ing. Fabrizio Castro

Este proyecto implementa un sistema distribuido de gestión de estadísticas deportivas utilizando **Java RMI (Remote Method Invocation)**. Permite a un **servidor central** administrar estadísticas de equipos y notificar automáticamente a **clientes conectados** sobre cambios en tiempo real. Los clientes pueden consultar, actualizar y visualizar estadísticas detalladas de los equipos.

---

## Componentes Principales

### **Servidor de Estadísticas**
- **Administra las estadísticas de los equipos.**
- **Permite a los clientes** consultar y actualizar estadísticas.
- **Notifica a los clientes** automáticamente cuando las estadísticas de un equipo cambian.

### **Cliente de Estadísticas**
- Permite a los usuarios interactuar con el servidor para:
  - Consultar estadísticas actuales.
  - Actualizar estadísticas de equipos.
  - Visualizar tablas detalladas de los equipos y sus estadísticas.

### **Notificaciones en Tiempo Real**
- Los clientes registrados reciben **alertas automáticas** cuando las estadísticas de un equipo se actualizan.

---

## Funcionalidades

### **Servidor**
1. **Gestión de Estadísticas:**
   - Administra datos como:
     - Yardas por tierra.
     - Yardas por pase.
     - Intercambios de balón.
   - Permite a los clientes consultar y actualizar estos datos.

2. **Notificaciones a Clientes:**
   - Notifica a todos los clientes conectados cuando se actualizan las estadísticas.

3. **Registro RMI:**
   - Proporciona un punto centralizado de acceso para los clientes mediante RMI.

### **Cliente**
1. **Consulta de Estadísticas:**
   - Permite ver estadísticas actuales de un equipo seleccionado.

2. **Actualización de Estadísticas:**
   - Permite modificar las estadísticas de un equipo.

3. **Visualización de Tabla:**
   - Presenta una tabla completa con las estadísticas de todos los equipos.

4. **Recepción de Notificaciones:**
   - Recibe alertas en tiempo real cuando las estadísticas de un equipo son modificadas.

---

## Estructura del Proyecto

### **Servidor**
- **`EstadisticasServidor.java`**:  
  Inicia el registro RMI y publica el objeto remoto.
- **`EstadisticasImpl.java`**:  
  Implementa la lógica principal del servidor, incluida la gestión de estadísticas y las notificaciones a los clientes.

### **Cliente**
- **`EstadisticasCliente.java`**:  
  Permite la interacción con el servidor y la visualización de datos.
- **`EstadisticasClienteInterfaz.java`**:  
  Define la interfaz remota para recibir notificaciones del servidor.

### **Interfaz Remota**
- **`EstadisticasInterfaz.java`**:  
  Define las operaciones remotas disponibles para los clientes, como consulta y actualización de estadísticas.

---

## Ejemplo de Uso

### Inicia el Servidor
```bash
java EstadisticasServidor
```

### Conectar Clientes
```bash
java EstadisticasCliente
```

### Pasos de Uso
1. **Inicia el Servidor RMI**
2. **Conéctate con Múltiples Clientes**
3. **Consulta o Actualiza Estadísticas:**
   * Desde el menú interactivo del cliente, selecciona opciones para consultar o actualizar estadísticas de un equipo.
4. **Notificaciones en Tiempo Real:**
   * Observa cómo los clientes reciben **notificaciones automáticas** cuando las estadísticas de un equipo son modificadas.

## Requisitos
* **Java JDK:** Versión 8 o superior.
* **Sistema Operativo:** Compatible con cualquier sistema que soporte Java.
* **Red Local o Internet:** Necesaria para la comunicación RMI entre cliente y servidor.

## Notas Importantes
* Asegúrate de que el **servidor esté en funcionamiento** antes de iniciar los clientes.
* Configura correctamente el registro RMI en el servidor para permitir la comunicación.
* Prueba el sistema en una red local para garantizar su correcto funcionamiento.
