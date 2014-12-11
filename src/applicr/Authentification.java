package applicr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

public class Authentification {
	
	public static boolean connecter(String matricule, String mdp){
		Connection connexion ;
		boolean connexionOk = false ;
		try{
			connexion = ConnexionBD.getConnexion();
			System.out.println("Connexion OK" );
				try{
					String requete = "SELECT VIS_MDP FROM VISITEUR WHERE VIS_MATRICULE = ?";
					PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(requete);
					pstmt.setString(1,matricule);
					ResultSet resultat = pstmt.executeQuery();
					
					try{
						resultat.next() ;
						if(resultat.getString("VIS_MDP").equals(mdp)){
							connexionOk = true;
						}
					}
					catch(SQLException e){
						System.out.println("Erreur lors du traitement des données "+e.getMessage());
					}
				}
				catch(SQLException e){
					System.out.println("Erreur au niveau de la requete"+e.getMessage());
				}
		}
		catch(SQLException e){
			System.out.println("Erreur lors de la connexion"+e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return connexionOk ;
	}
	
}
