package main;

public class Lexer {
    private String text;

    public Lexer() {
        this.text = "";
    }

    public Lexer(String t) {
        this.text = t;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}