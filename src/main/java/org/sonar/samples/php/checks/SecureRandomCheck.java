package org.sonar.samples.php.checks;

import com.google.common.collect.ImmutableSet;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.php.api.tree.SeparatedList;
import org.sonar.plugins.php.api.tree.expression.ExpressionTree;
import org.sonar.plugins.php.api.tree.expression.FunctionCallTree;
import org.sonar.plugins.php.api.visitors.PHPVisitorCheck;

import java.util.Set;

@Rule(key = SecureRandomCheck.KEY,
        name = "Functions generating random numbers that are not cryptographically safe should not be used",
        description = "This function does not generate cryptographically secure values, and should not be used for cryptographic purposes. If you need a cryptographically secure value, consider using random_int(), random_bytes(), or openssl_random_pseudo_bytes() instead.",
        priority = Priority.MAJOR,
        tags = {"security"}
)
public class SecureRandomCheck extends PHPVisitorCheck {

    public static final String KEY = "SecureRandomCheck";
    public static final Set<String> WEAK_FUNCTIONS = ImmutableSet.of("rand", "mt_rand");

    @Override
    public void visitFunctionCall(FunctionCallTree tree) {
        ExpressionTree callee = tree.callee();

        for (String function : WEAK_FUNCTIONS) {
            if (callee.toString().equals(function)) {
                context().newIssue(this, callee, "Do not use this cryptographically weak function.");
            }
        }


        super.visitFunctionCall(tree);
    }

}
