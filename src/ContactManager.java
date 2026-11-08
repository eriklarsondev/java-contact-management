import java.util.ArrayList;

public class ContactManager {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    public void addContact(Contact contact) {
        if (contact == null) return;
        String key = contact.email();
        if (key == null) return;
        if (containsEmail(key)) return;
        contacts.add(contact);
    }

    public void removeContact(String email) {
        String key = Contact.normalizeEmail(email);
        if (key == null) return;
        contacts.removeIf(contact -> key.equals(contact.email()));
    }

    private boolean containsEmail(String normalizedEmail) {
        for (Contact contact : contacts) {
            if (normalizedEmail.equals(contact.email())) {
                return true;
            }
        }
        return false;
    }
}
