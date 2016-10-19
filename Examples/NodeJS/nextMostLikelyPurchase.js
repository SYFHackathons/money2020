var request = require("request")
var globals = require("./globals")

// URL Method
var method = "nextMostLikelyPurchase";

// Build payload
var requestPayload = {
    "accountNum": "100009"
};

// Create credentials & payload options object
var options = globals(method, requestPayload);

// Make Request
request(
    options,
    function(error, response, body) {
        if (!error && response.statusCode == 200) {
            console.log(response.body);
        } else {
            console.log(response.statusCode + '-' + response.statusMessage);
        }
    }
);
