var APP_ID = 'amzn1.ask.skill.58d69239-cc5a-437d-a975-afe6e789a3b8'; //replace with "amzn1.echo-sdk-ams.app.[your-unique-value-here]";
var AlexaSkill = require('./AlexaSkill');

/**Define all the variables for the getRewards Request here */
//request and request-promise should be bundled in with node modules (do npm install for each and include node_modules folder in zip file)
var request = require('request');
var rp = require('request-promise');

//Credentials for Money2020 2016 Hackathon, should be put in header
var username="giveitatry";
var password="Sh0wT!me";

//Reqest payload for GetRewards includes url, requestPayload and options
var url = "https://syf2020.syfwebservices.com/syf/nextMostLikelyPurchase";

var requestPayload = {
  "accountNum": "100009"
};

var options = {
  headers: {
      "Username": username,
      "Password": password,
      "Content-Type": "application/json"
  },
  method: 'POST',
  uri: url,
  body: requestPayload,
  json: true
};

var HelloWorld = function () {
    AlexaSkill.call(this, APP_ID);
};

// Extend AlexaSkill
HelloWorld.prototype = Object.create(AlexaSkill.prototype);
HelloWorld.prototype.constructor = HelloWorld;

HelloWorld.prototype.eventHandlers.onSessionStarted = function (sessionStartedRequest, session) {
    console.log("HelloWorld onSessionStarted requestId: " + sessionStartedRequest.requestId
        + ", sessionId: " + session.sessionId);
    // any initialization logic goes here
};

HelloWorld.prototype.eventHandlers.onLaunch = function (launchRequest, session, response) {
    console.log("HelloWorld onLaunch requestId: " + launchRequest.requestId + ", sessionId: " + session.sessionId);


	var speechOutput = "Welcome to Synchrony Money2020 Hackathon.  What's up?";
    response.ask(speechOutput, "");
};

HelloWorld.prototype.eventHandlers.onSessionEnded = function (sessionEndedRequest, session) {
    console.log("HelloWorld onSessionEnded requestId: " + sessionEndedRequest.requestId
        + ", sessionId: " + session.sessionId);
    // any cleanup logic goes here
};


HelloWorld.prototype.intentHandlers = {

//Starting the Next Most Likely Purchse intent
	"NextMostLikelyPurchaseIntent": function (intent, session, response) {

    //using request-promise to initiate the POST request
    rp(options)
      .then(function (parsedBody) {
          console.log(parsedBody);
          //use parsedBody.'json id' to pull a value from the response
          var probability = parsedBody.categories[0].probability;
          var category = parsedBody.categories[0].categoryName;
             var axResponse = "The probability of you purchasing an " + category +" product is " + probability + " percent.";
                response.tell(axResponse);
      })
    .catch(function (err) {
      console.log("POST FAILED");
      response.tell("Sorry can't connect");
    });


    },

    "AMAZON.HelpIntent": function (intent, session, response) {
        response.ask("You can say hello to me!", "You can say hello to me!");
    }
};

// Create the handler that responds to the Alexa Request.
exports.handler = function (event, context) {
    // Create an instance of the HelloWorld skill.
    var helloWorld = new HelloWorld();
    helloWorld.execute(event, context);
};
