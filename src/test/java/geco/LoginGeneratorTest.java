package geco;

import junit.framework.TestCase;

public class LoginGeneratorTest extends TestCase {
    public void testGenerateLoginForNomAndPrenom() throws Exception {
    }

    public void testGenerateLoginForDurandPaulAccent() throws Exception {
        String loginPaulDurand =
                loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertThat(loginPaulDurand, equalTo("PDUR"));

    }

}