import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var geradora = new GeradorDeFigurinhas();

        //fazer uma conexão HTTP e buscar os top 250 filmes
        String urlIMDB = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String urlNASA = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        ClienteHttp clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(urlNASA);


        //exibir e manipular os dados
        var extratorNasa = new ExtratorDeConteudoDaNasa();
        var extratorIMDB = new ExtratorDeConteudoDoIMDB();
        List<Conteudo> conteudos = extratorNasa.extraiConteudos(json);

        conteudos.forEach(conteudo -> {
            try {
                geradora.cria(new URL(conteudo.urlImagem()).openStream(), "saida/" + conteudo.titulo() + ".png");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(conteudo.titulo());
        });
    }
}