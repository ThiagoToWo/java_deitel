import java.util.Scanner;

public class GradeBookTest {	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Insira o nume do curso: ");
		String nome = in.nextLine();
		System.out.print("Insira o número de alunos: ");
		int numAlunos = in.nextInt();
		System.out.print("Insira o número de avaliações: ");
		int numProvas = in.nextInt();
		
		int[][] notas = new int[numAlunos][numProvas];

		System.out.println("Insira a sequência de notas: ");

		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				notas[i][j] = in.nextInt();
			}		
		}		
		
		System.out.println();
		GradeBook gb = new GradeBook(nome, notas);
		gb.process();
	}
}

public class GradeBook {

	private int[][] notas;
	private String curso;

	public GradeBook(String curso, int[][] notas) {
		this.notas = notas;
		this.curso = curso;
	}

	public void setCurso(String nome) {
		curso = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void process() {
		System.out.printf("Diário do curso de %s%n%n", curso);
		tabelNotas();
		System.out.printf("%nNota mínima: %02d%nNota máxima: %02d%n", getMin(), getMax());		
		contruirGrafico();
	}

	public void tabelNotas() {
		System.out.printf("Notas dos alunos%n", curso);	
		System.out.print("          ");	
		
		for (int test = 0; test < notas[0].length; test++) {
			System.out.printf("         Nota %d ",test + 1);
		}

		System.out.println("   Média aluno");

		for (int aluno = 0; aluno < notas.length; aluno++) {			
			System.out.printf("Aluno %2d:", aluno + 1);
			for (int nota : notas[aluno]) {
				System.out.printf("%16d", nota);
			}
			System.out.printf("%15.2f%n", getMedia(notas[aluno]));
		}

		System.out.print("M.P.Av:  ");
		
		

		for (int j = 0; j < notas[j].length; j++) {
			int total = 0;
			for (int i = 0; i < notas.length; i++) {
				total += notas[i][j];
			}
			double mediaAval = (double) total / notas.length;
			System.out.printf("%16.2f", mediaAval);
		}
		System.out.println();		
	}

	public int getMin() {
		int min = notas[0][0];

		for (int[] linha : notas) {
			for (int coluna : linha) {
				if (coluna < min) {
					min = coluna;
				}
			}			
		}
		
		return min;
	}

	public int getMax() {
		int max = notas[0][0];

		for (int[] linha : notas) {
			for (int coluna : linha) {
				if (coluna > max) {
					max = coluna;
				}
			}
		}
		
		return max;
	}
	
	public double getMedia(int[] notasAluno) {
		double total = 0;

		for (double nota : notasAluno) {
			total += nota;
		}
		
		return total / notasAluno.length;
	}

	public double getDesvPad(int[] notasAluno) {
		double total = 0;
		double media = getMedia(notasAluno);

		for (double nota : notasAluno) {
			total += Math.pow(nota - media, 2);
		}
		
		double var = total / notasAluno.length;
		
		return Math.sqrt(var);
	}

	public void contruirGrafico() {
		System.out.print("\nHistograma das notas\n");
		
		int[] freq = new int[11];

		for (int[] linha : notas) {
			for (int coluna : linha) {
				freq[coluna / 10]++;
			}			
		}

		for (int i = 0; i < freq.length; i++) {
			if (i == 10) {
				System.out.printf("%7d: ", 100);
			} else {
				System.out.printf("%02d - %02d: ", 10 * i, 10 * i + 9);
			}
			
			for (int j = 0; j < freq[i]; j++) {
				System.out.print("*");
			}

			System.out.println();
		} 
	}
}