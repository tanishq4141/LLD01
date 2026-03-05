public class CreditsRule implements EligibilityRule {
    private final int minCredits;

    public CreditsRule(int minCredits) {
        this.minCredits = minCredits;
    }

    @Override
    public Violation checkViolation(StudentProfile student) {
        if (student.earnedCredits < minCredits) {
            return new Violation("CREDITS", String.valueOf(minCredits));
        }
        return null;
    }
}
