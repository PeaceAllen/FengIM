
const Koa = require('koa');

const app = new Koa();

const server = require('http').createServer(app.callback());
const io = require('socket.io')(server);

io.on('connection', () => { 
    
    console.log('receive one \'connection msg\'');

 });

 io.on('add user', () => { 
    
    console.log('receive one \'add user\'');

 });


server.listen(3000);

console.log('hello rnning.')