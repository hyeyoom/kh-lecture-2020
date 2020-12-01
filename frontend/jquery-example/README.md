# Intro.

jQuery가 하는 일은 크게 다음과 같음.  

- DOM 제어
- 이벤트 핸들링
- Ajax

이 중에서 ajax만 간단하게 다뤄보자.  

# 1. Ajax

`A`synchronous `J`avascript `A`nd `X`ML의 acronym이다.  
최신 자바스크립트에서는 ajax를 위해서 `fetch API`를 제공하며 다음 문서를 참고하자.  

- [https://developer.mozilla.org/ko/docs/Web/API/Fetch_API](https://developer.mozilla.org/ko/docs/Web/API/Fetch_API)
- [https://developer.mozilla.org/ko/docs/Web/API/Fetch_API/Fetch%EC%9D%98_%EC%82%AC%EC%9A%A9%EB%B2%95](https://developer.mozilla.org/ko/docs/Web/API/Fetch_API/Fetch%EC%9D%98_%EC%82%AC%EC%9A%A9%EB%B2%95)

하지만 이건 jquery 문서니까 jquery를 다뤄보자.  

[HTTP method](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods)에 대해서는 이미 한 차례 다루었으므로 설명은 생략한다.  

테스트를 위해 Fake API를 사용해보자.  

[https://jsonplaceholder.typicode.com/](https://jsonplaceholder.typicode.com/)

Routes 항목을 보면 다음과 같은 리스트가 나온다.  


- GET	/posts
- GET	/posts/1
- GET	/posts/1/comments
- GET	/comments?postId=1
- POST	/posts
- PUT	/posts/1
- PATCH	/posts/1
- DELETE /posts/1

HTTP 메서드와 URI로 구분되어 있다. 여기서 볼만한 API는 다음과 같다.  

- 포스트 목록: GET /posts
- 특정 포스트: GET /posts/1
- 특정 포스트의 댓글 목록: /posts/1/comments
- 특정 포스트의 댓글 목록: /comments?postId=1

특정 포스트의 댓글 목록이 두 개인데 첫 번째는 `REST` 스타일의 API고, 두 번째는 고전적인 HTTP API 스타일이다.  

포스트 목록을 가져와보자.  

```javascript
$.get("https://jsonplaceholder.typicode.com/posts", data => console.log(data))
```

그리고 크롬 개발자 도구를 열어 콘솔 탭에서 확인해보자.  

특정 포스트를 열어보는 것도 동일하다.  

```javascript
$.get("https://jsonplaceholder.typicode.com/posts/1", data => console.log(data))
```

이를 이용해 간단한 블로그 페이지를 만들어보자.  

