import java.util.*;

public class InvoiceFormatter {
    public String format(String invoiceId, List<LineItem> lines, double subtotal,
            double taxPercent, double taxAmount, double discount, double total) {

                
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoiceId).append("\n");

        for (LineItem line : lines) {
            out.append(String.format("- %s x%d = %.2f\n",
                    line.itemName, line.quantity, line.lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPercent, taxAmount));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));

        return out.toString();
    }

    public static class LineItem {
        public final String itemName;
        public final int quantity;
        public final double lineTotal;

        public LineItem(String itemName, int quantity, double lineTotal) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.lineTotal = lineTotal;
        }
    }
}
