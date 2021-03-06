<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>基地列表</title>
</head>

<body>
<div class="layui-container">
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
              <a><cite>基地列表</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/channel/home/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
        <c:if test="${checkRole == 4}">
		    <a id="addButn" class="layui-btn layui-btn-normal" role="button"
		           style="margin-right: 10px;float: right" href="${pageContext.request.contextPath}/admin/channel/home/add">添加基地</a>
        </c:if>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/channel/home/list',limits:[10,30,50,100], limit: 10,page:true,id:'homeId'}"
                   lay-filter="home">
                <thead>
                <tr>
                    <th lay-data="{field:'homeId',align:'center', width:100, sort: true}">ID</th>
                    <th lay-data="{field:'homeName',align:'center', width:150, sort: true}">基地名称</th>
                    <th lay-data="{field:'homeUserName', align:'center',width:150, sort: true}">基地负责人</th>
                    <th lay-data="{field:'homeAdds', align:'center',width:400, sort: true}">基地地址</th>
                    <th lay-data="{field:'status',align:'center', width:100, sort: true,templet: '#homeStateTpl'}">
                        基地状态
                    </th>
                    <th lay-data="{width:120, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<script type="text/html" id="toolBar">
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="update">修改</a>
    <a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="delete">删除</a>
</script>
<!--推送规则模板-->
<script type="text/html" id="homeStateTpl">
    {{#  if(d.status ===1){ }}
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="yes">已启用</a>
    {{#  } }}
    {{#  if(d.status ===0){ }}
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="no">已注销</a>
    {{#  } }}
</script>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
    layui.use(['table', 'element', 'jquery'], function () {
        var table = layui.table,
            element = layui.element,
            $ = layui.jquery;
        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
        //监听工具条
        table.on('tool(home)', function (obj) {
            var data = obj.data;
            if (obj.event === 'update') {
                window.location.href = '${pageContext.request.contextPath}/admin/channel/home/update/' + data.homeId;
            }


            //此处需要完善
            if (obj.event === 'delete') {
            	var homeId = obj.data.homeId;
                layer.confirm('您确定要删除该基地吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/channel/home/deleteHomeById", {homeId: homeId}, function (data) {
                        if ("success"==data) {
                            //如果修改成功,则刷新页面
                            layer.msg('删除成功!', {icon: 1});
                            window.location.reload(); //刷新当前页面
                        }
                    }).error(function () {
                        layer.msg('删除失败!', {icon:5});
                    });
                });
            }
            if (obj.event === 'yes') {
            	var homeId = obj.data.homeId;
                //已启用,设置为禁用
                $.post("${pageContext.request.contextPath}/admin/channel/home/updateState", {homeId: homeId, status: 0}, function (data) {
                    var data = data;
                    if (data == "success") {
                        //如果修改成功,则刷新页面
                        //window.location.reload(); //刷新当前页面
                        window.location.href="${pageContext.request.contextPath}/admin/channel/home/index";
                    }
                })
            }
            if (obj.event === 'no') {
            	var homeId = obj.data.homeId;
                //已禁用,设置为启用
                $.post("${pageContext.request.contextPath}/admin/channel/home/updateState", {homeId: homeId, status: 1}, function (data) {
                    var data = data;
                    if (data == "success") {
                        //如果修改成功,则刷新页面
                        //window.location.reload(); //刷新当前页面
                        window.location.href="${pageContext.request.contextPath}/admin/channel/home/index";
                    }
                })
            }
        });
        //弹出层
        var msg = "${msg}";
        if (msg.length != "") {
            layer.msg(msg, {icon: 6});
            $("#msg").text("");
        }
    });
</script>
</body>

</html>