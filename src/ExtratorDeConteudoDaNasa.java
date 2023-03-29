import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos(String json) {

        //pegar só os dados importantes (titulo, imagem)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        listaDeAtributos.forEach(atributo -> conteudos.add(new Conteudo(atributo.get("title"), atributo.get("url"))));

        return conteudos;
    }
}
