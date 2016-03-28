package com.example;

/**
 * Created by huimin on 3/21/16.
 */

//Spring uses the Jackson JSON library to automatically marshal instances of type Greeting into JSON
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
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
