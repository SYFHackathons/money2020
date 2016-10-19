var request = require("request")
var globals = require("./globals")

// URL Method
var method = "getRewards";

// Build Payload
var requestPayload = {
    "Header": {
        "trans_id": "demorewards"
    },
    "gps_syf_profileid": "6ff47aed18048b7708dd84b47152ee75db535e0eaa90b46fc3b7dc20745780dd"
};

// Build payload
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
