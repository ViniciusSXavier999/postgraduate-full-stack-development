import { createServer } from 'http'


createServer(function (req, res) {

    res.write('Hello World Descomplica!')
    return res.end();

}).listen(8080);