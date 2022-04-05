<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>复查单详情</title>
</head>

<body>
<div class="layui-container">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
    <style>
        body {
            margin: 10px;
        }
    </style>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
                <a href="${pageContext.request.contextPath}/admin/checkOrder/index">复查单列表</a>
                <a><cite>复查单详情</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="javascript:location.reload()" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
            <a class="layui-btn layui-btn-danger" role="button"
               style="margin-right: 10px;float: right"
               href="${pageContext.request.contextPath}/admin/checkOrder/index">返回上一级</a>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <div class="layui-input-inline layui-col-md8" style="width:350px;">
                <label class="layui-form-label">复查医院：</label>
                <label class="layui-form-label">${checkOrderVO.hospital}</label>
            </div>
            <div class="layui-input-inline layui-col-md8" style="width:350px;">
                <label class="layui-form-label">复查日期：</label>
                <label class="layui-form-label">${checkOrderVO.dateTime}</label>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <div class="layui-input-inline layui-col-md8" style="width:350px;">
                <label class="layui-form-label">医保报销：</label>
                <label class="layui-form-label">${checkOrderVO.fd_gov}</label>
            </div>
            <div class="layui-input-inline layui-col-md8" style="width:350px;">
                <label class="layui-form-label">个人自费：</label>
                <label class="layui-form-label">${checkOrderVO.fd_self}</label>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <div class="layui-input-inline layui-col-md8" style="width:550px;">
                <textarea name="medicial" style="left:20px" class="layui-textarea" disabled>药方：${checkOrderVO.medicial}</textarea>
            </div>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>血沉测定</legend>
        </fieldset>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>项目</th>
                <th>结果</th>
                <th>参考范围</th>
                <th>单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${checkOrderVO.tesrVO.quotas}" var="quota">
                <tr>
                    <td>${quota.name}</td>
                    <td <c:if test="${quota.upOrDown != 0}">style="color: red"</c:if>>
                            ${quota.value}
                            <c:if test="${quota.upOrDown == 1}">
                                <i class="layui-icon">&#xe619;</i>
                            </c:if>
                            <c:if test="${quota.upOrDown == -1}">
                                <i class="layui-icon">&#xe61a;</i>
                            </c:if>
                    </td>
                    <td><c:if test="${quota.downLimit != -1}">${quota.downLimit}</c:if>
                        --
                        <c:if test="${quota.upLimit != -1}">${quota.upLimit}</c:if>
                    </td>
                    <td>${quota.unit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>免疫球蛋白C3C4测定</legend>
        </fieldset>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>项目</th>
                <th>结果</th>
                <th>参考范围</th>
                <th>单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${checkOrderVO.immunoglobulinVO.quotas}" var="quota">
                <tr>
                    <td>${quota.name}</td>
                    <td <c:if test="${quota.upOrDown != 0}">style="color: red"</c:if>>
                            ${quota.value}
                        <c:if test="${quota.upOrDown == 1}">
                            <i class="layui-icon">&#xe619;</i>
                        </c:if>
                        <c:if test="${quota.upOrDown == -1}">
                            <i class="layui-icon">&#xe61a;</i>
                        </c:if>
                    </td>
                    <td><c:if test="${quota.downLimit != -1}">${quota.downLimit}</c:if>
                        --
                        <c:if test="${quota.upLimit != -1}">${quota.upLimit}</c:if>
                    </td>
                    <td>${quota.unit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>生化筛查常规测定</legend>
        </fieldset>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>项目</th>
                <th>结果</th>
                <th>参考范围</th>
                <th>单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${checkOrderVO.screeningVO.quotas}" var="quota">
                <tr>
                    <td>${quota.name}</td>
                    <td <c:if test="${quota.upOrDown != 0}">style="color: red"</c:if>>
                            ${quota.value}
                        <c:if test="${quota.upOrDown == 1}">
                            <i class="layui-icon">&#xe619;</i>
                        </c:if>
                        <c:if test="${quota.upOrDown == -1}">
                            <i class="layui-icon">&#xe61a;</i>
                        </c:if>
                    </td>
                    <td><c:if test="${quota.downLimit != -1}">${quota.downLimit}</c:if>
                        --
                        <c:if test="${quota.upLimit != -1}">${quota.upLimit}</c:if>
                    </td>
                    <td>${quota.unit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>血常规测定</legend>
        </fieldset>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>项目</th>
                <th>结果</th>
                <th>参考范围</th>
                <th>单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${checkOrderVO.routineVO.quotas}" var="quota">
                <tr>
                    <td>${quota.name}</td>
                    <td <c:if test="${quota.upOrDown != 0}">style="color: red"</c:if>>
                            ${quota.value}
                        <c:if test="${quota.upOrDown == 1}">
                            <i class="layui-icon">&#xe619;</i>
                        </c:if>
                        <c:if test="${quota.upOrDown == -1}">
                            <i class="layui-icon">&#xe61a;</i>
                        </c:if>
                    </td>
                    <td><c:if test="${quota.downLimit != -1}">${quota.downLimit}</c:if>
                        --
                        <c:if test="${quota.upLimit != -1}">${quota.upLimit}</c:if>
                    </td>
                    <td>${quota.unit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>尿常规+比重测定</legend>
        </fieldset>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>项目</th>
                <th>结果</th>
                <th>参考范围</th>
                <th>单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${checkOrderVO.urinalysisVO.quotas}" var="quota">
                <tr>
                    <td>${quota.name}</td>
                    <td <c:if test="${quota.upOrDown != 0}">style="color: red"</c:if>>
                            ${quota.value}
                        <c:if test="${quota.upOrDown == 1}">
                            <i class="layui-icon">&#xe619;</i>
                        </c:if>
                        <c:if test="${quota.upOrDown == -1}">
                            <i class="layui-icon">&#xe61a;</i>
                        </c:if>
                    </td>
                    <td><c:if test="${quota.downLimit != -1}">${quota.downLimit}</c:if>
                        --
                        <c:if test="${quota.upLimit != -1}">${quota.upLimit}</c:if>
                    </td>
                    <td>${quota.unit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>24小时尿蛋白测定</legend>
        </fieldset>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>项目</th>
                <th>结果</th>
                <th>参考范围</th>
                <th>单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${checkOrderVO.proteinVO.quotas}" var="quota">
                <tr>
                    <td>${quota.name}</td>
                    <td <c:if test="${quota.upOrDown != 0}">style="color: red"</c:if>>
                            ${quota.value}
                        <c:if test="${quota.upOrDown == 1}">
                            <i class="layui-icon">&#xe619;</i>
                        </c:if>
                        <c:if test="${quota.upOrDown == -1}">
                            <i class="layui-icon">&#xe61a;</i>
                        </c:if>
                    </td>
                    <td><c:if test="${quota.downLimit != -1}">${quota.downLimit}</c:if>
                        --
                        <c:if test="${quota.upLimit != -1}">${quota.upLimit}</c:if>
                    </td>
                    <td>${quota.unit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<span hidden id="msg">${msg}</span>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.1.0.min.js"></script>
<script>
    layui.use(['element', 'form', 'jquery'], function () {
        var form = layui.form,
            layer = layui.layer,
            element = layui.element,
            $ = layui.jquery;

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
        
        //弹出层
        var msg=$("#msg").text();
        if (msg.length!=""){
            layer.msg(msg, {icon: 5});
        }
    });
</script>

</body>
</html>