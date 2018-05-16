package org.sonar.samples.php.checks;

import org.junit.Test;
import org.sonar.plugins.php.api.tests.PHPCheckTest;
import org.sonar.plugins.php.api.tests.PhpTestFile;

import java.io.File;

public class OWASP_A9_2017CheckTest {

    @Test
    public void test() throws Exception {
        PHPCheckTest.check(new OWASP_A9_2017Check(), new PhpTestFile(new File("src/test/resources/checks/OWASP_A9_2017Check.php")));
    }

}
