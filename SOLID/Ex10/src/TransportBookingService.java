// takes its dependencies through the constructor; pricing pulled out into FareCalc
public class TransportBookingService {
    private final DistanceCalc distCalc;
    private final DriverAlloc driverAlloc;
    private final PaymentProcess payment;
    private final FareCalc fareCalc;

    public TransportBookingService(DistanceCalc distCalc, DriverAlloc driverAlloc,
                                   PaymentProcess payment, FareCalc fareCalc) {
        this.distCalc = distCalc;
        this.driverAlloc = driverAlloc;
        this.payment = payment;
        this.fareCalc = fareCalc;
    }

    public void book(TripRequest req) {
        double km = distCalc.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverAlloc.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = fareCalc.calculate(km);

        String txn = payment.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
