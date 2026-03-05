public class CgrRule implements EligibilityRule {
    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }

    @Override
    public Violation checkViolation(StudentProfile student) {
        if (student.cgr < minCgr) {
            return new Violation("CGR", String.valueOf(minCgr));
        }
        return null;
    }
}
