package midiasocial.main;

import java.util.HashMap;
import java.util.Map;

import midiasocial.factory.SocialMediaFactory;
import midiasocial.unific.ISocialMediaApi;
import midiasocial.unific.models.Conteudo;
import midiasocial.unific.models.Plataforma;
import midiasocial.unific.models.RespostaUnificada;;

public class GerenciadorMidiaSocial {

    public static void main(String[] args) {
        System.out.println("Iniciando Gerenciador de Mídia Social...");

        // Dica 4: Configuração por ambiente (simulada com um Map)
        Map<String, String> config = new HashMap<>();
        config.put("TWITTER_API_KEY", "key_twitter_12345");
        config.put("INSTA_USER_TOKEN", "token_insta_abcde");
        config.put("LINKEDIN_OAUTH_TOKEN", "oauth_li_xyz");
        config.put("TIKTOK_SESSION_KEY", "session_tt_789");

        // Dica 3: Usar a Factory Method (Task 3)
        SocialMediaFactory factory = new SocialMediaFactory();

        // Criamos os adapters dinamicamente. O cliente não sabe (nem se importa)
        // que por baixo dos panos são um TwitterAdapter ou InstagramAdapter.
        ISocialMediaApi apiTwitter = factory.criarApi(Plataforma.TWITTER, config);
        ISocialMediaApi apiInstagram = factory.criarApi(Plataforma.INSTAGRAM, config);

        System.out.println("\n-----------------------------------------");
        
        // --- Cenário 1: Postar no Twitter ---
        System.out.println("Tentando postar no Twitter...");
        Conteudo conteudoTweet = new Conteudo();
        conteudoTweet.setTexto("Este é meu primeiro post usando o Padrão Adapter! #Java #DesignPatterns");
        
        // O cliente chama o método unificado postar()
        RespostaUnificada respTwitter = apiTwitter.postar(conteudoTweet);
        
        // Task 2: O cliente recebe uma RespostaUnificada
        System.out.println("Resultado: " + respTwitter);

        System.out.println("\n-----------------------------------------");

        // --- Cenário 2: Postar no Instagram ---
        System.out.println("Tentando postar no Instagram...");
        Conteudo conteudoInsta = new Conteudo();
        conteudoInsta.setTexto("Olha que legal essa arquitetura de software!");
        conteudoInsta.setImagem(new byte[] { 0x10, 0x20, 0x30 }); // Simulação de uma imagem
        
        RespostaUnificada respInstagram = apiInstagram.postar(conteudoInsta);
        System.out.println("Resultado: " + respInstagram);
        
        System.out.println("\n-----------------------------------------");

        // --- Cenário 3: Falha no Instagram (sem imagem) ---
        System.out.println("Tentando postar no Instagram SEM IMAGEM (deve falhar)...");
        Conteudo conteudoInstaFalha = new Conteudo();
        conteudoInstaFalha.setTexto("Isso não vai funcionar...");

        RespostaUnificada respInstaFalha = apiInstagram.postar(conteudoInstaFalha);
        System.out.println("Resultado: " + respInstaFalha);
        
        System.out.println("\n-----------------------------------------");
        
        // --- Cenário 4: Obter Estatísticas ---
        if(respTwitter.isSucesso()) {
            System.out.println("Buscando estatísticas do Twitter...");
            System.out.println(apiTwitter.obterEstatisticas(respTwitter.getPostId()));
        }
    }
}