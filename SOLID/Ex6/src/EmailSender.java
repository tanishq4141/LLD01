
public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public boolean send(Notification n) {
        //  // LSP smell: truncates silently, changing meaning
        // String body = n.body;
        // if (body.length() > 40) body = body.substring(0, 40);
        // System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        // audit.add("email sent");



        if (n.email == null || n.email.isEmpty()) {
            audit.add("email failed: no address");
            return false;
        }
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
        return true;
    }
}
