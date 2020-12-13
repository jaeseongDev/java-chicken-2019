# java-chicken-2019

## 기능 구현 목록
### 메인 화면
- [x] 메인화면 출력하기
- [x] 원하는 기능 입력받기
    - [x] [예외처리] 기능에 없는 값을 입력하면 안 된다.
- [x] 입력받은 기능을 실행시키기
- [ ] 각 기능이 끝날 경우 메인화면으로 다시 돌아오도록 하기
- [ ] 주문 혹은 결제가 불가능한 경우 그 이유를 보여주고, 다시 주문 혹은 결제가 가능하도록 해야 한다. 

### 주문 등록
- [x] 테이블 목록 출력하기
    - [ ] 주문이 등록된 테이블에는 별도의 표시(₩)해서 출력하기
- [x] 테이블 번호 입력받기
    - [x] [예외처리] 테이블 목록에 있는 번호가 아닌 값을 입력하면 안 된다. 
- [x] 메뉴 리스트 출력
- [x] 등록할 메뉴 입력받기
    - [x] [예외처리] 메뉴 리스트에 없는 번호를 입력하면 안 된다. 
- [ ] 메뉴 수량 입력받기
    - [ ] [예외처리] 숫자만 입력해야 한다. 
    - [ ] [예외처리] 1 이상 99 이하의 숫자만 입력해야 한다.
 

### 결제 하기
- [ ] 결제할 테이블 입력 받기
    - [ ] [예외처리] 테이블 목록에서 별도의 표시(₩)가 된 번호 이외의 번호는 입력하면 안 된다. 
- [ ] 주문 내역 출력하기
- [ ] 결제 방법 입력 받기
    - [ ] [예외처리] 1, 2 이외의 값을 입력하면 안 된다. 
- [ ] 최종 결제할 금액 출력
    - [ ] 현금 결제일 경우, 전체 금액에서 5% 할인
    - [ ] 치킨 10개당 10,000원 할인 (10개 10,000원 할인 / 20개 20,000원 할인 ...)
    
