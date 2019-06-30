/**
 * 
 * HTTP cloud function provides sorting feature for an arbitrary array of 
 * objects (passed as a JSON body), criteria and order.
 * 
 * @param {!Object} req Cloud Function request context.
 * @param {!Object} res Cloud Function response context.
 */

require('@google/cloud-debug');
const connection = require('./database')

exports.newRating = function newRating(req, res) {
    let userID = req.body.userID;
    let comment = req.body.comment;
    let rating = req.body.rating;
    let accommodationID = req.body.accommodationID;
	let reservationID = req.body.reservationID;
    connection.query("insert into ratings (userID, comment, rating, accommodationID, published, reservationID) values (?, ?, ?, ?, ?, ?)", [userID, comment, rating, accommodationID, 0, reservationID], (err, result) => {
	if (err) res.status(400).send(err);
	else {
		
		res.status(200).send('upisano');

	}
	
    });
};
