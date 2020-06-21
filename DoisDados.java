import java.security.SecureRandom;

public class DoisDados {
	public static void main(String[] args) {
		int[][] resultados = new int[6][6];
		int dado1;
		int dado2;

		for (int i = 0; i < 36000; i++) {
			dado1 = new SecureRandom().nextInt(6) + 1;
			dado2 = new SecureRandom().nextInt(6) + 1;
			resultados[dado1 - 1][dado2 - 1]++;			
		}

		for (int i = 0; i < resultados.length; i++) {
			for (int j = 0; j < resultados[i].length; j++) {
				System.out.printf("%6d",resultados[i][j]);
			}
			System.out.println();
		}		
	}
}