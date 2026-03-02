// base ₹50 + ₹6.67 per km
public class DefaultFareCalc implements FareCalc {
    private static final double BASE = 50.0;
    private static final double PER_KM = 6.6666666667;

    @Override
    public double calculate(double distanceKm) {
        double fare = BASE + distanceKm * PER_KM;
        return Math.round(fare * 100.0) / 100.0;
    }
}

