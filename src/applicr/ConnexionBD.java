package applicr;

import java.sql.* ;

public class ConnexionBD {
	//private static final String dbURL = "jdbc:mysql://localhost/gsb?useUnicode=yes&characterEncoding=UTF-8" ;
	private static final String dbURL = "jdbc:mysql://192.168.104.202:3306/GsbCRSlam" ;
	//private static final String dbURL = "jdbc:mysql://127.0.0.1:3306/GsbCRSlam" ;
	private static final String user = "admin" ;
	//private static final String user = "root" ;
	//private static final String password = "" ;
	private static final String password = "azerty" ;
	private static Connection connexion = null ;
	
	private ConnexionBD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver") ;
		connexion = DriverManager.getConnection(dbURL,user,password) ;
	}
	
	public static Connection getConnexion() throws ClassNotFoundException, SQLException{
		if(connexion == null){
			new ConnexionBD() ;
		}
		return connexion ;
	}
}
