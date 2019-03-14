// import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class Game extends JPanel{
	
	/*A classe “Game” representará a tela, dentro da janela, onde o jogo
	 *	ocorrerá.
	 */
	
	private Bola bola;
	
	public Game() {
		bola = new Bola();
		setFocusable(true); // Define o foco para o painel criado
		setLayout(null); // Layout vazio, não será adicionado nenhum outro componente específico
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				gameLoop();
				
			}
		}).start();
	
	}
	
	// Game loop --------------------------------------------------------------
	public void gameLoop() {
		
		while (true) {
			handlerEvents();
			update();
			render();
			
			try {
				Thread.sleep(17); // Gera exceção
			} catch (InterruptedException e) {
				Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
			}
			
		}
			
	}
	
	public void handlerEvents() {
		
	}
	
	public void update() {
		testeColisoes();
		// bola.velX += 1;
		bola.setPosX(bola.getPosX() + bola.getVelX());
		bola.setPosY(bola.getPosY() + bola.getVelY());
		
	}
	
	public void render() {
		repaint();
		
	}
	
	// Outros métodos ------------------------------------------------
	
	public void testeColisoes() {
		if(bola.getPosX() + (bola.getRaio() * 2) >= Principal.LARGURA_TELA || bola.getPosX() <= 0) {
			bola.setVelX(bola.getVelX() * -1);
			
		}
		
		if(bola.getPosY() + (bola.getRaio() * 2) >= Principal.ALTURA_TELA || bola.getPosY() <=0) {
			bola.setVelY(bola.getVelY() * -1);
		}
		
	}
	
	// Método sobrescrito --------------------------------------------
	
	@Override
	protected void paintComponent(Graphics g) { // Desenha os elementos gráficos na tela
		super.paintComponent(g); // chama o metodo original da classe pai
		setBackground(Color.LIGHT_GRAY);
		
		/* Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));

		g.setColor(Color.yellow);
		g.fillOval((Principal.LARGURA_TELA/2) - 50, (Principal.ALTURA_TELA/2) - 50, 100, 100);
		
		g.setColor(Color.red);
		g.drawLine(0, 0, Principal.LARGURA_TELA, Principal.ALTURA_TELA); // define onde começa e termina
		
		g.setColor(Color.blue);
		g.drawLine(0, Principal.ALTURA_TELA, Principal.LARGURA_TELA, 0); // define onde começa e termina
		
		g.setColor(Color.RED);
		g.fillOval(bola.posX, bola.posY, bola.raio * 2, bola.raio*2); // Desenha a bola com Pos X, Y, altura e largura
		
		*/
				
		g.drawImage(bola.getParada(), bola.getPosX(), bola.getPosY(), null);
	}
	
}
