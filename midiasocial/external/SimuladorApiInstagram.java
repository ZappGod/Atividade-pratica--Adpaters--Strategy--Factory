package midiasocial.external;

import midiasocial.external.responses.InstaPostResult;

// ADAPTEE: Interface incompatível do Instagram
public class SimuladorApiInstagram {

    public InstaPostResult postMedia(byte[] image, String caption, String userToken) {
        if (userToken == null || !userToken.startsWith("token_insta")) {
            return new InstaPostResult(null, false, 403); // Forbidden
        }
        if (image == null || image.length == 0) {
            return new InstaPostResult(null, false, 400); // Bad Request
        }

        System.out.println("[Instagram API] Postando imagem com legenda: '" + caption + "'");
        String postId = "insta_" + System.currentTimeMillis();
        return new InstaPostResult(postId, true, 200);
    }
}