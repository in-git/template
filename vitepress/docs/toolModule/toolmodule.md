---
pageClass: getting-started
---

# 工具模块

该工具模块存放的是平时封装的函数

不积硅步，无以至千里。不积小流，无以成江海。

不依赖第三方代码

[W3school](https://www.w3school.com.cn/js/js_window_location.asp)

## 判断是否为 JSON 字符串

```js
  /**
   * 是否为JSON字符串
   * @param {String} str json字符串
   * @return {Boolean}
   */
  isJSON(str) {
    if (typeof str == 'string') {
      try {
        var obj = JSON.parse(str);
        return true;
      } catch (e) {
        return false;
      }
    }
    return false;
  }
```

## 去除字符串首尾两端空格

```js
  /**
   * 去除字符串首尾两端空格
   * @param {String} str
   * @return {String}
   */
  trim(str) {
    if (str) {
      return str.replace(/(^\s*)|(\s*$)/g, '');
    } else {
      return '';
    }
  }
```

## 脱敏 （保护数据隐私）

```js
  /**
   * 脱敏 （保护数据隐私）
   * split 将字符串转数组
   * map 返回一个新数组，数组中的元素为原始数组元素调用函数处理后的值。不会对空数组进行处理
   * join 将数组转字符串
   * @param {String} value 脱敏的对象
   * @return {String}
   */
  desensitization(value) {
    if (value) {
      var valueNew = '';
      const length = value.length;
      valueNew = value
        .split('')
        .map((number, index) => {
          // 脱敏：从倒数第五位开始向前四位脱敏
          const indexMin = length - 8;
          const indexMax = length - 5;

          if (index >= indexMin && index <= indexMax) {
            return '*';
          } else {
            return number;
          }
        })
        .join('');
      return valueNew;
    } else {
      return '';
    }
  }
```

## 判断是否 Array 对象

```js
  /**
   * 判断是否Array对象
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isArray(value) {
    return Object.prototype.toString.call(value) === '[object Array]';
  }
```

## 判断是否 Object 对象

```js
  /**
   * 判断是否Object对象
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isObject(value) {
    return Object.prototype.toString.call(value) === '[object Object]';
  }
```

## 判断是否日期对象

```js
  /**
   * 判断是否日期对象
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isDate(value) {
    return Object.prototype.toString.call(value) === '[object Date]';
  }
```

## 判断是否 Function 对象

```js
  /**
   * 判断是否Function对象
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isFunction(value) {
    return Object.prototype.toString.call(value) === '[object Function]';
  }
```

## 判断是否正则表达式

```js
  /**
   * 判断是否正则表达式
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isRegExp(value) {
    return Object.prototype.toString.call(value) === '[object RegExp]';
  }
```

## 判断是否 Math

```js
  /**
   * 判断是否Math
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isMath(value) {
    return Object.prototype.toString.call(value) === '[object Math]';
  }
```

## 判断值是否不为空

```js
  /**
   * 含有数据
   * @param {Object} value 判断的值
   * @return {Boolean}
   */
  hasValue(value) {
    return !this.isEmpty(value);
  }
```

## 判断是否移动电话

```js
  /**
   * 判断是否移动电话
   * @param {Number} value 判断的值
   * @return {Boolean}
   */
  isMobilePhone(value) {
    // 移动电话
    return /^1[3|4|5|7|8|9|6][0-9]\d{4,8}$/.test(value);
  }
```

## 判断是否为空

```js
  /**
   * 判断是否为空
   * @param {Object} value 判断的对象
   * @return {Boolean}
   */
  isEmpty(value) {
    return value === null || value === undefined || value === '' || (this.isArray(value) && value.length === 0);
  }
```

## 判断是否为邮箱

```js
  /**
   * 判断是否为邮箱
   * @param {String} value 判断的值
   * @return {Boolean}
   */
  isEmail(value) {
    return /^[a-zA-Z\-_0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+)+$/.test(value);
  }
```

## 对象转 json 字符串

```js
  /**
   * 对象转换为json字符串
   * @param  {JSON} jsonObj Json对象
   * @return {String} Json字符串
   */
  toJsonStr(jsonObj) {
    return JSON.stringify(jsonObj);
  },
```

# json 字符串转换为 json 对象

```js
  /**
   * json字符串转换为json对象
   * @param {String} jsonStr Json对象字符串
   * @return {JSON} Json对象
   */
  toJson(jsonStr) {
    return JSON.parse(jsonStr);
  },
```

## LocalStorage 与 SessionStorage 存储

```js
  /**
   * window.location.href 返回当前页面的 href (URL)
   * window.location.hostname 返回 web 主机的域名
   * window.location.pathname 返回当前页面的路径或文件名
   * window.location.protocol 返回使用的 web 协议（http: 或 https:）
   * window.location.assign 加载新文档
   */
  getModuleKey (key) {
    var moduleName = window.location.pathname; //得到  /basehome/
    moduleName = moduleName.substring(0, moduleName.length - 1); //得到  /basehome
    moduleName = moduleName.substring(moduleName.lastIndexOf('/') + 1, moduleName.length); //得到  basehome
    return moduleName + '_' + key;
  },
  /**
   * 设置SessionStorage的值
   * @param {String} key 键
   * @param {Object} value 要存的对象
   */
  setSessionStorage(key, value) {
    key = this.getModuleKey(key);
    if (this.isObject(value) || this.isArray(value)) {
      value = this.toJsonStr(value);
    }
    sessionStorage[key] = value;
  },
  /**
   * 获取SessionStorage的值
   * @param {String} key 键
   * @param {Boolean} isDeserialize 是否反序列化
   */
  getSessionStorage(key, isDeserialize = true) {
    key = this.getModuleKey(key);
    var rs = sessionStorage[key];
    if (isDeserialize) {
      try {
        if (rs != undefined) {
          var obj = this.toJson(rs);
          rs = obj;
        }
      } catch (error) { }
    }

    return rs;
  },
  /**
   * 清除SessionStorage的值
   * @param {String} key 键
   */
  removeSessionStorage(key) {
    key = this.getModuleKey(key);
    return sessionStorage.removeItem(key);
  },
    /**
   * 设置LocalStorage的值
   * @param {String} key 键
   * @param {Object} value 要存的对象
   */
  setLocalStorage(key, value) {
    key = this.getModuleKey(key);
    if (this.isObject(value) || this.isArray(value)) {
      value = this.toJsonStr(value);
    }
    localStorage[key] = value;
  },
  /**
   * 获取LocalStorage的值
   * @param {String} key 键
   */
  getLocalStorage(key) {
    key = this.getModuleKey(key);
    var rs = localStorage[key];
    try {
      if (rs != undefined) {
        var obj = this.toJson(rs);
        rs = obj;
      }
    } catch (error) { }
    return rs;
  },
  /**
   * 清除LocalStorage的值
   * @param {String} key 键
   */
  removeLocalStorage(key) {
    key = this.getModuleKey(key);
    return localStorage.removeItem(key);
  },
```

## 日期格式化

```js
  /**
   * 对传入的时间值进行格式化。后台传入前台的时间有两种个是：Sql时间和.Net时间
   * @param {String|Date} sValue 传入的时间字符串
   * @param {String|Boolean} dateFormat  日期格式，日期格式：eg：'Y-m-d H:i:s'
   * @return {String} 2014-03-01 这种格式
   * @example
   * 1) Sql时间格式：2015-02-24T00:00:00
   * 2) .Net时间格式：/Date(1410744626000)/
   */
  getDateTimeStr(sValue, dateFormat = 'Y-m-d') {
    var dt;
    // 1.先解析传入的时间对象，
    if (sValue) {
      // 不为Date格式，就转换为DateTime类型
      if (toString.call(sValue) !== '[object Date]') {
        // 1)纯数字
        if (toString.call(sValue) === '[object Number]') {
          dt = new Date(sValue);
        } else {
          // 2.字符串
          sValue = sValue + '';
          sValue = sValue.replace(/-/g, '/');
          if (sValue.indexOf('T') > 0) {
            // 1)格式：2015-02-24T00:00:00
            var timestr = sValue.replace('T', ' ').replace(/-/g, '/'); //=> 2015/02/24 00:00:00
            dt = new Date(timestr);
          } else if (sValue.indexOf('Date') >= 0) {
            // 2).Net格式：/Date(1410744626000)/
            //Convert date type that .NET can bind to DateTime
            //var date = new Date(parseInt(sValue.substr(6)));
            var timestr = sValue.toString().replace(/\/Date\((\d+)\)\//gi, '$1'); //
            dt = new Date(Math.abs(timestr));
          } else {
            dt = new Date(sValue);
          }
        }
      } else {
        dt = sValue;
      }
    } else {
      return '';
    }

    // 2.转换
    // 1)转换成对象 'Y-m-d H:i:s'
    var obj = {}; //返回的对象，包含了 year(年)、month(月)、day(日)
    obj.Y = dt.getFullYear(); //年
    obj.m = dt.getMonth() + 1; //月
    obj.d = dt.getDate(); //日期
    obj.H = dt.getHours();
    obj.i = dt.getMinutes();
    obj.s = dt.getSeconds();
    //2.2单位的月、日都转换成双位
    if (obj.m < 10) {
      obj.m = '0' + obj.m;
    }
    if (obj.d < 10) {
      obj.d = '0' + obj.d;
    }
    if (obj.H < 10) {
      obj.H = '0' + obj.H;
    }
    if (obj.i < 10) {
      obj.i = '0' + obj.i;
    }
    if (obj.s < 10) {
      obj.s = '0' + obj.s;
    }
    // 3.解析
    var rs = dateFormat
      .replace('Y', obj.Y)
      .replace('m', obj.m)
      .replace('d', obj.d)
      .replace('H', obj.H)
      .replace('i', obj.i)
      .replace('s', obj.s);
    return rs;
  }
```

## 把总秒数转换为时分秒

```js
  /**
   * 把总秒数转换为时分秒
   * @param {Number} seconds 秒数
   * @param {String} dateFormat 日期格式
   * @return {String}
   * @example
   * 100 => 00:01:40
   */
  getSFM(seconds, dateFormat = 'H:i:s') {
    var obj = {};
    obj.H = Number.parseInt(seconds / 3600);
    obj.i = Number.parseInt((seconds - obj.H * 3600) / 60);
    obj.s = Number.parseInt(seconds - obj.H * 3600 - obj.i * 60);
    if (obj.H < 10) {
      obj.H = '0' + obj.H;
    }
    if (obj.i < 10) {
      obj.i = '0' + obj.i;
    }
    if (obj.s < 10) {
      obj.s = '0' + obj.s;
    }

    // 3.解析
    var rs = dateFormat
      .replace('H', obj.H)
      .replace('i', obj.i)
      .replace('s', obj.s);
    return rs;
  },
```

## 是否同一天

```js
  /**
   * 是否同一天
   * @param {Date} dt1 dt1
   * @param {Date} dt2 dt2
   * @return {Boolean}
   */
  isSomeDay(dt1, dt2) {
    if (dt1.getFullYear() == dt2.getFullYear() && dt1.getMonth() == dt2.getMonth() && dt1.getDate() == dt2.getDate()) {
      return true;
    }
    return false;
  },
```

## 获取当前时间

```js
  /**
   * 获取当前时间
   */
  getCurrentTime() {
    let yy = new Date().getFullYear();
    let mm = new Date().getMonth() + 1 < 10 ? '0' + (new Date().getMonth() + 1) : new Date().getMonth() + 1;
    let dd = new Date().getDate();
    let hh = new Date().getHours();
    let mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes();
    let ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds();
    return yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf + ':' + ss;
  },
```

## 获取明天之后时间

```js
  /**
   * 获取明天之后时间
   * @param int days 天数
   * @return 返回日期 yyyy-MM-dd HH:mm:ss
   */
  getDateAfterTodayTime(days) {
    const nextDay = new Date(new Date().getTime() + days * 24 * 3600 * 1000);
    let yy = nextDay.getFullYear();
    let mm = nextDay.getMonth() + 1 < 10 ? '0' + (nextDay.getMonth() + 1) : nextDay.getMonth() + 1;
    let dd = nextDay.getDate();
    let hh = nextDay.getHours();
    let mf = nextDay.getMinutes() < 10 ? '0' + nextDay.getMinutes() : nextDay.getMinutes();
    let ss = nextDay.getSeconds() < 10 ? '0' + nextDay.getSeconds() : nextDay.getSeconds();
    return yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf + ':' + ss;
  },
```

## Cookie 相关

```js
  /**
   * 获取cookie的某个偏移范围的值
   * @param {Number} offset 偏移
   * @private
   */
  _getCookieVal: function (offset) {
    var endstr = document.cookie.indexOf(';', offset);
    if (endstr == -1) {
      endstr = document.cookie.length;
    }
    return unescape(document.cookie.substring(offset, endstr));
  },

  /**
   * 获取指定key的cookie
   * @param {String} key cookie的key
   * @return {Object}
   */
  getCookie: function (key) {
    var arg = key + '=',
      alen = arg.length,
      clen = document.cookie.length,
      i = 0,
      j = 0;

    while (i < clen) {
      j = i + alen;
      if (document.cookie.substring(i, j) == arg) {
        return this._getCookieVal(j);
      }
      i = document.cookie.indexOf(' ', i) + 1;
      if (i === 0) {
        break;
      }
    }
    return null;
  },

  /**
   * 设置cookie
   * @param {String} key cookie的key
   * @param {String} value cookie的value
   */
  setCookie: function (key, value) {
    var argv = arguments,
      argc = arguments.length,
      expires = argc > 2 ? argv[2] : null,
      path = argc > 3 ? argv[3] : '/',
      domain = argc > 4 ? argv[4] : null,
      secure = argc > 5 ? argv[5] : false;

    document.cookie =
      key +
      '=' +
      escape(value) +
      (expires === null ? '' : '; expires=' + expires.toGMTString()) +
      (path === null ? '' : '; path=' + path) +
      (domain === null ? '' : '; domain=' + domain) +
      (secure === true ? '; secure' : '');
  },
```

## 判断是否还有特殊字符

```js
  /**
   * 是否含有特殊字符
   * @param  {String} value 传入的值
   * @return {Boolean} true 含有特殊符号;false 不含有特殊符号
   */
  isHaveSpecialChar: function (value) {
    var oldLength = value.length;
    var newLength = value.replace(/[`~!@#$%^&*_+=\\{}:"<>?\[\];',.\/~！@#￥%……&*——+『』：“”《》？【】；‘’，。？ \[\]()（）]/g, '').length;
    if (newLength < oldLength) {
      return true;
    }
    return false;
  },
```

## 合并数组内成员的某个对象

```js
  /**
   * 合并数组内成员的某个对象
   * @param {Array} arr 需要合并的数组
   * @param {String} fieldName 数组成员内的指定字段
   * @param {String} split 分隔符，默认为','
   * @example
   * var arr = [{name:'tom',age:13},{name:'jack',age:13}] => (arr, 'name') => tom,jack
   */
  joinArray: function (arr, fieldName, split) {
    split = split == undefined ? ',' : split;
    var rs = arr
      .map((item) => {
        return item[fieldName];
      })
      .join(split);
    return rs;
  },
```

## 扩充 sourceObj

```js
  /**
   * 扩充sourceObj
   * @param {Object} sourceObj
   * @param {Object} targetObj
   */
  extend: function (sourceObj, targetObj) {
    var keys = Object.keys(sourceObj);
    for (let i = 0; i < keys.length; i++) {
      const key = keys[i];
      if (targetObj[key] !== undefined) {
        sourceObj[key] = targetObj[key];
      }
    }
  },
```

## 获取 url 内 quest string 的值

```js
  /**
   * 获取url内quest string的值
   * @param {String} name quest string name
   * @param {String} url 网址
   */
  getUrlParameterByName(name, url) {
    if (!url) {
      url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, '\\$&');
    let regular = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)');
    let val = regular.exec(url);
    if (!val) {
      return null;
    }
    if (!val[2]) {
      return '';
    }
    return decodeURIComponent(val[2].replace(/\+/g, ' '));
  },
```

## 汉字转拼音码

```js
  /**
   * 汉字转拼音码
   * @param {*} str
   * @returns string
   */
  generateCNToPyCode(str) {
    if (typeof str != 'string') throw new Error(-1, '函数makePy需要字符串类型参数!');
    var arrResult = new Array(); //保存中间结果的数组
    for (var i = 0, len = str.length; i < len; i++) {
      //获得unicode码
      var ch = str.charAt(i);
      //检查该unicode码是否在处理范围之内,在则返回该码对映汉字的拼音首字母,不在则调用其它函数处理
      arrResult.push(this.checkCh(ch));
    }
    //处理arrResult,返回所有可能的拼音首字母串数组
    let pycode = this.mkRslt(arrResult).toLowerCase();
    return pycode;
  },
  checkCh(ch) {
    var uni = ch.charCodeAt(0);
    //如果不在汉字处理范围之内,返回原字符,也可以调用自己的处理函数
    if (uni > 40869 || uni < 19968) return ch; //dealWithOthers(ch);
    //检查是否是多音字,是按多音字处理,不是就直接在strChineseFirstPY字符串中找对应的首字母
    return strChineseFirstPY.charAt(uni - 19968);
  },
  mkRslt(arr) {
    var arrRslt = [''];
    for (var i = 0, len = arr.length; i < len; i++) {
      var str = arr[i];
      var strlen = str.length;
      if (strlen == 1) {
        for (var k = 0; k < arrRslt.length; k++) {
          arrRslt[k] += str;
        }
      } else {
        var tmpArr = arrRslt.slice(0);
        arrRslt = [];
        for (k = 0; k < strlen; k++) {
          //复制一个相同的arrRslt
          var tmp = tmpArr.slice(0);
          //把当前字符str[k]添加到每个元素末尾
          for (var j = 0; j < tmp.length; j++) {
            tmp[j] += str.charAt(k);
          }
          //把复制并修改后的数组连接到arrRslt上
          arrRslt = arrRslt.concat(tmp);
        }
      }
    }
    // 去除前后空格
    //arrRslt = arrRslt.toString().replace(/(^\s*)|(\s*$)/g,"");
    // 去除所有空格
    arrRslt = arrRslt.toString().replace(/\s+/g, '');
    return arrRslt;
  },
```

## 汉字转五笔简码

```js
  /**
   * 汉字转五笔简码
   * @param {*} str
   * @returns string
   */
  generateCNToWbCode(str) {
    if (typeof str != 'string') throw new Error(-1, '函数需要字符串类型参数!');
    var arrResult = new Array(); //保存中间结果的数组
    // 处理数字和字母：对数字和字母直接返回
    for (var i = 0, len = str.length; i < len; i++) {
      // 获得unicode码
      var ch = str.charAt(i);
      // 检查字库
      if (this.getWubiCode(ch)) {
        arrResult.push(this.getWubiCode(ch));
      }
    }

    if (!arrResult.length) {
      return '';
    }

    let wbCode = this.mkRslt(arrResult).toLowerCase();

    return wbCode;
  },
  getWubiCode(ch) {
    // 遍历简码数组
    for (var i = 0, len = wubiLib.length; i < len; i++) {
      var str = wubiLib[i];
      for (var k = 0; k < str.length; k++) {
        if (ch == str[k]) {
          // 返回第一个字母
          return str[0];
        }
      }
    }
  },
```

## 获取 tree 的匹配项

```js
  /**
   * 获取tree的匹配项
   * @param {Array} treeList tree
   * @param {String} matchPropertyName 匹配的属性名称
   * @param {String} matchValue 匹配的值
   */
  getTreeItem: function (treeList, matchPropertyName, matchValue) {
    let matchItem = null;
    if (Array.isArray(treeList)) {
      for (let i = 0; i < treeList.length; i++) {
        const item = treeList[i];
        if (item.childrens && item.childrens.length > 0) {
          let treeList = item.childrens;
          matchItem = this.getTreeItem(treeList, matchPropertyName, matchValue);
        }

        if (item[matchPropertyName] == matchValue) {
          matchItem = item;
        }

        if (matchItem) {
          break;
        }
      }
    }
    return matchItem;
  },
```

## 数字保留小数

```js
  /**
   * 数字保留小数
   * @param {Number} num 转换的数字
   * @param {Number} n 需要保留小数的位数
   */
  roundNum: function (num, n) {
    n = n ? parseInt(n) : 0;
    if (n <= 0) {
      return Math.round(num);
    }
    num = Math.round(num * Math.pow(10, n)) / Math.pow(10, n); //四舍五入
    num = Number(num).toFixed(n); //补足位数
    return num;
  },
```

## 把 HTML 格式的字符串转义成实体格式字符串

```js
  /**
   * 把HTML格式的字符串转义成实体格式字符串
   * @param {String} str
   */
  escapeHTMLString(str) {
    if (!str) {
      return '';
    }

    str = str.replace(/</g, '&lt;');
    str = str.replace(/>/g, '&gt;');
    return str;
  },
```
