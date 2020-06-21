public class Perfeito {
	
	public static void main(String[] args) {
		for (int n = 1; n <= 10000; n++) {			
			if (isPerfect(n)) {
				System.out.print(n + ": ");
				for (long i = 1; i < n; i++) {
					if (n % i == 0) {
						System.out.print(i + " ");
					}
				}
				System.out.println("--> Número perfeito");									
			}			
		}				
	}

	public static boolean isPerfect(long num) {
		long soma = 1;
		boolean perf = false;
		
		for (long i = 2; i * i < num; i++) {
			if (num % i == 0) {		
				soma += i;
				soma += num/i;
			}									
		}	

		if (num > 1 && soma == num) {
			perf = true;			
		}
		
		return perf;
	}
}