# Java Contact Management

A small Java exercise: a contact list built from a `Contact` base class with `PersonalContact` and `WorkContact` subclasses. Each contact normalizes its email on construction (trimmed, lowercased), and `ContactManager` compares those normalized addresses so duplicate and blank emails are rejected.

### Running

```
javac -d out/production/java-contact-management src/*.java
java -cp out/production/java-contact-management Main
```
