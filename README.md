Proyecto Creado Por Ing. Fabrizio Castro

Componentes Principales:

Servidor de Estadísticas:
-Administra las estadísticas de los equipos.
-Permite a los clientes consultar y actualizar estadísticas.
-Notifica a los clientes sobre cambios en las estadísticas.

Cliente de Estadísticas:
-Permite a los usuarios interactuar con el servidor para consultar o actualizar estadísticas.
-Muestra tablas detalladas de los equipos y sus estadísticas.

Notificaciones en Tiempo Real:
-Los clientes registrados reciben notificaciones automáticas cuando las estadísticas de un equipo cambian.

Funcionalidades:

Servidor:
-Gestión de Estadísticas:
-Administra estadísticas como yardas por tierra, yardas por pase e intercambios de balón.
-Permite a los clientes consultar y actualizar estos datos.
-Notificaciones a Clientes:
-Notifica a todos los clientes registrados cuando se actualizan las estadísticas de un equipo.
-Registro RMI:
-Proporciona un punto centralizado de acceso mediante RMI para los clientes.

Cliente:
-Consulta de Estadísticas:
-Muestra las estadísticas actuales de un equipo seleccionado.
-Actualización de Estadísticas:
-Permite modificar las estadísticas de un equipo.
-Visualización de Tabla:
-Presenta una tabla detallada de estadísticas para todos los equipos.

Notificaciones:
-Recibe alertas en tiempo real cuando cambian las estadísticas de un equipo.

Funciones:

Servidor:
-Administra Estadísticas:
-Consulta y actualiza datos sobre yardas por tierra, yardas por pase e intercambios.
-Envía Notificaciones:
-Informa a los clientes registrados sobre cambios en las estadísticas.
-Registra Clientes:
-Mantiene una lista de clientes conectados.

Cliente:
-Consulta y Actualización:
-Consulta estadísticas detalladas de equipos o actualiza sus valores.
-Visualización:
-Muestra tablas completas con estadísticas de todos los equipos registrados.
-Recepción de Notificaciones:
-Recibe notificaciones en tiempo real.

Estructura de las clases del Código:

Servidor:
-EstadisticasServidor.java: Inicia el registro RMI y publica el objeto remoto.
-EstadisticasImpl.java: Implementa la lógica del servidor, incluida la gestión de estadísticas.

Cliente:
-EstadisticasCliente.java: Permite la interacción con el servidor y la visualización de datos.
-EstadisticasClienteInterfaz.java: Define la interfaz remota para recibir notificaciones.

Interfaz Remota:
-EstadisticasInterfaz.java: Define las operaciones remotas disponibles para los clientes.

Ejemplo de Uso:
-Inicia el servidor.
-Conéctate con múltiples clientes.
-Consulta o actualiza estadísticas de equipos en tiempo real.
-Observa cómo los cambios se notifican automáticamente a otros clientes.
