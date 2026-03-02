// plug in the implementations and run
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");

        PlagiarismCheck pc = new PlagiarismChecker();
        CodeGrade cg = new CodeGrader();
        ReportWrite rw = new ReportWriter();
        Rubric rubric = new Rubric();

        EvaluationPipeline pipeline = new EvaluationPipeline(pc, cg, rw, rubric);
        pipeline.evaluate(sub);
    }
}
