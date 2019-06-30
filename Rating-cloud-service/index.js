/**
 * 
 * HTTP cloud function provides sorting feature for an arbitrary array of 
 * objects (passed as a JSON body), criteria and order.
 * 
 * @param {!Object} req Cloud Function request context.
 * @param {!Object} res Cloud Function response context.
 */

require('@google/cloud-debug');
exports.sortContacts = function (req, res) {
	
	let prop = req.query.criteria || 'last_name';
	let order = req.query.order || 'ascending';
	let contacts = req.body;
    
    if (contacts === undefined) {
    	// This is an error case, as HTTP request body is required.
    	console.warn('Bad request: No contacts provided.');
    	res.status(400).send('Contacts is not defined!');
  	} else {
    	// Everything is okay.
		  console.log('Contacts array length: ', contacts.length); 
		  console.log('Sort criteria: ', prop);
		  console.log('Sort order: ', order);
      let contactsSorted = contacts.sort(propComparator(prop, order));
      console.log(JSON.stringify(contacts)); 
		  res.status(200).send(contactsSorted);
  	}
    
};

function propComparator(prop, order) {
    return function(c1, c2) {
		if (order == 'ascending') {
			if (c1[prop] < c2[prop])
				return -1;
			if (c1[prop] > c2[prop])
				return 1;
			return 0;
		} else {
			if (c1[prop] < c2[prop])
				return 1;
			if (c1[prop] > c2[prop])
				return -1;
			return 0;
		}
  	};
}