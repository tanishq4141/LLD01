public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        // projector supports both Switchable and InputConnectable
        InputConnectable projInput = reg.getFirst(InputConnectable.class);
        ((Switchable) projInput).powerOn();
        projInput.connectInput("HDMI-1");

        reg.getFirst(BrightnessControllable.class).setBrightness(60);

        reg.getFirst(TemperatureControllable.class).setTemperatureC(24);

        System.out.println("Attendance scanned: present=" + reg.getFirst(Scannable.class).scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        // power off everything that can be switched off
        for (Switchable s : reg.getAll(Switchable.class)) {
            s.powerOff();
        }
    }
}
