/* ------ ············ ------ */
/* ------- Axios依赖
/* ------ ············ ------ */

import axios from "axios";

axios.defaults.timeout = 5000;
// axios.defaults.baseURL = 'http://127.0.0.1:8090';
//开发模式服务器地址
if (process.env.NODE_ENV == "development") {
  axios.defaults.baseURL = "http://127.0.0.1:4000";
}
//局域网服务器地址
else if (process.env.NODE_ENV == "debug") {
  axios.defaults.baseURL = "http://192.168.0.54:4000";
}
// 外网服务器地址
else if (process.env.NODE_ENV == "production") {
  axios.defaults.baseURL = "http://0.0.0.0:4000";
}

/* 
	功能:
		1.请求拦截器
		2.配置token响应头
 */
axios.interceptors.request.use(
  (config) => config,
  (err) => {
    return Promise.reject(err);
  }
);

//响应拦截器
axios.interceptors.response.use(
  (response) => {
    return response;
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
export function patch(url, data = {}) {
  return new Promise((resolve, reject) => {
    axios.patch(url, data).then(
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
