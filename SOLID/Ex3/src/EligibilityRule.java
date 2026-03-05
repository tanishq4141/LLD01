public interface EligibilityRule {

    Violation checkViolation(StudentProfile student);
}
