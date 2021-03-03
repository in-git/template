const _utils = {
  /* 
        功能说明:
            1.将数字转为字符串
            2.没三位带分隔符
            3.保留两位小数点
        效果:100,000,000.00
    */
  formatDouble(value) {
    var num = parseFloat(value);
    num = num.toFixed(2) + "";
    var str = num.split(".")[0];
    var lis = num.split(".")[1];
    var siz = 0;
    var result = "";
    for (var i = str.length - 1; i >= 0; i--) {
      if (siz++ % 3 == 0) {
        siz = 0;
        result = "," + str.substr(i, 3) + result;
      }
    }
    if (str.length % 3 != 0) {
      result = str.substr(0, str.length % 3) + result;
    } else {
      result = result.substring(1, result.length);
    }
    return result + "." + lis;
  },
};
export default _utils;
