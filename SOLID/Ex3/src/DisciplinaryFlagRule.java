public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public String checkViolation(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return "disciplinary flag present";
        }
        return null;
    }
}
