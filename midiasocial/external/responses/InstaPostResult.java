package midiasocial.external.responses;

// Resposta específica do Instagram
public class InstaPostResult {
    private String postId;
    private boolean postedSuccessfully;
    private int httpCode;

    public InstaPostResult(String postId, boolean postedSuccessfully, int httpCode) {
        this.postId = postId;
        this.postedSuccessfully = postedSuccessfully;
        this.httpCode = httpCode;
    }

    public String getPostId() { return postId; }
    public boolean isPostedSuccessfully() { return postedSuccessfully; }
}