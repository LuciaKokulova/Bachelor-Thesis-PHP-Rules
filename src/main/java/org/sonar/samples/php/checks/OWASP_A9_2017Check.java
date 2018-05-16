package org.sonar.samples.php.checks;

import com.google.common.collect.ImmutableSet;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.php.api.tree.SeparatedList;
import org.sonar.plugins.php.api.tree.expression.ExpressionTree;
import org.sonar.plugins.php.api.tree.expression.FunctionCallTree;
import org.sonar.plugins.php.api.visitors.PHPVisitorCheck;

import java.util.Set;


@Rule(key = "OWASP_A9_2017Check",
        name = "Components with known vulnerabilities should not be used",
        description = "Applications and APIs using components with known vulnerabilities may undermine application defenses and enable various attacks and impacts.",
        priority = Priority.CRITICAL,
        tags = {"security"}
)
public class OWASP_A9_2017Check extends PHPVisitorCheck {

    private static final Set<String> VULNERABLE_COMPONENTS = ImmutableSet.of("sha1", "sha2", "md2", "md4", "md5", "ripemd128");
    private static final Set<String> VULNERABLE_FUNCTIONS = ImmutableSet.of("hash", "hash_init", "hash_hmac", "hash_hmac_file", "hash_file");
    public static final String KEY = "OWASP_A9_2017Check";

    @Override
    public void visitFunctionCall(FunctionCallTree tree) {
        ExpressionTree callee = tree.callee();

        SeparatedList<ExpressionTree> arguments = tree.arguments();
        for (ExpressionTree et : arguments) {
            String[] split = callee.toString().split("->");
            for (int i = 0; i < split.length; i++) {
                for (String component : VULNERABLE_COMPONENTS) {
                    if (split[i].equals(component)) {
                        context().newIssue(this, callee, "This is cryptographic hash function with known vulnerabilities! Use another one.");
                    }
                    for (String function : VULNERABLE_FUNCTIONS) {
                        String hashFunction = et.toString();
                        if (split[i].equals(function) && hashFunction.substring(1, hashFunction.length()-1).equals(component)) {
                            context().newIssue(this, callee, "Do not use 'hash' function in combination with unsafe hashes like " + hashFunction + ".");
                        }
                    }
                }

            }


        }

        super.visitFunctionCall(tree);
    }


}
