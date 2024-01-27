package domain;

public class Card {
    private String pattern;
    private String mark;
    private int number;

    Card(String pattern, String mark, int number) {
        this.pattern = pattern;
        this.mark = mark;
        this.number = number;
    }

    Card(String pattern, int index) {
        this.pattern = pattern;
        this.mark = indexToMark(index);
        this.number = indexToNumber(index);
    }

    private String indexToMark(int index) {
        if (number == 1) {
            return "A";
        }
        if (number == 11) {
            return "J";
        }
        if (number == 12) {
            return "Q";
        }
        if (number == 13) {
            return "K";
        }
        return String.valueOf(index);
    }

    private int indexToNumber(int index) {
        if (index > 10) return 10;
        return number;
    }

}
