package org.dmullins.outpace.number;

public abstract class ASCIINumber {

    public abstract int getNumber();
    abstract String getFirst();
    abstract String getSecond();
    abstract String getThird();

    public int getLength() {
        return getFirst().length();
    }

    public boolean isMatch(String first, String second, String third) {
        return first.startsWith(getFirst()) && second.startsWith(getSecond()) && third.startsWith(getThird());
    }

}
