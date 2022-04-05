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
                <a href="${pageContext.request.contextPath}/admin/quota/routine/index">血常规测定列表</a>
                <a><cite>修改检查单</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="javascript:location.reload()" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
            <a class="layui-btn layui-btn-danger" role="button"
               style="margin-right: 10px;float: right"
               href="${pageContext.request.contextPath}/admin/quota/routine/index">返回上一级</a>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <form class="layui-form layui-form-pane"
                  action="${pageContext.request.contextPath}/admin/quota/routine/update/"
                  method="post">
                <input type="text" name="id" value="${routineVO.id}" hidden>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">白细胞计数</label>
                        <div class="layui-input-block">
                            <input type="text" name="white_count" lay-verify="digital|required" placeholder="白细胞计数(10E9/L)"
                                   value="${routineVO.white_count.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">红细胞计数</label>
                        <div class="layui-input-block">
                            <input type="text" name="red_count" lay-verify="digital|required" placeholder="红细胞计数(10E12/L)"
                                   value="${routineVO.red_count.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">中性粒细胞%</label>
                        <div class="layui-input-block">
                            <input type="text" name="mid_cell_percent" lay-verify="digital|required" placeholder="中性粒细胞%"
                                   value="${routineVO.mid_cell_percent.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">血红蛋白</label>
                        <div class="layui-input-block">
                            <input type="text" name="hemoglobin" lay-verify="digital|required" placeholder="血红蛋白(g/L)"
                                   value="${routineVO.hemoglobin.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">淋巴细胞%</label>
                        <div class="layui-input-block">
                            <input type="text" name="lb_cell_percent" lay-verify="digital|required" placeholder="淋巴细胞%"
                                   value="${routineVO.lb_cell_percent.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">红细胞积压</label>
                        <div class="layui-input-block">
                            <input type="text" name="red_cell_jy" lay-verify="digital|required" placeholder="红细胞积压(%)"
                                   value="${routineVO.red_cell_jy.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">单核细胞%</label>
                        <div class="layui-input-block">
                            <input type="text" name="singo_cell_percent" lay-verify="digital|required" placeholder="单核细胞%"
                                   value="${routineVO.singo_cell_percent.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">平均红细胞体积</label>
                        <div class="layui-input-block">
                            <input type="text" name="ave_red_cell_lv" lay-verify="digital|required" placeholder="平均红细胞体积(fl)"
                                   value="${routineVO.ave_red_cell_lv.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">嗜酸性粒细胞%</label>
                        <div class="layui-input-block">
                            <input type="text" name="shuan_cell_percent" lay-verify="digital|required" placeholder="嗜酸性粒细胞%"
                                   value="${routineVO.shuan_cell_percent.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">平均血红蛋白含量</label>
                        <div class="layui-input-block">
                            <input type="text" name="ave_hemoglobin_per" lay-verify="digital|required" placeholder="平均血红蛋白含量(pg)"
                                   value="${routineVO.ave_hemoglobin_per.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">嗜碱性粒细胞%</label>
                        <div class="layui-input-block">
                            <input type="text" name="jian_cell_percent" lay-verify="digital|required" placeholder="嗜碱性粒细胞%"
                                   value="${routineVO.jian_cell_percent.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">平均血红蛋白浓度</label>
                        <div class="layui-input-block">
                            <input type="text" name="ave_hemoglobin_lev" lay-verify="digital|required" placeholder="平均血红蛋白浓度(g/L)"
                                   value="${routineVO.ave_hemoglobin_lev.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">中性粒细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="mid_cell" lay-verify="digital|required" placeholder="中性粒细胞(10E9/L)"
                                   value="${routineVO.mid_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">红细胞分布宽度</label>
                        <div class="layui-input-block">
                            <input type="text" name="red_cell_width" lay-verify="digital|required" placeholder="红细胞分布宽度(%)"
                                   value="${routineVO.red_cell_width.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">淋巴细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="lb_cell" lay-verify="digital|required" placeholder="淋巴细胞(10E9/L)"
                                   value="${routineVO.lb_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">血小板计数</label>
                        <div class="layui-input-block">
                            <input type="text" name="platelet_count" lay-verify="digital|required" placeholder="血小板计数(10E9/L)"
                                   value="${routineVO.platelet_count.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">单核细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="singo_cell" lay-verify="digital|required" placeholder="单核细胞(10E9/L)"
                                   value="${routineVO.singo_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">血小板积压</label>
                        <div class="layui-input-block">
                            <input type="text" name="platelet_jy" lay-verify="digital|required" placeholder="血小板积压(%)"
                                   value="${routineVO.platelet_jy.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">嗜酸性粒细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="shuan_cell" lay-verify="digital|required" placeholder="嗜酸性粒细胞(10E9/L)"
                                   value="${routineVO.shuan_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">平均血小板体积</label>
                        <div class="layui-input-block">
                            <input type="text" name="ave_platelet_lv" lay-verify="digital|required" placeholder="平均血小板体积(fl)"
                                   value="${routineVO.ave_platelet_lv.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">嗜碱性粒细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="jian_cell" lay-verify="digital|required" placeholder="嗜碱性粒细胞(10E9/L)"
                                   value="${routineVO.jian_cell.value}"
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