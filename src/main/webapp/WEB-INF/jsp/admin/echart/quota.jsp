<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>指标视图</title>
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
              <a><cite>指标视图</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/echart/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>

        <div class="layui-form">
            <div class="layui-inline">
                检查单：
                <div class="layui-input-inline">
                    <select name="checkType" id="checkType" lay-filter ="checkTypeFun"
                            class="layui-form-select">
                        <option value="esr" selected>血沉</option>
                        <option value="immunoglobulin">免疫球蛋白C3C4</option>
                        <option value="protein">24小时尿蛋白测定</option>
                        <option value="routine">血常规</option>
                        <option value="screening">生化筛查常规</option>
                        <option value="urinalysis">尿常规</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                指标项：
                <div class="layui-input-inline">
                    <select name="quotaName" id="quotaName" lay-filter="monitorEchart"
                            class="layui-form-select">
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                时间频次：
                <div class="layui-input-inline">
                    <select name="timeSelect" id="timeSelect" lay-filter="timeSelectFunc"
                            class="input-select">
                        <option value="7" selected>最近七次</option>
                        <option value="15">最近十五次</option>
                        <option value="30">最近三十次</option>
                        <option value="">所有</option>
                    </select>
                </div>
            </div>
        </div>


        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" style="margin-top:5px; background-image: url(${pageContext.request.contextPath}/resources/1.png)">
            <div id="monitorDataSearchEchartDiv" style="width: 100%;height: 400px"></div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/echarts.js"></script>
<script>
    layui.use(['table', 'element', 'jquery', 'form'], function () {
        var table = layui.table,
            element = layui.element,
            form = layui.form,
            $ = layui.jquery;
        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
        var myTemperatureChart = echarts.init(document
            .getElementById('monitorDataSearchEchartDiv'));

        form.on('select(monitorEchart)', function(data){
            echartLoad(myTemperatureChart);
        });
        form.on('select(checkTypeFun)', function(data){
            checkTypeMapped();
            echartLoad(myTemperatureChart);
        });
        form.on('select(timeSelectFunc)', function(data){
            echartLoad(myTemperatureChart);
        });

        //弹出层
        var msg = "${msg}";
        if (msg.length != "") {
            layer.msg(msg, {icon: 6});
            $("#msg").text("");
        }
        layer.ready(function(){
            checkTypeMapped();
            echartLoad(myTemperatureChart);
        });
    });
    function checkTypeMapped() {
        layui.use(['jquery', 'form'], function () {
            var $ = layui.jquery;
            var form = layui.form;
            var checkType = $("select[name='checkType'] option:selected").val();$.ajax({
                url: "${pageContext.request.contextPath}/common/checkTypeSelection/"+checkType,
                type: "get",
                async: false,
                success: function (data) {
                    if(data != null) {
                        $("#quotaName").html("");
                    }
                    for(var key in data) {
                        $("#quotaName").append("<option value='"+data[key]+"'>"+key+"</option>");
                    }
                    form.render();
                }
            });
        });
    }
    function echartLoad(myTemperatureChart) {
        layui.use(['jquery'], function () {
            var $ = layui.jquery;
            var checkType = $("select[name='checkType'] option:selected").val();
            var quotaName = $("select[name='quotaName'] option:selected").val();
            var timeSearch = $("select[name='timeSelect'] option:selected").val();
            var quotaDesc = $("select[name='quotaName'] option:selected").text();
            var xdata = [];
            var minLine = 0, maxLine = 0;
            var seriesData = [];
            var unit = "";
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/admin/echart/quota/loadData",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({
                    checkType: checkType,
                    quotaName: quotaName,
                    timeSearch: timeSearch
                }),
                dataType: "json",
                async: false,
                success: function (data) {
                    if(data.dateString != null) {
                        xdata = data.dateString;
                        seriesData = data.seriesData;
                        minLine = data.downLimit;
                        maxLine = data.upLimit;
                        unit = data.unit;
                    }
                }
            });
            //myTemperatureChart.clear();
            // 显示标题，图例和空的坐标轴
            myTemperatureChart.setOption({
                title: {
                    text: ''
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {},
                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        dataView: { readOnly: false },
                        magicType: { type: ['line', 'bar'] },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    axisTick: {           //去掉坐标轴刻线
                        show: false
                    },
                    data: xdata,
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(30,130,190,0.7)'     //X轴的颜色
                        },
                    },
                    axisLabel: {
                        textStyle:{
                            color:'#FFF',
                            fontSize:13
                        },
                        interval:0,
                        rotate:40
                    }
                },
                visualMap: {
                    show: false,
                    pieces: [
                        {
                            gte: minLine,
                            lte: maxLine,          //这儿设置基线上下颜色区分 基线下面为绿色
                            color: '#03d6d6'
                        }, {

                            gt: maxLine,          //这儿设置基线上下颜色区分 基线上面为红色
                            color: '#e91642'
                        }, {

                            lt: minLine,          //这儿设置基线上下颜色区分 基线上面为红色
                            color: '#e91642'
                        }]
                },
                yAxis: {
                    type: 'value',
                    name: unit,
                    nameTextStyle:{
                        color:"#FFF",
                        fontSize:13,
                    },
                    axisLabel: {
                        formatter: '{value}',
                        textStyle:{
                            color:'#FFF',
                            fontSize:13
                        }
                    },
                    axisTick: {//去掉坐标轴刻线
                        show: false
                    },
                    axisLine:{
                        lineStyle:{
                            color:'rgba(30,130,190,0.7)'         //y轴的颜色
                        },
                    },
                    splitLine:{show: false}//去除网格线
                },
                series: [
                    {
                        name: quotaDesc,
                        type: 'line',
                        smooth: 0.2, //平滑处理，为number时，值越小越接折线（0-1）true=0.5
                        itemStyle: {
                            normal: {
                                lineStyle: {
                                    width:3// 0.1的线条是非常细的了
                                }
                            }
                        },
                        data: seriesData,
                        markPoint: {
                            data: [
                                { type: 'max', name: 'Max' },
                                { type: 'min', name: 'Min' }
                            ]
                        },
                        markLine: {
                            silent: true,
                            lineStyle: {
                                normal: {
                                    color: '#01fef9'                   // 这儿设置安全基线颜色
                                }
                            },
                            data: [{
                                yAxis: minLine
                            },{
                                yAxis: maxLine
                            }],
                            label: {
                                normal: {
                                    formatter: '安全\n基线'           // 这儿设置安全基线
                                }
                            }
                        }

                    }
                ]
            });
            // myTemperatureChart.showLoading(); // 数据加载完之前先显示一段简单的loading动画
            // var aaa = [];    //类别数组（实际用来盛放X轴坐标值）
            // var legendData = [];
            // var seriesArray = [];
            //
            // //加载数据层
            // var indexs = layer.load(3);
            // $.ajax({
            //     url: "monitor/data",
            //     type: "POST",
            //     data: {
            //         checkType: checkType,
            //         quotaName: quotaName,
            //         timeSearch: timeSearch
            //     },
            //     dataType: "json",
            //     async: false,
            //     success: function (data) {
            //
            //
            //         if (data.jsonFlag == 1) {//里面有值
            //             console.log(data.data)
            //             if (data.data != null && data.data.length > 0) {
            //                 //处理x轴时间
            //                 for (var i = 0; i < data.data.length; i++) {//一行数据
            //                     //
            //                     var timeStr = "";//处理时间
            //                     if (data.data[i].arrayofkeyvalue.k != null && data.data[i].arrayofkeyvalue.k != "") {
            //                         var nian = data.data[i].arrayofkeyvalue.k.slice(0, 4);
            //                         var yue = data.data[i].arrayofkeyvalue.k.slice(4, 6);
            //                         var ri = data.data[i].arrayofkeyvalue.k.slice(6, 8);
            //                         var shi = data.data[i].arrayofkeyvalue.k.slice(8, 10);
            //                         var fen = data.data[i].arrayofkeyvalue.k.slice(10, 12);
            //                         var miao = data.data[i].arrayofkeyvalue.k.slice(12, 14);
            //                         timeStr = nian + "-" + yue + "-" + ri + " " + shi + ":" + fen + ":" + miao;
            //                         console.log("时间" + timeStr)
            //                         aaa.push(timeStr)
            //                     }
            //                 }
            //                 //处理seriesArray和因子名称
            //                 var objectLength = 0;//因子下标
            //                 for (var k = 0; k < objectLength + 1; k++) {//objectLength+1 解决下标为0不能进入的问题
            //
            //                     var dataRtd = [];
            //                     var map = "", arrB = [], colObjectB = "";
            //                     for (var i = 0; i < data.data.length; i++) {//一行数据
            //                         //
            //                         if (data.data[i].arrayofkeyvalue.k != null && data.data[i].arrayofkeyvalue.k != "") {
            //
            //
            //                             //得到因子名称对象
            //                             var colObject = data.data[0].arrayofkeyvalue.v
            //                             colObjectB = colObject;
            //                             var colObjectKeyValue = data.data[i].arrayofkeyvalue.v
            //                             //转为数组
            //                             var arr = []
            //                             for (var i in colObjectKeyValue) {
            //                                 arr.push(i); //值
            //                             }
            //                             // arrB = arr;
            //
            //                             objectLength = arr.length;
            //
            //                             if (k < objectLength) {//解决一开始的问题，实质是<才能进入
            //                                 dataRtd.push(arr[k].Rtd);
            //
            //                             } else {
            //                                 break;
            //                             }
            //
            //                         }
            //
            //                     }
            //
            //
            //                     console.log(dataRtd)//每个因子对应的集合实时值
            //
            //                     if (dataRtd.length > 0) {
            //                         console.log(colObjectB)
            //                         var arrB = [];//把object转成数组
            //                         for (var j in colObjectB) {
            //                             arrB.push(j); //因子名
            //                         }
            //
            //                         for (var a = 0; a < arrB.length; a++) {
            //                             if (a == k) {
            //                                 //   console.log("实时"+dataRtd)//因子名
            //                                 console.log("因子名")
            //                                 console.log(arrB[k])
            //                                 var divisor = {
            //                                     'name': arrB[k],
            //                                     'type': 'line',
            //                                     'symbol': 'emptydiamond', // 设置折线图中表示每个坐标点的符号
            //                                     'data': dataRtd
            //                                 };
            //                                 legendData.push(arrB[k]);
            //                                 seriesArray.push(divisor)
            //                             }
            //
            //                         }
            //
            //
            //                     }
            //                 }
            //
            //                 myTemperatureChart.hideLoading(); // 隐藏加载动画
            //                 myTemperatureChart.setOption({ // 加载数据图表
            //                     legend: {
            //                         'data': legendData
            //                     },
            //                     //错误写法
            //                     // xAxis: {
            //                     //     data: aaa
            //                     // },
            //                     //正确写法
            //                     xAxis: [
            //                         {
            //                             type: 'category',
            //                             boundaryGap: false,
            //                             data: aaa
            //                         }
            //                     ],
            //
            //
            //                     series: seriesArray
            //
            //
            //                     //  series:  [{name: "烟气温度", type: "line", symbol: "emptydiamond",data:["17.9300","17.9300","17.9300","17.9300"]}
            //                     // ,{name: "烟气流速", type: "line", symbol: "emptydiamond",data:["17.9300","17.9300","17.9300","17.9300"]}
            //                     // ,{name: "烟气压力", type: "line", symbol: "emptydiamond",data:["17.9300","17.9300","17.9300","17.9300"]}
            //                     //  ,{name: "废气", type: "line", symbol: "emptydiamond",data:["17.9300","17.9300","17.9300","17.9300"]}
            //                     // ,{name: "烟气湿度", type: "line", symbol: "emptydiamond",data:["17.9300","17.9300","17.9300","17.9300"]}
            //                     //  ,{name: "非甲烷总烃", type: "line", symbol: "emptydiamond",data:["17.9300","17.9300","17.9300","17.9300"]}]
            //                 });
            //                 console.log(myTemperatureChart)
            //             } else {
            //                 layer.msg('没有查询到数据！', {offset: '150px', icon: 1});
            //                 myTemperatureChart.hideLoading();
            //             }
            //
            //         } else {
            //
            //             layer.msg('没有查询到数据！', {offset: '150px', icon: 1});
            //             myTemperatureChart.hideLoading();
            //
            //         }
            //         myTemperatureChart.hideLoading();
            //
            //         //加载数据层关闭
            //         layer.close(indexs);
            //         return false;
            //     }
            // });
        });
    }
</script>
</body>

</html>