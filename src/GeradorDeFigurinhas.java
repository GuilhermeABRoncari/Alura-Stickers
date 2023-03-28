import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradorDeFigurinhas {
    public void cria(InputStream inputStream, double nota, String nomeArquivo) throws Exception {
        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem em memoria com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int novaLargura = largura / 2;
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, Transparency.TRANSLUCENT);

        //copiar a imagem original para novo imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte
        graphics.setColor(Color.RED);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 86));

        //escrever uma frase na imagem
        if (nota > 8.9) graphics.drawString("Filme exelente!", novaLargura / 2 - novaLargura / 2, novaAltura - 80);
        if (nota > 8.1 && nota < 9) graphics.drawString("Filme bom!", novaLargura / 2 - novaLargura / 2, novaAltura - 80);
        if (nota < 8) graphics.drawString("Filme mediano!", novaLargura / 2 - novaLargura / 2, novaAltura - 80);


        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
