package domain;

public class Name {
	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("1자 이상의 이름을 입력해주세요.");
		}
	}
}
