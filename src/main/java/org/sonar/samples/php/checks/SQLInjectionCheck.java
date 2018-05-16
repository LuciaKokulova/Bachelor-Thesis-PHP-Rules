package org.sonar.samples.php.checks;

import com.google.common.collect.ImmutableSet;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.php.api.tree.SeparatedList;
import org.sonar.plugins.php.api.tree.expression.ExpressionTree;
import org.sonar.plugins.php.api.tree.expression.FunctionCallTree;
import org.sonar.plugins.php.api.visitors.PHPVisitorCheck;

import java.util.Set;

@Rule(
        key = SQLInjectionCheck.KEY,
        priority = Priority.MAJOR,
        name = "Not using bindParam() can cause SQLInjection.",
        tags = {"security"}
)
public class SQLInjectionCheck extends PHPVisitorCheck {

    private static final Set<String> DATA_MANIPULATION_STATEMENTS = ImmutableSet.of("DELETE", "SELECT", "INSERT", "UPDATE", "REPLACE");
    public static final String KEY = "SQLInjectionCheck";

    @Override
    public void visitFunctionCall(FunctionCallTree tree) {
        ExpressionTree callee = tree.callee();

        SeparatedList<ExpressionTree> arguments = tree.arguments();
        for (ExpressionTree et : arguments) {
            boolean fine = false;
            for (String statement : DATA_MANIPULATION_STATEMENTS) {
                if (et.toString().contains(statement)) {

                    String[] split = callee.toString().split("->");
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].equals("prepare")) {
                            fine = true;
                        }
                    }
                    if (!fine) {
                        context().newIssue(this, callee, "Remove the usage of " + statement + " without bindParam().");
                    }
                }
            }
        }

        super.visitFunctionCall(tree);
    }


}
