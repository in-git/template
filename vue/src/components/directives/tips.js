/* 
  样式文件:global.scss 
  使用:v-tips="{text:'msg'}"
*/

var className = "d-tips animate__animated animate__lightSpeedInRight";
const tips = {
  bind(el, { value }) {
    var div = document.createElement("div");
    console.log(value);
    div.textContent = value.text;
    div.className = className
    var clearFlag;
    el.addEventListener("mouseenter", function () {
      var globalTips = document.querySelectorAll("." + className);
      Array.from(globalTips).forEach((node) => {
        node.parentNode.removeChild(node);
      });

      el.style.position = "relative";
      el.append(div);
      clearInterval(clearFlag);
      clearFlag = setTimeout(() => {
        if (el.contains(div)) el.removeChild(div);
      }, 4000);
    });
  },
};
export default tips;
