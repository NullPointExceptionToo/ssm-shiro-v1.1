<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>商品列表</title>
</head>

<body>
<div class="layui-container">
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
              <a><cite>商品列表</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/channel/product/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
        <a class="layui-btn layui-btn-normal" role="button"
           style="margin-right: 10px;float: right" href="${pageContext.request.contextPath}/admin/channel/product/add">添加商品</a>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/channel/product/list',limits:[10,30,50,100], limit: 10,page:true,id:'pid'}"
                   lay-filter="product">
                <thead>
                <tr>
                    <!--<th lay-data="{checkbox:true, fixed: true}"></th>-->
                    <th lay-data="{field:'pid',align:'center', width:100, sort: true}">商品ID</th>
                    <th lay-data="{field:'productName',align:'center', width:100, sort: true}">商品名称</th>
                    <th lay-data="{field:'productTypeName', align:'center',width:100, sort: true}">商品种类</th>
                    <th lay-data="{field:'productDes', align:'center',width:200, sort: true}">商品描述</th>
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
        table.on('tool(product)', function (obj) {
            var data = obj.data;
            if (obj.event === 'update') {
                window.location.href = '${pageContext.request.contextPath}/admin/channel/product/update/' + data.pid;
            }


            //此处需要完善
            if (obj.event === 'delete') {
                var pid = obj.data.pid;
                layer.confirm('您确定要删除该商品吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/channel/product/deleteProductById", {pid: pid}, function (data) {
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