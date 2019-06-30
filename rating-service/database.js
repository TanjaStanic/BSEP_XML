const mysql = require('mysql');

let connection = mysql.createConnection({
    host: "172.21.144.1",
    user: "root",
    database: "megatravel_rating",
    password: "sara0301997188128"
});

connection.connect(function(err) {
    if (err) {
        console.error('Error connecting: ' + err.stack);
        return;
    }
    console.log('Connected as thread id: ' + connection.threadId);
});

module.exports = connection;