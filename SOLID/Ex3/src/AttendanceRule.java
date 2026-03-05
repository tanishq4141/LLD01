public class AttendanceRule implements EligibilityRule {
    private final int minAttendance;

    public AttendanceRule(int minAttendance) {
        this.minAttendance = minAttendance;
    }

    @Override
    public Violation checkViolation(StudentProfile student) {
        if (student.attendancePct < minAttendance) {
            return new Violation("ATTENDANCE", String.valueOf(minAttendance));
        }
        return null;
    }
}
