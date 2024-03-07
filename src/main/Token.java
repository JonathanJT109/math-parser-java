package main;

public class Token {
    TokenKind kind;
    String value;
    Position pos;

    public Token() {
        this.kind = TokenKind.Unexpected;
        this.value = "";
        this.pos = new Position();
    }

    public Token(TokenKind kind, String value, Position pos) {
        this.kind = kind;
        this.value = value;
        this.pos = pos;
    }

    public TokenKind getKind() {
        return kind;
    }

    public String getValue() {
        return value;
    }

    public Position getPos() {
        return pos;
    }

    public void setKind(TokenKind kind) {
        this.kind = kind;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setPos(Integer start, Integer end, Integer line) {
        pos.setStart(start);
        pos.setEnd(end);
        pos.setLine(line);
    }
}
