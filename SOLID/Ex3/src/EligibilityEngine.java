import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {
        this.store = store;
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

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for (EligibilityRule rule : rules) {
            String violation = rule.checkViolation(s);
            if (violation != null) {
                status = "NOT_ELIGIBLE";
                reasons.add(violation);
                break;            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;

    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
