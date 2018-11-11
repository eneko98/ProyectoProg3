
import java.sql.*;
import java.util.logging.*;

/** Clase de gesti�n de base de datos del sistema de analiticas
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class BD {

	private static Exception lastError = null;  // Informaci�n de �ltimo error SQL ocurrido
	// TODO CAMBIAR CONSTANTES
	private static final String NOMBRETABLA = "Usuario";
	private static final String COLUMNAS_TABLA = " (nombre string, contrase�a string, correo string, codUsuario string)";
	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			log( Level.INFO, "Conectada base de datos " + nombreBD, null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexi�n de base de datos " + nombreBD, e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table "+NOMBRETABLA+COLUMNAS_TABLA);
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			log( Level.INFO, "Creada base de datos", null );
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en creaci�n de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE M�TODO CON PRECAUCI�N. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists "+NOMBRETABLA);
			log( Level.INFO, "Reiniciada base de datos", null );
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	/** Cierra la base de datos abierta
	 * @param con	Conexi�n abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en cierre de base de datos", e );
			e.printStackTrace();
		}
	}
	
	/** Devuelve la informaci�n de excepci�n del �ltimo error producido por cualquiera 
	 * de los m�todos de gesti�n de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}
	
	// TODO CAMBIAR SELECT, UPDATE, INSERT Y DELETE
	
	
	/** A�ade una analitica a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la analitica)
	 * @param codigo	C�digo a a�adir a la BD (en nueva fila)
	 * @param contador	contador a a�adir a esa nueva fila de la BD
	 * @return	true si la inserci�n es correcta, false en caso contrario
	 */
	public static boolean usuarioInsert( Statement st, Usuario usuario) {
		String sentSQL = "";	
		try {
			sentSQL = "insert into usuario values('" + secu(usuario.getNombre()) + "', '" + secu(usuario.getContrasenya()) + "', '"+ secu(usuario.getcorreo()) +  "')";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que a�adir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean cancionInsert( Statement st, Cancion cancion) {
		String sentSQL = "";	
		try {
			sentSQL = "insert into cancion values('" + secu(cancion.getTitulo()) + "', '" + secu(cancion.getAutor()) + "', '"+ secu(cancion.getFechaSubida()) + "', '"+ cancion.getCaratula()+ "', '" + cancion.getCreador() + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que a�adir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean LiricaInsert( Statement st, Lirica lirica) {
		String sentSQL = "";	
		try {
			sentSQL = "insert into lirica values('" + secu(lirica.getLetra()) + "', ";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que a�adir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	/** Realiza una consulta a la tabla abierta de la BD, usando la sentencia SELECT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la analitica)
	 * @param codigo	C�digo a buscar en la tabla
	 * @return	contador cargado desde la base de datos para ese c�digo, Integer.MAX_VALUE si hay cualquier error
	 */
	public static int usuarioSelect( Statement st, Usuario usuario, String codSelect ) {
		String sentSQL = "";
		try {
			int ret = Integer.MAX_VALUE;
			sentSQL = "select * from usuario where Codigo Usuario='"  + codSelect + "'";
			ResultSet rs = st.executeQuery( sentSQL );
			if (rs.next()) {
				ret = rs.getInt( "Codigo Usuario" );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return Integer.MAX_VALUE;
		}
	}
	
	public static int cancionSelect( Statement st, Cancion cancion, String codSelect ) {
		String sentSQL = "";
		try {
			int ret = Integer.MAX_VALUE;
			sentSQL = "select * from cancion where Codigo cancion='" + codSelect + "'";
			ResultSet rs = st.executeQuery( sentSQL );
			if (rs.next()) {
				ret = rs.getInt( "Codigo cancion" );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return Integer.MAX_VALUE;
		}
	}
	public static int LiricaSelect( Statement st, Lirica lirica, String codSelect ) {
		String sentSQL = "";
		try {
			int ret = Integer.MAX_VALUE;
			sentSQL = "select * from lirica where Codigo cancion='" + codSelect + "'";
			ResultSet rs = st.executeQuery( sentSQL );
			if (rs.next()) {
				ret = rs.getInt( "Codigo cancion" );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return Integer.MAX_VALUE;
		}
	}

	/** Modifica una anal�tica en la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la anal�tica)
	 * @param codigo	C�digo a modificar en la base de datos
	 * @param contador	Contador a modificar de ese c�digo
	 * @return	true si la inserci�n es correcta, false en caso contrario
	 */
	public static boolean usuarioUpdate( Statement st, Usuario usuario, String codUpdate ) {
		String sentSQL = "";
		try {
			sentSQL = "update usuario set nombre=" + ", nombre= " + usuario.getNombre() + ", contrasenya= "+ usuario.getContrasenya() + ", correo= " + usuario.getcorreo() + "where codigo='" + codUpdate + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean cancionUpdate( Statement st, Cancion cancion, String codUpdate ) {
		String sentSQL = "";
		try {
			sentSQL = "update cancion set titulo=" + ", titulo=" + cancion.getTitulo() + ", autor="+ cancion.getAutor() + ", fecha de subida= "+ cancion.getFechaSubida() + ", caratula= "+ cancion.getCaratula() + ", creador=  " + cancion.getCreador() + "where codCancion='" + codUpdate + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean LiricaUpdate( Statement st, Lirica lirica, String codUpdate ) {
		String sentSQL = "";
		try {
			sentSQL = "update cancion set titulo=" + ", letra=" + lirica.getLetra() + "where codLirica='" + codUpdate + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	/** Borrar una anal�tica de la tabla abierta de BD, usando la sentencia DELETE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la anal�tica)
	 * @param codigo	C�digo de anal�tica a borrar de la base de datos
	 * @return	true si el borrado es correcto, false en caso contrario
	 */
	public static boolean usuarioDelete( Statement st, Usuario usuario, String codDelete ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from usuario where codigo='" + codDelete + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean cancionDelete( Statement st, Cancion cancion, String codDelete ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from cancion where codigo='" + codDelete + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean liricaDelete( Statement st, Lirica lirica, String codDelete ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from lirica where codigo='" + codDelete + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	
	/////////////////////////////////////////////////////////////////////
	//                      M�todos privados                           //
	/////////////////////////////////////////////////////////////////////

	// Devuelve el string "securizado" para volcarlo en SQL
	// (Implementaci�n 1) Sustituye ' por '' y quita saltos de l�nea
	// (Implementaci�n 2) Mantiene solo los caracteres seguros en espa�ol
	private static String secu( String string ) {
		// Implementaci�n (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementaci�n (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ��������������.,:;-_(){}[]-+*=<>'\"�?�!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}
	

	/////////////////////////////////////////////////////////////////////
	//                      Logging                                    //
	/////////////////////////////////////////////////////////////////////
	
	private static Logger logger = null;
	// M�todo p�blico para asignar un logger externo
	/** Asigna un logger ya creado para que se haga log de las operaciones de base de datos
	 * @param logger	Logger ya creado
	 */
	public static void setLogger( Logger logger ) {
		BD.logger = logger;
	}
	// M�todo local para loggear (si no se asigna un logger externo, se asigna uno local)
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BD.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
	
	
}
