/*
    1.生成随机整数
    2.默认返回0-10 的值
*/
export function randomInt(max = 0, min = 10) {
  return Math.round((Math.random() * min) + max);
}
/* 随机十六进制颜色 */
export const randomHex = () =>
  `#${Math.floor(Math.random() * 0xffffff)
    .toString(16)
    .padEnd(6, '0')}`;

/* 复制指定文本 */
export function copyText(text = '') {
  const tempdom = document.createElement('input');
  tempdom.value = text;
  document.body.appendChild(tempdom);
  tempdom.select();
  document.execCommand('Copy');
  tempdom.remove();
}
