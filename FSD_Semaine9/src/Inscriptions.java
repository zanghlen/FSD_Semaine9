import java.util.HashSet;
import java.util.Iterator;
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
		if ( placeRestanteInscrits() ) {
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
		if (etudiantInscrits.contains(etudiant)) {
			return ; 
		}
		if (etudiantsEnAttente.add(etudiant)) {
			fileDAttente.addLast(etudiant);
		}

	}

	// renvoie null s’il n’y a pas d’etudiant en attente
	public Etudiant attribuerPlace(){ 
		// A COMPLETER
		if (fileDAttente.isEmpty()) {
			return null;
		}
		Etudiant toRemove = fileDAttente.removeFirst();
		if (!estEnAttente(toRemove)) {
			return null;
		}

		if (placeRestanteInscrits()) {
			retirerFileAttente(toRemove);
			inscrire(toRemove);
			return toRemove;
		} else if (!placeRestanteInscrits()) {
			mettreEnAttente(toRemove);
		}
		return null;
	}

	private boolean placeRestanteInscrits() {
		return etudiantInscrits.size() < nbMaxInscrits;
	}


	// renvoie false si l'etudiant n'est pas en attente
	public boolean retirerFileAttente(Etudiant etudiant){
		return etudiantsEnAttente.remove(etudiant);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String toReturn = "--- Gens Inscrits ---";
		for (Iterator<Etudiant> iterator = etudiantInscrits.iterator(); iterator
				.hasNext();) {
			Etudiant etudiant = (Etudiant) iterator.next();
			toReturn += "\n" + etudiant.toString();
		}

		toReturn += "\n--- Gens en attente ---";
		for (Iterator<Etudiant> iterator = etudiantsEnAttente.iterator(); iterator
				.hasNext();) {
			Etudiant etudiant = (Etudiant) iterator.next();
			if (etudiantsEnAttente.contains(etudiant)) {
				toReturn += "\n" + etudiant.toString();
			}

		}
		return toReturn;
	}



}
