# 기능 목록

<hr>

## view

### inputView

- [ ] 입력
  - [x] 플레이어 목록 입력 
  - [ ] 플레이어가 카드를 받을지 여부(y/n) 입력

### outputView

- [ ] 출력
  - [x] 플레이어 이름 입력하기 문구
  - [ ] 게임 시작 시 카드 2장 배분에 대한 문구
  - [ ] 플레이어가 카드를 받을지 여부(y/n) 묻는 문구
  - [ ] 참여자 카드 리스트 내의 카드 출력 (jason카드: 7클로버, K스페이드)
  - [ ] 딜러 카드 추가적으로 받았을 때 문구

- [ ] 결과 출력
  - [ ] 점수 계산 결과 출력
  - [ ] 최종 승패 출력

<hr>

## domain

- [x] 참가자(클래스)

- [x] 플레이어(참가자 상속)

- [x] 플레이어 리스트
  - [x] 플레이어 이름 목록 받아서 플레이어 리스트 생성 
  - [x] 플레이어 이름 중복 예외처리
  - [x] 플레이어 리스트 반환

- [x] 딜러(참가자 상속)

- [ ] 참가자 리스트: 딜러와 플레이어 리스트 함께 저장하는 리스트

- [ ] 카드 배분
  - [ ] 게임 시작 시 카드 2장 씩 참가자들에 카드덱에서 추출하여 배분
  - [ ] 플레이어에 카드 1장 카드덱에서 추출하여 배분
  - [ ] 딜러에 카드 1장 카드덱에서 추출하여 배분

- [ ] 참가자 카드 리스트: 딜러와 플레이어가 배분 받은 카드들 담는 리스트
  - [ ] 카드 리스트에 카드 추가

- [x] 카드 심볼 상수(하트~스페이드)

- [x] 카드 숫자 상수(에이스~잭,퀸,킹)

- [x] 카드: 심볼(하트, 스페이드, 다이아몬드, 클로버)과 숫자(에이스~킹) 조합으로 이루어진 카드

- [x] 카드덱: 52가지 카드 담고 있는 하나의 카드덱
  - [x] 카드덱에서 카드 추출하여 반환

- [ ] 점수 계산
  - [ ] 카드 리스트에 있는 카드에 대해 최종 점수 계산하여 반환

- [ ] 최종 승패 판단
  - [ ] 참여자들 최종 승패

<hr>

## controller

- [ ] 게임 매니저
  - [ ] 게임 시작
    - [ ] 참가자 생성
    - [ ] 카드 배분
    - [ ] 점수 계산 결과 출력
    - [ ] 최종 승패 결과 출력
  - [ ] 참가자 생성
    - [ ] 플레이어 이름 입력 받기
    - [ ] 플레이어 리스트 생성
      - [ ] 플레이어 생성
    - [ ] 딜러 생성
  - [ ] 카드 배분
    - [ ] 플레이어들에게 카드 추가 여부 묻기 (모든 플레이어에 대해, 각 플레이어 그만 추가할 때까지)
    - [ ] 딜러 카드 합 16이하 시 카드 추가
