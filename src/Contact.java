import java.util.Locale;

public abstract class Contact {
    private final String fullName;
    private final String email;
    private final String phoneNumber;
    private final Relationship relationship;

    public Contact(String fullName, String email, String phoneNumber, Relationship relationship) {
        this.fullName = fullName;
        this.email = normalizeEmail(email);
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
    }

    public String fullName() {
        return fullName;
    }

    public String email() {
        return email;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public Relationship relationship() {
        return relationship;
    }

    public static String normalizeEmail(String email) {
        if (email == null) return null;
        String trimmed = email.trim().toLowerCase(Locale.ROOT);
        return trimmed.isEmpty() ? null : trimmed;
    }

    public enum Relationship {
        FAMILY, FRIEND, WORK, OTHER
    }
}
