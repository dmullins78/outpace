package org.dmullins.outpace.number;

public class ASCIIZero extends ASCIINumber {

    public int getNumber() {
        return 0;
    }

    String getFirst() {
        return " _ ";
    }

    String getSecond() {
        return "| |";
    }

    String getThird() {
        return "|_|";
    }

}
