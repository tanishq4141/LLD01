public class SingleRoom implements PricingComponent {
    @Override
    public Money getMonthlyFee() {
        return new Money(14000.0);
    }

    @Override
    public Money getDeposit() {
        return new Money(0.0);
    }
}
