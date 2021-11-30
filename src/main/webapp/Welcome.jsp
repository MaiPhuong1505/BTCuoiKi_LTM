<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <div class="form-input">
            <form class="form-input-number" action="/CK_LTM/Welcome" method="post">
                <input type="text" class="input" name="number">
                <input type="button" class="submit-button" value="Tính">
            </form>
        </div>
        <div class="history">
            <!-- hiện số đã nhập -->
        </div>
    </body>
    <script>
        const form = document.querySelector('.form-input-number');
        form.addEventListener('submit', (e) => {
            let val = document.querySelector('.input').value;
            val = Number(val);
            if (!Number.isInteger(val)) {
                alert("Mời bạn nhập lại !");
                document.querySelector('.input').value = "";
                e.preventDefault();
            }
        })
    </script>

    </html>