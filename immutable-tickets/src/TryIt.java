import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Starter demo that shows why mutability is risky.
 *
 * After refactor:
 * - direct mutation should not compile (no setters)
 * - external modifications to tags should not affect the ticket
 * - service "updates" should return a NEW ticket instance
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        // 1. Create ticket using Builder (through service)
        IncidentTicket original = service.createTicket(
                "TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created : " + original);

        // 2. "Update" by assigning — returns a NEW instance
        IncidentTicket assigned = service.assign(original, "agent@example.com");
        System.out.println("\nAssigned (new)   : " + assigned);
        System.out.println("Original (same)  : " + original);

        // 3. Escalate — returns yet another NEW instance
        IncidentTicket escalated = service.escalateToCritical(assigned);
        System.out.println("\nEscalated (new)  : " + escalated);
        System.out.println("Assigned  (same) : " + assigned);

        // 4. Try to mutate tags from outside — should be blocked
        List<String> tags = escalated.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("\n*** BUG: external mutation succeeded ***");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nExternal tag mutation blocked (immutable list).");
        }

        // 5. Build a ticket directly with the Builder
        IncidentTicket custom = new IncidentTicket.Builder("INC-42", "user@corp.io", "Dashboard slow")
                .description("Loads in 12 s instead of 2 s")
                .priority("HIGH")
                .slaMinutes(60)
                .source("WEBHOOK")
                .customerVisible(true)
                .addTag("PERFORMANCE")
                .addTag("FRONTEND")
                .build();
        System.out.println("\nCustom ticket    : " + custom);
    }
}
