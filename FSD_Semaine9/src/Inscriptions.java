import java.util.HashSet;
import java.util.LinkedList;


public class Inscriptions {
	
	private HashSet<Etudiant> etudiantInscrits;
	private HashSet<Etudiant> etudiantsEnAttente;
	private LinkedList<Etudiant> fileDAttente; 
	private int nbMaxInscrits;
	
	// nombreMax est le maximum d'inscrits autorise dans le groupe de conversation
	public Inscriptions(int nombreMax){
		this.etudiantInscrits = new HashSet<Etudiant>(nombreMax);
		this.etudiantsEnAttente = new HashSet<Etudiant>();
		this.fileDAttente = new LinkedList<Etudiant>();
		this.nbMaxInscrits = nombreMax;
	}
	
	// renvoie le nombre d'inscrits, c-a-d le nombre d'etudiant faisant partie du groupe de conversation
	public int nombreIscrits(){
		return etudiantInscrits.size();
	}
	// verifie si l'etudiant fait partie du groupe de conversation
	public boolean estInscrit(Etudiant etudiant){
		// A COMPLETER
		return false;
	}
	
	// verifie si l'etudiant se trouve dans la liste d'attente
	public boolean estEnAttente(Etudiant etudiant){
		// A COMPLETER
		return false;
	}
	
	// renvoie false si plus de place
	// il ne faut pas verifier si l'etudiant est deja present
	public boolean inscrire(Etudiant etudiant){ 
		// A COMPLETER
		return false;
	}
	
	// renvoie false si l'etudiant n'est pas inscrit
	// il faut juste supprimer l'etudiant
	// cette methode ne s'occupe pas d'attribuer une place a un etudiant en attente
	public boolean desinscrire(Etudiant etudiant){
		// A COMPLETER
		return false;
	}
	

	// il ne faut pas verifier si l'etudiant est deja present
	public void mettreEnAttente(Etudiant etudiant){
		// A COMPLETER
	}
	
	// renvoie null s’il n’y a pas d’etudiant en attente
	public Etudiant attribuerPlace(){ 
		// A COMPLETER
		return null;
	}
	
	// renvoie false si l'etudiant n'est pas en attente
	public boolean retirerFileAttente(Etudiant etudiant){
		// A COMPLETER
		return false;
	}

}
