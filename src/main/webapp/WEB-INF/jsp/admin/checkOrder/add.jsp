<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>添加复查单</title>
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
                <a><cite>添加复查单</cite></a>
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
            <form class="layui-form layui-form-pane"
                  action="${pageContext.request.contextPath}/admin/checkOrder/add/"
                  method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">复查医院</label>
                        <div class="layui-input-block">
                            <input type="text" name="hospital" lay-verify="required" placeholder="医院"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">复查时间</label>
                        <div class="layui-input-block">
                            <input type="text" id="date" name="date" lay-verify="date|required" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">医保报销费用</label>
                        <div class="layui-input-block">
                            <input type="text" name="fd_gov" lay-verify="required|digital" placeholder="医保报销费用"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">自费费用</label>
                        <div class="layui-input-block">
                            <input type="text" name="fd_self" lay-verify="required|digital" placeholder="自费费用"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline" style="width:600px">
                        <label class="layui-form-label">药方</label>
                        <div class="layui-input-block">
                            <textarea name="medicial" placeholder="请输入内容" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: center">
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit="" lay-filter="rulesSubmit">提交</button>
                        <button class="layui-btn layui-btn-primary" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<span hidden id="msg">${msg}</span>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.1.0.min.js"></script>
<script>
    layui.use(['element', 'form', 'jquery', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            element = layui.element,
            laydate = layui.laydate,
            $ = layui.jquery;
        form.verify({
            digital: [
                /^(([^0][0-9]+|0).([0-9]{1,3})$)|^(([^0][0-9]+|0)$)|^(([1-9]+).([0-9]{1,3})$)|^(([1-9]+)$)/
                ,'请填入数字'
            ]
        });

        laydate.render({
            elem: '#date' ,//input的id
        });

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });

        //监听提交
        form.on('submit(rulesSubmit)', function (data) {
            //提交表单
        	<%--var url = "${pageContext.request.contextPath}/admin/quota/tesr/add";--%>
    		<%--var tesr={};--%>
            <%--var check_id = $("select[name='check_id'] option:selected").val();--%>
            <%--var esr = $("input[name='esr']").val();--%>
            <%--tesr.esr = esr;--%>
            <%--tesr.check_id = check_id;--%>
    		<%--var result;--%>
    		<%--$.ajax({--%>
                <%--type: "post",--%>
                <%--url: url,--%>
                <%--async: false,//同步提交--%>
                <%--data: {"tesr":JSON.stringify(tesr)},--%>
                <%--success: function (ev) {--%>
                	<%--result = ev;--%>
                <%--}--%>

            <%--});--%>
            <%--if (result == 1) {--%>
            	<%--window.location.href="${pageContext.request.contextPath}/admin/order/cosOrder/index?msg=success";--%>
            <%--} else {--%>
                <%--layer.msg("新增失败", {icon: 5});--%>
            <%--}--%>
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