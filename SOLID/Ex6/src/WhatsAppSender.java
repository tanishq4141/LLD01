
public class WhatsAppSender extends NotificationSender {

    public WhatsAppSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public boolean send(Notification n) {

        //  // LSP violation: tightens precondition
        // if (n.phone == null || !n.phone.startsWith("+")) {
        //     throw new IllegalArgumentException("phone must start with + and country code");
        // }


        if (n.phone == null || !n.phone.startsWith("+")) {
            System.out.println("WA ERROR: phone must start with + and country code");
            audit.add("WA failed");
            return false;
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
        return true;
    }
}
