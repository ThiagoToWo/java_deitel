import java.security.SecureRandom;
import java.util.Scanner;

public class CalcTeacher {
	
	private SecureRandom rdm = new SecureRandom();
	private static Scanner input = new Scanner(System.in);
	
	private int resposta;
	private int n1;
	private int n2;
	private int acerto = 0;
	private static double rate = 0;
	private static int turn;
 
	public static void main(String[] args) {
				
		System.out.println("PROFESSOR DE C�LCULO MENTAL\nCriado por Thiago de Oliveira alves\ntowo497@gmail.com\n\n");
		System.out.print("* Insira um n�vel de dificuldade: ");
		int nivel = input.nextInt();
		System.out.println("* Escolha um tipo de problema.");
		System.out.print("* Adi��o --> 1, subtra��o --> 2, multiplica��o --> 3, divis�o --> 4, todas --> 5: ");		
		int mode = input.nextInt();
		System.out.println();
		
		switch (mode) {
		case 1:
			CalcTeacher ctAd = new CalcTeacher();
			for (turn = 1; turn <= 10; turn++) {
				ctAd.proporAd(nivel);				
			}
			avaliar(rate);
			break;
		case 2:
			CalcTeacher ctSub = new CalcTeacher();
			for (turn = 1; turn <= 10; turn++) {
				ctSub.proporSub(nivel);
			}
			avaliar(rate);
			break;
		case 3:
			CalcTeacher ctMul = new CalcTeacher();
			for (turn = 1; turn <= 10; turn++) {
				ctMul.proporMul(nivel);
			}
			avaliar(rate);
			break;
		case 4:
			CalcTeacher ctDiv = new CalcTeacher();
			for (turn = 1; turn <= 10; turn++) {
				ctDiv.proporDiv(nivel);
			}
			avaliar(rate);			
			break;
		case 5:
			CalcTeacher ctRandom = new CalcTeacher();
			for (turn = 1; turn <= 10; turn++) {
				ctRandom.proporRandom(nivel);
			}
			avaliar(rate);
			break;
		}
		

	}

	private void proporAd(int nivel) {
		
		n1 = rdm.nextInt((int) Math.pow(10, nivel));
		n2 = rdm.nextInt((int) Math.pow(10, nivel));

		System.out.printf("%d. Quanto � %d mais %d? ", turn, n1, n2);
		resposta = input.nextInt();

		if (resposta == n1 + n2) {
			elogiar();
			acerto++;
		} else {
			corrigir();
		}

		rate = acerto * 10.0;

	}
	
	private void proporSub(int nivel) {

		n1 = rdm.nextInt((int) Math.pow(10, nivel));
		n2 = rdm.nextInt((int) Math.pow(10, nivel));

		System.out.printf("%d. Quanto � %d menos %d? ", turn, Math.max(n1, n2), Math.min(n1, n2));
		resposta = input.nextInt();

		if (resposta == Math.abs(n1 - n2)) {
			elogiar();
			acerto++;
		} else {
			corrigir();
		}

		rate = acerto * 10.0;

	}

	private void proporMul(int nivel) {
		
		n1 = rdm.nextInt((int) Math.pow(10, nivel));
		n2 = rdm.nextInt((int) Math.pow(10, nivel));

		System.out.printf("%d. Quanto � %d vezes %d? ", turn, n1, n2);
		resposta = input.nextInt();

		if (resposta == n1 * n2) {
			elogiar();
			acerto++;
		} else {
			corrigir();
		}

		rate = acerto * 10.0;

	}
	
	private void proporDiv(int nivel) {

		n1 = (int) (Math.pow(10, nivel) + rdm.nextInt((int) Math.pow(10, nivel + 1)));
		n2 = 1 + rdm.nextInt((int) Math.pow(10, nivel));

		System.out.printf("%d. Qual o quociente de %d por %d? ", turn, n1, n2);
		resposta = input.nextInt();

		if (resposta == n1 / n2) {
			elogiar();
			acerto++;
		} else {
			corrigir();
		}

		rate = acerto * 10.0;

	}

	private void proporRandom(int nivel) {

		int mode = 1 + new SecureRandom().nextInt(4);

		switch (mode) {
		case 1:
			proporAd(nivel);
			break;
		case 2:
			proporSub(nivel);
			break;
		case 3:
			proporMul(nivel);
			break;
		case 4:
			proporDiv(nivel);
		}

	}	
	
	private void elogiar() {
		
		int opcao = 1 + rdm.nextInt(4);
		
		switch (opcao) {
		case 1: 
			System.out.println("Muito bom!\n");
			break;
		case 2:
			System.out.println("Excelente!\n");
			break;
		case 3:
			System.out.println("Bom trabalho!\n");
			break;
		case 4: 
			System.out.println("Mantenha um bom trabalho!\n");
		}
	}
	
	private void corrigir() {
		
		int opcao = 1 + rdm.nextInt(4);
		
		switch (opcao) {
		case 1: 
			System.out.println("N�o. Por favor, tente de novo.\n");
			break;
		case 2:
			System.out.println("Errado. Tente mais uma vez.\n");
			break;
		case 3:
			System.out.println("N�o desista!\n");
			break;
		case 4: 
			System.out.println("N�o. Continue tentando.\n");
		}
	}
	
	private static void avaliar(double rate) {
		if (rate >= 70.0 ) {
			System.out.printf("Voc� teve %.1f porcento de acerto.%nPabab�ns. Est� pronto para passar para o pr�ximo n�vel!\n", rate);
		} else {
			System.out.printf("Voc� teve %.1f porcento de acerto.%nPe�a ajuda extra ao seu professor.\n", rate);
		}
	}

}
