package main;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = "src/assets/test.txt";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = contentBuilder.toString().trim();
        Lexer lex = new Lexer(text);
        List<Token> tokens = new ArrayList<>();

        Token tok;
        while ((tok = lex.nextToken()) != null) {
//            System.out.println(tok.info());
            tokens.add(tok);
            if (tok.getKind() == TokenKind.EndOfFile) {
                break;
            }
        }

        Parser par = new Parser(tokens);
        Object res = par.generateTree();
        System.out.println(res);
    }
}