package midiasocial.external;

import midiasocial.external.responses.TwitterResponse;

// ADAPTEE: Interface incompatível do Twitter
public class SimuladorApiTwitter {
    
    public TwitterResponse tweet(String text, String apiKey) {
        if (apiKey == null || !apiKey.startsWith("key_twitter")) {
            return new TwitterResponse(null, "ERROR", "Invalid API Key");
        }
        if (text.length() > 280) {
            return new TwitterResponse(null, "ERROR", "Tweet too long");
        }
        
        System.out.println("[Twitter API] Tweetando: '" + text + "'");
        String tweetId = "tw_" + System.currentTimeMillis();
        return new TwitterResponse(tweetId, "OK", null);
    }
}