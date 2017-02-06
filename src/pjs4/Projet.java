package pjs4;

import java.util.ArrayList;

public class Projet {
	
	private String emplacement;
	private ArrayList<Chapitre> chapitres; //Le premier est le num�ro 0
	private ArrayList<Fiche> fiches;
	
	private Projet(String emplacement){
		this.emplacement = emplacement;
		chapitres = new ArrayList<Chapitre>();
		fiches = new ArrayList<Fiche>();
	}
	
	/**
	 * Cr�e un nouveau projet et le retourne
	 * @param emplacement
	 * @return
	 */
	public static Projet creer(String emplacement){
		Projet p = new Projet(emplacement);
		creerArborescence(p);
		return p;
	}

	/**
	 * Cr�e les dossiers de l'arborescence
	 * V�rifie qu'ils n'existent pas d�j�
	 * Raise une erreur si d�j� existant ?
	 * @param p
	 */
	private static void creerArborescence(Projet p) {
		//Cr�er arbo chapitres et fiches
		p.initialiserChapitres();
		p.initialiserFiches();
		//Remplir attributs qui vont avec
	}
	
	/**
	 * Remplit la liste de fiches � partir de l'arborescence
	 */
	private void initialiserFiches() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Remplit la liste des chapitres � partir de l'arborescence
	 */
	private void initialiserChapitres() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Ouvre le projet, initialise les chapitres et fiches � partir de l'emplacement
	 * @param emplacement
	 * @return le projet ouvert
	 */
	public static Projet ouvrir(String emplacement){
		return null;
	}
	
	/**
	 * Enregistre tous les chapitres, fiches (et �ventuels fichiers de config)
	 */
	public void enregistrer(){
		for(int i = 0; i<chapitres.size(); i++)
			FileManager.enregistrer(emplacement,chapitres.get(i), i);
		for(Fiche f : fiches)
			FileManager.enregistrer(emplacement, f);
		//Si config � enregistrer, faire ici
	}

	/**
	 * Enregistre � un nouvel emplacement
	 * @param emplacement le nouvel emplacement du dossier
	 */
	public void enregistrerSous(String emplacement){
		String emplacementBackup = emplacement;
		//try catch
		this.emplacement = emplacement;
		enregistrer();
		//On catch les erreurs et r�tablit avec le backup
	}
	
	/**
	 * Renomme le projet dans l'appli java et dans l'arborescence
	 * @param nom le nouveau nom
	 */
	public void renommer(String nom){
		//Doit rename le nom du dossier dans emplacement (et on rename le dossier dans WINDOWS)
		//Pas oublier de backup comme enregistrer
	}
	
	/**
	 * Supprime le projet
	 */
	public void supprimer(){
		//Supprime d'abord les dossiers dans l'arborescence
		//Eventuellement d�truire l'objet java si moyen
	}
	
	/**
	 * Cree un nouveau chapitre
	 * @param nom le nom du chapitre
	 * @param numero le num�ro du chapitre
	 */
	public void creerChapitre(String nom, int numero){
		//Initialise un chapitre
		Chapitre c = new Chapitre(nom);
		FileManager.enregistrer(nom, c, numero);
		//Ins�rer c dans ArrayList au bon emplacement
	}
	
	/**
	 * Change l'emplacement d'un chapitre
	 * @param numeroOrigine le chapitre d�sign�
	 * @param numeroArrivee l'endroit o� il arrive
	 */
	public void bougerChapitre(int numeroOrigine,int numeroArrivee){
		//On get le chapitre de numeroOrigine, et on le bouge pour l'ins�rer � numeroArrivee
		//On change pas l'arborescence, on le fera au moment de l'enregistrement
	}
	
	/**
	 * Remplace un chapitre actuel par une version ant�rieure
	 * @param numero num du chapitre vis�
	 * @param numVersion num�ro de version
	 */
	public void retablirAncienChapitre(int numero, int numVersion){
		//Le file manager swap les 2 chapitres dans l'arborescence
		
		initialiserChapitres(); //On reload la liste des chapitres
	}
	
	/**
	 * Retourne une version ant�rieure d'un chapitre sans swap
	 * @param numero num du chapitre vis�
	 * @param numVersion num�ro de version
	 * @return le chapitre
	 */
	public Chapitre getAncienChapitre(int numero, int numVersion){
		return FileManager.getAncienChapitre(emplacement, numero, numVersion);
	}
	

}
