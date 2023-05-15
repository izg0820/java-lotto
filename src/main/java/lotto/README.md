# 로또(자동)

### 기능구현 목록
- [x] 문자열 split 후 lotto 객체 생성 - 단위테스트 가능
  - [x] 숫자가 6개인지 검증
- [x] 맞는 숫자가 몇개 있는지 확인 - 단위테스트 가능
- [X] 수익률 계산 - 단위테스트 가능
- [x] 번호 자동 생성 - 랜덤은 단위테스트 힘듬...
- [x] Input에 따라 로또 자동 생성
   - 단위테스트를 하기위해서 size 메소드를 추가하는게 맞을까...? 
- [x] 1등번호 Lotto 객체로 변경
- [x] inputView 객체 
   - [x] null혹은 ""인지 검증 -> input 객체 책임
- [x] ResultView 객체 - 단위테스트 가능
   - [x] 몇개의 당첨이 있는지 출력
- [x] 보너스 번호 구현
- [x] LottoPurchase 객체 추가 - 구입관련 책임 (자동 몇개, 수동 몇개...)
- [ ] 수동 입력받기 - LottoNumberCache, ManualLottoGenerator 이용