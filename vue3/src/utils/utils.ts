/* eslint-disable */
let temp: any = null;
export const debounce = (fn: any, timer = 500) => {
  var that = this;
  return function callback(args: any) {
    if (temp) {
      clearTimeout(temp);
    }
    temp = setTimeout(() => {
      fn.call(that, args);
      return;
    }, timer);
  };
};

/* 获取本地对象信息 */
export const getLacalInfo = (key: string) => {
  var info = window.localStorage.getItem(key);
  if (typeof info === "string") {
    return info;
  } else if (typeof info === "object" && info !== null) {
    return JSON.parse(info);
  }
};

/* 设置本地对象信息 */
export const setLocalInfo = (key: string, value: any) => {
  window.localStorage.setItem(key, value);
};

/* 检查是不是移动端 */
export const isMobile = () => {
  //获取浏览器navigator对象的userAgent属性（浏览器用于HTTP请求的用户代理头的值）
  var info = navigator.userAgent;
  //通过正则表达式的test方法判断是否包含“Mobile”字符串
  var isPhone = /mobile/i.test(info);
  //如果包含“Mobile”（是手机设备）则返回true
  return isPhone;
};
/* 检查是不是PC */
export function isPc() {
  return /(Win32|Win16|WinCE|Mac68K|MacIntel|MacIntel|MacPPC|Linux mips64)/i.test(
    navigator.platform
  );
}

/* 生成随机数字 */
export const randomNumber = (min: number, max: number) => {
  return Math.floor(Math.random() * (max - min + 1) + min);
};

/* 生成随机颜色 */
export const randomColor = () => {
  return `#${Math.floor(Math.random() * 0xffffff).toString(16)}`;
};
