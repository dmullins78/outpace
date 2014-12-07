package org.dmullins.outpace;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserStoryTwoTest {

    @Test
    public void shouldPassCheckSum() throws Exception {
        assertChecksum(true, 7, 1, 1, 1, 1, 1, 1, 1, 1);
        assertChecksum(true, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertChecksum(true, 4, 9, 0, 8, 6, 7, 7, 1, 5);
    }

    @Test
    public void shouldFailCheckSum() throws Exception {
        assertChecksum(false, 8, 8, 8, 8, 8, 8, 8, 8, 8);
        assertChecksum(false, 4, 9, 0, 0, 6, 7, 7, 1, 5);
        assertChecksum(false, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    private void assertChecksum(boolean isValid, Integer... accountNumbers) {
        List<Integer> accountNumber = asList(accountNumbers);

        Account account = new Account(accountNumber);

        assertThat(account.isValidCheckSum(), is(isValid));
    }

}