public class MessAddOn implements PricingComponent {
    @Override
    public Money getMonthlyFee() {
        return new Money(1000.0);
    }

    @Override
    public Money getDeposit() {
        return new Money(0.0);
    }
}
