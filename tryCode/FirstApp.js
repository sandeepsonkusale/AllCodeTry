console.log("Hello World Start");


var http = require("http");
var fs = require("fs");
var server = http.createServer(function (req, res) {
    displayForm(res);
});

function displayForm(res) {
    fs.readFile('form.html', function (err, data) {
        res.writeHead(200, {
            'Content-Type': 'text/html',
            //'Content-Length': data.length
        });
        res.write(data);
        res.end();
    });
}

server.listen(8081);
console.log('Server running at http://127.0.0.1:8081/');