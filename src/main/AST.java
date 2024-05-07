package main;

public class AST implements ParserResult{
    final String type;
    final String operator;
    final ParserResult lhs;
    final ParserResult rhs;

    public AST(String type, String operator, ParserResult lhs, ParserResult rhs) {
        this.type = type;
        this.operator = operator;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int indent) {
        StringBuilder fi = new StringBuilder();
        StringBuilder si = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            fi.append('\t');
            si.append('\t');
        }
        si.append('\t');

        return "{\n" + si + "type: " + this.type + ",\n" + si + "Operator: " + this.operator + ",\n" + si + "Left: " + lhs.toString(indent + 1) + ",\n" + si + "Right: " + rhs.toString(indent + 1) + "\n" + fi + "}";
    }
}
