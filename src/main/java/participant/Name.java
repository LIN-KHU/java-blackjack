package participant;

public class Name {

    private String name;

    public Name(String name) {
        String trimmedName = name.trim();
        IsNameEmpty(name);
        this.name = name;
    }

    private void IsNameEmpty(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("이름 빈칸 불가");
        }
    }

    public String getName() {
        return this.name;
    }

}
