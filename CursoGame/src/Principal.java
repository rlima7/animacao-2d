import java.awt.Dimension;
import javax.swing.JFrame;

public class Principal {
	public static final int LARGURA_TELA = 640;
	public static final int ALTURA_TELA = 480;

	public Principal() {
		JFrame janela = new JFrame("Jogo 2D");

		// Para definir largura e altura no Jpanel definido na classe Game
		Game game = new Game();
		// Define o tamanho da tela do jogo (Classe Game), não mais da janela
		game.setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA));

		janela.getContentPane().add(game); // Inclui o painel definido em Game
		// janela.setSize(LARGURA_TELA, ALTURA_TELA); // Define largura e altura
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerrar com click no x
		janela.setResizable(false); // Impede a tela de ser redimencionada
		janela.setLocation(100, 100); // Coodernadas X e Y da posição da janela na tela
		janela.setFocusable(true);
		janela.setVisible(true); // Confirma exibição da janela, caso contrário fica invisivel
		janela.pack(); // Encaixa a janela da aplicação perfeitamente no tamanho da tela (Game)

	}
	

	public static void main(String[] args) {
		new Principal(); // Dispara a aplicação chamando o construtor

	}

}
