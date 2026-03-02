// hardcoded driver for demo
public class DriverAllocator implements DriverAlloc {
    @Override
    public String allocate(String studentId) {
        return "DRV-17";
    }
}
