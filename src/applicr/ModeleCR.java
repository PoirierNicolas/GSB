package applicr;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ModeleCR {
	//private static Statement stmt;
	//private static Connection connexion;
	//public static ResultSet resultat;

	private List<CompteRendu> compteRendus ;
	
	public List<Praticien> getPraticiensHesitants(){
		List<Praticien> praticiens = new ArrayList<Praticien>() ;
		ResultSet resultat ;
		String requete ;
		Statement stmt ;
		Connection connexion ;
		
		try{
			connexion = ConnexionBD.getConnexion() ;
			stmt = (Statement) connexion.createStatement();
			requete = "select PRA_NOM,PRA_PRENOM,RAPPORT_VISITE.PRA_NUM,PRA_VILLE,PRA_COEFNOTORIETE,RAP_COEF_CONF,RAP_NUM, RAP_DATE FROM PRATICIEN INNER JOIN RAPPORT_VISITE ON PRATICIEN.PRA_NUM=RAPPORT_VISITE.PRA_NUM where PRATICIEN.PRA_NUM IN (SELECT PRA_NUM FROM RAPPORT_VISITE where RAP_COEF_CONF < 10);";
			resultat = stmt.executeQuery(requete);
			
			try{
				while(resultat.next()){
					Praticien praticien = new Praticien(resultat.getInt("PRA_NUM"),resultat.getString("PRA_NOM"),resultat.getString("PRA_PRENOM"),resultat.getString("PRA_VILLE"),resultat.getBigDecimal("RAP_COEF_CONF"),resultat.getFloat("PRA_COEFNOTORIETE"),resultat.getDate("RAP_DATE")) ;
					//System.out.println(praticien);
					praticiens.add(praticien);
					
				}
				
			}
			catch(Exception e){
				System.out.println("Erreur à la formation de la formation de la liste des praticiens hesitants : "+e.getMessage());
			}
		}
		catch(Exception e){
			System.out.println("Erreur au niveau de la requete des praticiens hesitants"+e.getMessage());
		}
		
		return praticiens ;
	}
	
	public List<Visiteur> getVisiteurs(){
		List<Visiteur> visiteurs = new ArrayList<Visiteur>();
		ResultSet resultat ;
		String requete ;
		Statement stmt ;
		Connection connexion ;
		
		try{
			connexion = ConnexionBD.getConnexion() ;
			stmt = (Statement) connexion.createStatement();
			requete = "select VIS_MATRICULE,VIS_NOM,VIS_PRENOM FROM VISITEUR;";
			resultat = stmt.executeQuery(requete);
			
			try{
				while(resultat.next()){
					Visiteur visiteur = new Visiteur(resultat.getString("VIS_MATRICULE"),resultat.getString("VIS_NOM"),resultat.getString("VIS_PRENOM")) ;
					//System.out.println(visiteur);
					visiteurs.add(visiteur);
					
				}
				
			}
			catch(Exception e){
				System.out.println("Erreur � la formation de la formation de la liste des visiteurs : "+e.getMessage());
			}
		}
		catch(Exception e){
			System.out.println("Erreur au niveau de la requete des visiteurs"+e.getMessage());
		}
		
		
		return visiteurs;
	}


	public List<CompteRendu> getCompterendu(String mois, String annee, String matriculeVisiteur){
		compteRendus = new ArrayList<CompteRendu>();
		ResultSet resultat ;
		String requete ;
		Connection connexion ;
		PreparedStatement pstmt;
		int moisInt = Integer.parseInt(mois);
		int anneeInt = Integer.parseInt(annee);
		
		try{
			connexion = ConnexionBD.getConnexion() ;
			requete = "SELECT RAP_NUM,RAP_BILAN,PRA_NOM, PRA_PRENOM, PRA_VILLE, DATE_VISITE, RAP_DATE, RAP_EST_LU FROM (RAPPORT_VISITE INNER JOIN PRATICIEN ON RAPPORT_VISITE.PRA_NUM = PRATICIEN.PRA_NUM) INNER JOIN VISITEUR ON RAPPORT_VISITE.VIS_MATRICULE = VISITEUR.VIS_MATRICULE WHERE RAPPORT_VISITE.VIS_MATRICULE = ? AND YEAR(RAP_DATE)=? AND MONTH(RAP_DATE)=?  ORDER BY RAP_DATE ASC;";
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			pstmt.setString(1,matriculeVisiteur);
			pstmt.setInt(2,anneeInt);
			pstmt.setInt(3,moisInt);
			resultat = pstmt.executeQuery();
			
			try{
				while(resultat.next()){
					CompteRendu compteRendu = new CompteRendu(resultat.getInt("RAP_NUM"),matriculeVisiteur,resultat.getString("PRA_NOM"),resultat.getString("PRA_PRENOM"),resultat.getString("PRA_VILLE"),resultat.getDate("DATE_VISITE"),resultat.getDate("RAP_DATE"),resultat.getByte("RAP_EST_LU"),resultat.getString("RAP_BILAN")) ;
					//System.out.println(visiteur);
					compteRendus.add(compteRendu);
					
				}
				
			}
			catch(Exception e){
				System.out.println("Erreur � la formation de la formation de la liste des Comptes Rendus : "+e.getMessage());
			}
		}
		catch(Exception e){
			System.out.println("Erreur au niveau de la requete des compte rendu"+e.getMessage());
		}
			
		return compteRendus;
	}
	
	public List<CompteRendu> getCompteRendusDunVisiteur(){
		return  compteRendus;
	}

	public void setEstlu(int numeroCompteRendu){
		int resultat ;
		String requete ;
		Connection connexion ;
		PreparedStatement pstmt;
		
		try{
			connexion = ConnexionBD.getConnexion() ;
			requete = "UPDATE RAPPORT_VISITE SET RAP_EST_LU=1 WHERE RAP_NUM = ? ;";
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			pstmt.setInt(1,numeroCompteRendu);
			resultat = pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("Erreur a la modification du champ est lu : "+e.getMessage());
			
		}
		
	}
	
}
