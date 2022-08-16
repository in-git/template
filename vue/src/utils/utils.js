// 绑定事件
export const on = function (ele, type, handle) {
  if (ele.addEventListener) {
    ele.addEventListener(type, handle, false);
  } else if (ele.attachEvent) {
    ele.attachEvent("on" + type, function () {
      handle.call(ele);
    });
  } else {
    ele["on" + type] = handle;
  }
};
// 节流
var CLEAR_FLAG = undefined;
export const debonuce = function (func, delay = 300) {
  clearTimeout(CLEAR_FLAG);
  return (() => {
    setTimeout(() => {
      func.call(this);
    }, delay);
  })();
};

// 加载文件夹下所有文件
// 使用方式
// var drawers = importAll(require.context('../views/drawers', true, /\.vue$/))
export const importAll = context => {
  const map = {}
  for (const key of context.keys()) {
    const keyArr = key.split('/')
    keyArr.shift() // 移除.
    map[keyArr.join('.').replace(/\.js$/g, '')] = context(key)
  }

  return map
}
