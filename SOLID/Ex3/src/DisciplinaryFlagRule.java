public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public Violation checkViolation(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return new Violation("DISCIPLINARY_FLAG", LegacyFlags.nameOf(student.disciplinaryFlag));
        }
        return null;
    }
}
