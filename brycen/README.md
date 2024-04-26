# CONVENTION

### 주석
주석은 서버주석을 사용하도록 한다 <!--/* 주석 */-->
  브라우저 개발자도구에 주석이 노출되는 것을 방지하기 위함
  README.md 파일 참조

### HTML / JS 코드 분리
화면 또는 비즈니스의 복잡도가 올라가면 코드 보기가 어려움
떄문에 화면(HTML)과 기능(JS)을 페이지상 분리

``` jscript
  <html
  lagn="ko"
  xmlns:th="http://www.thymeleaf.org" 
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
>
<head>
    <meta charset="UTF-8" />
    <!--/* css / jquery 를 관리하는 환경 영역[S] */-->
      <!--/* @{/css/common.css} 는 /src/main/resources/static 하위를 가리킴 */-->
      <link th:inline="css" th:href="@{/css/common.css}" rel="stylesheet"/>
      <!--/* jQuery CDN을 통해 jQuery 라이브러리 추가 */-->
      <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <!--/* css / jquery 를 관리하는 환경 영역[E] */-->
</head>
<body>
  <div th:replace="~{fragments/header::headerFragment}"></div>

  <th:block layout:fragment="content"></th:block>

  <div th:replace="~{fragments/footer::footerFragment}"></div>
</body>
</html>

<!-- HTML 과 script 분리 -->
<script th:src="@{/js/test.js}"></script>
<!-- jQuery 로드 후에 init 함수 호출 -->
<script>
    /* 
        jquery 사용 의미는 서버에서 렌더링 되어있는 데이터를 단순 삭제 / 수정과 같은 DOM을 조작함을 의미
        때문에 서버에서 처리되어 내려오는 변수(여기서는 activeProfile)를 init 함수에 전달하는 것은 사용하지 않도록 한다
     */
    $(document).ready(function() {
        // test.js 에 선언된 init 함수 호출
        init();
    });
</script>

<!-- test.js -->

// 메서드들 정의
const init = (() => {
  $('#content').on('click', function() {
      alert('!');
  })
})
```

## 사용 라이브러리
1) [Thymleaf](https://www.thymeleaf.org/) 
2) [jquery CDN](https://code.jquery.com/jquery-latest.min.js)

## 