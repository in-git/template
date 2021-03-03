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
      let myChart = this.$echarts.init(document.getElementById("main"));
      // 指定图表的配置项和数据
      let option = {
        grid: {
          show: true,
        },
        title: {
          text: "ECharts 入门示例",
        },
        tooltip: {},
        legend: {
          data: ["销量", "产量"],
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
        },
        yAxis: {
          position: "right",
        },
        series: [
          {
            name: "销量",
            type: "bar",
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