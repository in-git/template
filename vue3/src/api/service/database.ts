import http from "../config/http";
export function showDataBase(data?: any) {
    return http.request({
        url: "/show-database",
        method: "get",
        data
    })
}