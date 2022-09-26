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
                <a href="${pageContext.request.contextPath}/admin/quota/urinalysis/index">尿常规+比重测定列表</a>
                <a><cite>修改检查单</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="javascript:location.reload()" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
            <a class="layui-btn layui-btn-danger" role="button"
               style="margin-right: 10px;float: right"
               href="${pageContext.request.contextPath}/admin/quota/urinalysis/index">返回上一级</a>
        </div>
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md12">
            <form class="layui-form layui-form-pane"
                  action="${pageContext.request.contextPath}/admin/quota/urinalysis/update/"
                  method="post">
                <input type="text" name="id" value="${urinalysisVO.id}" hidden>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">隐血</label>
                        <div class="layui-input-block">
                            <input type="text" name="occult_blood" placeholder="隐血(mg/L)"
                                   value="${urinalysisVO.occult_blood.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">浊度</label>
                        <div class="layui-input-block">
                            <input type="text" name="hun_lev" placeholder="浊度"
                                   value="${urinalysisVO.hun_lev.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">白细胞酯酶</label>
                        <div class="layui-input-block">
                            <input type="text" name="leucocyte_esterase" placeholder="白细胞酯酶(leu/ul)"
                                   value="${urinalysisVO.leucocyte_esterase.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">颜色</label>
                        <div class="layui-input-block">
                            <input type="text" name="color" placeholder="颜色"
                                   value="${urinalysisVO.color.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">蛋白质</label>
                        <div class="layui-input-block">
                            <input type="text" name="protein" placeholder="蛋白质(g/L)"
                                   value="${urinalysisVO.protein.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">红细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="red_cell" lay-verify="digital|required" placeholder="红细胞(/ul)"
                                   value="${urinalysisVO.red_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">胆红素</label>
                        <div class="layui-input-block">
                            <input type="text" name="bilirubin" placeholder="胆红素(u mol/L)"
                                   value="${urinalysisVO.bilirubin.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">白细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="white_cell" lay-verify="digital|required" placeholder="白细胞(/ul)"
                                   value="${urinalysisVO.white_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">酮体</label>
                        <div class="layui-input-block">
                            <input type="text" name="ketone" placeholder="酮体(mmol/L)"
                                   value="${urinalysisVO.ketone.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">管型</label>
                        <div class="layui-input-block">
                            <input type="text" name="tube" lay-verify="digital" placeholder="管型(/ul)"
                                   value="${urinalysisVO.tube.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">尿胆原</label>
                        <div class="layui-input-block">
                            <input type="text" name="urobilinogen" placeholder="尿胆原(u mol/L)"
                                   value="${urinalysisVO.urobilinogen.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">上皮细胞</label>
                        <div class="layui-input-block">
                            <input type="text" name="up_cell" lay-verify="digital" placeholder="上皮细胞(/ul)"
                                   value="${urinalysisVO.up_cell.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">亚硝酸盐</label>
                        <div class="layui-input-block">
                            <input type="text" name="nitrite" placeholder="亚硝酸盐"
                                   value="${urinalysisVO.nitrite.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">细菌</label>
                        <div class="layui-input-block">
                            <input type="text" name="bacteria" lay-verify="digital" placeholder="细菌(/ul)"
                                   value="${urinalysisVO.bacteria.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">葡萄糖</label>
                        <div class="layui-input-block">
                            <input type="text" name="glucose" placeholder="葡萄糖(mmol/L)"
                                   value="${urinalysisVO.glucose.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">结晶</label>
                        <div class="layui-input-block">
                            <input type="text" name="crystal" lay-verify="digital" placeholder="结晶(/ul)"
                                   value="${urinalysisVO.crystal.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">PH</label>
                        <div class="layui-input-block">
                            <input type="text" name="pH" lay-verify="digital" placeholder="PH"
                                   value="${urinalysisVO.PH.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">粘液丝</label>
                        <div class="layui-input-block">
                            <input type="text" name="filament" lay-verify="digital" placeholder="粘液丝(/ul)"
                                   value="${urinalysisVO.filament.value}"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">比重</label>
                        <div class="layui-input-block">
                            <input type="text" name="levhigh" lay-verify="digital" placeholder="比重"
                                   value="${urinalysisVO.levhigh.value}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">类酵母菌</label>
                        <div class="layui-input-block">
                            <input type="text" name="class_bact" lay-verify="digital" placeholder="类酵母菌(/ul)"
                                   value="${urinalysisVO.class_bact.value}"
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