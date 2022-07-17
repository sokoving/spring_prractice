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


    <h1>새 글 쓰기</h1>
    <form action="/board/write" method="post">
        <label>
            # 작성자 : <input type="text" name="writer" placeholder="이름">
        </label>
        <label>
            # 글 제목 : <input type="text" name="title" placeholder="제목">
        </label>
        <label class="content-wrap">
            # 글 내용
            <textarea name="content" cols="40" rows="10" placeholder="내용을 입력해 주세요. "></textarea>
        </label>

        <div id="btn-wrap">
            <button type="submit" id="write-btn">등록</button>
            <button type="button" id="list-btn">취소</button>
        </div>
    </form>

    <script>
        const $btn = document.getElementById('btn-wrap');
        $btn.addEventListener('click', e => {
            if (!e.target.matches('button')) {
                return;
            } 
             // 취소하고 목록 가기
            else if (e.target.matches('#remove-btn')) {
                if (confirm('글 등록을 취소하고 목록으로 갑니다. ')) {
                    location.href = "/board/list";
                }
            }
        });
    </script>
</body>

</html>