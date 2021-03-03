<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="4">
          左侧饼状图
        </v-col>
        <v-col cols="8">
          <div id="main" style="width: 100%;minHeight:400px;"></div>
        </v-col>
      </v-row>
    </v-container>

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
        title: {
          text: "ECharts 入门示例",
        },
        showBackground:true,
        tooltip: {},
        legend: {
          data: ["2019销量", "2020销量", "2021销量"],
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
        },
        yAxis: {
          position: "left",
        },
        series: [
          {
            name: "2019销量",
            type: "bar",
            data: [125, 202, 336, 102, 102, 22.01],
            showBackground: true
          },
          {
            name: "2020销量",
            type: "bar",
            data: [100, 175, 156, 180, 10, 224],
          },
          {
            name: "2021销量",
            type: "bar",
            data: [155, 210, 316, 110, 110, 20],
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