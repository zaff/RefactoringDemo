package com.scrumtrek.simplestore;

/**
 * Created by user on 20.11.2015.
 * more
 * more
 */
public class TextStatement implements IStatement {
    private String rawContent;

    public TextStatement(String rawContent) {
        this.rawContent = rawContent;
    }

    @Override
    public String getRawContent() {
        return rawContent;
    }
}
