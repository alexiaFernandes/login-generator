package geco;

import junit.framework.TestCase;
import org.junit.Before;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;

public class LoginGeneratorTest extends TestCase {
    private LoginGenerator loginGenerator;

    @Before
    public void setUp() throws Exception{
        LoginService loginService = new LoginService(new String[] {"JROL", "BPER",
                "CGUR", "JDUP", "JRAL", "JRAL1"} );
        loginGenerator = new LoginGenerator(loginService);
    }
    public void testGenerateLoginForDurandPaul() throws Exception {
        String loginPaulDurand =
                loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        assertThat(loginPaulDurand, equalTo("PDUR"));

    }

    public void testGenerateLoginForRallingJohn() throws Exception {
        String loginPaulDurand =
                loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        assertThat(loginPaulDurand, equalTo("JRAL2"));

    }

    public void testGenerateLoginForDurandPaulAccent() throws Exception {
        String loginPaulDurand =
                loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertThat(loginPaulDurand, equalTo("PDUR"));

    }

}