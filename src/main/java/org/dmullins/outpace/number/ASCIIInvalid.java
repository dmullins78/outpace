package org.dmullins.outpace.number;

public class ASCIIInvalid extends ASCIINumber {

    public boolean isMatch(String first, String second, String third) {
        return true;
    }

    public int getLength() {
        return 3;
    }

    public int getNumber() {
        return -1;
    }

    String getFirst() {
        return null;
    }

    String getSecond() {
        return null;
    }

    String getThird() {
        return null;
    }

}
