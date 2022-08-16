/* 所有业务模块需要继承该类 */
import { post, del, get, put } from './axios'

export default class http {
  get(url, v) {
    return get(url, v)
  }
  post(url, v) {
    return post(url, v)
  }
  del(url, v) {
    return del(url, v)
  }
  put(url, v) {
    return put(url, v)
  }
}