
public class TestUnshuffleSortVS {

	public static void main(String[] args) {
		System.out.println("**********************************");
		System.out.println("Tests de la classe UnshuffleSortVS");
		System.out.println("**********************************");
		UnshuffleSortVS unshuffleSort = new UnshuffleSortVS();
		//test 1
		System.out.println("Test 1 : table vide");
		int[] t1 = new int[0];
		int[] t1Triee = unshuffleSort.trier(t1);
		if(t1Triee.length!=0){
			System.out.println("test 1 ko : taille incorrecte : " + t1Triee.length);
			System.exit(0);
		}
		System.out.println("Test 1 ok");
		System.out.println();
		
		
		System.out.println("Test 2 : table avec 1 element");
		int[] t2 = {1};
		int[] t2Triee = unshuffleSort.trier(t2);
		if(t2Triee.length!=1){
			System.out.println("test 2 ko : taille incorrecte : "+ t2Triee.length);
			System.exit(0);
		}
		if(t2Triee[0]!=1){
			System.out.println("test 2 ko : contenu incorrect");
			System.out.println("table avant tri : ");
			afficher(t2);
			System.out.println("table après tri : ");
			afficher(t2Triee);	
		}
		System.out.println("Test 2 ok");
		System.out.println();
		
		System.out.println("Test 3 : table triee de 6 entiers - 1 seule pile");
		int[] t3 = {6,5,4,3,2,1};
		int[] t3Triee = unshuffleSort.trier(t3);
		if(t3Triee.length!=t3.length){
			System.out.println("test 2 ko : taille incorrecte : "+ t3Triee.length);
			System.exit(0);
		}
		if(! estTriee(t3Triee)){
			System.out.println("test 3 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t3);
			System.out.println("table après tri : ");
			afficher(t3Triee);	
		}
		System.out.println("Test 3 ok");
		System.out.println();
		
		System.out.println("Test 4 : table triee de 6 entiers - 2 piles");
		System.out.println("         pas de deplacement de pile en etape 2");
		int[] t4 = {3,2,1,6,5,4};
		int[] t4Triee = unshuffleSort.trier(t4);
		if(t4Triee.length!=t4.length){
			System.out.println("test 4 ko : taille incorrecte : "+ t4Triee.length);
			System.exit(0);
		}
		if(! estTriee(t4Triee)){
			System.out.println("test 4 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t4);
			System.out.println("table après tri : ");
			afficher(t4Triee);	
		}
		System.out.println("Test 4 ok");
		System.out.println();
		
		System.out.println("Test 5 : table triee de 6 entiers - 6 piles");
		int[] t5 = {1,2,3,4,5,6};
		int[] t5Triee = unshuffleSort.trier(t5);
		if(t5Triee.length!=t5.length){
			System.out.println("test 5 ko : taille incorrecte : "+ t5Triee.length);
			System.exit(0);
		}
		if(! estTriee(t5Triee)){
			System.out.println("test 5 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t5);
			System.out.println("table après tri : ");
			afficher(t5Triee);	
		}
		System.out.println("Test 5 ok");
		System.out.println();
		
		System.out.println("Test 6 : table triee de 9 entiers - 3 piles");
		System.out.println("         pas de deplacement de pile en etape 2");
		int[] t6 = {3,2,1,6,5,4,9,8,7};
		int[] t6Triee = unshuffleSort.trier(t6);
		if(t6Triee.length!=t6.length){
			System.out.println("test 6 ko : taille incorrecte : "+ t6Triee.length);
			System.exit(0);
		}
		if(! estTriee(t6Triee)){
			System.out.println("test 6 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t6);
			System.out.println("table après tri : ");
			afficher(t6Triee);	
		}
		System.out.println("Test 6 ok");
		System.out.println();
		
		System.out.println("Test 7 : table triee de 9 entiers - 3 piles");
		System.out.println("         pas de deplacement de pile en etape 2");
		int[] t7 = {3,6,9,2,5,8,1,4,7};
		int[] t7Triee = unshuffleSort.trier(t7);
		if(t7Triee.length!=t7.length){
			System.out.println("test 7 ko : taille incorrecte : "+ t7Triee.length);
			System.exit(0);
		}
		if(! estTriee(t7Triee)){
			System.out.println("test 7 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t7);
			System.out.println("table après tri : ");
			afficher(t7Triee);	
		}
		System.out.println("Test 7 ok");
		System.out.println();
		
		System.out.println("Test 8 : table triee de 9 entiers - 3 piles");
		System.out.println("         deplacement de piles en etape 2");
		int[] t8 = {5,4,1,6,3,2,9,8,7};
		int[] t8Triee = unshuffleSort.trier(t8);
		if(t8Triee.length!=t8.length){
			System.out.println("test 8 ko : taille incorrecte : "+ t8Triee.length);
			System.exit(0);
		}
		if(! estTriee(t8Triee)){
			System.out.println("test 8 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t8);
			System.out.println("table après tri : ");
			afficher(t8Triee);	
		}
		System.out.println("Test 8 ok");
		System.out.println();
		
		System.out.println("Test 9 : table triee de 9 entiers - 3 piles");
		System.out.println("         deplacement de piles en etape 2");
		int[] t9 = {9,8,1,4,3,2,7,6,5};
		int[] t9Triee = unshuffleSort.trier(t9);
		if(t8Triee.length!=t9.length){
			System.out.println("test 9 ko : taille incorrecte : "+ t9Triee.length);
			System.exit(0);
		}
		if(! estTriee(t9Triee)){
			System.out.println("test 9 ko : table non triee");
			System.out.println("table avant tri : ");
			afficher(t9);
			System.out.println("table après tri : ");
			afficher(t9Triee);	
		}
		System.out.println("Test 9 ok");
		System.out.println();
		
		System.out.println("Test 10 : quelques tables au hasard");
		for (int i = 0; i < 100; i++) {
			int[] t10 = tableAuHasard(20);
			int[] t10Triee = unshuffleSort.trier(t10);
			if(! estTriee(t10Triee)){
				System.out.println("test 10 ko : table non triee");
				System.out.println("table avant tri : ");
				afficher(t10);
				System.out.println("table après tri : ");
				afficher(t10Triee);	
			}
		}
		for (int i = 0; i < 100; i++) {
			int[] t10 = tableAuHasard(1000);
			int[] t10Triee = unshuffleSort.trier(t10);
			if(! estTriee(t10Triee)){
				System.out.println("test 10 ko : table non triee");
				System.out.println("table avant tri : ");
				afficher(t10);
				System.out.println("table après tri : ");
				afficher(t10Triee);	
			}
		}
		System.out.println("Test 10 ok");
		System.out.println();
		System.out.println("\nTous les tests ont reussi!");

	}
	
	private static boolean estTriee(int[] table) {
		for (int i = 0; i < table.length - 1; i++) {
			if (table[i] > table[i + 1])
				return false;
		}
		return true;
	}
	
	public static void afficher(int[] table) {
		String resultat = "";
		for (int i = 0; i < table.length; i++) {
			resultat += " "+table[i];
		}
		System.out.println(resultat);
	}
	
	private static int[] tableAuHasard(int taille) {
		int[] tableEntiers = new int[taille];
		for (int i = 0; i < taille; i++) {
			tableEntiers[i] = (int) (Math.random() * 100);
		}
		return tableEntiers;
	}
	
}
