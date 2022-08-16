export const EventUtil = {

   addHandler: function (element, type, handler) { //添加事件
      if (element.addEventListener) {
         element.addEventListener(type, handler, false);  //使用DOM2级方法添加事件
      } else if (element.attachEvent) {                    //使用IE方法添加事件
         element.attachEvent("on" + type, handler);
      } else {
         element["on" + type] = handler;          //使用DOM0级方法添加事件
      }
   },

   removeHandler: function (element, type, handler) {  //取消事件
      if (element.removeEventListener) {
         element.removeEventListener(type, handler, false);
      } else if (element.detachEvent) {
         element.detachEvent("on" + type, handler);
      } else {
         element["on" + type] = null;
      }
   },

   getEvent: function (event) {  //使用这个方法跨浏览器取得event对象
      return event ? event : window.event;
   },

   getTarget: function (event) {  //返回事件的实际目标
      return event.target || event.srcElement;
   },

   preventDefault: function (event) {   //阻止事件的默认行为
      if (event.preventDefault) {
         event.preventDefault();
      } else {
         event.returnValue = false;
      }
   },

   stopPropagation: function (event) {  //立即停止事件在DOM中的传播
      //避免触发注册在document.body上面的事件处理程序
      if (event.stopPropagation) {
         event.stopPropagation();
      } else {
         event.cancelBubble = true;
      }
   },

   getRelatedTarget: function (event) {  //获取mouseover和mouseout相关元素
      if (event.relatedTarget) {
         return event.relatedTarget;
      } else if (event.toElement) {      //兼容IE8-
         return event.toElement;
      } else if (event.formElement) {
         return event.formElement;
      } else {
         return null;
      }
   },


   getWheelDelta: function (event) { //获取表示鼠标滚轮滚动方向的数值
      if (event.wheelDelta) {
         return event.wheelDelta ;
      } else {
         return -event.detail * 40;
      }
   },

   getCharCode: function (event) {   //以跨浏览器取得相同的字符编码，需在keypress事件中使用
      if (typeof event.charCode == "number") {
         return event.charCode;
      } else {
         return event.keyCode;
      }
   }

};