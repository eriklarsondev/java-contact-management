public record WorkContact(
        String fullName,
        String email,
        String phoneNumber,
        String company) implements Contact {

    @Override
    public Relationship relationship() {
        return Relationship.WORK;
    }
}
