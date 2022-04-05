<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>复查单列表</title>
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
              <a><cite>复查单列表</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/checkOrder/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>

        <a class="layui-btn layui-btn-normal" role="button"
               style="margin-right: 10px;float: right" href="${pageContext.request.contextPath}/admin/checkOrder/add">添加复查单</a>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/checkOrder/list',limits:[10,30,50,100], limit: 10,page:true,id:'id'}"
                   lay-filter=checkOrder>
                <thead>
                <tr>
                    <th lay-data="{field:'id',align:'center', width:100, sort: true}">复查单ID</th>
                    <th lay-data="{field:'date',align:'center', width:150, sort: true, templet: timeTpl}">复查时间</th>
                    <th lay-data="{field:'hospital', align:'center',width:150, sort: true}">复查医院</th>
                    <th lay-data="{field:'fd_gov',align:'center', width:150, sort: true}">医保</th>
                    <th lay-data="{field:'fd_self',align:'center', width:150, sort: true}">自费</th>
                    <th lay-data="{width:180, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<script type="text/html" id="toolBar">
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="update">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="delete">删除</a>
</script>
<script type="text/html" id="timeTpl">
    <div>{{layui.laytpl.toDateString(d.date)}}</div>
</script>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
    layui.use(['table', 'element', 'jquery', 'laytpl'], function () {
        var table = layui.table,
            element = layui.element,
            laytpl = layui.laytpl,
            $ = layui.jquery;
        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
        //监听工具条
        table.on('tool(checkOrder)', function (obj) {
            var data = obj.data;

            if (obj.event === 'delete') {
                layer.confirm('确定要删除该复查单吗？宝，会级联删除所有关联的检查单呦!', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/checkOrder/del", {id: data.id}, function (data) {
                        if ("success"==data) {
                            //如果删除成功,则刷新页面
                            layer.msg('删除成功!', {icon: 1});
                            window.location.reload(); //刷新当前页面
                        }
                    }).error(function () {
                        layer.msg('删除失败!', {icon:5});
                    });
                });
            }
            
            if (obj.event === 'detail') {
                window.location.href = '${pageContext.request.contextPath}/admin/checkOrder/detail/' + data.id;
            }
            if (obj.event === 'update') {
                window.location.href = '${pageContext.request.contextPath}/admin/checkOrder/update/' + data.id;
            }
        });
        //弹出层
        var msg = "${msg}";
        if (msg.length != "") {
            layer.msg(msg, {icon: 6});
            $("#msg").text("");
        }
        //时间戳的处理
        laytpl.toDateString = function(d, format){
            var date = new Date(d),
                ymd = [
                    this.digit(date.getFullYear(), 4)
                    ,this.digit(date.getMonth() + 1)
                    ,this.digit(date.getDate())
                ]
                ,hms = [
                    this.digit(date.getHours())
                    ,this.digit(date.getMinutes())
                    ,this.digit(date.getSeconds())
                ];
            format = format || 'yyyy-MM-dd';
            return format.replace(/yyyy/g, ymd[0])
                .replace(/MM/g, ymd[1])
                .replace(/dd/g, ymd[2])
                .replace(/HH/g, hms[0])
                .replace(/mm/g, hms[1])
                .replace(/ss/g, hms[2]);
        };
        //数字前置补零
        laytpl.digit = function(num, length, end){
            var str = '';
            num = String(num);
            length = length || 2;
            for(var i = num.length; i < length; i++){
                str += '0';
            }
            return num < Math.pow(10, length) ? str + (num|0) : num;
        };
    });
</script>
</body>

</html>