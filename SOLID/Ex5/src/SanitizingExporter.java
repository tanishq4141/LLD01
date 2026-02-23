public class SanitizingExporter extends Exporter {
    private final Exporter delegate;

    public SanitizingExporter(Exporter delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean canExport(ExportRequest req) {
        return delegate.canExport(req);
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (!canExport(req)) {
            throw new IllegalArgumentException("Invalid request");
        }
        String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        return delegate.export(new ExportRequest(req.title, body));
    }
}
