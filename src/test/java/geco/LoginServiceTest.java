package geco;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;


public class LoginServiceTest extends TestCase {
    private LoginService service;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        String existants[] = new String[0];
        service = new LoginService(existants);
    }

    @Test
    public void testLoginExists() throws Exception {
        assertThat(service.loginExists("unLoginInexistant"), is(false));

    }

    @Test
    public void testAddLogin() throws Exception {
        service.addLogin("monLogin");
        assertThat(service.loginExists("monLogin"), is(true));
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        service.addLogin("abc");
        service.addLogin("ade");
        service.addLogin("agf");
        service.addLogin("bac");
        List<String> res = service.findAllLoginsStartingWith("a");
        assertThat(res.size(), equalTo(3));
        assertThat(res, hasItem("abc"));
        assertThat(res, hasItem("agf"));
        assertThat(res, hasItem("ade"));
        assertThat(res, not(hasItem("bac")));
    }

    @Test
    public void testFindAllLogins() throws Exception {
        service.addLogin("a");
        service.addLogin("b");
        service.addLogin("c");
        service.addLogin("d");
        List<String> res = service.findAllLogins();
        assertThat(res.size(), equalTo(4));
        assertThat(res, hasItem("a"));
        assertThat(res, hasItem("b"));
        assertThat(res, hasItem("c"));
        assertThat(res, hasItem("d"));
    }

}