public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        manager.addContact(new PersonalContact(
                "Ada Lovelace", "ada@example.com", "555-0101", Contact.Relationship.FRIEND));
        manager.addContact(new PersonalContact(
                "Grace Hopper", "grace@example.com", "555-0102", Contact.Relationship.FAMILY));
        manager.addContact(new WorkContact(
                "Alan Turing", "alan@example.com", "555-0103", "Bletchley Park"));

        System.out.println("=== all contacts ===");
        printAll(manager);

        System.out.println("\n=== duplicates are rejected ===");
        manager.addContact(new PersonalContact(
                "Ada L.", "ada@example.com", "555-9999", Contact.Relationship.WORK));
        System.out.println("after same email:     " + manager.getContacts().size());
        manager.addContact(new PersonalContact(
                "Ada L.", "ADA@Example.com", "555-9999", Contact.Relationship.WORK));
        System.out.println("after different case: " + manager.getContacts().size());
        manager.addContact(new PersonalContact(
                "Nobody", "   ", "555-0000", Contact.Relationship.OTHER));
        System.out.println("after blank email:    " + manager.getContacts().size());

        System.out.println("\n=== removal ===");
        manager.removeContact("GRACE@EXAMPLE.COM");
        System.out.println("after GRACE@EXAMPLE.COM: " + manager.getContacts().size());
        manager.removeContact("grace@example.com");
        System.out.println("after again:             " + manager.getContacts().size());

        System.out.println("\n=== remaining ===");
        printAll(manager);
    }

    private static void printAll(ContactManager manager) {
        for (Contact contact : manager.getContacts()) {
            System.out.printf("%-14s %-20s %-10s %s%n",
                    contact.fullName(),
                    contact.email(),
                    contact.phoneNumber(),
                    describe(contact));
        }
    }

    private static String describe(Contact contact) {
        String label = switch (contact.relationship()) {
            case FAMILY -> "family";
            case FRIEND -> "friend";
            case WORK -> "colleague";
            case OTHER -> "other";
        };

        if (contact instanceof WorkContact work) {
            return label + " at " + work.company();
        }
        return label;
    }
}
