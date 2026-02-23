import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(BookingRequest req) {
        List<PricingComponent> components = PricingComponentFactory.createComponents(req);

        Money monthly = calculateTotal(components, PricingComponent::getMonthlyFee);
        Money deposit = calculateTotal(components, PricingComponent::getDeposit);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateTotal(List<PricingComponent> components, ComponentExtractor extractor) {
        Money total = new Money(0.0);
        for (PricingComponent component : components) {
            total = total.plus(extractor.extract(component));
        }
        return total;
    }

    @FunctionalInterface
    private interface ComponentExtractor {
        Money extract(PricingComponent component);
    }
}
