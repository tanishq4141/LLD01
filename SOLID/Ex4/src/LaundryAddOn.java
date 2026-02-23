public class LaundryAddOn implements PricingComponent {
    @Override
    public Money getMonthlyFee() {
        return new Money(500.0);
    }

    @Override
    public Money getDeposit() {
        return new Money(0.0);
    }
}
