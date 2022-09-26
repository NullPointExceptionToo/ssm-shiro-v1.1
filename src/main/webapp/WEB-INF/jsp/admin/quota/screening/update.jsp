<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>修改检查单</title>
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
                <a href="${pageContext.request.contextPath}/admin/quota/screening/index">生化筛查常规测定列表</a>
                <a><cite>修改检查单</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="javascript:location.reload()" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
            <a class="layui-btn layui-btn-danger" role="button"
               style="margin-right: 10px;float: right"
               href="${pageContext.request.contextPath}/admin/quota/screening/index">返回上一级</a>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <form class="layui-form layui-form-pane"
                  action="${pageContext.request.contextPath}/admin/quota/screening/update/"
                  method="post">
                <input type="text" name="id" value="${screeningVO.id}" hidden>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">总蛋白</label>
                        <div class="layui-input-block">
                            <input type="text" name="total_protein" lay-verify="digital" placeholder="总蛋白(g/L)"
                                   value="${screeningVO.total_protein.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">尿素</label>
                        <div class="layui-input-block">
                            <input type="text" name="niaosu" lay-verify="digital" placeholder="尿素(mmol/L)"
                                   value="${screeningVO.niaosu.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">白蛋白</label>
                        <div class="layui-input-block">
                            <input type="text" name="white_protein" lay-verify="digital" placeholder="白蛋白(g/L)"
                                   value="${screeningVO.white_protein.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">尿酸</label>
                        <div class="layui-input-block">
                            <input type="text" name="niaoshuan" lay-verify="digital" placeholder="尿酸(u mol/L)"
                                   value="${screeningVO.niaoshuan.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">球蛋白</label>
                        <div class="layui-input-block">
                            <input type="text" name="circle_protein" lay-verify="digital" placeholder="球蛋白(g/L)"
                                   value="${screeningVO.circle_protein.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">甘油三醇</label>
                        <div class="layui-input-block">
                            <input type="text" name="glycerol" lay-verify="digital" placeholder="甘油三醇(mmol/L)"
                                   value="${screeningVO.glycerol.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">白球蛋白比例</label>
                        <div class="layui-input-block">
                            <input type="text" name="whilte_circle_per" lay-verify="digital" placeholder="白球蛋白比例(%)"
                                   value="${screeningVO.whilte_circle_per.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">总胆固醇</label>
                        <div class="layui-input-block">
                            <input type="text" name="all_cholesterol" lay-verify="digital" placeholder="总胆固醇(mmol/L)"
                                   value="${screeningVO.all_cholesterol.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">谷丙转氨酶</label>
                        <div class="layui-input-block">
                            <input type="text" name="aminotransferase" lay-verify="digital" placeholder="谷丙转氨酶(U/L)"
                                   value="${screeningVO.aminotransferase.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">高密度脂蛋白-C</label>
                        <div class="layui-input-block">
                            <input type="text" name="high_protein" lay-verify="digital" placeholder="高密度脂蛋白-C(mmol/L)"
                                   value="${screeningVO.high_protein.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">总胆红素</label>
                        <div class="layui-input-block">
                            <input type="text" name="all_bilirubin" lay-verify="digital" placeholder="总胆红素(u mol/L)"
                                   value="${screeningVO.all_bilirubin.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">空腹血糖</label>
                        <div class="layui-input-block">
                            <input type="text" name="no_glucose" lay-verify="digital" placeholder="空腹血糖(mmol/L)"
                                   value="${screeningVO.no_glucose.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">直接胆红素</label>
                        <div class="layui-input-block">
                            <input type="text" name="dir_bilirubin" lay-verify="digital" placeholder="直接胆红素(u mol/L)"
                                   value="${screeningVO.dir_bilirubin.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">钾</label>
                        <div class="layui-input-block">
                            <input type="text" name="jia" lay-verify="digital" placeholder="钾(mmol/L)"
                                   value="${screeningVO.jia.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">间接胆红素</label>
                        <div class="layui-input-block">
                            <input type="text" name="no_bilirubin" lay-verify="digital" placeholder="间接胆红素(u mol/L)"
                                   value="${screeningVO.no_bilirubin.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">钠</label>
                        <div class="layui-input-block">
                            <input type="text" name="na" lay-verify="digital" placeholder="钠(mmol/L)"
                                   value="${screeningVO.na.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">肾小球滤过率-cr</label>
                        <div class="layui-input-block">
                            <input type="text" name="glomerulus_per" lay-verify="digital" placeholder="肾小球滤过率-cr(ml/min)"
                                   value="${screeningVO.glomerulus_per.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">氯</label>
                        <div class="layui-input-block">
                            <input type="text" name="lv" lay-verify="digital" placeholder="氯(mmol/L)"
                                   value="${screeningVO.lv.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">肌酐</label>
                        <div class="layui-input-block">
                            <input type="text" name="jigan" lay-verify="digital" placeholder="肌酐(u mol/L)"
                                   value="${screeningVO.jigan.value}"
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

        form.verify({
            digital: [
                /^(([^0][0-9]+|0).([0-9]{1,3})$)|^(([^0][0-9]+|0)$)|^(([1-9]+).([0-9]{1,3})$)|^(([1-9]+)$)/
                ,'请填入数字'
            ]
        });

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });

        //监听提交
        form.on('submit(rulesSubmit)', function (data) {
            //提交表单
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