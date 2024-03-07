package main;

public enum TokenKind {
    // Standard
    EndOfFile,
    Unexpected,
    Illegal,
    EndOfLine,
    Comment,

    // Identifiers and Literals
    Integer,
    Float,

    // Operators
    Plus,
    Minus,
    Asterisk,
    Slash,

    // Comparison
    Equal,
    LessThan,
    GreaterThan,
    LessThanOrEqualTo,
    GreaterThanOrEqualTo,

    // Symbols
    LeftParenthesis,
    RightParenthesis,
    LeftBrace,
    RightBrace,
    LeftBracket,
    RightBracket,
}
