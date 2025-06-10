// import  fs from "node:fs";
const fs = require('node:fs');

const filename = "f:/rabbitmq-server-4.0.2-1.el8.noarch.bk.rpm"

fs.stat(filename, (err, stats) => {
    if (err)
        console.log(err)
    else
        console.log(stats)
})