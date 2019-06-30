const mysql = require('mysql');

let connection = mysql.createConnection({
    user: "root",
    database: "ratings",
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