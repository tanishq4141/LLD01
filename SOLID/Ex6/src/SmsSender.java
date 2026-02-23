
public class SmsSender extends NotificationSender {

    public SmsSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public boolean send(Notification n) {
        if (n.phone == null || n.phone.isEmpty()) {
            audit.add("sms failed: no phone");
            return false;
        }
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
        return true;
    }
}
