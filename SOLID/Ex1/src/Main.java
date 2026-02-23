public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        OnboardingPrinter printer = new OnboardingPrinter();
        OnboardingService svc = new OnboardingService(db, printer);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);
        String raw2 = "name=Tanishq;email=tanishq@sst.edu;phone=8686252542;program=AI";
        svc.registerFromRawInput(raw2);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
