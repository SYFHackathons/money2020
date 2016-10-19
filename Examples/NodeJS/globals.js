module.exports = function(method, payload) {
    var serviceOptions = {
            url: "https://syf2020.syfwebservices.com/syf/" + method,
            headers: {
                "Username": "user_name",
                "Password": "password!",
                "Content-Type": "application/json"
            },
            method: "POST",
            json: payload
        };
  return serviceOptions
}
