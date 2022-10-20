const express = require("express");
var router = express.Router();
const axios = require("axios");
//引入
const redis = require("../redis/redis");
const { query } = require("../mysql/db");
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
module.exports = router;
