<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        label {
            display: block;
        }

        textarea {
            display: block;
            padding: 5px;
        }

        .content-wrap {
            margin: 10px 0;
        }
    </style>

</head>

<body>


    <h1>${p.boardNo}번 게시글</h1>
    <form action="#">
        <label>
            # 작성자 : <input type="text" name="writer" value="${p.writer}" disabled>
        </label>
        <label>
            # 글 제목 : <input type="text" name="title" value="${p.title}" disabled>
        </label>
        <label class="content-wrap">
            # 글 내용
            <textarea name="content" cols="40" rows="10" disabled>${p.content}</textarea>
        </label>

        <div id="btn-wrap">
            <button type="button" id="modi-btn">수정</button>
            <button type="button" id="list-btn">목록</button>
            <button type="button" id="remove-btn">삭제</button>
        </div>
    </form>


    <ul>
        <li>
            <form action="/comment/save" method="post">
                <input type="text" name = "boardNo" value="${p.boardNo}" hidden >
                <input type="text" name = "commentWriter" placeholder="댓글 작성자 이름">
                <input type="text" name = "commentContent" placeholder="댓글 내용">
                <button type="submit" id="comment-save-btn">등록</button>
            </form>
        </li>
        <c:forEach var="c" items="${cl}">
            <li>${c.commentWriter} : ${c.commentContent}
                <button type="button" id="comment-remove-btn">삭제</button>
            </li>
        </c:forEach>
    </ul>



    <script>


        // 본문 버튼 (수정, 목록, 삭제)
        const $btn = document.getElementById('btn-wrap');
        $btn.addEventListener('click', e => {
            if (!e.target.matches('button')) {
                return;
            }
            // 수정 화면 요청
            else if (e.target.matches('#modi-btn')) {
                location.href = "/board/modify?boardNo=${p.boardNo}"
            }
            // 목록으로
            else if (e.target.matches('#list-btn')) {
                location.href = "/board/list";
            }
            // 삭제
            else if (e.target.matches('#remove-btn')) {
                if (confirm('정말로 삭제할까요??')) {
                    location.href = "/board/delete/?boardNo=${p.boardNo}"
                }
            }
        });
    </script>
</body>

</html>