import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactManager {
    private final Map<String, Contact> contactsByEmail = new LinkedHashMap<>();

    public List<Contact> getContacts() {
        return List.copyOf(contactsByEmail.values());
    }

    public boolean addContact(Contact contact) {
        if (contact == null) return false;
        String key = contact.normalizedEmail();
        if (key == null) return false;
        return contactsByEmail.putIfAbsent(key, contact) == null;
    }

    public boolean removeContact(String email) {
        String key = Contact.normalizeEmail(email);
        return key != null && contactsByEmail.remove(key) != null;
    }
}
