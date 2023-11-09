# MyTodo

## 완성 예제
![myTodo](https://github.com/unso99/MyTodo/assets/94777814/5cece770-bdb8-40a0-b5a3-d5c6abf17eea)


## 이 프로젝트에서 사용한 기술
- [MVVM](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EB%B7%B0%EB%AA%A8%EB%8D%B8)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=ko)
- [Coroutine](https://developer.android.com/kotlin/coroutines?hl=ko)
- [Flow](https://developer.android.com/kotlin/flow?hl=ko)
- [Room](https://developer.android.com/training/data-storage/room?hl=ko)
- [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters?hl=ko)

## 프로젝트의 목적
- 비동기 처리를 위해 Coroutine과 Flow를 활용
- 의존성 주입(DI)을 위해 Hilt를 사용
- Room DB 활용
- MVVM 패턴과 BindingAdapter 활용

## 프로젝트를 하면서 느낀점
- Corutine을 사용해서 비동기처리를 진행보았다. RxJava와 비교를 해보면 훨씬 가독성이 좋고 사용하기에는 쉬웠다. 하지만 아직 익숙하지 않아서 앞으로는 비동기 처리를 할때 Corutine을 활용해서 해야겠다.
- DI를 사용하기위해서 Hilt 라이브러리를 사용해보았다. Hilt를 사용해보면서 사실 어려웠다. 작은 프로젝트일 수록 DI를 사용하는 것은 오히려 코드를 보기 어렵게 만든다고는 하지만 큰 프로젝트일 수록 DI를 사용했을 때의 장점인 클라이언트 테스트 용이, 결합도 낮음, 유지보수 용이 등을 무시할 수 없다고 생각한다.
- DI에 대한 공부와 Hilt의 사용법을 좀 더 공부해보며 다음 프로젝트에 적용시켜볼 예정이다.
- Room DB는 이전에도 활용을 해봤지만 DI를 적용시키며 각각의 필요한 module을 만들어서 해보니 쉽지 않았다.
- 이번 프로젝트에서도 MVVM 패턴을 활용해봤는데 확실히 계속 사용을 해보니 전보다는 쉽게 틀이 짜지는 거 같았다. 그래도 아직 미숙하기에 더 공부가 필요하다.
