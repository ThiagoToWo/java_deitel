import javax.swing.*;
import java.awt.*;

public class Janela2 {
	public static void main(String[] args) {
		PainelDeDesenho pd = new PainelDeDesenho();
		JFrame j = new JFrame();
		j.add(pd);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(250, 250);
		j.setLocation(500, 200);
		j.setVisible(true);
	}
}

class PainelDeDesenho extends JPanel {	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 200, 200);
		
		g.setColor(Color.BLACK);
		g.fillOval(55, 65, 30, 30);
		g.fillOval(135, 65, 30, 30);

		g.fillOval(50, 110, 120, 60);

		g.setColor(Color.YELLOW);
		g.fillRect(50, 110, 120, 30);
		g.fillOval(50, 120, 120, 40);
	}
}
