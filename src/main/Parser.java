package main;

import java.util.List;
import java.util.Objects;

public class Parser {
    private Integer cursor = 0;
    final List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token peak() {
        if (cursor >= tokens.size()) {
            System.out.println("Invalid index");
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this .tokens.get(cursor);
    }

    private Token peak(int n) {
        return this.tokens.get(cursor + n);
    }

    private Token consume() {
        Token tok = this.tokens.get(cursor);
        cursor++;
        return tok;
    }

    private Token consume(int n) {
        Token tok = this.tokens.get(cursor);
        cursor += n;
        return tok;
    }

    private ParserResult additive() {
        ParserResult lhs = this.multiplicative();

        while (this.peak().getKind() == TokenKind.Plus || this.peak().getKind() == TokenKind.Minus) {
            String operator = (Objects.equals(this.consume().getValue(), "+")) ? "Addition" : "Subtraction";
            ParserResult rhs = this.multiplicative();
            lhs = new AST("BinaryExpression", operator, lhs, rhs);
        }

        return lhs;
    }

    private ParserResult multiplicative() {
        ParserResult lhs = this.primary();
        while (this.peak().getKind() == TokenKind.Asterisk || this.peak().getKind() == TokenKind.Slash) {
            String operator = (Objects.equals(this.consume().getValue(), "*")) ? "Multiplication" : "Division";
            ParserResult rhs = this.primary();
            lhs = new AST("BinaryExpression", operator, lhs, rhs);
        }
        return lhs;
    }

    private ParserResult paren() {
        this.consume();
        ParserResult tree = this.generateTree();
        this.consume();
        return tree;
    }

    private ParserResult primary() {
        return switch (this.peak().getKind()) {
            case TokenKind.LeftParenthesis -> this.paren();
            default -> new Literal(this.consume());
        };
    }

    public ParserResult generateTree() {
        return this.additive();
    }
}
