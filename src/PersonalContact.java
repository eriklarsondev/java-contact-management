public record PersonalContact(
        String fullName,
        String email,
        String phoneNumber,
        Relationship relationship) implements Contact {
}
