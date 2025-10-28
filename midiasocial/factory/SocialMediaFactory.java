package midiasocial.factory;

import java.util.Map;

import midiasocial.adapters.InstagramAdapter;
import midiasocial.adapters.TwitterAdapter;
import midiasocial.unific.ISocialMediaApi;
import midiasocial.unific.models.Plataforma;

public class SocialMediaFactory {

    // O Factory Method
    public ISocialMediaApi criarApi(Plataforma plataforma, Map<String, String> config) {
        ISocialMediaApi api;

        switch (plataforma) {
            case TWITTER:
                api = new TwitterAdapter();
                break;
            case INSTAGRAM:
                api = new InstagramAdapter();
                break;
            case LINKEDIN:
                // api = new LinkedInAdapter(); // Implementação omitida
                // break;
            case TIKTOK:
                // api = new TikTokAdapter(); // Implementação omitida
                // break;
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + plataforma);
        }

        // 4. Configuração por ambiente (Injeção de Dependência)
        // Autentica o adapter usando as credenciais específicas
        if (!api.autenticar(config)) {
            System.err.println("AVISO: Falha ao autenticar API para " + plataforma);
            // Poderia lançar uma exceção aqui, dependendo da regra de negócio
        }
        
        return api;
    }
}