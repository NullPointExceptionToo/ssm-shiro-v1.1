<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                   href="${pageContext.request.contextPath}/admin/order/cosOrder/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
        <c:if test="${checkRole == 6}">
		    <a class="layui-btn layui-btn-normal" role="button"
		           style="margin-right: 10px;float: right" href="${pageContext.request.contextPath}/admin/order/cosOrder/add">添加订单</a>
        </c:if>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/order/cosOrder/list',limits:[10,30,50,100], limit: 10,page:true,id:'cid'}"
                   lay-filter=cosOrder>
                <thead>
                <tr>
                    <th lay-data="{field:'cid',align:'center', width:100, sort: true}">订单ID</th>
                    <th lay-data="{field:'storeName',align:'center', width:150, sort: true}">下单商店</th>
                    <th lay-data="{field:'cosDate',align:'center', width:150, sort: true,templet: timeTpl}">下单时间</th>
                    <th lay-data="{field:'ordStatus', align:'center',width:150, sort: true, templet: '#orderStateTpl'}">订单状态</th>
                    <c:if test="${checkRole == 4}">
                        <th lay-data="{width:180, align:'center', toolbar: '#toolBar1'}">操作</th>
                    </c:if>
                    <c:if test="${checkRole != 4}">
                        <th lay-data="{width:180, align:'center', toolbar: '#toolBar2'}">操作</th>
                    </c:if>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<script type="text/html" id="toolBar1">
    {{#  if(d.ordStatus ===0 || d.ordStatus ===2){ }}
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="detail">详情</a>
    {{#  } }}
    {{#  if(d.ordStatus ===1){ }}
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="cancel">撤销</a>
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="delivery">配送</a>
    {{#  } }}
</script>
<script type="text/html" id="toolBar2">
    {{#  if(d.ordStatus ===0){ }}
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="delete">删除</a>
    {{#  } }}
    {{#  if(d.ordStatus ===2){ }}
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="detail">详情</a>
    {{#  } }}
    {{#  if(d.ordStatus ===1){ }}
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="cancel">撤销</a>
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="detail">详情</a>
    {{#  } }}
</script>
<script type="text/html" id="orderStateTpl">
    {{#  if(d.ordStatus ===0){ }}
           已撤销
    {{#  } }}
    {{#  if(d.ordStatus ===1){ }}
          待配送
    {{#  } }}
    {{#  if(d.ordStatus ===2){ }}
          已配送
    {{#  } }}
</script>

<script type="text/html" id="timeTpl">
    <div>{{layui.laytpl.toDateString(d.cosDate)}}</div>
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
        table.on('tool(cosOrder)', function (obj) {
            var data = obj.data;


            //此处需要完善
            if (obj.event === 'cancel') {
            	var cid = obj.data.cid;
                layer.confirm('您确定要撤销该订单吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/order/cosOrder/cancelCosOrderById", {cid: cid}, function (data) {
                        if ("success"==data) {
                            //如果修改成功,则刷新页面
                            layer.msg('撤销成功!', {icon: 1});
                            window.location.reload(); //刷新当前页面
                        }else{
                            layer.msg(data, {icon: 5});
                            window.location.reload();
                        }
                    }).error(function () {
                        layer.msg('撤销失败!', {icon:5});
                    });
                });
            }
            
            //此处需要完善
            if (obj.event === 'delivery') {
            	var cid = obj.data.cid;
                layer.confirm('您确定要配送该订单吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/order/cosOrder/deliveryCosOrderById", {cid: cid}, function (data) {
                        if ("success"==data) {
                            //如果配送成功,则刷新页面
                            layer.msg('配送成功!', {icon: 1});
                            window.location.reload(); //刷新当前页面
                        }
                        if ("mark"==data) {
                            layer.msg('失败，商品库存不足', {icon: 5});
                        }
                    }).error(function () {
                        layer.msg('配送失败!', {icon:5});
                    });
                });
            }
            
            if (obj.event === 'delete') {
            	var cid = obj.data.cid;
                layer.confirm('您确定要删除该订单吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/order/cosOrder/delCosOrderById", {cid: cid}, function (data) {
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
                window.location.href = '${pageContext.request.contextPath}/admin/order/cosOrder/detail/' + data.cid;
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