public abstract class Exporter {
    /**
     * Checks if this exporter can handle the given request.
     * 
     * @param req the request to check
     * @return true if the request can be exported, false otherwise
     */
    public boolean canExport(ExportRequest req) {
        return req != null;
    }

    /**
     * Exports the request to a specific format.
     * 
     * Preconditions:
     * - req must not be null.
     * - canExport(req) must return true.
     * 
     * Postconditions:
     * - Returns a non-null ExportResult.
     * - Does not throw exceptions if preconditions are met.
     * - Accurately represents the request data according to the format.
     * 
     * @param req the export request
     * @return the export result
     * @throws IllegalArgumentException if preconditions are not met
     */
    public abstract ExportResult export(ExportRequest req);
}
