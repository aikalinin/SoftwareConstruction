package org.edu.hse.generics;

public enum Colors {
    BLUE("blue"), RED("red"), YELLOW("yellow"),
    BLACK(0);

    private String s = "";
    private Integer i = 0;

    Colors(String s) {
        this.s = s;
    }

    Colors(Integer i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
