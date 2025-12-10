package steps;

import org.junit.After;
import org.junit.Before;
import utils.Driver;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(){
        Driver.quitDriver();
    }

}
