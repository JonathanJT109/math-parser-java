package main;

public class Position {
    private Integer start;
    private Integer end;
    private Integer line;

    public Position() {
        this.start = 0;
        this.end = 0;
        this.line = 0;
    }

    public Position(Integer start, Integer end, Integer line) {
        this.start = start;
        this.end = end;
        this.line = line;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getLine() {
        return line;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String info() {
        return this.start + " -> " + this.end + ", line: " + this.line;
    }
}
