import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentRepository db, OnboardingPrinter printer) {
        this.db = db;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        StudentParser parser = new StudentParser();
        StudentRequest request = parser.parse(raw);

        StudentValidator validator = new StudentValidator();
        List<String> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, request.name, request.email, request.phone, request.program);

        db.save(rec);

        printer.printSuccess(id, db.count(), rec);
    }
}
