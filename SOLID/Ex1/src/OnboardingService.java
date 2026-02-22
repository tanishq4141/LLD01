import java.util.*;

public class OnboardingService {
   private final StudentRepository db;

    public OnboardingService(StudentRepository db) {
        this.db = db;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);
        StudentParser parser = new StudentParser();
        StudentRequest request = parser.parse(raw);
       

        // validation inline, printing inline
        StudentValidator validator = new StudentValidator();
        List<String> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors)
                System.out.println("- " + e);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, request.name, request.email, request.phone, request.program);

        db.save(rec);

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
