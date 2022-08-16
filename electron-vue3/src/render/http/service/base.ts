import http from "../axios"
export const getInfo = (params: any) => {
    return http.get("/api/info", params)
}