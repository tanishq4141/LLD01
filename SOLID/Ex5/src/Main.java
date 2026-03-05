public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        // all exporters return results now, no need for try-catch
        System.out.println("PDF: " + describe(pdf.export(req)));
        System.out.println("CSV: " + describe(csv.export(req)));
        System.out.println("JSON: " + describe(json.export(req)));
    }

    private static String describe(ExportResult out) {
        if (!out.success) {
            return "ERROR: " + out.errorMessage;
        }
        return "OK bytes=" + out.bytes.length;
    }
}
