
public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public boolean send(Notification n) {
        if (n.email == null || n.email.isEmpty()) {
            audit.add("email failed: no address");
            return false;
        }
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
        return true;
    }
}
