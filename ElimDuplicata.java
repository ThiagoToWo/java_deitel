import java.util.Scanner;

public class ElimDuplicata {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] freq = new int[91];
		
		for (int i = 0; i < 5; i++) {
			int num = in.nextInt();
			freq[num - 10]++;
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				System.out.printf("%d ", i + 10);
			} 
		}
	}
}