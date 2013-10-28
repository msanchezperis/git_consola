import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FraseGit {

	public static void main(String[] args) {
		
		//generem variables
		Scanner lector = new Scanner(System.in);
		FraseGit p = new FraseGit();
		String frase;
		String resultat;
		
		//demanem la frase per consola i la guardem
		System.out.println("Introdueix una frase: ");
		frase = lector.nextLine();
		lector.close();
		
		System.out.println("---------------------------------");
		
		//passem per la funcio de comptaLletres i retornem el resultat
		resultat = p.comptaLletres(frase);
		System.out.println("Dins la frase hi ha: ");
		System.out.println("- "+resultat);
		
	}

	public String comptaLletres(String frase) {
		
		//generem variables
		frase = frase.toUpperCase();
		String[] auxiliar = frase.split("");
		String abecedari = "ABCÇDEFGHIJKLMNOPQRSTUVWXYZ";
		String resultat = "";
		ArrayList<Lletra> lletresArray = new ArrayList<Lletra>();
		
		//recorrem l'abecedari i si el troba o creem la lletra a l'array o l'augmentem
		//comença per 1 pk el split genera un espai en blanc en java
		for(int f = 1; f < auxiliar.length; f++) {
			if(abecedari.indexOf(auxiliar[f]) != -1) {
				//creem un boolea de semafor
				boolean trobat = false;
				for(Lletra ll : lletresArray) {
					if(ll.getLletra().equals(auxiliar[f])) {
						ll.sumarLletra();
						trobat = true;
						break;
					}
				}
				if (trobat == false) {
					lletresArray.add(new Lletra(auxiliar[f]));
				}
			}
		}
		
		
		//Ordenem la llista per el comparador implementat més abaix
		Collections.sort(lletresArray, new Comparator<Lletra>() {
			//classe implementada per ordenar la llista alfabèticament "sintaxi LAMBDA"
				@Override
				public int compare(Lletra o1, Lletra o2) {
			        return o1.getLletra().compareTo(o2.getLletra());
			    }
			}
		);
		
		
		//recorrem l'array list
		String separador = " ";
		for(Lletra i : lletresArray) {
			resultat += separador+i.getLletra()+"-"+i.getQuantitat()+" vegada(es)";
			separador = ", ";
		}
		resultat += ".";
		resultat = resultat.trim();
		
		return resultat;

	}
	
	

	
	//classe de l'objecte lletra
	public class Lletra {
		//Definim les propietas de lletra
		String valor;
		int quantitat;
		
		//metodes per utilitzar la classe
		public Lletra(String valor) {
			this.valor = valor;
			this.quantitat = 1;
		}
		
		public void sumarLletra() {
			this.quantitat++;
		}
		
		public String getLletra() {			
			return this.valor;
		}
		
		public int getQuantitat() {			
			return this.quantitat;
		}
		
	}
	
	
}
	

