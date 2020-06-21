public class Craps {
	private static final java.security.SecureRandom rnd = new java.security.SecureRandom();

	private enum Status {VENCEU, PERDEU, CONTINUE};
	
	public static void main(String[] args) {
		int meuPonto = 0;
		Status gameStatus;

		int soma = rolarDado();

		switch (soma) {
			case 2:
			case 3:
			case 12:
				gameStatus = Status.PERDEU;
				break;
			case 7:
			case 11:
				gameStatus = Status.VENCEU;
				break;
			default:
				gameStatus = Status.CONTINUE;
				meuPonto = soma;
				System.out.printf("Seu ponto é de %d%n", meuPonto); 
		}

		while (gameStatus == Status.CONTINUE) {
			soma = rolarDado();

			if (soma == meuPonto) {
				gameStatus = Status.VENCEU;
			} else {
				if (soma == 7) {
					gameStatus = Status.PERDEU;
				}
			}						
		}

		if (gameStatus == Status.VENCEU) {
			System.out.println("O jogador venceu"); 
		} else {
			System.out.println("O jogador perdeu"); 
		}
	}

	public static int rolarDado() {
		int d1 = 1 + rnd.nextInt(6);
		int d2 = 1 + rnd.nextInt(6);

		int soma = d1 + d2;

		System.out.printf("O jogador rolou %d + %d = %d%n", d1, d2, soma); 
		return soma;
	}
	
}