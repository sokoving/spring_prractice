<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>

<body>


    <h1># 게시판</h1>
    <table id="post-table">
        <tr>
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>

        <c:forEach var="p" items="${pl}">
            <tr>
                <td>${p.boardNo}</td>
                <td>${p.writer}</td>
                <td><a href="/board/content?boardNo=${p.boardNo}">${p.title}</a></td>
                <td>${p.regDate}</td>
                <td>${p.viewCnt}</td>
            </tr>
        </c:forEach>

    </table>
    
    <button id="write-btn">새 글 쓰기</button>

    <script>

        const $writeBtn = document.getElementById('write-btn');
        $writeBtn.addEventListener("click", e => {
            location.href = "/board/write"
        })


    </script>


</body>

</html>