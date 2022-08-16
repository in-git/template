
const ENTER = 0
const LEAVE = 1
const MESSAGE = 2

let count = 0
const socketIO = require('socket.io')

module.exports = function (server) {
    const io = socketIO(server, {
        cors: {
            origin: '*'
        }
    })

    io.on('connection', socket => {
        console.log('user connected')
        count++
        let user = `用户${count}`

        io.sockets.emit('broadcast_msg',
            {
                type: ENTER,
                msg: `${user}加入群聊`,
                time: new Date().toLocaleString()
            }
        )

        socket.on('send_msg', (data) => {
            console.log(`收到客户端的消息：${data}`)
            io.sockets.emit('broadcast_msg', {
                type: MESSAGE,
                msg: `${user}:${data}`,
                time: new Date().toLocaleString()
            })
        })

        socket.on('disconnect', () => {
            console.log('user disconnected')
            io.sockets.emit('broadcast_msg', {
                type: LEAVE,
                msg: `${user}离开了群聊`,
                time: new Date().toLocaleString()
            })
            count--
        });
    });
}