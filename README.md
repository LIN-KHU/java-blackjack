# 기능 목록

<hr>

## view

- [ ] 입력
  - [ ] 플레이어 목록 입력 
  - [ ] 플레이어가 카드를 받을지 여부(y/n) 입력
    - [ ] y 또는 n인지 검증

- [ ] 출력
  - [ ] 플레이어 이름 입력하기 문구
  - [ ] 게임 시작 시 카드 2장 배분에 대한 문구
  - [ ] 참여자 카드 리스트 내의 카드 출력 (jason카드: 7클로버, K스페이드)
  - [ ] 플레이어가 카드를 받을지 여부(y/n) 묻는 문구
  - [ ] 딜러 카드 추가적으로 받았을 때 문구
  - [ ] 카드 점수 계산 결과 출력
  - [ ] 최종 승패 결과 출력

<hr>

## domain

### participant

- [x] 참가자(클래스)

- [x] 플레이어(참가자 상속)

- [x] 딜러(참가자 상속)

- [ ] 이름: 참가자의 필드

- [ ] 이름 검증

- [x] 카드 리스트: 딜러와 플레이어가 배분 받은 카드들 담는 리스트

### carddeck

- [x] 카드 심볼(하트~스페이드)

- [x] 카드 랭크(랭크(에이스~잭,퀸,킹)와 숫자 값)

- [x] 카드: 심볼(하트, 스페이드, 다이아몬드, 클로버)과 랭크(에이스~킹) 조합으로 이루어진 카드

- [x] 카드덱: 52가지 카드 담고 있는 하나의 카드덱
  - [x] 카드덱에서 카드 추출하여 반환


### 비즈니스 로직

- [x] 블랙잭: 카드덱 생성, 참가자에 카드 배분

- [x] 카드 점수 계산

- [x] 딜러 승리 채크

<hr>

## controller

- [ ] 게임 매니저
  - [ ] 게임 시작
    - [ ] 참가자 생성
    - [ ] 블랙잭 게임 시작
    - [ ] 점수 계산 결과 출력
    - [ ] 최종 승패 결과 출력