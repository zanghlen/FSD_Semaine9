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
		this.nbMaxInscrits = nombreMax;
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
		return etudiantsEnAttente[etudiant.getNiveau().getIndice()].contains(etudiant);
	}

	// renvoie false si plus de place
	// il ne faut pas verifier si l'etudiant est deja present
	public boolean inscrire(Etudiant etudiant){ 
		// il reste de la place pour une inscription
		if ( placeRestanteInscrits(etudiant.getNiveau().getIndice()) ) {
			return etudiantsInscrits[etudiant.getNiveau().getIndice()].add(etudiant);
		}
		return false;
	}

	// renvoie false si l'etudiant n'est pas inscrit
	// il faut juste supprimer l'etudiant
	// cette methode ne s'occupe pas d'attribuer une place a un etudiant en attente
	public boolean desinscrire(Etudiant etudiant){
		return etudiantsInscrits[etudiant.getNiveau().getIndice()].remove(etudiant);
	}


	// il ne faut pas verifier si l'etudiant est deja present
	public void mettreEnAttente(Etudiant etudiant){
		if (etudiantsEnAttente[etudiant.getNiveau().getIndice()].add(etudiant)) {
			fileDAttente[etudiant.getNiveau().getIndice()].addLast(etudiant);
		}
		
	}
	

	//TODO terminer la methode 
	// renvoie null s’il n’y a pas d’etudiant en attente
	public Etudiant attribuerPlace(int niveau){ 
		// A COMPLETER
		// contient il ?
		if (fileDAttente[niveau].isEmpty()) {
			return null;
		}
		// je supprime de la file d'attente
		Etudiant toRemove = fileDAttente[niveau].removeFirst();
		if (!estEnAttente(toRemove)) { // mais est il dans la l'ensemble des gens en attente
			return null;
		}
		
		if (placeRestanteInscrits(niveau)) {
			retirerFileAttente(toRemove);
			inscrire(toRemove);
			return toRemove;
		} else if (placeRestanteInscrits(niveau)) {
			 mettreEnAttente(toRemove);
		}
		return null;
	}

	private boolean placeRestanteInscrits(int indice) {
		return etudiantsInscrits[indice].size() < nbMaxInscrits;
	}
	
	
	// TODO terminer la methode 
	// renvoie false si l'etudiant n'est pas en attente
	public boolean retirerFileAttente(Etudiant etudiant){
		// A COMPLETER
		return etudiantsEnAttente[etudiant.getNiveau().getIndice()].remove(etudiant);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println( "   ---   LISTE DE PERSONNES INSCRITES   ---");
		for (Niveau n : Niveau.values()) {
			System.out.println("\n   ---"+n+"---");
			int i = n.getIndice();
			for (Etudiant e : etudiantsInscrits[i]) {
				System.out.println(e);
			}
		}
		System.out.println("   ---   LISTE DES PERSONNES EN ATTENTE   --");
		for (Niveau n : Niveau.values()) {
			System.out.println("\n   ---"+n+"---");
			int i = n.getIndice();
			for (Etudiant e : etudiantsEnAttente[i]) {
				System.out.println(e);
			}
		}
		
		return "";
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
