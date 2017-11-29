package geco;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PasswordGenerationTest {
    private PasswordGeneration pwg;
    @Before
    public void setUp() throws Exception {
        this.pwg = new PasswordGeneration();
    }

    @Test
    public void getRandomPassword() throws Exception {
        String pwd = this.pwg.getRandomPassword();
        assertThat(pwd.length(), is(8));
    }

}