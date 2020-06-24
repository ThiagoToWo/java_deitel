import java.util.Arrays;
import java.util.Scanner;

public class Crivo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("DISTRIBUIÇÃO DOS PRIMOS\n");

		System.out.print("Entre o valor máximo do conjunto de primos (máx = 2.147.483.648): ");
		int maximo = input.nextInt();

		System.out.print("Entre a amplitude do intervalo de distribuição dos primos: ");
		int intervalo = input.nextInt();
		
		boolean[] inteiros = new boolean[maximo + 1];
		Arrays.fill(inteiros, true);
		int[] frequencia = new int[100];		

		for (int p = 2; p*p <= maximo; p++) {
			if (inteiros[p]) {
				for (int n = 2 * p; n <= maximo; n += p) {
					inteiros[n] = false;
				}
			} 
		}

		System.out.println("\nLista de primos distribuidos em "
					+ "classes de aplitude " + intervalo + ":\n");

		for (int primo = 2; primo <= maximo; primo++) {	

			if (inteiros[primo] == true) {
				frequencia[primo % 100]++;
				System.out.print(primo + " ");				
			}
			
			if (primo % intervalo == 0) {
				System.out.println();
			}						
		}

		for (int fim = 3; fim < frequencia.length; fim++) {
			System.out.printf("final %02d: %d%n",fim, frequencia[fim]);
		}
	}
}