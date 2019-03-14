import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bola {
	private int posX, posY, raio, velX, velY;
	private BufferedImage parada;
	
	public Bola() {
		
		try {
			parada = ImageIO.read(getClass().getResource("imgs/parada.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		posX = 200;
		posY = 200;
		raio = 50;
		velX = 5;
		velY = 5;
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

	public BufferedImage getParada() {
		return parada;
	}

	public void setParada(BufferedImage parada) {
		this.parada = parada;
	}
	
	

}
