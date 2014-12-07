package org.dmullins.outpace;

import org.dmullins.outpace.number.ASCIINumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountParser {

    private static final int MAX_LINE_SIZE = 27;
    String one, two, three;
    ASCIINumbers numbers;

    public AccountParser(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
        numbers = new ASCIINumbers();
    }

    public Account parse() {
        List<ASCIINumber> results = new ArrayList<>();

        getAsciiNumber(results, 0);

        List<Integer> asciiNumbers = results.stream().map(ASCIINumber::getNumber).collect(Collectors.toList());
        return new Account(asciiNumbers);
    }

    private void getAsciiNumber(List<ASCIINumber> results, int offset) {
        ASCIINumber number = numbers.toNumber(sub(one, offset), sub(two, offset), sub(three, offset));

        results.add(number);

        int newOffset = offset + number.getLength();
        if (newOffset < MAX_LINE_SIZE) {
            getAsciiNumber(results, newOffset);
        }
    }

    private String sub(String line, int offset) {
        return line.substring(offset, line.length());
    }

}
