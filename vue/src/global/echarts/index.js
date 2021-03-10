/* 
    导出echarts文件
*/
import grid from "./common/grid";
import title from "./common/title";
import toolbar from "./common/toolbar";
import toolbox from "./common/toolbox";
import xAxis from "./common/xAxis";
import yAxis from "./common/yAxis";
let echarts = require("echarts");
let option = {
  yAxis,
  xAxis,
  toolbox,
  toolbar,
  title,
  grid,
};
let _echarts = {
  // 初始化
  init: (selector) => {
    let _mecharts = echarts.init(document.querySelector(selector));
    _mecharts.setOption(option);
  },
  //   需要传输的数据
  option
};
export default _echarts;
