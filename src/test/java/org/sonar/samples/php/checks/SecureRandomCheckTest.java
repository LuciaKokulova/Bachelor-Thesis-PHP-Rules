package org.sonar.samples.php.checks;

import org.junit.Test;
import org.sonar.plugins.php.api.tests.PHPCheckTest;
import org.sonar.plugins.php.api.tests.PhpTestFile;

import java.io.File;

public class SecureRandomCheckTest {

    @Test
    public void test() throws Exception {
        PHPCheckTest.check(new SecureRandomCheck(), new PhpTestFile(new File("src/test/resources/checks/SecureRandomCheck.php")));
    }

}
