package midiasocial.unific;

import java.util.Map;
import midiasocial.unific.models.Conteudo;
import midiasocial.unific.models.Estatisticas;
import midiasocial.unific.models.RespostaUnificada;

/**
 * (TARGET INTERFACE)
 * Esta é a interface unificada que nosso sistema (Cliente) usará.
 * Todos os Adapters deverão implementar esta interface.
 */
public interface ISocialMediaApi {
    
    // Autentica na plataforma usando um mapa genérico de credenciais.
    boolean autenticar(Map<String, String> credenciais);

    // Posta um conteúdo unificado na plataforma.
    RespostaUnificada postar(Conteudo conteudo);

    // Obtém estatísticas unificadas de um post.
    Estatisticas obterEstatisticas(String postId);
}