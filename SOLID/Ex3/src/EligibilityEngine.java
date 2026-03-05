import java.util.*;

public class EligibilityEngine {
    private final List<EligibilityRule> rules;

    public EligibilityEngine() {
        this.rules = createRules();
    }

    private List<EligibilityRule> createRules() {
        RuleInput config = new RuleInput();
        List<EligibilityRule> ruleList = new ArrayList<>();

        ruleList.add(new DisciplinaryFlagRule());
        ruleList.add(new CgrRule(config.minCgr));
        ruleList.add(new AttendanceRule(config.minAttendance));
        ruleList.add(new CreditsRule(config.minCredits));

        return ruleList;
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<Violation> violations = new ArrayList<>();
        String status = "ELIGIBLE";

        for (EligibilityRule rule : rules) {
            Violation violation = rule.checkViolation(s);
            if (violation != null) {
                status = "NOT_ELIGIBLE";
                violations.add(violation);
                break;
            }
        }

        return new EligibilityEngineResult(status, violations);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<Violation> violations;

    public EligibilityEngineResult(String status, List<Violation> violations) {
        this.status = status;
        this.violations = violations;
    }
}
