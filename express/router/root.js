const express = require('express');
var router = express.Router();
const axios = require('axios')
//引入
const redis = require('../redis/redis')

//断开链接 
router.get("/", (req, res) => {
    axios.get("http://wallpaper.apc.360.cn/index.php?c=WallPaperAndroid&a=getAllCategories").then(async ares => {
        //链接redis
        await redis.connect()
        let result = await redis.get('login')
        console.log(result);
        res.send(ares.data)
        redis.qiut()
    })
})

module.exports = router