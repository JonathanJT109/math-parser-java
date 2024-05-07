package main;

public class Lexer {
    final private String text;
    private Integer position = 0;
    private Integer line = 1;
    private Integer index = 0;


    public Lexer() {
        this.text = "";
    }

    public Lexer(String t) {
        this.text = t;
    }

    public String getText() {
        return this.text;
    }

    private Character currentChar() {
        if (this.position >= this.text.length())
            return '\0';
        return text.charAt(this.position);
    }

    private void nextChar() {
        position++;
        index++;
    }

    private void isWhitespace() {
        while ((currentChar() == ' ' || currentChar() == '\t') && this.position < text.length())
            nextChar();
    }

    private Token defaultToken(TokenKind kind, Position pos) {
        if (kind == TokenKind.NewLine) {
            this.position++;
            this.line++;
            this.index = 0;
            return new Token(kind, "\\n", pos);
        } else if (kind == TokenKind.EndOfFile) {
            this.position = 0;
            this.line = 1;
            this.index = 0;
            return new Token(TokenKind.EndOfFile, "\\0", pos);
        }

        return new Token(kind, String.valueOf(this.text.charAt(this.position++)), pos);
    }

    private Token readNumber() {
        Position pos = new Position(this.index, 0, this.line);
        Integer start = this.position;
        boolean isDecimal = false;

        while (Character.isDigit(currentChar())) {
            nextChar();
            if (currentChar() == '.' && Character.isDigit(this.text.charAt(this.position + 1))) {
                isDecimal = true;
                nextChar();
            }
        }

        pos.setEnd(this.index);

        if (isDecimal)
            return new Token(TokenKind.Float, this.text.substring(start, this.position), pos);
        return new Token(TokenKind.Integer, this.text.substring(start, this.position), pos);
    }

    public Token nextToken() {
        isWhitespace();

        if (Character.isDigit(currentChar())) {
            return readNumber();
        }

        Position pos = new Position(this.index++, this.index, this.line);
        return switch (currentChar()) {
            case '\0' -> defaultToken(TokenKind.EndOfFile, pos);
            case '\n' -> defaultToken(TokenKind.NewLine, pos);
            case '(' -> defaultToken(TokenKind.LeftParenthesis, pos);
            case '+' -> defaultToken(TokenKind.Plus, pos);
            case '-' -> defaultToken(TokenKind.Minus, pos);
            case '/' -> defaultToken(TokenKind.Slash, pos);
            case '*' -> defaultToken(TokenKind.Asterisk, pos);
            case '=' -> defaultToken(TokenKind.Equal, pos);
            default -> defaultToken(TokenKind.Unexpected, pos);
        };
    }
}