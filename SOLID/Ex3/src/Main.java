public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);

        EligibilityEngine engine = new EligibilityEngine();
        EligibilityEngineResult result = engine.evaluate(s);

        new ReportPrinter().print(s, result);
        new FakeEligibilityStore().save(s.rollNo, result.status);
    }
}
