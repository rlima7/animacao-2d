import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Bola {
	private int posX, posY, raio, velX, velY;
	private BufferedImage cima, baixo, esquerda, direita, parada, direita_baixo, direita_cima, 
	esquerda_baixo, esquerda_cima; 
	
	public Bola() {
		
		try {
			cima = ImageIO.read(getClass().getResource("imgs/cima.gif"));
			baixo = ImageIO.read(getClass().getResource("imgs/baixo.gif"));
			esquerda = ImageIO.read(getClass().getResource("imgs/esquerda.gif"));
			direita = ImageIO.read(getClass().getResource("imgs/direita.gif"));
			parada = ImageIO.read(getClass().getResource("imgs/parada.gif"));
			esquerda_baixo = ImageIO.read(getClass().getResource("imgs/esquerda_baixo.gif"));
			esquerda_cima = ImageIO.read(getClass().getResource("imgs/esquerda_cima.gif"));
			direita_baixo = ImageIO.read(getClass().getResource("imgs/direita_baixo.gif"));
			direita_cima = ImageIO.read(getClass().getResource("imgs/direita_cima.gif"));
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		posX = 100;
		posY = 100;
		raio = 50;
		velX = 0;
		velY = 0;
	}
	
	// Getter Setter
	// ***********************************************************************************************

	public BufferedImage getCima() {
		return cima;
	}

	public void setCima(BufferedImage cima) {
		this.cima = cima;
	}

	public BufferedImage getBaixo() {
		return baixo;
	}

	public void setBaixo(BufferedImage baixo) {
		this.baixo = baixo;
	}

	public BufferedImage getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(BufferedImage esquerda) {
		this.esquerda = esquerda;
	}

	public BufferedImage getDireita() {
		return direita;
	}

	public void setDireita(BufferedImage direita) {
		this.direita = direita;
	}

	public BufferedImage getParada() {
		return parada;
	}

	public void setParada(BufferedImage parada) {
		this.parada = parada;
	}

	public BufferedImage getDireita_baixo() {
		return direita_baixo;
	}

	public void setDireita_baixo(BufferedImage direita_baixo) {
		this.direita_baixo = direita_baixo;
	}

	public BufferedImage getDireita_cima() {
		return direita_cima;
	}

	public void setDireita_cima(BufferedImage direita_cima) {
		this.direita_cima = direita_cima;
	}

	public BufferedImage getEsquerda_baixo() {
		return esquerda_baixo;
	}

	public void setEsquerda_baixo(BufferedImage esquerda_baixo) {
		this.esquerda_baixo = esquerda_baixo;
	}

	public BufferedImage getEsquerda_cima() {
		return esquerda_cima;
	}

	public void setEsquerda_cima(BufferedImage esquerda_cima) {
		this.esquerda_cima = esquerda_cima;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}	
	
	
}
