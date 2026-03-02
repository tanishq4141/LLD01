// default impl — scores based on code length + rubric bonus
public class CodeGrader implements CodeGrade {
    @Override
    public int grade(Submission s, Rubric r) {
        int base = Math.min(80, 50 + s.code.length() % 40);
        return base + r.bonus;
    }
}
