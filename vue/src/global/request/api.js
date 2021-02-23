import { get, post } from "./axios";

/**  ⊹⊹⊹⊹ 请求模板 ⊹⊹⊹⊹ */

// export const getInfo = (v) => get(Vue.prototype.api + "api", v);
// const postInfo = (v) => post(Vue.prototype.api + "api  ", v);

/**  ⊹⊹⊹⊹ END ⊹⊹⊹⊹ */

/**
 * 功能:  post请求参数
 */

const fileUpload = v => post("upload", v);
const test = v => get("test", v);
const filePolicy =v => get("/file/policy",v)//文件传输

/**  ⊹⊹⊹⊹ API导出 ⊹⊹⊹⊹ */
export default {
    fileUpload,
    test,
    filePolicy
}
