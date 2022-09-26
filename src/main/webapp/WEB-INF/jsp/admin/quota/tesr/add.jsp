<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>添加检查单</title>
</head>

<body>
<div class="layui-container">
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
                <a href="${pageContext.request.contextPath}/admin/quota/tesr/index">血沉检查单列表</a>
                <a><cite>添加检查单</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="javascript:location.reload()" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
            <button class="layui-btn layui-btn-primary" style="float: right" onclick="buttonFun()">导入</button>
            <input id="img" type="file" class="layui-btn"
                   style="margin-right: 10px;float: right;display: none;" onchange="myUpload('tesr')"/>
            <a class="layui-btn layui-btn-danger" role="button"
               style="margin-right: 10px;float: right"
               href="${pageContext.request.contextPath}/admin/quota/tesr/index">返回上一级</a>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <form class="layui-form layui-form-pane"
                  action="${pageContext.request.contextPath}/admin/quota/tesr/add/"
                  method="post">
              <div class="layui-form-item" name="item">
                <div class="layui-input-inline layui-col-md8" style="width:350px;">
                    <label class="layui-form-label">复查单</label>
                    <div class="layui-input-block">
                        <select name="check_id" lay-verify="required" lay-search="">
                            <option value="">请选择要绑定的复查单</option>
                            <c:forEach items="${checkOrders}" var="checkOrder">
                                 <option value="${checkOrder.id}"><fmt:formatDate value="${checkOrder.date}" pattern="yyyy/MM/dd"/>-${checkOrder.hospital}</option>
                            </c:forEach>
                        </select>
                    </div>
                 </div>
                 <div class="layui-input-inline layui-col-md8" style="width:350px;">
                    <label class="layui-form-label">血沉</label>
                    <div class="layui-input-block">
                        <input type="text" name="esr" lay-verify="number|required" placeholder="血沉(mm/每小时)"
                               class="layui-input">
                    </div>
                 </div>
                </div>
                <div class="layui-form-item layui-col-md8" style="text-align: center">
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

        });

        //弹出层
        var msg=$("#msg").text();
        if (msg.length!=""){
            layer.msg(msg, {icon: 5});
        }
    });

    function buttonFun() {
        $("#img").click();
    }

    function myUpload(type) {
        layui.use(['jquery'], function () {
            var url = "${pageContext.request.contextPath}/common/upload/"+type;
            var $ = layui.jquery;
            var file = $("#img").get(0).files[0];
            var formdata = new FormData();
            formdata.append("file", file);
            var loadIndex = '';
            $.ajax({
                type: "post",
                url: url,
                data: formdata,
                processData: false,
                contentType : false,
                beforeSend:function(){
                    //显示正在加载数据
                    loadIndex = layer.load(0, {
                        shade: [0.1, '#fff']
                    });
                },
                success: function (data) {
                    layer.close(loadIndex);
                    if(data != null) {
                        for(var item in data){
                            $("input[name='"+item+"']").val(data[item]);
                        }
                    }
                },
                error: function (data) {
                    layer.close(loadIndex);
                    layer.msg('导入失败了呦，宝!', {icon:5});
                }

            });
            $("#img").val("");
        });
    }
</script>

</body>
</html>