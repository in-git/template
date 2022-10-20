const express = require("express");
var router = express.Router();
const axios = require("axios");
//引入
const redis = require("../redis/redis");
const { query } = require("../mysql/db");
<<<<<<< HEAD
/* 显示所有数据库 */
router.get("/show-database", (req, res) => {
  query((result) => {
    res.send(JSON.stringify(result));
  }, "SHOW DATABASES");
});

router.post("/select", (req, res) => {
  console.log("reqreqreq",req.body);
  query((result) => {
    // console.log(result);
    res.send("res");
  }, "SHOW DATABASES");
});
=======

//断开链接
router.get("/", (req, res) => {
  axios
    .get(
      "http://wallpaper.apc.360.cn/index.php?c=WallPaperAndroid&a=getAllCategories"
    )
    .then(async (ares) => {
      //链接redis
      await redis.connect();
      let result = await redis.get("login");
      console.log(result);
      res.send(ares.data);
      redis.quit();
    });
});
/*  */
router.get("/mysql", (req, res) => {
  query((result) => {
    console.log(result);
    res.send("成功" + JSON.stringify(result));
  }, "select 123");
});

>>>>>>> 1eeb2129cc917c5acdc0a044fd39b1e683003a64
module.exports = router;
