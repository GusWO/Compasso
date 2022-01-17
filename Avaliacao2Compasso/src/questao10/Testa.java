package questao10;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Testa {

	public static void main(String[] args) {

		String texto;
		Scanner scan = new Scanner(System.in);
		int felizcount = 0;
		int tristecount = 0;
		String ponto;
		String ponto2;
		System.out.println("Digita algo ai: ");
		texto = scan.nextLine();	
		ponto = texto.replace(":-)", ".");
		ponto2 = texto.replace(":-(", ".");
		System.out.println(texto);
		System.out.println(": "+ponto); 
		System.out.println(": " + ponto2);
		
	}
}
