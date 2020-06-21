import javax.swing.*;
import java.awt.*;

public class Janela {
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
		int x = this.getWidth();
		int y = this.getHeight();
		for (int i = 0; i < 250; i += 15) {
			g.drawLine(0, 0, i, y - i);
			g.drawLine(x, y , x - i, i);
			g.drawLine(0, y , x - i, y - i);
			g.drawLine(x, 0 , i, i);
		}		
	}
}

