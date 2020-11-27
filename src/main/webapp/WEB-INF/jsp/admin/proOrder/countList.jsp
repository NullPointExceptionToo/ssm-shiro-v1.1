<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>库存列表</title>
</head>

<body>
<div class="layui-container">
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
              <a><cite>库存列表</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/order/proOrder/countIndex" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/order/proOrder/countList',limits:[10,30,50,100], limit: 10,page:true,id:'id'}"
                   lay-filter=countList>
                <thead>
                <tr>
                    <th lay-data="{field:'proName', align:'center',width:150, sort: true}">商品名称</th>
                    <th lay-data="{field:'proCount',align:'center', width:150, sort: true}">供货数量（斤）</th>
                    <th lay-data="{field:'sellCount',align:'center', width:150, sort: true}">已销数量（斤）</th>
                    <th lay-data="{field:'restCount',align:'center', width:150, sort: true}">库存数量（斤）</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<script type="text/html" id="toolBar">
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
        table.on('tool(countList)', function (obj) {
            var data = obj.data;

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