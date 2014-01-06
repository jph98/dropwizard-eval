package com.mango.evaldropwizard.domain;

/**
 * Representative of the JSON message that will be sent from clients.
 * JSON Serialisation is done by Jackson
 */
public class Saying {
    
    private final long id;
    private final String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
