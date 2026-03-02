// default impl — just builds a filename for now
public class ReportWriter implements ReportWrite {
    @Override
    public String write(Submission s, int plag, int code) {
        return "report-" + s.roll + ".txt";
    }
}
