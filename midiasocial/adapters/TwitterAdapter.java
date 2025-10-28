package midiasocial.adapters;

import java.util.Map;

import midiasocial.external.SimuladorApiTwitter;
import midiasocial.external.responses.TwitterResponse;
import midiasocial.unific.ISocialMediaApi;
import midiasocial.unific.models.Conteudo;
import midiasocial.unific.models.Estatisticas;
import midiasocial.unific.models.RespostaUnificada;

public class TwitterAdapter implements ISocialMediaApi {

    // 1. O Adapter "embrulha" o Adaptee
    private final SimuladorApiTwitter apiTwitter;
    private String apiKey;

    public TwitterAdapter() {
        this.apiTwitter = new SimuladorApiTwitter();
    }

    @Override
    public boolean autenticar(Map<String, String> credenciais) {
        this.apiKey = credenciais.get("TWITTER_API_KEY");
        if (this.apiKey != null) {
            System.out.println("TwitterAdapter: Autenticado com sucesso.");
            return true;
        }
        System.err.println("TwitterAdapter: Falha na autenticação. Chave 'TWITTER_API_KEY' não encontrada.");
        return false;
    }

    @Override
    public RespostaUnificada postar(Conteudo conteudo) {
        if (this.apiKey == null) {
            return new RespostaUnificada(false, null, "Não autenticado", null);
        }
        
        // 2. O Adapter "traduz" a chamada unificada para a chamada específica
        // O Twitter só posta texto.
        if (conteudo.getTexto() == null) {
            return new RespostaUnificada(false, null, "Conteúdo de texto é obrigatório para o Twitter", null);
        }
        
        // Chamada ao Adaptee
        TwitterResponse respostaApi = apiTwitter.tweet(conteudo.getTexto(), this.apiKey);

        // 3. O Adapter "traduz" a resposta específica para a resposta unificada (Task 2)
        boolean sucesso = "OK".equals(respostaApi.getStatus());
        String mensagem = sucesso ? "Tweet postado com sucesso." : respostaApi.getErrorMessage();
        Estatisticas stats = sucesso ? new Estatisticas(0, 0, 0) : null;
        
        return new RespostaUnificada(sucesso, respostaApi.getTweetId(), mensagem, stats);
    }

    @Override
    public Estatisticas obterEstatisticas(String postId) {
        // Simulação
        System.out.println("[Twitter API] Buscando estatísticas para o tweet: " + postId);
        return new Estatisticas(150, 30, 10);
    }
}