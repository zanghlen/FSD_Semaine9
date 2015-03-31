import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Inscriptions {
	
	private static final int nbNiveaux = Niveau.values().length;
	private int nbMaxInscrits;

	private HashSet<Etudiant>[] etudiantsInscrits;
	private HashSet<Etudiant>[] etudiantsEnAttente;
	private LinkedList<Etudiant>[] fileDAttente; 

	// nombreMax est le maximum d'inscrits autorise dans le groupe de conversation
	public Inscriptions(int nombreMax){
		this.etudiantsInscrits = new HashSet[nbNiveaux];
		this.etudiantsEnAttente= new HashSet[nbNiveaux];
		this.fileDAttente = new LinkedList[nbNiveaux];
		for (int indice = 0 ; indice < Niveau.values().length ; indice++) {
			etudiantsEnAttente[indice] = new HashSet<Etudiant>(nombreMax);
			etudiantsInscrits[indice] = new HashSet<Etudiant>(nombreMax);
			fileDAttente[indice] = new LinkedList<Etudiant>();
		}
		
	}

	// renvoie le nombre d'inscrits, c-a-d le nombre d'etudiant faisant partie du groupe de conversation
	public int nombreIscrits(int niveau){
		return etudiantsInscrits[niveau].size();
	}
	// verifie si l'etudiant fait partie du groupe de conversation
	public boolean estInscrit(Etudiant etudiant){
		int indiceNiveau = etudiant.getNiveau().getIndice();
		return etudiantsInscrits[indiceNiveau].contains(etudiant);
	}

	// verifie si l'etudiant se trouve dans la liste d'attente
	public boolean estEnAttente(Etudiant etudiant){
		// A COMPLETER
	}

	// renvoie false si plus de place
	// il ne faut pas verifier si l'etudiant est deja present
	public boolean inscrire(Etudiant etudiant){ 

	}

	// renvoie false si l'etudiant n'est pas inscrit
	// il faut juste supprimer l'etudiant
	// cette methode ne s'occupe pas d'attribuer une place a un etudiant en attente
	public boolean desinscrire(Etudiant etudiant){

	}


	// il ne faut pas verifier si l'etudiant est deja present
	public void mettreEnAttente(Etudiant etudiant){

		
	}

	// renvoie null s’il n’y a pas d’etudiant en attente
	public Etudiant attribuerPlace(){ 
		// A COMPLETER
		return null;
	}

	private boolean placeRestanteInscrits() {

	}


	// renvoie false si l'etudiant n'est pas en attente
	public boolean retirerFileAttente(Etudiant etudiant){

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
	}
	
	public enum Niveau { 
		DEBUTANT(0), INTERMEDIAIRE(1) , EXPERT(2);
		private int indice ;
		private Niveau(int indice){
			this.indice = indice ; 
		}
		public int getIndice(){
			return this.indice;
		}
	};


}
