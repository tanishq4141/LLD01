// what the pipeline needs from a report writer
public interface ReportWrite {
    String write(Submission s, int plag, int code);
}

