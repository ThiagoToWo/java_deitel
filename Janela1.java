import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Janela1 {
	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Digite 1 para desenhar quadrados"
						+ "\nDigite 2 para desenhar círculos");

		int escolha = Integer.parseInt(input);		

		Shape pd = new Shape(escolha);
		JFrame j = new JFrame();
		j.add(pd);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(550, 550);
		j.setLocation(500, 200);
		j.setVisible(true);
	}
}

class Shape extends JPanel {	

	private int escolha;

	public Shape(int escolha) {
		this.escolha = escolha;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < 50; i++) {
			switch(escolha) {
				case 1:
					g.drawRect(10 + i * 10, 10 + i * 10, 
						50 + i * 10, 50 + i * 10);
					break;
				case 2:
					g.drawOval(10 + i * 10, 10 + i * 10, 
						50 + i * 10, 50 + i * 10);
					break;
			}
		}		
	}
}

