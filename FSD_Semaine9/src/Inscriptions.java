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
		return etudiantInscrits.contains(etudiant);
	}

	// verifie si l'etudiant se trouve dans la liste d'attente
	public boolean estEnAttente(Etudiant etudiant){
		// A COMPLETER
		return etudiantsEnAttente.contains(etudiant);
	}

	// renvoie false si plus de place
	// il ne faut pas verifier si l'etudiant est deja present
	public boolean inscrire(Etudiant etudiant){ 

		// il reste de la place pour une inscription
		if ( etudiantInscrits.size() < nbMaxInscrits ) {
			return etudiantInscrits.add(etudiant);
		}
		return false;
	}

	// renvoie false si l'etudiant n'est pas inscrit
	// il faut juste supprimer l'etudiant
	// cette methode ne s'occupe pas d'attribuer une place a un etudiant en attente
	public boolean desinscrire(Etudiant etudiant){
		return etudiantInscrits.remove(etudiant);
	}


	// il ne faut pas verifier si l'etudiant est deja present
	public void mettreEnAttente(Etudiant etudiant){
		fileDAttente.addLast(etudiant);
		etudiantsEnAttente.add(etudiant);
	}
	
	//TODO terminer la methode 
	// renvoie null s’il n’y a pas d’etudiant en attente
	public Etudiant attribuerPlace(){ 
		// A COMPLETER
		if (fileDAttente.isEmpty()) {
			return null;
		}
		Etudiant toRemove = fileDAttente.removeFirst();
		
		return null;
	}
	// TODO terminer la methode 
	// renvoie false si l'etudiant n'est pas en attente
	public boolean retirerFileAttente(Etudiant etudiant){
		// A COMPLETER
		return false;
	}

}
