/**
 * element           要绑定事件的对象及HTML节点。
 * type              事件名称attachEvent监听的事件前边的加上“on”比如“onclick”和“onmouseover”addEventListener与之相反。
 * listener          要绑定的事件监听函数
 */
/* eslint-disable */
export const addEvent = function (element: any, type: any, callback: any) {
  if (element.addEventListener) {
    // 支持使用 addEventListener()
    if (type.slice(0, 2) === "on")
      // 以 "on" 开头不需要则去掉
      type = type.slice(2);
    element.addEventListener(type, callback);
  } else if (element.attachEvent) {
    // 支持使用 attachEvent()
    if (type.slice(0, 2) !== "on")
      // 没有以 "on" 开头需要则加上
      type = "on" + type;
    element.attachEvent(type, callback);
  } else {
    type.slice(0, 2) !== "on"
      ? (element["on" + type] = callback)
      : (element[type] = callback);
  }
};
/**
 * @description 复制
 * @param {*} id DOM ID
 */
export const copyDomText = (node: HTMLElement) => {
  let createRange = document.createRange();
  createRange.selectNodeContents(node);
  const selection = document.getSelection() as Selection;
  selection.removeAllRanges();
  selection.addRange(createRange);
  document.execCommand("Copy");
  selection.removeAllRanges();
};

export const createStyle = (code: string) => {
  var style = document.createElement("style");
  //for Chrome Firefox Opera Safari
  style.appendChild(document.createTextNode(code));
  //for IE
  //style.styleSheet.cssText = code;
  var head = document.getElementsByTagName("head")[0];
  head.appendChild(style);
};
export const openLink = (href: string) => {
  var link = document.createElement("a") as HTMLAnchorElement;
  link.href = href;
  link.target = "_blank";
  document.body.append(link);
  link.click();
  setTimeout(() => link.parentNode?.removeChild(link));
};

// 删除事件
export function removeEvent(el: any, event: String, handler: Function) {
  if (!el) {
    return
  }
  if (el.detachEvent) {
    el.detachEvent('on' + event, handler)
  } else if (el.removeEventListener) {
    el.removeEventListener(event, handler, true)
  } else {
    el['on' + event] = null
  }
}