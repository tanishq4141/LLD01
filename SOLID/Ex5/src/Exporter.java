// base class for all exporters
// contract: accept any non-null request, return ExportResult (never throw)
public abstract class Exporter {

    // handles null check here so subclasses don't have to
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            return ExportResult.error("request is null");
        }
        return doExport(req);
    }

    // subclasses do their format-specific work here
    protected abstract ExportResult doExport(ExportRequest req);
}
