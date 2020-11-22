<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
    <style>
        body {
            margin: 10px;
        }

        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>

<body>
<div class="layui-container">
    <!--
作者：yuton.yao@qq.com
时间：2017-09-01
描述：引入公共html
-->
    <div class="cnzz" style="display: none;">
        <script src="http://s95.cnzz.com/stat.php?id=1253551100&web_id=1253551100" language="JavaScript"></script>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
    layui.use(['element', 'jquery'], function () {
        var element = layui.element,
            $ = layui.jquery;
    });
</script>
</body>

</html>