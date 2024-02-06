package constants;

public enum Result {
    PLAYER_WIN("승"),
    PLAYER_LOSE("패"),
    BUST("패"),
    PUSH("무승부");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
