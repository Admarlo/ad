package serpis.ad;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VentaMain {

	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		entityManagerFactory=
				Persistence.createEntityManagerFactory("serpis.ad.gventa");
		
	}

}
