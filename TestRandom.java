import java.security.SecureRandom;

public class TestRandom {
	
   public static void main(String[] a) {

	
	SecureRandom rnd = new SecureRandom();	
	int[] teste = {1, 2, 7, 3, 6, 13};	
	int loop = 1000;
	int roll = 6;
	int[] cont = new int[roll];

	for (int i = 1; i <= loop; i++) {

		int x = 1 + rnd.nextInt(roll);
		System.out.printf("%3d", x);
		
		if (i % 20 == 0) {
			System.out.println();
		}		
		
		cont[x - 1]++;
		
	}	
	
	for (int i = 0; i < roll; i++) {
		
		System.out.printf("%nquantidade de %ds: %d%n", i + 1, cont[i]);
		
	}	
	
	int desvMin = (int) (media(cont) - desvPad(cont));
	int desvMax = (int) (media(cont) + desvPad(cont));
	System.out.printf("%nA média é %.2f", media(cont));
	System.out.printf("%nO desvio padrão é %.2f%n", desvPad(cont));
	System.out.printf("%nAs frequências entre 1 desvio padrão estão entre %d e %d\n", desvMin, desvMax);	
	//System.out.printf("A quantidade de vezes que ocorreu entre 1 desvio padrão é %d, correspondendo a %.2f porcento%n", (int) maioria(cont)[0], maioria(cont)[1]);
   }

   public static double media(int[] data) {

	int size = data.length;	
	double total = 0;
	double media = 0;

	if (size != 0) {
		for (int i = 0; i < size; i++) {
			total += data[i];
		}
		media = total / size;
	} else {
		System.out.print("O array de dados está vazio.");
	}
	
	return media; 
   }

   public static double desvPad(int[] data) {

	int size = data.length;	
	double total = 0;
	double media = media(data);
	double var = 0;
	double desvPad = 0;

	if (size != 0) {
		for (int i = 0; i < size; i++) {
			total += Math.pow(data[i] - media, 2);
		}
		var = total / size;
		desvPad = Math.sqrt(var);
	} else {
		System.out.print("O array de dados está vazio.");
	}
	
	return desvPad; 
   }

   /*public static double[] maioria(int[] data) {
	
	int size = data.length;	
	int maior = 0; 

	for (double i = media(data) - desvPad(data); i <= media(data) + desvPad(data); i++) {
		
		maior++;
		
	}

	double rateMaior = (double) maior/size;
	
	double[] values = {maior, rateMaior};

	return values;	

	
   }*/  
}