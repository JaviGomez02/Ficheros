package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenaPorNumCapitulos implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		return o1.getNumCapitulos() - o2.getNumCapitulos();
	}

}
