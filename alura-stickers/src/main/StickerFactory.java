package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class StickerFactory {
    

    public void create(InputStream inputStream, String nomeArquivo, boolean txtIsCustom) throws Exception {
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        BufferedImage novaImagem = createNewImage(imagemOriginal);

        String texto = "Elite";
        
        if (txtIsCustom) {
        	var read = new Scanner(System.in);
        	System.out.println("Digite o texto desejado:");
            texto = read.nextLine();
      
        }
        
        Font fonte = new Font("Comic Suns MS", Font.BOLD, 64);
        Color corTexto = Color.white;
        Color corBorda = Color.BLACK;
        float larguraBorda = imagemOriginal.getWidth() * 0.004f;

        addText(novaImagem, texto, fonte, corTexto, corBorda, larguraBorda);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
    
    

    private BufferedImage createNewImage(BufferedImage imagemOriginal) {
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage newImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        return newImage;
    }
    
    

    private void addText(BufferedImage imagem, String texto, Font fonte, Color corTexto,
                                Color corBorda, float larguraBorda) {
        Graphics2D graphics = (Graphics2D) imagem.getGraphics();
        graphics.setFont(fonte);

        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int) retangulo.getWidth();
        int posicaoX = (imagem.getWidth() - larguraTexto) / 2;
        int posicaoY = imagem.getHeight() - 100;

        graphics.setColor(corTexto);
        graphics.drawString(texto, posicaoX, posicaoY);

        Shape outline = new TextLayout(texto, fonte, graphics.getFontRenderContext()).getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoX, posicaoY);
        graphics.setTransform(transform);

        BasicStroke borda = new BasicStroke(larguraBorda);
        graphics.setStroke(borda);
        graphics.setColor(corBorda);
        graphics.draw(outline);
        graphics.setClip(outline);
    }
}
