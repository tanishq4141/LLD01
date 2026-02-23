public class GymAddOn implements PricingComponent {
    @Override
    public Money getMonthlyFee() {
        return new Money(300.0);
    }

    @Override
    public Money getDeposit() {
        return new Money(0.0);
    }
}
