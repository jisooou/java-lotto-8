# java-lotto-precourse

---
## **3주차 로또**

---

### **📂 프로젝트 디렉터리 구조** ###
```
src
└── main
    └── java
        └── lotto
            ├── Application.java  # 프로젝트 진입점 (main)
            │
            ├── controller
            │   └── LottoController.java  # 입력 -> service 로직 -> 출력 
            │
            ├── exception
            │   └── ErrorCode.java  # 예외 메시지 처리 
            │
            ├── model
            │   ├── Lotto.java  # 한 장의 로또 (6개)
            │   ├── LottoNumber.java  # 로또 번호 (개별)
            │   ├── BonusNumber.java  # 보너스 번호
            │   ├── PurchasePrice.java  # 구매 금액
            │   ├── WinnerNumber.java  # 당첨 번호
            │   └── Statistics.java  # 당첨 결과
            │
            ├── service
            │   └── LottoService.java  # 로또 발행, 일치 검사, 통계, 수익률 계산 로직
            │
            ├── util
            │   └── ConvertToNumber.java  # 입력값 문자열 변환 유틸리티
            │
            └── view
                ├── InputView.java  # 사용자 입력
                └── OutputView.java  # 결과 출력
```
---
### **🔖 Model** 

#### **1. LottoNumber**

- 로또 번호 : 1~45

  ☑️로또 번호는 범위가 1~45 숫자여야 한다.


#### **2. Lotto**

- 6개의 숫자로 이루어져 있는 1개의 로또이다.

  ☑️로또 번호는 6개여야 한다.

  ☑️로또 번호는 중복될 수 없다.


#### **3. BonusNumber**

- 사용자로부터 입력받는 1개의 보너스 숫자이다.

  ☑️보너스 번호는 범위가 1~45 숫자여야 한다.

  ☑️보너스 번호와 로또 번호는 중복될 수 없다.


#### **4. PurchasePrice**

- 사용자로부터 입력받는 로또 구매 금액이다.

  ☑️금액은 1000원 단위이다.

  ☑️금액은 숫자여야 한다.


#### **5. WinnerNumber**

- 당첨된 로또 번호 6개를 보관한다.

  ☑️로또 번호는 범위가 1~45 숫자여야 한다.

  ☑️로또 번호는 중복될 수 없다.


#### **6. Statistics**

- 당첨 결과(출력값)를 Enum으로 관리한다.
  - 몇 개가 일치하는지 알아야 한다. (일치 개수)
  - 가격을 알아야 한다. (상금)
  - 보너스 볼과 일치하는지 알아야 한다. (보너스 일치 여부)

---

### **⛔️ Exception**

#### ErrorCode

- ERROR로 시작하는 예외 메시지를 Enum으로 관리한다.

---

### **💡 Service**

- 로또 발행을 관리한다.
- 하나의 로또 내에 일치하는 로또 번호의 개수와 보너스 번호의 일치 여부를 관리한다.
- 모든 로또의 당첨 통계를 관리한다.
- 수익률을 관리한다.

---

### **🖥️ View**

#### **InputView**

- 구입 금액을 입력받는다.
- 당첨 번호를 입력받는다.
- 보너스 번호를 입력받는다.

#### **OutputView**

- 구매한 로또 개수를 출력한다.
- 구매한 로또 번호를 출력한다.
  - 로또 번호는 오름차순으로 출력된다.
- 당첨 통계를 출력한다.
  - n개 일치하는 것이 몇 개인지 출력한다.
- 수익률을 출력한다.
  - 소수점 둘째 자리에서 반올림한다.

---

### **⚙️ Controller**

#### **LottoController**

- InputView을 통해 입력을 받는다.
- LottoService를 통해 로직을 수행한다.
- OutputView를 통해 출력을 한다.
- 예외가 발생하면 재입력을 요구한다.

---

### **🛠️ Util**

#### **ConvertToNumber**

- 쉼표로 구분되어 있는 문자열(입력값)을 List<Integer>로 변환해 준다.

---