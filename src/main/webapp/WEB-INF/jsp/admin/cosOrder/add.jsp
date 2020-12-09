<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>添加订单</title>
</head>

<body>
<div class="layui-container">
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
                <a href="${pageContext.request.contextPath}/admin/order/cosOrder/index">订单列表</a>
                <a><cite>添加订单</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="javascript:location.reload()" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
            <a class="layui-btn layui-btn-danger" role="button"
               style="margin-right: 10px;float: right"
               href="${pageContext.request.contextPath}/admin/order/cosOrder/index">返回上一级</a>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <form id="formData" class="layui-form layui-form-pane">

              <div class="layui-form-item" name="item">
                <div class="layui-input-inline layui-col-md8" style="width:350px;">
                    <label class="layui-form-label">商品</label>
                    <div class="layui-input-block">
                        <select name="pid" lay-verify="required" lay-search="">
                            <option value="">请选择或搜索商品</option>
                            <c:forEach items="${productRes}" var="product">
                                 <option value="${product.pid}">${product.proName}(库存:<c:if test="${product.restCount < 9999}">${product.restCount}</c:if>
                                                                                       <c:if test="${product.restCount >= 9999}">9999</c:if>斤)</option>
                            </c:forEach>
                        </select>
                    </div>
                 </div>
                 <div class="layui-input-inline layui-col-md8" style="width:350px;">
                    <label class="layui-form-label">订购数量（斤）</label>
                    <div class="layui-input-block">
                        <input type="text" name="count" lay-verify="number|required" placeholder="订货数量（斤）"
                               class="layui-input">
                    </div>
                 </div>
                 <button name="del" type="button" class="layui-btn layui-btn-sm layui-btn-primary" style="padding: 0 8px;" onclick="delItem(this)">
				    <i class="layui-icon" style="font-size:27px">&#x1007;</i>
				 </button> 
				 <button name="add" type="button" class="layui-btn layui-btn-sm layui-btn-primary" style="padding: 0 8px;" onclick="addItem(this)">
				    <i class="layui-icon" style="font-size:25px">&#xe61f;</i>
				 </button> 
                </div>
                <div class="layui-form-item layui-col-md8" style="text-align: center">
                    <div class="layui-form-item">
                        <input class="layui-btn" lay-submit="" lay-filter="rulesSubmit" style="width:65px;" value="提交"  />
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

        //监听提交
        form.on('submit(rulesSubmit)', function (data) {
            //提交表单
        	var url = "${pageContext.request.contextPath}/admin/order/cosOrder/add";
    		var cosOrder={};
    		var ordArray=[];
    		$("#formData").find("div[name='item']").each(function(){
    			var selectItem = $(this).find("select[name='pid'] option:selected").eq(0);
    			var inputItem = $(this).find("input[name='count']").eq(0);
    			var ordItem = {};
    			ordItem.productId = selectItem.val();
    			ordItem.productName = selectItem.text().split("(")[0];
    			ordItem.count = inputItem.val();
    			ordArray.push(ordItem);
    		});
    		cosOrder.ordArray = ordArray;
    		var result;
    		$.ajax({
                type: "post",
                url: url,
                async: false,//同步提交
                data: {"cosOrder":JSON.stringify(cosOrder)},
                success: function (ev) {
                	result = ev;
                }

            });
            if (result == 333) {
            	layer.msg("未持有商店,请联系公司绑定商店!", {icon: 5});
            } 
            if (result == 2) {
            	layer.msg("库存量不足", {icon: 5});
            } 
            if (result == 1) {
            	window.location.href="${pageContext.request.contextPath}/admin/order/cosOrder/index?msg=success";
            } 
        });
        
        //弹出层
        var msg=$("#msg").text();
        if (msg.length!=""){
            layer.msg(msg, {icon: 5});
        }
    });
    function addItem(e){
    	var item = $(e).parent().clone();
    	$(e).parent().after(item);
    	layui.use(['form'], function () {
    		var form = layui.form;
    		form.render();
    	});
    }
    function delItem(e){
    	if ($(e).parent().parent().children().length > 2) {
    		$(e).parent().remove();
    	}
    }
    function submitOrder() {
    	layui.use(['jquery'], function () {
    		var url = "${pageContext.request.contextPath}/admin/order/cosOrder/add";
    		var $ = layui.jquery;
    		var cosOrder={};
    		var ordArray=[];
    		$("#formData").find("div[name='item']").each(function(){
    			var selectItem = $(this).children("select[name='pid'] option:selected")
    			var inputItem = $(this).children("input[name='count']")
    			var ordItem = {};
    			ordItem.productId = selectItem.val();
    			ordItem.productName = selectItem.text();
    			ordItem.count = inputItem.val();
    			ordArray.push(ordItem);
    		});
    		cosOrder.ordArray = ordArray;
    		var result;
    		$.ajax({
                type: "post",
                url: url,
                async: false,//同步提交
                data: cosOrder,
                success: function (ev) {
                	result = ev;
                }

            });
            if (result == 333) {
            	layer.msg("未持有商店,请联系公司绑定商店!", {icon: 5});
            } 
            if (result == 2) {
            	layer.msg("库存量不足标识", {icon: 5});
            } 
            if (result == 1) {
            	window.location.href="${pageContext.request.contextPath}/admin/order/cosOrder/index?msg=success";
            } 
    	});
    }
</script>

</body>
</html>