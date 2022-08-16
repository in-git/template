
const app = require("./app")
const http = require('http')
const server = http.createServer(app)
const socket = require("./socket/socket")
const root = require("./router/root")

socket(server);

app.use("/", root)
server.listen(8000, () => {
    console.log("server running on port 8000")
})