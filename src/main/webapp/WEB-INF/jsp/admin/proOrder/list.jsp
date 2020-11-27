<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>订单列表</title>
</head>

<body>
<div class="layui-container">
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
              <a><cite>订单列表</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/order/proOrder/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
	    <a id="addButn" class="layui-btn layui-btn-normal" role="button"
	           style="margin-right: 10px;float: right" href="${pageContext.request.contextPath}/admin/order/proOrder/add">添加订单</a>
        <input type="text" id="checkRole" value="${checkRole}" hidden>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/order/proOrder/list',limits:[10,30,50,100], limit: 10,page:true,id:'oid'}"
                   lay-filter=proOrder>
                <thead>
                <tr>
                    <th lay-data="{field:'oid',align:'center', width:100, sort: true}">ID</th>
                    <th lay-data="{field:'phomeName',align:'center', width:150, sort: true}">生产基地</th>
                    <th lay-data="{field:'profarmer', align:'center',width:150, sort: true}">生产农户</th>
                    <th lay-data="{field:'proName', align:'center',width:150, sort: true}">商品名称</th>
                    <th lay-data="{field:'proNum',align:'center', width:150, sort: true}">供货数量（斤）</th>
                    <th lay-data="{field:'sellNum',align:'center', width:150, sort: true}">已销数量（斤）</th>
                    <th lay-data="{field:'proDate',align:'center', width:150, sort: true,templet: timeTpl}">下单时间</th>
                    <th lay-data="{width:120, align:'center', toolbar: '#toolBar'}">操作</th>
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
<script type="text/html" id="timeTpl">
    <div>{{layui.laytpl.toDateString(d.proDate)}}</div>
</script>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
    layui.use(['table', 'element', 'jquery'], function () {
        var table = layui.table,
            element = layui.element,
            $ = layui.jquery;
        if ($("#checkRole").val() != 5) {
        	$("#addButn").hide();
        }else{
        	$("#addButn").show();
        }
        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
        //监听工具条
        table.on('tool(proOrder)', function (obj) {
            var data = obj.data;


            //此处需要完善
            if (obj.event === 'delete') {
            	var oid = obj.data.oid;
                layer.confirm('您确定要删除该订单吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/order/proOrder/deleteProOrderById", {oid: oid}, function (data) {
                        if ("success"==data) {
                            //如果修改成功,则刷新页面
                            window.location.reload(); //刷新当前页面
                            layer.msg('删除成功!', {icon: 1});
                        }
                        if ("mark"==data) {
                            layer.msg('失败，产品库存剩余数量不足以抵消该订单已售数量', {icon: 5});
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
        
      //时间戳的处理
        layui.laytpl.toDateString = function(d, format){
         var date = new Date(d || new Date()),
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
         format = format || 'yyyy-MM-dd HH:mm:ss';       
         return format.replace(/yyyy/g, ymd[0])
         .replace(/MM/g, ymd[1])
         .replace(/dd/g, ymd[2])
         .replace(/HH/g, hms[0])
         .replace(/mm/g, hms[1])
         .replace(/ss/g, hms[2]);
        };    
        //数字前置补零
        layui.laytpl.digit = function(num, length, end){
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