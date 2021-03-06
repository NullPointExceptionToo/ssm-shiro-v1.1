<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css"/>
    <title>密码修改</title>
</head>

<body>
<div class="layui-container">
    <!--
        作者：yuton.yao@qq.com
        时间：2017-09-01
        描述：引入公共html
    -->
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
                <a href="${pageContext.request.contextPath}/admin/member/index">个人资料</a>
                <a><cite>密码修改</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/menu/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
        <form class="layui-form" action="" style="align-self: center">
            <div class="layui-form-item" hidden>
                <label class="layui-form-label">用户ID</label>
                <div class="layui-input-inline">
                    <input type="text" name="id" required lay-verify="required" placeholder="" autocomplete="off"
                           value="${user.id}" readonly class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" required lay-verify="required" placeholder="" autocomplete="off"
                           value="${user.username}" readonly class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">旧密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="pwd" required <%--lay-verify="pwd"--%> placeholder="请输入旧密码" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="npwd" name="password" required lay-verify="pwd" placeholder="请输入新密码"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">重复新密码</label>
                <div class="layui-input-inline">
                    <input type="password" required lay-verify="repwd" placeholder="请再次输入新密码" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="updatePwd">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
    //密码修改
    layui.use(['form','element', 'jquery'], function () {
        var $ = layui.jquery;
        var form = layui.form;
        form.verify({
            pwd: [/(.+){6,12}$/, '密码必须6到12位'],
            repwd: function (value) {
                //获取密码
                var pwd = $("#npwd").val();
                if (pwd != value) {
                    return '两次输入的密码不一致';
                }
            }
        });
        //监听导航点击
        /*element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });*/
        //监听提交
        form.on('submit(updatePwd)', function (data) {
            if (data.field.pwd == data.field.password) {
                layer.msg("您输入的<font color='red'>新密码</font>和旧密码一致,请重新输入!", {icon: 5});
            } else {
                /* var user = JSON.stringify(data.field);
                 layer.msg(user);*/
                submit($, data.field);
            }
            return false;
        });
    });

    //提交
    function submit($, params) {
        var id = params.id;
        $.post('${pageContext.request.contextPath}/admin/member/updatepwd/', params, function (res) {
            //alert(res);
            if (res == 0) {
                layer.msg("旧密码输入有误,请重新输入!", {icon: 5});
            } else if (res == 1) {
                /*layer.msg("用户密码修改成功,请重新登录!",'',login())
                login();*/
                layer.msg('密码修改成功,请重新登录!', {
                    icon: 6
                    , btn: ['确定']
                    , yes: function () {
                        window.top.location = "${pageContext.request.contextPath}/logout";
                    }
                });
            } else if (res == 2) {
                layer.msg("用户密码修改失败!", {icon: 5});
            }
        }, 'json');
    }
</script>
</body>

</html>