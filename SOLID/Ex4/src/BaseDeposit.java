public class BaseDeposit implements PricingComponent {
    @Override
    public Money getMonthlyFee() {
        return new Money(0.0);
    }

    @Override
    public Money getDeposit() {
        return new Money(5000.0);
    }
}
