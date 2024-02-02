package blackjack;

//public class Card {
//
//    private final Shape shape; // 카드의 모양을 enum으로 관리
//    private final CardNumber carNumber // 카드 숫자를 값 객체로 포장해서 관리
//
//}

enum Shape {
    HEARTS("하트"),
    SPADES("스페이드"),
    DIAMONDS("다이아몬드"),
    CLUBS("클로버");

    private String shape;

    Shape(String shape){
        this.shape = shape;
    }
}

