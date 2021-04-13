<%--
  Created by IntelliJ IDEA.
  User: liyawei
  Date: 2021/4/13
  Time: 下午7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script>

    function btnClick() {
      const xmlHttp = new XMLHttpRequest();
      var result;
      xmlHttp.onreadystatechange = function (){
        if (xmlHttp.status == 200 && xmlHttp.readyState == 4)
        {
          alert(xmlHttp.responseText)
        }
      }

      xmlHttp.open("post", "/hello?username=李亚伟", true);
      xmlHttp.send();
    }
  </script>
</head>
<body>
<h1>HelloWorld!</h1>

<form action="/hello" method="get">
  <input type="text" name="username"><br>
  <input type="submit" value="提交">
</form>

<input type="button" onclick="btnClick()" value="获取">

</body>
</html>
