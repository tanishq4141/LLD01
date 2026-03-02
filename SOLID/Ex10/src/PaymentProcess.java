// what the booking service needs from a payment gateway
public interface PaymentProcess {
    String charge(String studentId, double amount);
}

