package zavrsniprojekat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Knjiga k = new Knjiga();
		k.ukloniZnakeIzKnjige();
		k.pronadjiNoveReci();
		System.out.println("Broj pojavljivanja reci u knjizi: " + k.brojPojavljivanja().size());
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("Dvadeset najcesce ponavljanih reci: ");
		ArrayList<String> najcesceReci = k.najcescePonavljaneReci(20);
		Collections.sort(najcesceReci);
		System.out.print("[");
		String separator = "";
		StringBuilder reci = new StringBuilder();
		for (String rec : najcesceReci) {
			reci.append(separator);
			reci.append(rec);
		    separator = ", ";
		}
		System.out.print(reci.toString());
		System.out.println("]");
		
		System.out.println("-------------------------------------------------------------------------------");
		k.upisUFajl("sortiraneReci");

	}

}