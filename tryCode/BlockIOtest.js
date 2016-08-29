/**
 * Created by iripl-83 on 21-08-2016.
 */
var fs = require("fs");
//var data = fs.readFileSync('Letter_to_Mahindra.txt');

fs.readFile('c:\\_Sandeep\\Letter_to_Mahindra.txt', function (err, data) {
    if (err) return console.error(err);
    console.log(data.toString());
});
console.log("Program Ended");