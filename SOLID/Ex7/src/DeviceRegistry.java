import java.util.*;

// holds all devices; lets you look them up by capability type
public class DeviceRegistry {
    private final List<SmartClassroomDevice> devices = new ArrayList<>();

    public void add(SmartClassroomDevice d) { devices.add(d); }

    
    @SuppressWarnings("unchecked")
    public <T> T getFirst(Class<T> capability) {
        for (SmartClassroomDevice d : devices) {
            if (capability.isInstance(d)) return (T) d;
        }
        throw new IllegalStateException("No device supports: " + capability.getSimpleName());
    }

    
}
