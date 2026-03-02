// only implements scan (doesn't need power/brightness/temp/input)
public class AttendanceScanner implements Scannable {
    @Override public int scanAttendance() { return 3; }
}
