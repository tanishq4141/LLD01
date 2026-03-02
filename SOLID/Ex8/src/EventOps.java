// event planning operations
public interface EventOps extends ClubAdminTools {
    void createEvent(String name, double budget);
    int getEventsCount();
}

