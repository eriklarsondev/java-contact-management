public class WorkContact extends Contact {
    private final String company;

    public WorkContact(String fullName, String email, String phoneNumber, String company) {
        super(fullName, email, phoneNumber, Relationship.WORK);
        this.company = company;
    }

    public String company() {
        return company;
    }
}
