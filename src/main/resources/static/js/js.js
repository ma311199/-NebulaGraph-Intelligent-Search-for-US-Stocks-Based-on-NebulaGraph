$(window).load(function() {
    $(".loading").fadeOut()
})
$(function() {
    echarts_1();
    echarts_2();
    echarts_3();
    echarts_4();
    echarts_5();
    echarts_6();
    zb1();
    zb2();
    zb3();
    zb4();
    zb5();
    zb6();

    function echarts_1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart1'));
        var option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: { // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['总成交量', '最大成交量', '最小成交量', '平均成交量', ],
                textStyle: {
                    color: 'skyblue'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,1)'
                    }
                }, //左线色
            },
            yAxis: {
                type: 'category',
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,1)'
                    }
                }, //左线色
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1)"
                    }
                }, //x轴线
                data: ['WeJiumeng', 'LGDxiye', 'TESknight', 'JDGKanavi', 'JackeyLove', 'SNSofM', 'V5Mole', 'EDGScout', 'SNhuanfeng', 'FPXDoinb']
            },
            series: [{
                name: '总成交量',
                type: 'bar',
                stack: '总量',
                itemStyle: {
                    color: '#37A2DA'
                },
                label: {
                    show: false,
                    position: 'insideRight'
                },
                data: [47, 52, 44, 48, 42, 52, 49, 37, 52, 45]
            },
                {
                    name: '最大成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#67E0E3'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [205, 191, 239, 169, 205, 125, 162, 136, 189, 157]
                },
                {
                    name: '最小成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#FFDB5C'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [266, 289, 299, 345, 278, 375, 270, 286, 315, 304]
                },
                {
                    name: '平均成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#7f8aff'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [119, 124, 76, 122, 117, 136, 115, 73, 102, 115]
                },

            ]
        };

        var cname=[];
        var totalVolume=[];
        var maxVolume=[];
        var minVolume=[];
        var avgVolume=[]
        //请求后台数据
        $.ajax({
            type: "get",
            url: "/stock/monthVolume",
            contentType: "application/json",
            success: function(res){
                console.log("=====res: =======")
                console.log(res);
                for (var i = 0; i < res.length ; i++) {
                    cname.push(res[i].cname);
                    totalVolume.push(res[i].total_wk_volume);
                    maxVolume.push(res[i].max_wk_volume);
                    minVolume.push(res[i].min_wk_volume);
                    avgVolume.push(res[i].avg_wk_volume);

                }
                myChart.setOption({
                    yAxis:[{
                        data: cname
                    }],
                    series:[
                        {
                            data: totalVolume
                        },
                        {
                            data: maxVolume
                        },
                        {
                            data: minVolume
                        },
                        {
                            data: avgVolume
                        }
                    ]
                });
            }
        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }



    function echarts_2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart2'));

        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            legend: {

                top: '10%',
                data: ['LNG\nLight', 'RNG\nXLB', 'FPX\nDoinb', 'IG\nTheShy', 'TES\nknight'],
                icon: 'circle',
                textStyle: {
                    color: 'rgba(255,255,255,.6)',
                }
            },
            calculable: true,
            series: [{
                name: '',
                color: ['#62c98d', '#2f89cf', '#4cb9cf', '#53b666', '#62c98d', '#205acf', '#c9c862', '#c98b62', '#c962b9', '#c96262'],
                type: 'pie',
                //起始角度，支持范围[0, 360]
                startAngle: 0,
                //饼图的半径，数组的第一项是内半径，第二项是外半径
                radius: [51, 100],
                //支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度
                center: ['50%', '45%'],

                //是否展示成南丁格尔图，通过半径区分数据大小。可选择两种模式：
                // 'radius' 面积展现数据的百分比，半径展现数据的大小。
                //  'area' 所有扇区面积相同，仅通过半径展现数据大小
                roseType: 'area',
                //是否启用防止标签重叠策略，默认开启，圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: true,
                        //  formatter: '{c}辆'
                    },
                    emphasis: {
                        show: true
                    }
                },
                labelLine: {
                    normal: {
                        show: true,
                        length2: 1,
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [{
                        value: 1,
                        name: 'LNG\nLight',
                    },
                    {
                        value: 4,
                        name: 'RNG\nXLB',
                    },
                    {
                        value: 5,
                        name: 'FPX\nDoinb',
                    },
                    {
                        value: 6,
                        name: 'IG\nTheShy',
                    },
                    {
                        value: 9,
                        name: 'TES\nknight',
                    },

                    {
                        value: 0,
                        name: "",
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },


                ]
            }]
        };
        // 定义x、y轴数据数组
        var cname=[]
        var symbol=[];
        var diff=[];
        //请求后台数据
        $.ajax({
            type: "get",
            url: "/stock/diff",
            contentType: "application/json",
            success: function(res){
                console.log("=====res: =======")
                console.log(res);
                for (var i = 0; i < res.length ; i++) {
                    cname.push(res[i].cname);
                    symbol.push(res[i].symbol);
                    diff.push(res[i].diff);
                }
                myChart.setOption({
                    legend:{
                        data:[cname[0]+'\n'+symbol[0],cname[1]+'\n'+symbol[1],cname[2]+'\n'+symbol[2],cname[3]+'\n'+symbol[3],cname[4]+'\n'+symbol[4]]
                    },
                    series: [{
                        data:[
                            {
                                value :diff[0],
                                name:cname[0]+'\n'+symbol[0]
                            },
                            {
                                value: diff[1],
                                name: cname[1] + '\n' + symbol[1]
                            },
                            {
                                value :diff[2],
                                name:cname[2]+'\n'+symbol[2]
                            },
                            {
                                value :diff[3],
                                name:cname[3]+'\n'+symbol[3]
                            },
                            {
                                value :diff[4],
                                name:cname[4]+'\n'+symbol[4]
                            },
                            {
                                value: 0,
                                name: "",
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            },
                            {
                                value: 0,
                                name: "",
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            },
                            {
                                value: 0,
                                name: "",
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            },
                            {
                                value: 0,
                                name: "",
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            },
                            {
                                value: 0,
                                name: "",
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            },
                        ]
                    }]
                });
            }
        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function echarts_3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart3'));

        option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    lineStyle: {
                        color: '#57617B'
                    }
                }
            },
            legend: {

                //icon: 'vertical',
                data: ['开盘价', '最高价', '最低价','收盘价'],
                //align: 'center',
                // right: '35%',
                top: '0',
                textStyle: {
                    color: "#fff"
                },
                // itemWidth: 15,
                // itemHeight: 15,
                itemGap: 20,
            },
            grid: {
                left: '0',
                right: '20',
                top: '10',
                bottom: '20',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: false,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: 'rgba(255,255,255,1)',
                        fontSize: 11
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,.1)'
                    }
                },
                data: ['\nWE\nJiumeng', '\nLGD\nxiye', '\nTES\nknight', '\nJDG\nKanavi', '\nTES\nJackeyLove', '\nSN\nSofM', '\nV5\nMole', '\nEDG\nScout',
                    '\nSN\nhuanfeng', '\nFPX\nDoinb', '\nIG\nNing', '\nV5\nSamd'
                ]
            }, {

            }],
            yAxis: [{
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: 'rgba(255,255,255,.6)'
                    }
                },
                scale:true,
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,.1)'
                    }
                },
                splitLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,.1)'
                    }
                }
            }],
            series: [{
                name: '开盘价',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {
                    normal: {
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(24, 163, 64, 0.3)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(24, 163, 64, 0)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#cdba00',
                        borderColor: 'rgba(137,189,2,0.27)',
                        borderWidth: 12
                    }
                },
                data: [205, 191, 239, 169, 205, 125, 162, 136, 189, 157, 121, 158]
            }, {
                name: '最高价',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {
                    normal: {
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(39, 122,206, 0.3)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(39, 122,206, 0)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#277ace',
                        borderColor: 'rgba(0,136,212,0.2)',
                        borderWidth: 12
                    }
                },
                data: [266, 289, 299, 345, 278, 375, 270, 270, 286, 315, 304, 220]
            }, {
                name: '最低价',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {
                    normal: {
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(39, 122,206, 0.3)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(39, 122,206, 0)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#ab2f80',
                        borderColor: 'rgba(29,133,70,0.5)',
                        borderWidth: 12
                    }
                },
                data: [119, 124, 76, 122, 117, 136, 115, 73, 102, 115, 107, 81]
            },
                {
                    name: '收盘价',
                    type: 'line',
                    smooth: true,
                    symbol: 'circle',
                    symbolSize: 5,
                    showSymbol: false,
                    lineStyle: {
                        normal: {
                            width: 2
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(39, 122,206, 0.3)'
                            }, {
                                offset: 0.8,
                                color: 'rgba(39, 122,206, 0)'
                            }], false),
                            shadowColor: 'rgba(0, 0, 0, 0.1)',
                            shadowBlur: 10
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: '#67E0E3',
                            borderColor: 'rgba(10,148,236,0.5)',
                            borderWidth: 12
                        }
                    },
                    data: [11, 124, 16, 122, 317, 136, 115, 73, 193, 15, 107, 29]
                }]
        };

        // 定义x、y轴数据数组
        var cname=[]
        var symbol=[];
        var open=[];
        var high=[];
        var low=[];
        var close=[];
        //请求后台数据
        $.ajax({
            type: "get",
            url: "/stock/price",
            contentType: "application/json",
            success: function(res){
                console.log("=====res: =======")
                console.log(res);
                for (var i = 0; i < res.length ; i++) {
                    cname.push(res[i].cname);
                    symbol.push(res[i].symbol);
                    open.push(res[i].open);
                    high.push(res[i].high);
                    low.push(res[i].low);
                    close.push(res[i].close);
                }
                myChart.setOption({
                    xAxis:[{
                        data:['\n'+cname[0]+'\n'+symbol[0],'\n'+cname[1]+'\n'+symbol[1],'\n'+cname[2]+'\n'+symbol[2],'\n'+cname[3]+'\n'+symbol[3],'\n'+cname[4]+'\n'+symbol[4],
                            '\n'+cname[5]+'\n'+symbol[5],'\n'+cname[6]+'\n'+symbol[6],'\n'+cname[7]+'\n'+symbol[7],'\n'+cname[8]+'\n'+symbol[8],'\n'+cname[9]+'\n'+symbol[9],
                            '\n'+cname[10]+'\n'+symbol[10],'\n'+cname[11]+'\n'+symbol[11]]
                    }],
                    series:[
                        {
                            data: open
                        },
                        {
                            data: high
                        },
                        {
                            data: low
                        },
                        {
                            data: close
                        }
                    ]
                });
            }
        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function echarts_4() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart4'));
        option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    lineStyle: {
                        color: '#57617B'
                    }
                }
            },
            "legend": {

                "data": [{
                        "name": "平均成交额"
                    },
                    {
                        "name": "总成交额"
                    },
                    {
                        "name": "总成交量"
                    }
                ],
                "top": "0%",
                "textStyle": {
                    "color": "rgba(255,255,255,1)", //图例文字
                    "fontSize": "16"
                }
            },

            "xAxis": [{
                "type": "category",

                data: ['BLG', 'VG', 'FPX', 'EDG', 'RNG', 'LGD', 'WE', 'SN', 'IG', 'V5', 'JDG', 'TES'],
                axisLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)"
                    }
                },
                axisLabel: {
                    textStyle: {
                        color: "rgb(255,255,255)",
                        fontSize: '11',
                    },
                },

            }, ],
            "yAxis": [
                {
                    type: "value",
                    name: "万元",
                    min: 0,
                    interval: 10,
                    axisLabel: {
                        show: true,

                    },
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(255,255,255,1)'
                        }
                    }, //左线色
                    axisTick:{
                        alignWithLabel:true
                    },
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: "rgba(255,255,255,0.5)"
                        }
                    }, //x轴线
                },
                {
                    "type": "value",
                    "name": "万股",
                    "show": true,
                    "axisLabel": {
                        "show": true,

                    },
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(255,255,255,1 )'
                        }
                    }, //右线色
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: "rgba(255,255,255,0.2)"
                        }
                    }, //x轴线
                },
            ],
            "grid": {
                "top": "10%",
                "right": "30",
                "bottom": "30",
                "left": "30",
            },
            "series": [{
                    "name": "平均成交额",

                    "type": "bar",
                    "data": [17, 19, 23, 20, 21, 29, 25, 31, 26, 30, 33, 33],
                    "barWidth": "auto",
                    "itemStyle": {
                        "normal": {
                            "color": {
                                "type": "linear",
                                "x": 0,
                                "y": 0,
                                "x2": 0,
                                "y2": 1,
                                "colorStops": [{
                                        "offset": 0,
                                        "color": "#67E0E3"
                                    },

                                    {
                                        "offset": 1,
                                        "color": "#67E0E3"
                                    }
                                ],
                                "globalCoord": false
                            }
                        }
                    }
                },
                {
                    "name": "总成交额",
                    "type": "bar",
                    "data": [
                        22, 22, 22, 18, 18, 25, 22, 21, 18, 19, 15, 12
                    ],
                    "barWidth": "auto",

                    "itemStyle": {
                        "normal": {
                            "color": {
                                "type": "linear",
                                "x": 0,
                                "y": 0,
                                "x2": 0,
                                "y2": 1,
                                "colorStops": [{
                                        "offset": 0,
                                        "color": "#FFDB5C"
                                    },
                                    {
                                        "offset": 1,
                                        "color": "#FFDB5C"
                                    }
                                ],
                                "globalCoord": false
                            }
                        }
                    },
                    "barGap": "0"
                },
                {
                    "name": "总成交量",
                    "type": "line",
                    "yAxisIndex": 1,

                    "data": [43, 46, 51, 52, 53, 53, 53, 59, 59, 61, 68, 73],
                    lineStyle: {
                        normal: {
                            width: 2
                        },
                    },
                    "itemStyle": {
                        "normal": {
                            "color": "#48f593",

                        }
                    },
                    "smooth": true
                }
            ]
        };


        // 定义x、y轴数据数组
        var category=[]
        var allvolume=[];
        var allprice=[];
        var avprice=[];

        //请求后台数据
        $.ajax({
            type: "get",
            url: "/stock/sumprice",
            contentType: "application/json",
            success: function(res){
                console.log("=====res: =======")
                console.log(res);
                for (var i = 0; i < res.length ; i++) {
                    category.push(res[i].category);
                    allvolume.push(res[i].allvolume);
                    allprice.push(res[i].allprice);
                    avprice.push(res[i].avprice);

                }
                myChart.setOption({
                    xAxis:[{
                        data: category
                    }],
                    series:[
                        {
                            data: avprice
                        },
                        {
                            data: allprice
                        },
                        {
                            data: allvolume
                        }
                    ]
                });
            }
        });
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function echarts_5() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart5'));
        var option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: { // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['总成交量', '最大成交量', '最小成交量', '平均成交量', ],
                textStyle: {
                    color: 'skyblue'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,1)'
                    }
                }, //左线色
            },
            yAxis: {
                type: 'category',
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,1)'
                    }
                }, //左线色
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1)"
                    }
                }, //x轴线
                data: ['WeJiumeng', 'LGDxiye', 'TESknight', 'JDGKanavi', 'JackeyLove', 'SNSofM', 'V5Mole', 'EDGScout', 'SNhuanfeng', 'FPXDoinb']
            },
            series: [{
                    name: '总成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#37A2DA'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [47, 52, 44, 48, 42, 52, 49, 37, 52, 45]
                },
                {
                    name: '最大成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#67E0E3'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [205, 191, 239, 169, 205, 125, 162, 136, 189, 157]
                },
                {
                    name: '最小成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#FFDB5C'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [266, 289, 299, 345, 278, 375, 270, 286, 315, 304]
                },
                {
                    name: '平均成交量',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        color: '#7f8aff'
                    },
                    label: {
                        show: false,
                        position: 'insideRight'
                    },
                    data: [119, 124, 76, 122, 117, 136, 115, 73, 102, 115]
                },

            ]
        };

        var cname=[];
        var totalVolume=[];
        var maxVolume=[];
        var minVolume=[];
        var avgVolume=[]
        //请求后台数据
        $.ajax({
            type: "get",
            url: "/stock/weekVolume",
            contentType: "application/json",
            success: function(res){
                console.log("=====res: =======")
                console.log(res);
                for (var i = 0; i < res.length ; i++) {
                    cname.push(res[i].cname);
                    totalVolume.push(res[i].total_wk_volume);
                    maxVolume.push(res[i].max_wk_volume);
                    minVolume.push(res[i].min_wk_volume);
                    avgVolume.push(res[i].avg_wk_volume);

                }
                myChart.setOption({
                    yAxis:[{
                        data: cname
                    }],
                    series:[
                        {
                            data: totalVolume
                        },
                        {
                            data: maxVolume
                        },
                        {
                            data: minVolume
                        },
                        {
                            data: avgVolume
                        }
                    ]
                });
            }
        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function echarts_6() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echarts6'));
        option = {
            polar: {
                radius: [30, '80%']
            },
            radiusAxis: {
                max: 4
            },
            angleAxis: {
                type: 'category',
                data: ['a', 'b', 'c', 'd'],
                startAngle: 75
            },
            tooltip: {},
            series: {
                type: 'bar',
                data: [2, 1.2, 2.4, 3.6],
                coordinateSystem: 'polar',
                label: {
                    show: true,
                    position: 'middle',
                    formatter: '{b}: {c}'
                }
            },
            animation: false
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }
    function zb1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('zb1'));
        document.getElementById('z1').innerHTML="Qg<br>胜率最高";

        var v2 = 33 //胜利
        var v1 = 12 //战败
        var v3 = v1 + v2 //总消费 
        option = {
            tooltip: {
                trigger: 'item',
            },
            series: [{

                type: 'pie',
                radius: ['60%', '70%'],
                color: '#37A2DA',
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: v2,
                    name: '胜利',
                    label: {
                        normal: {
                            formatter: v2 + '',
                            textStyle: {
                                fontSize: 20,
                                color: '#fff',
                            }
                        }
                    }
                }, {
                    value: v1,
                    name: '战败',
                    label: {
                        normal: {
                            formatter: function(params) {
                                return '胜率' + Math.round(v2 / v3 * 100) + '%'
                            },
                            textStyle: {
                                color: '#aaa',
                                fontSize: 12
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgba(255,255,255,.2)'
                        },
                        emphasis: {
                            color: '#fff'
                        }
                    },
                }]
            }]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function zb2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('zb2'));
        var v1 = 738 //总击杀
        var v2 = 542 //总死亡
        var v3 = v1 + v2 //
        option = {

            tooltip: {
                trigger: 'item',
            },
            series: [{
                type: 'pie',
                radius: ['60%', '70%'],
                color: '#32C5E9',
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: v1,
                    name: '总击杀',
                    label: {
                        normal: {
                            formatter: v1 + '',
                            textStyle: {
                                fontSize: 20,
                                color: '#fff',
                            }
                        }
                    }
                }, {
                    value: v2,
                    name: '总死亡',
                    label: {
                        normal: {
                            formatter: function(params) {
                                return '总击杀'
                            },
                            textStyle: {
                                color: '#aaa',
                                fontSize: 12
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgba(255,255,255,.2)'
                        },
                        emphasis: {
                            color: '#fff'
                        }
                    },
                }]
            }]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function zb3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('zb3'));
        var v1 = 51 //排眼
        var v2 = 121 //插眼
        var v3 = v1 + v2 //总消费 
        option = {
            tooltip: {
                trigger: 'item',
            },
            series: [{

                type: 'pie',
                radius: ['60%', '70%'],
                color: '#67E0E3',
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: v2,
                    name: '插眼',
                    label: {
                        normal: {
                            formatter: v2 + '',
                            textStyle: {
                                fontSize: 20,
                                color: '#fff',
                            }
                        }
                    }
                }, {
                    value: v1,
                    name: '排眼',
                    label: {
                        normal: {
                            formatter: function(params) {
                                return '总插眼'
                            },
                            textStyle: {
                                color: '#aaa',
                                fontSize: 12
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgba(255,255,255,.2)'
                        },
                        emphasis: {
                            color: '#fff'
                        }
                    },
                }]
            }]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function zb4() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('zb4'));
        var v1 = 76 //死亡
        var v2 = 239 //击杀
        var v3 = v1 + v2

        option = {
            tooltip: {
                trigger: 'item',
            },
            series: [{

                type: 'pie',
                radius: ['60%', '70%'],
                color: '#9FE6B8',
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: v2,
                    name: '击杀',
                    label: {
                        normal: {
                            formatter: v2 + '',
                            textStyle: {
                                fontSize: 20,
                                color: '#fff',
                            }
                        }
                    }
                }, {
                    value: v1,
                    name: '死亡',
                    label: {
                        normal: {
                            formatter: function(params) {
                                return '总击杀'
                            },
                            textStyle: {
                                color: '#aaa',
                                fontSize: 12
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgba(255,255,255,.2)'
                        },
                        emphasis: {
                            color: '#fff'
                        }
                    },
                }]
            }]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function zb5() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('zb5'));
        var v1 = 348 //助攻和击杀
        var v2 = 165 //死亡
        var v3 = v1 + v2 //总消费
        option = {
            tooltip: {
                trigger: 'item',
            },
            series: [{

                type: 'pie',
                radius: ['60%', '70%'],
                color: '#FFDB5C',
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: v2,
                    name: '总死亡',
                    label: {
                        normal: {
                            formatter: v2 + '',
                            textStyle: {
                                fontSize: 20,
                                color: '#fff',
                            }
                        }
                    }
                }, {
                    value: v1,
                    name: '击杀和助攻',
                    label: {
                        normal: {
                            formatter: function(params) {
                                return '总死亡'
                            },
                            textStyle: {
                                color: '#aaa',
                                fontSize: 12
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgba(255,255,255,.2)'
                        },
                        emphasis: {
                            color: '#fff'
                        }
                    },
                }]
            }]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function zb6() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('zb6'));
        var k = 19;
        var a = 34;
        var d = 7;
        var v1 = d //死亡
        var v2 = k + a //击杀和助攻
        option = {
            tooltip: {
                trigger: 'item',
            },
            series: [{

                type: 'pie',
                radius: ['60%', '70%'],
                color: '#FB7293',
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: v2,
                    name: '击杀和助攻',
                    label: {
                        normal: {
                            formatter: v2 + '',
                            textStyle: {
                                fontSize: 20,
                                color: '#fff',
                            }
                        }
                    }
                }, {
                    value: v1,
                    name: '死亡',
                    label: {
                        normal: {
                            formatter: function(params) {
                                return 'KDA：' + Math.round((k + a) / d)
                            },
                            textStyle: {
                                color: '#aaa',
                                fontSize: 12
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgba(255,255,255,.2)'
                        },
                        emphasis: {
                            color: '#fff'
                        }
                    },
                }]
            }]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }
})