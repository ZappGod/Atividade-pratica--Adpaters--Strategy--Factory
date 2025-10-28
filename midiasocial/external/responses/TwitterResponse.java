package midiasocial.external.responses;

// Resposta específica do Twitter
public class TwitterResponse {
    private String tweetId;
    private String status; // ex: "OK", "ERROR"
    private String errorMessage;

    public TwitterResponse(String tweetId, String status, String errorMessage) {
        this.tweetId = tweetId;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getTweetId() { return tweetId; }
    public String getStatus() { return status; }
    public String getErrorMessage() { return errorMessage; }
}