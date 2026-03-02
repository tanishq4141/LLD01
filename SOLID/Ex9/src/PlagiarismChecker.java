// default impl — can swap this out for a real one later
public class PlagiarismChecker implements PlagiarismCheck {
    @Override
    public int check(Submission s) {
        return (s.code.contains("class") ? 12 : 40);
    }
}
