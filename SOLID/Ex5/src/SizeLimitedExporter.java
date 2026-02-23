public class SizeLimitedExporter extends Exporter {
    private final Exporter delegate;
    private final int maxLength;
    private final String errorMessage;

    public SizeLimitedExporter(Exporter delegate, int maxLength, String errorMessage) {
        this.delegate = delegate;
        this.maxLength = maxLength;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean canExport(ExportRequest req) {
        if (req != null && req.body != null && req.body.length() > maxLength) {
            return false;
        }
        return delegate.canExport(req);
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (!canExport(req)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return delegate.export(req);
    }
}
