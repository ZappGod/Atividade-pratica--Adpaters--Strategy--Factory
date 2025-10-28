package midiasocial.adapters;

import java.util.Map;

import midiasocial.external.SimuladorApiInstagram;
import midiasocial.external.responses.InstaPostResult;
import midiasocial.unific.ISocialMediaApi;
import midiasocial.unific.models.Conteudo;
import midiasocial.unific.models.Estatisticas;
import midiasocial.unific.models.RespostaUnificada;

public class InstagramAdapter implements ISocialMediaApi {

    // 1. O Adapter "embrulha" o Adaptee
    private final SimuladorApiInstagram apiInstagram;
    private String userToken;

    public InstagramAdapter() {
        this.apiInstagram = new SimuladorApiInstagram();
    }

    @Override
    public boolean autenticar(Map<String, String> credenciais) {
        this.userToken = credenciais.get("INSTA_USER_TOKEN");
        if (this.userToken != null) {
            System.out.println("InstagramAdapter: Autenticado com sucesso.");
            return true;
        }
        System.err.println("InstagramAdapter: Falha na autenticação. Chave 'INSTA_USER_TOKEN' não encontrada.");
        return false;
    }

    @Override
    public RespostaUnificada postar(Conteudo conteudo) {
        if (this.userToken == null) {
            return new RespostaUnificada(false, null, "Não autenticado", null);
        }
        
        // 2. Tradução da chamada: Instagram requer imagem
        if (conteudo.getImagem() == null) {
            return new RespostaUnificada(false, null, "Imagem é obrigatória para o Instagram", null);
        }
        String legenda = (conteudo.getTexto() != null) ? conteudo.getTexto() : "";

        // Chamada ao Adaptee
        InstaPostResult respostaApi = apiInstagram.postMedia(conteudo.getImagem(), legenda, this.userToken);

        // 3. Tradução da resposta (Task 2)
        boolean sucesso = respostaApi.isPostedSuccessfully();
        String mensagem = sucesso ? "Postado no Instagram com sucesso." : "Erro HTTP " + respostaApi.hashCode(); // Simulação
        Estatisticas stats = sucesso ? new Estatisticas(0, 0, 0) : null;

        return new RespostaUnificada(sucesso, respostaApi.getPostId(), mensagem, stats);
    }

    @Override
    public Estatisticas obterEstatisticas(String postId) {
        System.out.println("[Instagram API] Buscando estatísticas para o post: " + postId);
        return new Estatisticas(1200, 5, 80);
    }
}