public class ReportPrinter {
    public void print(StudentProfile s, EligibilityEngineResult r) {
        System.out.println("Student: " + s.name + " (CGR=" + String.format("%.2f", s.cgr)
                + ", attendance=" + s.attendancePct + ", credits=" + s.earnedCredits
                + ", flag=" + LegacyFlags.nameOf(s.disciplinaryFlag) + ")");
        System.out.println("RESULT: " + r.status);
        for (Violation v : r.violations) {
            System.out.println("- " + formatViolation(v));
        }
    }

    private String formatViolation(Violation v) {
        return switch (v.ruleName) {
            case "ATTENDANCE" -> "attendance below " + v.detail;
            case "CGR" -> "CGR below " + v.detail;
            case "CREDITS" -> "credits below " + v.detail;
            case "DISCIPLINARY_FLAG" -> "disciplinary flag: " + v.detail;
            default -> v.ruleName + ": " + v.detail;
        };
    }
}
