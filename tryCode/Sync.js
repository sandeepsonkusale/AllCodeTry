/**
 * Created by iripl-83 on 23-08-2016.
 */
var fs = require("fs");
console.log("\n *START* \n");
var content = fs.readFileSync("JSON\\uid_data.json");

var jsonContent = JSON.parse(content);
// Get Value from JSON
console.log("User Name:", jsonContent.username);
console.log("Email:", jsonContent.email);
console.log("Password:", jsonContent.password);


/*
var exjson = content;

for(var exKey in exjson) {
    console.log("key:"+exKey+", value:"+exjson[exKey]);
}

 */
//console.log("Output Content : \n"+ content);
console.log("\n *EXIT* \n");