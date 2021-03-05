<template>
  <div id="app">
    <div id="main" style="max-width:600px; width: 100%;height:400px;"></div>
  </div>
</template>
<script>
export default {
  name: "app",
  methods: {
    drawChart() {
      let myChart = this.$echarts.init(document.getElementById("main"));
      // 指定图表的配置项和数据
      let option = {
        /* **************
        |    工具栏    |
        *****************/
        toolbox: {
          show: true,
          orient: "vertical", //方向:horizontal,vertical
          itemSize: 14, //图标大小
          showTitle: true, //是否显示图标提示
          feature: {
            // 图片保存
            saveAsImage: {
              type: "png", //保存图片的类型
              name: "echarts_pictrue", //保存图片的名字
              backgroundColor: "", //背景颜色
              title: "保存图片", //图标标题
              // icon: "", //设置图标url
            },
            restore: {
              show: true,
              title: "还原",
            }, //  还原
            dataView: {}, //数据显示
            dataZoom: {}, //缩放
            magicType: {
              //动态类型切换
              type: ["line", "bar", "stack", "tiled"],
            },
            brush: {},
          }, //自定义图标
          tooltip: {
            show: true,
            formatter: function (param) {
              return "<div>" + param.title + "</div>"; // 自定义的 DOM 结构
            },
          },
        },
        /* **************
        |    表格标题    |
        *****************/
        title: {
          text: "表格标题",
          show: true, //是否展示表格标题
          link: "https://www.baidu.com", //文本链接
          target: "blank", //self:当前窗口打开link,blank:新窗口打开link
          textStyle: {
            //样式
            color: "pink", //颜色
            fontSize: 12, //大小
          },
          subtext: "副标题", //副标题
          sublink: "https://www.baidu.com", //富文本链接
          subtextStyle: {}, //富文本样式
          textAlign: "auto",
          //副标题和标题的对齐方式
          //'auto'、'left'、'right'、'center'
          triggerEvent: true, //是否触发事件
          zlevel: 2, //控制显示顺序
          // 位置
          // top:0,left:0,right:0,bottom:0
        },
        /* **********
        |  组件容器  |
        *************/
        grid: {
          show: false,
          backgroundColor: "red",
          shadowColor: "pink",
          // 位置
          // top:0,left:0,right:0,bottom:0
        },

        /* **********
        |  辅助提示  | 
        *************/
        tooltip: {
          show: true,
          trigger: "axis", //触发位置:item,axis
          axisPointer: {
            type: "cross", //指针类型:line,shadow,cross,none
            snap: false, //自动吸附
            z: 0, //指针显示顺序
            lable: {
              //指针文本标签
              show: false,
              precision: 2, //小数点精度
              color: "green",
            },
          },
        },
        /* **************
        |  图标筛选模块  |
        *****************/
        legend: {
          // data: ["销量", "产量"], //数据,必须与series的保持一致
          // 选择按钮:
          type: "plain", //类型:plain,scroll,使用scroll需要其他配置
          orient: "horizontal", // horizontal:水平,vertical:垂直,多个生效
          align: "left", //选择按钮: 文字和按钮的位置 auto,left,right
          formatter: "{name}", //文字格式
          selectedMode: true, //是否能筛选
          inactiveColor: "pink", //关闭选择时的颜色
          // 位置
          // top:0,left:0,right:0,bottom:0
          textStyle: {}, //文本样式
        },
        /* **************
        |     X轴坐标    |
        *****************/
        xAxis: {
          position: "bottom", //位置:top,bottom
          triggerEvent: {
            //是否响应鼠标
          },
          // 坐标轴的线
          axisLine: {
            show: true, //默认显示
          },
          //类型-category:离散数据
          //类型-value:连续数据,会变成细线[bar]
          //类型-time:时间轴
          //类型-log:对数轴
          type: "category",
          name: "x轴名字", //x轴的名字
          nameLocation: "", //名字位置:start,end,middle
          nameRotate: 45, //名字旋转角度
          inverse: false, //名字是否旋转
          //  min:0,max:100:最小值,最大值
          scale: false, //当type=true有效
          silent: false, //禁止交互
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
          // realtimeSort: true, //开启动态图
          // sortSeriesIndex: 12, //动态排序选择的ID
        },
        yAxis: {
          position: "left",
          realtimeSort: true,
        },
        series: [
          {
            name: "销量",
            type: "line",
            data: [125, 20, 36, 10, 10, 202],
          },
          {
            name: "产量",
            type: "bar",
            data: [5, 20, 36, 10, 10, 120],
          },
          {
            name: "价格",
            type: "bar",
            data: [5, 20, 36, 10, 10, 20],
          },
        ],
        darkMode: {},
        animation: true, //开启动画
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
  },
  mounted() {
    this.drawChart();
  },
};
</script>