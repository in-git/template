/*
 * @Descripttion: 
 * @version: 1.00
 * @Author: 吴文龙
 * @LastEditors: 吴文龙
 */
import http from "../axios/http.js"
class Index extends http {
   getBaseInfo(params) {
      const url = "/base"
      return this.get(url, params)
   }
}
export default (function () {
   let instance = null
   return function () {
      return !instance ? instance = new Index() : instance
   }()
})()
