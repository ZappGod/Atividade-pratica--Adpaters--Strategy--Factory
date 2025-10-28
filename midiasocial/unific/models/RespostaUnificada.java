package midiasocial.unific.models;

public class RespostaUnificada {
    private boolean sucesso;
    private String postId;
    private String mensagem;
    private Estatisticas estatisticasIniciais;

    public RespostaUnificada(boolean sucesso, String postId, String mensagem, Estatisticas estatisticasIniciais) {
        this.sucesso = sucesso;
        this.postId = postId;
        this.mensagem = mensagem;
        this.estatisticasIniciais = estatisticasIniciais;
    }

    public boolean isSucesso() { return sucesso; }
    public String getPostId() { return postId; }
    public String getMensagem() { return mensagem; }

    @Override
    public String toString() {
        return "RespostaUnificada [" +
                "sucesso=" + sucesso +
                ", postId='" + postId + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", " + estatisticasIniciais +
                ']';
    }
}