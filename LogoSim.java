import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LogoSim {
	
	static int[][] floor = new int[20][20];
	static int x = 0;
	static int y = 0;
	static int currentPosition = floor[x][y];
	static boolean penDown = false;
	
	static boolean forRight = false;
	static boolean forLeft = false;
	static boolean forDown = true;
	static boolean forUp = false;
	static boolean[] sentido = {forDown, forRight, forUp, forLeft};
	static int sentidoCount = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> arguments = new ArrayList<>();
		
		while (input.hasNext()) {
			int arg = input.nextInt();
			if (arg == 9) {					
				break;
			} else {				
				arguments.add(arg);
			}			
		}
		input.close();
				
		for (int i = 0; i < arguments.size(); i++) {			
			switch (arguments.get(i)) {
			case 1:
				penDown = false;
				break;
			case 2:
				penDown = true;
				break;
			case 3:
				Arrays.fill(sentido, false);
				sentido[++sentidoCount % 4] = true;				
				break;
			case 4:
				Arrays.fill(sentido, false);
				sentido[--sentidoCount % 4] = true;				
				break;
			case 5:
				int steps = arguments.get(++i);
				goFoward(steps);
				break;
			case 6:
				display();
				break;
			default:
				break;
			}
		}		
	}
	
	public static void goFoward(int n) {
		int steps;
		if (sentido[0]) {
			for (steps = 0; steps < n; steps++) {
				if (penDown == true) {
					floor[x + steps][y] = 1;				
				} else {
					floor[x + steps][y] = 0;
				}
			}
			x += steps;
		} else if (sentido[1]) {
			for (steps = 0; steps < n; steps++) {
				if (penDown == true) {
					floor[x][y + steps] = 2;				
				} else {
					floor[x][y + steps] = 0;
				}
			}
			y += steps;
		} else if (sentido[2]) {
			for (steps = 0; steps < n; steps++) {
				if (penDown == true) {
					floor[x - steps][y] = 3;				
				} else {
					floor[x - steps][y] = 0;
				}
			}
			x -= steps;
		} else if (sentido[3]) {
			for (steps = 0; steps < n; steps++) {
				if (penDown == true) {
					floor[x][y - steps] = 4;				
				} else {
					floor[x][y - steps] = 0;
				}
			}
			y -= steps;
		}
	}
		
	public static void display() {
		System.out.println();
		for (int i = 0; i < floor.length; i++) {
			for (int j = 0; j < floor.length; j++) {
				if (floor[i][j] == 1) 				
					System.out.print("v ");
				else if (floor[i][j] == 2)
					System.out.print("> ");
				else if (floor[i][j] == 3)
					System.out.print("^ ");
				else if (floor[i][j] == 4)
					System.out.print("< ");
				else
					System.out.print("  ");				
			}
			System.out.println();
		}
	}
}
