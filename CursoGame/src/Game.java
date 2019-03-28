import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Game extends JPanel{
	// Esta classe representará a tela, dentro da janela, onde o jogo ocorrerá. 
	
	private Bola bola;
	private BufferedImage imgAtual;
	private boolean k_cima, k_baixo, k_esquerda, k_direita = false;
	
	public Game() {
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_UP: k_cima = false; break;
				case KeyEvent.VK_DOWN: k_baixo = false; break;
				case KeyEvent.VK_LEFT: k_esquerda = false; break;
				case KeyEvent.VK_RIGHT: k_direita = false; break;
				
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_UP: k_cima = true; break;
				case KeyEvent.VK_DOWN: k_baixo = true; break;
				case KeyEvent.VK_LEFT: k_esquerda = true; break;
				case KeyEvent.VK_RIGHT: k_direita = true; break;
				
				}
			}
		});
		
		bola = new Bola();
		setFocusable(true); // Define o foco para o painel criado
		setLayout(null); // Layout vazio, não será adicionado nenhum outro componente específico
		
		new Thread(new Runnable() { // instancia da Thread + classe interna anonima
		
			@Override
			public void run() {
				gameloop();
			}
			
		}).start(); // dispara a Thread
	}
	
	
	/// Game loop
	// **************************************************************************************
	public void gameloop() {
		while(true) {
			handlerEvents();
			update();
			render();
			try {
				Thread.sleep(17);
			}catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
	// **************************************************************************************
	public void handlerEvents() {
		bola.setVelX(0);
		bola.setVelY(0);
		imgAtual = bola.getParada();
		
		if(k_cima) {
			bola.setVelY(-3);
			imgAtual = bola.getCima();
			if(k_esquerda) {
				bola.setVelX(-3);
				imgAtual = bola.getEsquerda_cima();
			}else if(k_direita) {
				bola.setVelX(3);
				imgAtual = bola.getDireita_cima();
			}
			
		}else if(k_baixo) {
			bola.setVelY(3);
			imgAtual = bola.getBaixo();
			if(k_esquerda) {
				bola.setVelX(-3);
				imgAtual = bola.getEsquerda_baixo();
			}else if(k_direita) {
				bola.setVelX(3);
				imgAtual = bola.getDireita_baixo();
			}
			
		}else if(k_esquerda) {
			bola.setVelX(-3);
			imgAtual = bola.getEsquerda();
		}else if(k_direita){
			bola.setVelX(3);
			imgAtual = bola.getDireita();
		}
	}
	
	
	public void update() {
		bola.setPosX(bola.getPosX() + bola.getVelX());
		bola.setPosY(bola.getPosY() + bola.getVelY());
		testeColisoes();
	}
	
	
	public void render() {
		repaint();
	}
	
	
	// Outros métodos
		// ******************************************************************************
	public void testeColisoes() {
		if(bola.getPosX() + (bola.getRaio()*2) >= Principal.LARGURA_TELA || bola.getPosX() <= 0){
			bola.setPosX(bola.getPosX() - bola.getVelX());
		}
		
		if(bola.getPosY() + (bola.getRaio()*2) >= Principal.ALTURA_TELA || bola.getPosY() <= 0) {
			bola.setPosY(bola.getPosY() - bola.getVelY());
		}
	}
		
	
	// Método sobrescrito
		// *****************************************************************************
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.LIGHT_GRAY);
		
		g.setColor(Color.RED);
		g.drawImage(imgAtual, bola.getPosX(), bola.getPosY(), null);
		
	}
}