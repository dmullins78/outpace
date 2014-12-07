package org.dmullins.outpace;

import org.dmullins.outpace.number.*;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class ASCIINumbers {

    private List<ASCIINumber> numbers;

    public ASCIINumbers() {
        numbers = asList(
                new ASCIIZero(),
                new ASCIIOne(),
                new ASCIITwo(),
                new ASCIIThree(),
                new ASCIIFour(),
                new ASCIIFive(),
                new ASCIISix(),
                new ASCIISeven(),
                new ASCIIEight(),
                new ASCIINine(),
                new ASCIIInvalid()
        );
    }

    public ASCIINumber toNumber(String first, String second, String third) {
        return numbers.stream()
                .filter(n -> n.isMatch(first, second, third))
                .findFirst().get();
    }
}
