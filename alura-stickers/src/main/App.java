package main;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
    	var read = new Scanner(System.in);

        API api = selectApi(read); // Escolhe a API para fazer a(s) figurinha(s)
        String url = api.getUrl();
        ExtractorContent extrator = api.getExtrator();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json); // "Pega" a API desejada.
        var geradora = new StickerFactory();
        
        var dir = new File("stickers/");
        if(!dir.exists()) {
        	dir.mkdir();
        }
        
        boolean customText = txtIsCustom(read);
        System.out.println("Deseja obter figurinhas da API inteira? (S/N)");
        String answer = read.nextLine();
        
        if(answer.equalsIgnoreCase("s")) {
	        System.out.println("Gerando as figurinhas, aguarde...");
	        for (Conteudo conteudo : conteudos) {
	            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
	            String nomeArquivo = setNomeArquivo(conteudo);
	            
	            System.out.println(conteudo.titulo());
	            geradora.create(inputStream, nomeArquivo, customText);
	            System.out.println();
	        }
	        System.out.println("Figurinhas geradas com sucesso! Verifique a pasta Stickers do projeto baixado.");
        
        } else {
        	System.out.println("Digite o nome da imagem desejada:");
        	String imgName = read.nextLine();
        	Conteudo img = conteudos.stream().filter(conteudo -> conteudo.titulo().equals(imgName))
        		                             .findFirst()
        		                             .orElseThrow(() -> new RuntimeException("Conteudo não encontrada"));
        	
        	InputStream inputStream = new URL(img.urlImagem()).openStream();
        	String nomeArquivo = setNomeArquivo(img);
            
            geradora.create(inputStream, nomeArquivo, customText);

            System.out.println(img.titulo());
            System.out.println();
            System.out.println("Figurinha gerada com sucesso! Verifique a pasta Stickers do projeto baixado.");
    	}	
    
        read.close();
    }

   
//---------------------------------------------------------------------------------------------------------------	
   
	private static String setNomeArquivo(Conteudo conteudo) {
        String nomeArquivo = "stickers/" + conteudo.titulo() + ".png";
        
        if(conteudo.titulo().length() > 20) {
        	nomeArquivo = "stickers/sticker" + new Random().nextInt(1000) + ".png";
        }
        return nomeArquivo;
	}

//---------------------------------------------------------------------------------------------------------------	
	
	private static boolean txtIsCustom(Scanner read) {
		boolean custom = false;
		System.out.println("Deseja inserir um texto personalizado na figurinha? (S/N) (Padrao: 'Elite')");
		String answer = read.nextLine();
		if(answer.equalsIgnoreCase("s")) {
			custom = true;
		}
		
		return custom;
	}

//---------------------------------------------------------------------------------------------------------------	
	private static API selectApi(Scanner read) {
    	System.out.println("Bem-vindo ao gerador de figurinhas!"
				+ "Selecione uma das APIs para gerar as figurinhas:");
	
		System.out.println("(1) Top 10 filmes (imDB)\n"
						 + "(2) Top 10 series (imDB)\n"
						 + "(3) Fotos diarias da NASA\n"
						 + "(4) Ranking de linguagens");
		
		int apiNum = Integer.parseInt(read.nextLine());
		API api;
		
	    switch (apiNum) {
	    case 1:
	    	api = API.IMDB_TOP_MOVIES;
	        break;
	    case 2:
	        api = API.IMDB_TOP_SERIES;
	        break;
	    case 3:
	    	api = API.NASA;
	        break;
	    case 4:
	    	api = API.LANGUAGE_RANK;
	    	break;
	    default:
	    	read.close();
	        throw new IllegalArgumentException("Número de API inválido: " + apiNum);
	        
	    }
	    
	    return api;
		
	}
	
}
