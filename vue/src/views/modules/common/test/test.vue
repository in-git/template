<template>
  <div id="app">
    <div id="main" style="width: 600px;height:400px;"></div>
  </div>
</template>
<script>
export default {
  name: "app",
  methods: {
    drawChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("main"));
      // 指定图表的配置项和数据
      let option = {
        title: {
          text: "ECharts 入门示例",
          textStyle: {
            color: "purple",
          },
          borderWidth: 0.5,
          borderColor: "rbga(0,0,0,0.2 )",
          left: 15,
          top: 18,
        },
        tooltip: {
          trigger: "axis",
          triggerOn: "click",
          formatter: "hah",
        },
        toolbox: {
          feature: {
            saveAsImage: {},
            dataView: {},
            restore: {},
            dataZoom: {},
            magicType: {
              type: ["bar", "line", "pie"],
            },
          },
        },
        legend: {
          data: ["销量"],
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: [5, 20, 36, 10, 10, 20],
          },
        ],
        dataZoom: [
          {
            // 这个dataZoom组件，默认控制x轴。
            type: "slider", // 这个 dataZoom 组件是 slider 型 dataZoom 组件
            start: 0, // 左边在 10% 的位置。
            end: 100, // 右边在 60% 的位置。
          },
        ],
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
