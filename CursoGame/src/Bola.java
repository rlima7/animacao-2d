import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bola {
	private int posX, posY, raio, velX, velY;
	// private BufferedImage parada;
	private BufferedImage direita_baixo;
	private BufferedImage direita_cima;
	private BufferedImage esquerda_cima;
	private BufferedImage esquerda_baixo;

	public Bola() {

		try {
			// parada = ImageIO.read(getClass().getResource("imgs/parada.gif"));
			direita_baixo = ImageIO.read(getClass().getResource("imgs/direita_baixo.gif"));
			direita_cima = ImageIO.read(getClass().getResource("imgs/direita_cima.gif"));
			esquerda_cima = ImageIO.read(getClass().getResource("imgs/esquerda_cima.gif"));
			esquerda_baixo = ImageIO.read(getClass().getResource("imgs/esquerda_baixo.gif"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Combinar para mover a bola em diferentes pisições
		posX = 200;
		posY = 200;
		raio = 50;
		velX = 3;
		velY = 3;

	}

	// Obter imagem
	// ************************************************************************************

	public BufferedImage obterImagem() { // Retorna objeto BufferedImage
		if (velX < 0) { // mover-se para a esquerda
			if (velY < 0) { // cima
				return esquerda_cima;
			} else { // baixo
				return esquerda_baixo;
			}

		} else { // mover-se para a direita
			if (velY < 0) { // cima
				return direita_cima;

			} else { // baixo
				return direita_baixo;

			}

		}

	}
	// ************************************************************************************

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
