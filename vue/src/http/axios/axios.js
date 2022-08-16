/* ------ ············ ------ */
/* ------- Axios依赖
/* ------ ············ ------ */
var config = {
  host:8080
}
import axios from "axios";
axios.defaults.timeout = 10000;

axios.defaults.baseURL = config.host;
//开发模式服务器地址
if (process.env.NODE_ENV == "development") {
  axios.defaults.baseURL = config.host;
}
//局域网服务器地址
else if (process.env.NODE_ENV == "debug") {
  axios.defaults.baseURL = config.host;
}
// 外网服务器地址
else if (process.env.NODE_ENV == "production") {
  axios.defaults.baseURL = config.online_host;
}

// response 拦截器
axios.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      return response.data
    }
  },
  (err) => {
    if (err && err.response) {

      switch (err.response.status) {
        case 400:
          console.error("请求错误");
          break;
        case 401:
          console.error("未授权，请登录");
          break;
        case 403:
          console.error(`拒绝访问`);
          break;
        case 404:
          console.error(`请求地址出错!`);
          break;
        case 408:
          console.error(`请求超时!`);
          break;
        case 500:
          console.error(`服务器内部错误!`);
          break;
        case 501:
          console.error(`服务未实现!`);
          break;
        case 502:
          console.error(`网关错误`);
          break;
        case 503:
          console.error(`服务不可用`);
          break;
        case 504:
          console.error(`网关超时`);
          break;
        case 505:
          console.error(`HTTP版本不受支持`);
          break;
      }
    }
    return Promise.reject(err); // 返回接口返回的错误信息
  }
);
/* 
  功能:
    1.请求拦截器
    2.配置token响应头
 */
axios.interceptors.request.use(
  // 配置token
  (config) => {
    let token = window.localStorage.getItem("authToken");
    if (token) {
      config.headers.authToken = token;
    }
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

/** 封装get方法**/
export function get(url, params = {}) {
  return new Promise((resolve, reject) => {
    axios
      .get(url, {
        params,
      })
      .then((response) => {
        response = response || {}
        resolve(response.data);
      })
      .catch((err) => {
        reject(err);
      });
  });
}

/**封装post请求**/
export function post(url, data = {}) {
  return new Promise((resolve, reject) => {
    axios.post(url, data).then(
      (response) => {
        resolve(response.data);
      },
      (err) => {
        reject(err);
      }
    );
  });
}

/** 封装patch请求 **/
export function del(url, data = {}) {
  return new Promise((resolve, reject) => {
    axios.delete(url, data).then(
      (response) => {
        resolve(response.data);
      },
      (err) => {
        reject(err);
      }
    );
  });
}

/** 封装put请求 **/
export function put(url, data = {}) {
  return new Promise((resolve, reject) => {
    axios.put(url, data).then(
      (response) => {
        resolve(response.data);
      },
      (err) => {
        reject(err);
      }
    );
  });
}
