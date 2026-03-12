// only implements scan (doesn't need power/brightness/temp/input)
public class AttendanceScanner implements Scannable {
    @Override public int scanAttendance() { return 3; }
}




// public class AttendanceScanner implements SmartClassroomDevice {
//     @Override public void powerOn() { /* ok */ }
//     @Override public void powerOff() { /* no output */ }

//     @Override public void setBrightness(int pct) { /* irrelevant */ }
//     @Override public void setTemperatureC(int c) { /* irrelevant */ }
//     @Override public int scanAttendance() { return 3; }
//     @Override public void connectInput(String port) { /* irrelevant */ }
// }
