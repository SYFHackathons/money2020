var request = require("request"),
    username = "TheUserName",
    password = "ThePassword",
    url = "https://syf2020.syfwebservices.com/syf/getRewards",
    auth = "Basic " + new Buffer(username + ":" + password)

var requestPayload = {
    "Header": {
        "trans_id": "demorewards"
    },
    "gps_syf_profileid": "6ff47aed18048b7708dd84b47152ee75db535e0eaa90b46fc3b7dc20745780dd"
};

request({
        url: url,
        headers: {
            "Username": username,
            "Password": password,
            "Content-Type": "application/json"
        },
        method: "POST",
        json: requestPayload
    },
    function(error, response, body) {
        if (!error && response.statusCode == 200) {
            console.log(response.body) // Show the HTML for the Google homepage.
        } else {
            console.log(response.statusCode + '-' + response.statusMessage);
        }
    }
);
