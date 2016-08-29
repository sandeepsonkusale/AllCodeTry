console.log("Hello World Start");


var http = require("http");
http.createServer(function (request, response) {
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.write('Hello World Step1 Write here...\n');
    console.log("IN the Browser");
    var fs = require("fs")
    fs.readFile('c:\\_Sandeep\\Letter_to_Mahindra.txt', function (err, data) {
        if (err) return console.error(err);
        response.write(data.toString());
    });
    console.log("After writing the files");
    response.end('Hello World\n');
}).listen(8081);
console.log('Server running at http://127.0.0.1:8081/');