package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.HeaderRunner;
import runners.HomeRunner;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HomeRunner.class,
        HeaderRunner.class
})
public class DemirYoluADY {
}
