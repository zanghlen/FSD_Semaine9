import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;



/**
 * Algorithme de tri : UnshuffleSort version simplifiee
 * (implementation doublement chainee avec des piles)

 * Cet algorithme de tri necessite l’utilisation d’une liste doublement chainee
 * de piles. Cet algorithme de tri comporte deux etapes. La premiere consiste a
 * repartir les donnees a trier dans un nombre variable de piles. Lorsque toutes
 * les donnees auront ete reparties, la deuxieme etape se chargera de remplir la
 * table a renvoyer.
 * 
 * Les 2 etapes sont basees sur le principe suivant : La liste des piles devra
 * toujours etre triee en utilisant le sommet de chaque pile comme clef de tri.
 * La pile aussi est triee.
 * 
 * 
 */
public class UnshuffleSortVS {
	private LinkedList<ArrayDeque<Integer>>  liste;

	public UnshuffleSortVS() {
		this.liste = new LinkedList<ArrayDeque<Integer>>();
	}

	/**
	 * tri des elements reçus en parametre
	 * 
	 * @param tableATrier
	 *            table a trier
	 * @return table contenant les elements tries
	 * @throws ListeVideException
	 */
	public int[] trier(int[] tableATrier) {
		repartirDonnees(tableATrier);
		return fusionnerPiles(tableATrier.length);
	}

	/**
	 * 1ere etape du tri : repartition des donnees dans les piles
	 * 
	 * @param tableATrier
	 *            table a trier
	 */
	private void repartirDonnees(int[]tableATrier) {
		// A COMPLETER
		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :
	}

	private void placerElement(int element) {
		// A COMPLETER
	}
	

	/**
	 * 2eme etape du tri : fusion des piles
	 * 
	 * @param taille
	 *            nombre d'elements de la table a trier
	 * @return table contenant les elements tries
	 * @throws ListeVideException
	 */
	private int[] fusionnerPiles(int taille) {
		return null;
		// A COMPLETER
		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :
	}


	private void deplacerPremierePile() {
		// A COMPLETER
	}
	
	public String toString(){
		String aRenvoyer="";
		int cptPile = 1;
		Iterator<ArrayDeque<Integer>> it = this.liste.iterator();
		while(it.hasNext()){
			ArrayDeque<Integer> pile = it.next();
			aRenvoyer+="pile"+cptPile+" :\n";
			aRenvoyer+=pile.toString();
		}
		return aRenvoyer;
	}

}
