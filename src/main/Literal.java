package main;

public class Literal implements ParserResult {
    final private String type;
    final private String value;

    public Literal(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Literal(Token token) {
        this.type = "Number";
        this.value = token.getValue();
    }

    public String getType(){
        return this.type;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return "{\ntype: " + this.type + ",\nvalue: " + this.value + "\n}";
    }

    public String toString(int indent){
        StringBuilder fi = new StringBuilder();
        StringBuilder si = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            fi.append('\t');
            si.append('\t');
        }
        si.append('\t');

        return "{\n" + si + "type: " + this.type + ",\n" + si + "value: " + this.value + "\n" + fi + "}";
    }
}
