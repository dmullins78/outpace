package org.dmullins.outpace;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Account {

    public static final int MOD_VAL = 11;
    public static final int MULTIPLIER = 9;
    private List<Integer> asciiNumbers;

    public Account(List<Integer> asciiNumbers) {
        this.asciiNumbers = asciiNumbers;
    }

    public String getNumber() {
        String accountNumber = asciiNumbers.stream()
                .map(t -> t > -1 ? "" + t : "?")
                .collect(joining(""));

        return isValidCheckSum() ? accountNumber : accountNumber + " ILL";
    }

    public boolean isValidCheckSum() {
        int multiplier = MULTIPLIER;

        int total = 0;
        for (Integer asciiNumber : asciiNumbers) {
            total += asciiNumber * multiplier;

            multiplier--;
        }

        return total % MOD_VAL == 0;
    }
}
