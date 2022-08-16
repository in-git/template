var prefix = "iu_global_tips_";
const tips = {
  bind(el, { value }) {
    var className = "global-tips";
    var div = document.createElement("div");
    div.className = className;
    div.textContent = value.text;
    div.classList.add(prefix + value.class);

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
      }, 2000);
    });
  },
};
export default tips;
