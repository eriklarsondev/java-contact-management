import java.util.Locale;

public interface Contact {
    String fullName();
    String email();
    String phoneNumber();
    Relationship relationship();

    default String normalizedEmail() {
        return normalizeEmail(email());
    }

    static String normalizeEmail(String email) {
        if (email == null) return null;
        String trimmed = email.trim().toLowerCase(Locale.ROOT);
        return trimmed.isEmpty() ? null : trimmed;
    }

    enum Relationship {
        FAMILY, FRIEND, WORK, OTHER
    }
}
