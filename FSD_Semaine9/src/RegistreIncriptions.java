import java.util.Scanner;


public class RegistreIncriptions {
	private static Scanner sc = new Scanner(System.in);
	private static Inscriptions inscriptions ;
	public static void main(String[] args) {

		inscriptions = new Inscriptions(12);

		System.out.println("Programme de gestion des incription ");
		System.out.println();
		System.out.println();
		int choix = 1 ;
		do {
			System.out.println("            ---menu---              ");
			System.out.println();
			System.out.println("1 - afficher le nombre de personnes inscrites  ");
			System.out.println("2 - verifier si l'etudiant est inscrit ");
			System.out.println("3 - verifier si l'etudiant est en attente ");
			System.out.println("4 - inscrire un etudiant ");
			System.out.println("5 - desincrire un etudiant ");
			System.out.println("6 - mettre un etudiant en attente");
			System.out.println("7 - attribuer une place a un etudiant ");
			System.out.println("8 - retirer un etudiant de la file d'attente\n");
			System.out.println("9 - afficher l'etat des inscription et de la file d'attente\n");
			System.out.println("autre - quitter");
			try {
				choix = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("Mauvais caractere insere !");
				System.out.println("Le programme s'arretera dans un instant ...");
				choix = -1;
				break;
			}
			switch (choix) {
			case 1:
				nombreInscrits();
				break;
			case 2:
				estInscrit();
				break;
			case 3:
				estEnAttente();
				break;
			case 4:
				inscrireUnEtudiant();
				break;
			case 5:
				desinscrireUnEtudiant();
				break;
			case 6:
				mettreEnAttente();// TODO
				break;
			case 7:
				attribuerPlace();
				break;
			case 8:
				retirerEtudiantEnAttente();
				break;
			case 9:
				System.out.println(inscriptions.toString());
				break;
			default:
				break;
			}
		} while (choix >0 && choix < 10);

	}
	private static void retirerEtudiantEnAttente() {
		// TODO Auto-generated method stub
		Etudiant et = nouvelEtudiant();
		if (inscriptions.retirerFileAttente(et)) {
			System.out.println("l'etudiant a ete retire de la file d'attente !");
		} else {
			System.out.println("l'etudiant n'a pas ete retire !");
		}

	}
	private static void attribuerPlace() {
		// TODO Auto-generated method stubSystem.out.println("Son niveau aussi ?");
		System.out.println("attribuer une place a quel niveau ? :");
		System.out.println("1 - Debutant \n2 - Intermediaire\n3 - Expert");
		int choix = sc.nextInt();
		Inscriptions.Niveau niveau = null ; 
		switch (choix) {
		case 1:
			niveau = Inscriptions.Niveau.DEBUTANT;
		case 2:
			niveau = Inscriptions.Niveau.INTERMEDIAIRE;
		case 3:
			niveau = Inscriptions.Niveau.EXPERT;
		default:
			break;
		}
		
		Etudiant et = inscriptions.attribuerPlace(niveau.getIndice());
		// TODO Auto-generated method stub
		if (et == null) {
			System.out.println("l'attribution n'a pas pu se faire !");
		} else {
			System.out.println("l'attribution de place a ete faite !");
		}

	}
	private static void mettreEnAttente() {
		// TODO Auto-generated method stub
		Etudiant et = nouvelEtudiant();
		inscriptions.mettreEnAttente(et);
		System.out.println("l'etudiant a ete mis en attente s'il ne l'etait pas deja ");
	}
	private static void desinscrireUnEtudiant() {
		Etudiant et = nouvelEtudiant();
		if (inscriptions.desinscrire(et)) {
			System.out.println("l'etudiant a ete desinscrit avec succés !");
		}else {
			System.out.println("l'etudiant n'a pas ete desinscrit !");
		}

	}
	
	private static void inscrireUnEtudiant() {
		Etudiant et = nouvelEtudiant();
		if (inscriptions.inscrire(et)) {
			System.out.println("l'etudiant a ete inscrit avec succés !");
		}else {
			System.out.println("l'etudiant n'a pas ete inscrit !");
			System.out.println("Mettez le dans la file d'attente");
		}

	}
	private static void estEnAttente() {
		Etudiant et = nouvelEtudiant();
		boolean estInscrit = inscriptions.estEnAttente(et); 
		if(estInscrit){
			System.out.println("L'etudiant est en attente !");
		}else{
			System.out.println("l'etudiant n'est pas en attente !");
		}

	}
	private static void estInscrit() {
		Etudiant et = nouvelEtudiant();
		boolean estInscrit = inscriptions.estInscrit(et); 
		if(estInscrit){
			System.out.println("L'etudiant est inscrit !");
		}else{
			System.out.println("l'etudiant n'est pas inscrit !");
		}

	}
	private static Etudiant nouvelEtudiant() {
		System.out.println("Pourriez vous introduire le nom de l'etudiant voulu ?");
		String nom = sc.next();
		System.out.println("Son niveau aussi ?");
		System.out.println("Voici le choix possible :");
		System.out.println("1 - Debutant \n2 - Intermediaire\n3 - Expert");
		int choix = sc.nextInt();
		Inscriptions.Niveau niveau = null ; 
		switch (choix) {
		case 1:
			niveau = Inscriptions.Niveau.DEBUTANT;
			break;
		case 2:
			niveau = Inscriptions.Niveau.INTERMEDIAIRE;
			break;
		case 3:
			niveau = Inscriptions.Niveau.EXPERT;
			break;

		default:
			break;
		}
		Etudiant etudiant = new Etudiant(nom,niveau);
		return etudiant ; 
	}
	private static void nombreInscrits() {
		for (Inscriptions.Niveau n : Inscriptions.Niveau.values()) {
			System.out.println("Il y a actuellement " + inscriptions.nombreIscrits(n.getIndice()) + " etudiants inscrits en niveau " + n );
		}
	}

}
