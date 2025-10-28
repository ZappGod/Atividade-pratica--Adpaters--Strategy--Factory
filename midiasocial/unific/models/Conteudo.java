package midiasocial.unific.models;

// Modelo de dados unificado para representar o conteúdo a ser postado
public class Conteudo {
    private String texto;
    private byte[] imagem;
    private String videoPath;
    private String linkArtigo;

    // Getters e Setters
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public byte[] getImagem() { return imagem; }
    public void setImagem(byte[] imagem) { this.imagem = imagem; }
    public String getVideoPath() { return videoPath; }
    public void setVideoPath(String videoPath) { this.videoPath = videoPath; }
    public String getLinkArtigo() { return linkArtigo; }
    public void setLinkArtigo(String linkArtigo) { this.linkArtigo = linkArtigo; }
}