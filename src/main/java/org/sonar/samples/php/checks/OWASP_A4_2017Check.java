package org.sonar.samples.php.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.php.api.tree.SeparatedList;
import org.sonar.plugins.php.api.tree.expression.ExpressionTree;
import org.sonar.plugins.php.api.tree.expression.FunctionCallTree;
import org.sonar.plugins.php.api.visitors.PHPVisitorCheck;

@Rule(key = "OWASP_A4_2017Check",
        name = "XML processors should not evaluate external entity references within XML documents",
        description = "Many older or poorly configured XML processors evaluate external entity references within XML\n" +
                "documents. External entities can be used to disclose internal files using the file URI handler,\n" +
                "internal SMB file shares on unpatched Windows servers, internal port scanning, remote code\n" +
                "execution, and denial of service attacks, such as the Billion Laughs attack. ",
        priority = Priority.CRITICAL,
        tags = {"security"}
)
public class OWASP_A4_2017Check extends PHPVisitorCheck {

    public static final String KEY = "OWASP_A4_2017Check";
    private static boolean disabled = false;

    @Override
    public void visitFunctionCall(FunctionCallTree tree) {
        ExpressionTree callee = tree.callee();
        SeparatedList<ExpressionTree> arguments = tree.arguments();

        if (callee.toString().equals("libxml_disable_entity_loader") && arguments.isEmpty()) {
            context().newIssue(this, callee, "Argument of 'libxml_disable_entity_loader' has to be set to 'true' to avoid XXE.");
        }

        for (ExpressionTree et : arguments) {
            if (callee.toString().equals("libxml_disable_entity_loader") && et.toString().equals("true")) {
                disabled = true;
            }
            if (callee.toString().equals("libxml_disable_entity_loader") && et.toString().equals("false")) {
                context().newIssue(this, callee, "Argument of 'libxml_disable_entity_loader' has to be set to 'true' to avoid XXE.");
            }
        }

        super.visitFunctionCall(tree);
    }


}
