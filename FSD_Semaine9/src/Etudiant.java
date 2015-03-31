
public class Etudiant {

	private String nom ;
	private Inscriptions.Niveau niveau ; 

	public Inscriptions.Niveau getNiveau() {
		return niveau;
	}

	public Etudiant(String nom, Inscriptions.Niveau niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (niveau != other.niveau)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	} 
	
	

	
}
