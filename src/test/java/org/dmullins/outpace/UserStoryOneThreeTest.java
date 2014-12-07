package org.dmullins.outpace;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class UserStoryOneThreeTest {

    @Test
    public void shouldPassUserStoryOne() throws Exception {
        FileParser parser = parseFile("account_file.txt");

        List<Account> accounts = parser.parse();

        assertThat(accounts.size(), is(11));
        assertNumber(accounts, 0, "000000000");
        assertNumber(accounts, 1, "111111111");
        assertNumber(accounts, 2, "222222222");
        assertNumber(accounts, 3, "333333333");
        assertNumber(accounts, 4, "444444444");
        assertNumber(accounts, 5, "555555555");
        assertNumber(accounts, 6, "666666666");
        assertNumber(accounts, 7, "777777777");
        assertNumber(accounts, 8, "888888888");
        assertNumber(accounts, 9, "999999999");
        assertNumber(accounts, 10, "123456789");
    }

    @Test
    public void shouldPassUserStoryThree() throws Exception {
        FileParser parser = parseFile("story_3.txt");

        List<Account> accounts = parser.parse();

        assertNumber(accounts, 0, "000000051");
        assertNumber(accounts, 1, "49006771? ILL");
        assertNumber(accounts, 2, "1234?678? ILL");
    }

    public FileParser parseFile(String fileName) throws Exception {
        return new FileParser("src/test/resources", fileName);
    }

    private void assertNumber(List<Account> accounts, int index, String value) {
        assertThat(accounts.get(index).getNumber(), startsWith(value));
    }

}