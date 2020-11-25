# 목차

- [목차](#목차)
- [1. 용어 정리](#1-용어-정리)
- [2. 스프링 기본 사용 방법](#2-스프링-기본-사용-방법)
  - [2.1. 컨트롤러](#21-컨트롤러)
    - [2.1.1. Controller](#211-controller)
    - [2.1.2. RestController](#212-restcontroller)
    - [2.1.3. 요청(Request)](#213-요청request)
      - [2.1.3.1. PathVariable](#2131-pathvariable)
      - [2.1.3.2. Query String - @RequestParam](#2132-query-string---requestparam)
      - [2.1.3.3. 객체 - @RequestBody](#2133-객체---requestbody)
    - [2.1.4. 응답](#214-응답)
      - [2.1.4.1. 페이지로 응답](#2141-페이지로-응답)
      - [2.1.4.2. 페이지 + 모델](#2142-페이지--모델)
      - [2.1.4.3. 객체로 응답](#2143-객체로-응답)

# 1. 용어 정리

라이브러리 vs 프레임워크  
- 라이브러리: 제어 흐름이 개발자에게 있음
- 프레임워크: 제어 흐름이 프레임워크에 있음

IoC(Inversion of Control)
- 제어 역전

스프링의 역할
- IoC Container
  - Bean: 스프링에서 관리하는 객체. 라이프사이클 존재.
    - Component: 이 어노테이션이 붙으면 스프링이 관리함
      - Controller
      - RestController
      - Service
      - Repository
    - 빈을 등록하는 과정
      - 스프링 프레임워크가 시작되면 등록할 클래스를 탐색해서(xml, Java Config(annotation)) IoC 컨테이너에 등록
    - 기본적으로 싱글톤임
  - DI(Dependency Injection): 의존성을 관리해 줌.
  - AOP(Aspect-Oriented Programming)
    - 횡단 관심사(Cross Concern): 모든 레이어에 걸쳐 공통적으로 사용되는 모듈들
      - 로깅(logging)
      - 퍼포먼스 측정

# 2. 스프링 기본 사용 방법

기본적인 레이어 구성

![1.png](assets/1.png)

- Controller(RestController)
  - 요청과 응답에 대한 처리 수행
  - Controller: 페이지(템플릿 포함)로 응답
  - RestController: RESTful, HTTP API 등의 처리
- Service
  - Infrastructure에 대한 처리
  - 도메인, 레포지토리 통합
- Domain
  - 비즈니스 로직
  - 값 객체(VO, Value Object)
  - 엔티티(Entity)
- Repository
  - 저장과 관련된 인터페이스
  - 인터페이스 구현체

## 2.1. 컨트롤러

이 레이어가 처리하는 일은 다음과 같다.  

- 요청과 응답 처리
  - 페이지로 응답(i.e. `index.mustache`)
  - API 응답(RESTful, HTTP API)

### 2.1.1. Controller

페이지로 응답한다. `View Resolver`에게 뷰 이름(예: `index.mustache`)을 주면 등록된 뷰가 존재하면 이 뷰로 추가적인 처리를 수행 후 응답해줌.  

기본적인 사용 방법

```java
@Controller
@RequestMapping("/path")
public class 컨트롤러모듈이름 {

    // 매핑 어노테이션
    @GetMapping
    public String 메서드이름() {
        return "뷰_이름";
    }
}
```

매핑 어노테이션
- `@-Mapping`의 구조를 가지고 있음
- HTTP Method를 기술해주면 됨
  - GetMapping
  - PostMapping
  - PutMapping
  - ... (HTTP Method 이름들)
- 매핑 어노테이션 최상위: `@RequestMapping`

RequestMapping 어노테이션
- method: HTTP 메소드. RequestMethod enum 타입.  
- value: 경로

경로 지정 방식
- 클래스에 경로가 지정되어 있는 경우
  - 예를들어 클래스에 `/path`가 지정되어 있고
  - 메서드에 `/add`가 지정된 경우
    - 실제로는 uri `/path/add`에 대한 처리를 하게 됨
- 클래스에 경로가 지정되어 있지 않는 경우
  - 메서드에 지정된 경로로 접근

### 2.1.2. RestController

페이지에 한정된 Controller와 달리 다양한 응답을 해줄 수 있음.  

```java
@RestController
@RequestMapping("/path")
public class 컨트롤러모듈이름 {

    // 매핑 어노테이션
    @GetMapping
    public String 메서드이름() {
        return "뷰_이름";
    }
}
```

### 2.1.3. 요청(Request)

#### 2.1.3.1. PathVariable

예를들어 다음과 같은 URI로 요청이 들어옴.  

```text
/users/550e8400-e29b-41d4-a716–446655440000
```

이 경우 다음 코드로 처리 가능

```java
@GetMapping("/{userId}")
public String getUserInfo(@PathVariable String userId) {
    System.out.println(userId);
    return "안녕";
}
```

일반화

```java
@매핑어노테이션("/{메서드파라미터이름}")
public 반환타입 getUserInfo(@PathVariable 타입 메서드파라미터이름) {
    // 코드 작성
    return 알아서하시오;
}
```

#### 2.1.3.2. Query String - @RequestParam

쿼리스트링은 다음과 같은 구조를 가지고 있다.  

```text
/path?key1=value1&key2=value2
```

- URL에 길이 제한이 있기 때문에 쿼리 스트링 또한 길이 제한이 있음.  
- 브라우저에 대놓고 보이기 때문에 민감한 정보는 노출시키면 안됨.  

다음과 같은 요청이 들어왔다고 가정해보자.  

```text
/users?key=할말
```

다음과 같은 코드로 읽을 수 있음.  

```java
@GetMapping
public String getgetget(@RequestParam("key") String value) {
    System.out.println(value);
    return "ㅃㅇ";
}
```

> 참고: RequestParam과 같은 경우 query string, form 데이터 등을 받을 수 있음.  
> 서블릿의 request.getParameter("파라미터이름")과 유사.  

#### 2.1.3.3. 객체 - @RequestBody

대표적으로 JSON 요청을 객체로 변환할 수 있음.  
JSON(Javascript Object Notation) 객체를 문자열로 표현.  

자바스크립트 객체로 사용자 정보를 표현하면 다음과 같다.  
```javascript
const user = {
    name: 'Chiho Won',
    email: 'high.neoul@gmail.com'
}
```

위 자바스크립트 객체는 문자열로 다음과 같이 표현할 수 있음  

```text
"{"name":"Chiho Won","email":"high.neoul@gmail.com"}"
```

이는 자바의 다음에 해당한다.  

```java
public class User {
    private String user;
    private String email;
}
```

이를 처리하기 위한 코드는 다음과 같다.  

우선 User 객체.  

```java
public class User {
	private String name;
	private String email;
	
	public User() {
		
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}	
}
```

컨트롤러는 다음과 같음  

```java
@PostMapping
public String postpost(@RequestBody User user) {
    System.out.println(user);
    return "어 안녕!";
}
```

### 2.1.4. 응답

응답에 대해 정리함..  

#### 2.1.4.1. 페이지로 응답

다음과 같은 조건이 필요하다.  

- `@Controller`
- 메서드에서 뷰 이름 반환

#### 2.1.4.2. 페이지 + 모델

페이지에 모델을 넘겨주어 동적으로 페이지를 그릴 수 있다.  

> 참고: 지정한 템플릿 엔진의 문법을 따라야 함.  

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>사용자 정보 페이지</title>
</head>

<body>
	<h1>이름: {{ name }}</h1>
	<h1>메일: {{ email }}</h1>    
</body>

</html>
```

모델을 넘겨주는 방법은 다음과 같다.  

1. 메서드 파라미터로 Model 넘겨주는 방법
```java
public String userInfo(Model model) {
    model.addAttribute("name", "원치호");
    model.addAttribute("email", "high.neoul@gmail.com");
    return "userView";
}
```

2. ModelAndView 사용하는 방법

```java
@GetMapping("/user-info")
public ModelAndView userInfo() {
    final ModelAndView mv = new ModelAndView();
    // 뷰 네임 설정
    mv.setViewName("userView");
    // 모델 설정
    mv.addObject("name", "원치호");
    mv.addObject("email", "high.neoul@gmail.com");
    return mv;
}
```


#### 2.1.4.3. 객체로 응답

```java
public 반환할객체타입 메서드이름(아무거나) {
    return 객체;    // json
}
```