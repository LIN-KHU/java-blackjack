package participant;

public class Name {

    private String name;

    public Name(String name) {
        String trimmedName = name.trim();
        IsNameEqualsDealer(name);
        IsNameEmpty(name);
        this.name = name;
    }

    private void IsNameEqualsDealer(String name) {
        if (name.equals("딜러")) {
            throw new IllegalArgumentException("딜러 이름 사용 불가");
        }
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
