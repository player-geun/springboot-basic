# SpringBoot Basic Weekly Mission
스프링부트 basic 위클리미션을 코드리뷰하는 Repository입니다.

## 🧑‍🏫 미션 제출 후 코드 리뷰 결과
📌 [Part 1](https://github.com/prgrms-be-devcourse/springboot-basic/pull/648)
<br>
📌 [Part 2](https://github.com/prgrms-be-devcourse/springboot-basic/pull/724)

<br>

## 📚 배운 점
### 도메인의 의존 관계 최소화

도메인은 가장 상위 컴포넌트로써 하위 컴포넌트에 대한 의존성을 가지고 있으면 안됩니다. 이 과정에서 도메인에 대한 의존성을 최소화하기 위해 toString() 에 대한 재정의를 고민할 수 있었습니다.

바우처를 콘솔에 찍거나 파일로 저장할 때, 도메인을 문자열로 변환해야 하는 요구사항이 발생합니다. 이때 toString 을 뷰 로직이나 파일 저장 형식에 의존되지 않도록 설계하였습니다.하지만 이 과정에서 toString() 을 로그에 찍기위해 재정의한다고 판단하면, 재정의가 가능하다는 것을 피드백 받았습니다.

결국 이 과정을 통해 자신의 구현과 설계에 근거가 중요하다는 것을 느꼈고, 상황에 따라 다른 정답이 존재한다는 것을 알 수 있었습니다.

<br>

### 변경의 전파를 최소화할 수 있도록 설계

각각의 도메인 마다 별도의 레이어들을 구축하고, 각 레이어들의 책임을 명확히 구분하였습니다. 

기존의 Presentation 레이어의 콘솔 컨트롤러를 타임리프 컨트롤러로 변경하면서, 각 레이어의 책임을 명확히 구분하는 것이 중요한 것을 배울 수 있었습니다. 각 레이어의 책임을 명확하게 하지 않았다면, Presentation 레이어를 변경할 때 많은 레이어들을 변경해야 했을 것이기 때문입니다. 

저는 dto 를 통해 입출력 데이터를 일관성있게 가져가여, application 로직을 건들이지 않고 presentation 레이어만 수정하여 프로그램의 입출력 방식을 변경할 수 있었습니다.

<br>

### 바우처 정책에 추상화를 통한 DI를 적용하여, 변경과 확장에 열려있도록 설계

현재 요구사항에서 바우처 정책은 2개이지만, 충분히 더 확장 가능하다고 생각했습니다. 따라서 해당 지점은 확장이 편하게 설계하는 것이 중요하다고 판단하여 DI 를 적용하였습니다.

바우처 정책을 추상화한 인터페이스를 선언하여, 향후 구현체가 새로 바뀌더라도 의존성 주입 부분만 변경해준다면 더 이상 코드 수정을 하지 않아도 됩니다.

<br>

### 테스트를 슬라이싱하여 보다 독립적이고 가벼운 테스트 구현

처음에는 @SpringBootTest 를 통해서 테스트를 진행했습니다.  멘토님들이 이 부분에 대해 실무에서는 실제 운영 중인 거대한 스프링 컨테이너를 띄우고 테스트를 진행한다면, 다양한 모듈이 섞여서 작동하여 예상하기 어려운 에러들도 많이 발생한다고 피드백 주셨습니다.

따라서 해당 레이어의 빈들만 슬라이스 하여 테스트할 수 있는 방법에 대해서 학습하였고 이를 presentation 레이어에 적용하였습니다.


<br>

## 📌 더 고민하면 좋을 점

테스트도 결국 유지보수를 해야 하는 비용인데, 상황에 따라 적절한 테스트 범위에 대해서 고민해보자.
