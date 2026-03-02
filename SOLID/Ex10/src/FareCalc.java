// pricing logic lives here, not inside the booking service
public interface FareCalc {
    double calculate(double distanceKm);
}

