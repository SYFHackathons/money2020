package com.syf.hackathon;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DemoController {

    @RequestMapping("/getRewards")
    public String callGetRewards() throws Exception {
		
		String payload = "{\r\n\t\"Header\": { \"trans_id\": \"demorewards\" },\r\n\t\"gps_syf_profileid\": \"6ff47aed18048b7708dd84b47152ee75db535e0eaa90b46fc3b7dc20745780dd\"\r\n}";
		
		RestClient client = new RestClient();
		return client.post("getRewards", payload);
    }	
	
	@RequestMapping("/nextMostLikelyPurchase")
	public String callGetNextMostLikelyPurchase() throws Exception {
		
		String payload = "{\r\n    \"accountNum\": \"100009\"\r\n}";
		
		RestClient client = new RestClient();
		return client.post("nextMostLikelyPurchase", payload);
	}
	
	@RequestMapping("/applyForCredit")
	public String callApplyForCredit() throws Exception {
		
		String payload = "{\r\n\r\n\t\"apply\" : {\r\n\t\t\"applyRequest\" : {\r\n\t\t\t\"authCosApplicantData\" : {\r\n\t\t\t\t\"lastNameapp\" : \"\",\r\n\t\t\t\t\"firstNameapp\" : \"\",\r\n\t\t\t\t\"middleInitialapp\" : \"\",\r\n\t\t\t\t\"suffixapp\" : \"\",\r\n\t\t\t\t\"ssn1\" : \"\",\r\n\t\t\t\t\"birthDateapp\" : \"\",\r\n\t\t\t\t\"driverLicenseNumberapp\" : \"\",\r\n\t\t\t\t\"driverLicenseStateapp\" : \"\",\r\n\t\t\t\t\"signatureIndicatorapp\" : \"\",\r\n\t\t\t\t\"titleapp\" : \"\",\r\n\t\t\t\t\"occupationCodeapp\" : \"\",\r\n\t\t\t\t\"incomeAnnualapp\" : \"\",\r\n\t\t\t\t\"address\" : {\r\n\t\t\t\t\t\"address2app\" : \"\",\r\n\t\t\t\t\t\"stateapp\" : \"\",\r\n\t\t\t\t\t\"address1app\" : \"\",\r\n\t\t\t\t\t\"cityapp\" : \"\",\r\n\t\t\t\t\t\"zipCodeapp\" : \"\"\r\n\t\t\t\t},\r\n\t\t\t\t\"membershipNumberapp\" : \"\",\r\n\t\t\t\t\"ssnOverrideapp\" : \"\",\r\n\t\t\t\t\"driverLicenseExpiryDateapp\" : \"\"\r\n\t\t\t},\r\n\t\t\t\"spouseDetails\" : {\r\n\t\t\t\t\"spFirstName\" : \"\",\r\n\t\t\t\t\"spMiddleName\" : \"\",\r\n\t\t\t\t\"spLastName\" : \"\",\r\n\t\t\t\t\"address\" : {\r\n\t\t\t\t\t\"address2spd\" : \"\",\r\n\t\t\t\t\t\"statespd\" : \"\",\r\n\t\t\t\t\t\"address1spd\" : \"\",\r\n\t\t\t\t\t\"cityspd\" : \"\",\r\n\t\t\t\t\t\"zipCodespd\" : \"\"\r\n\t\t\t\t}\r\n\t\t\t},\r\n\t\t\t\"merchantData\" : {\r\n\t\t\t\t\"clientDepartment\" : \"\",\r\n\t\t\t\t\"iovationRequestType\" : \"application\",\r\n\t\t\t\t\"operator\" : \"ECOM\",\r\n\t\t\t\t\"clientData\" : \"\",\r\n\t\t\t\t\"merchantNumber\" : \"0000000000010032\",\r\n\t\t\t\t\"country\" : \"US\",\r\n\t\t\t\t\"deviceType\" : \"T\",\r\n\t\t\t\t\"originalProductCode\" : \"010\",\r\n\t\t\t\t\"rewardsCode\" : \"\",\r\n\t\t\t\t\"membershipNumber\" : \"\",\r\n\t\t\t\t\"primaryGroup\" : \"000\",\r\n\t\t\t\t\"empAccountCode\" : \"Y\",\r\n\t\t\t\t\"salesPerson\" : \"213006748\",\r\n\t\t\t\t\"clientDataShare\" : \"\",\r\n\t\t\t\t\"sendEmail\" : \"\",\r\n\t\t\t\t\"referalCode\" : \"\",\r\n\t\t\t\t\"register\" : \"REGISTER\",\r\n\t\t\t\t\"clientId\" : \"TJX\",\r\n\t\t\t\t\"referCode\" : \"\",\r\n\t\t\t\t\"comment\" : \"\",\r\n\t\t\t\t\"secondaryGroup\" : \"000\"\r\n\t\t\t},\r\n\t\t\t\"primaryApplicant\" : {\r\n\t\t\t\t\"tempPassDays\" : \"\",\r\n\t\t\t\t\"longitude\" : \"\",\r\n\t\t\t\t\"cardIndSEDS\" : \"\",\r\n\t\t\t\t\"promoTrack\" : \"\",\r\n\t\t\t\t\"employerState\" : \"\",\r\n\t\t\t\t\"spCode\" : \"\",\r\n\t\t\t\t\"bankCardNumber\" : \"\",\r\n\t\t\t\t\"signatureIndicator\" : \"\",\r\n\t\t\t\t\"customerLoanTerm\" : \"\",\r\n\t\t\t\t\"passportIssuingCountry\" : \"\",\r\n\t\t\t\t\"swipeEdit\" : \"\",\r\n\t\t\t\t\"address\" : {\r\n\t\t\t\t\t\"address2\" : \"\",\r\n\t\t\t\t\t\"state\" : \"IL\",\r\n\t\t\t\t\t\"address1\" : \"21 KING ARTHUR CT\",\r\n\t\t\t\t\t\"city\" : \"FANTASY ISLAND\",\r\n\t\t\t\t\t\"zipCode\" : \"60750\"\r\n\t\t\t\t},\r\n\t\t\t\t\"plateCode\" : \"\",\r\n\t\t\t\t\"ssn\" : \"666010080\",\r\n\t\t\t\t\"permanentResidentCard\" : \"\",\r\n\t\t\t\t\"passportNumber\" : \"\",\r\n\t\t\t\t\"cardIndVISA\" : \"\",\r\n\t\t\t\t\"cardIndAMEX\" : \"\",\r\n\t\t\t\t\"mobileStoreDistance\" : \"\",\r\n\t\t\t\t\"bankCardType\" : \"\",\r\n\t\t\t\t\"employerName\" : \"\",\r\n\t\t\t\t\"redemptionAmount\" : \"\",\r\n\t\t\t\t\"timeAtHome\" : \"\",\r\n\t\t\t\t\"latitude\" : \"\",\r\n\t\t\t\t\"applicationCountry\" : \"\",\r\n\t\t\t\t\"homePhone\" : \"1234567891\",\r\n\t\t\t\t\"requestedlineOfCredit\" : \"\",\r\n\t\t\t\t\"relativeInfo\" : \"\",\r\n\t\t\t\t\"memberNumber\" : \"\",\r\n\t\t\t\t\"employerPhone\" : \"\",\r\n\t\t\t\t\"imageDocID\" : \"\",\r\n\t\t\t\t\"secLastName\" : \"\",\r\n\t\t\t\t\"optOutFlag\" : \"\",\r\n\t\t\t\t\"eBillEnrollment\" : \"\",\r\n\t\t\t\t\"cardIndMC\" : \"\",\r\n\t\t\t\t\"birthDate\" : \"19700605\",\r\n\t\t\t\t\"promoCode\" : \"\",\r\n\t\t\t\t\"incomeAnnual\" : \"12000000\",\r\n\t\t\t\t\"companyPhone\" : \"\",\r\n\t\t\t\t\"maidenName\" : \"\",\r\n\t\t\t\t\"authCosCode\" : \"\",\r\n\t\t\t\t\"insuranceCode\" : \"\",\r\n\t\t\t\t\"onlineLetter\" : \"\",\r\n\t\t\t\t\"billingLastName\" : \"\",\r\n\t\t\t\t\"caCivicNumber\" : \"\",\r\n\t\t\t\t\"previousAddress\" : {\r\n\t\t\t\t\t\"address2prvad\" : \"\",\r\n\t\t\t\t\t\"stateprvad\" : \"\",\r\n\t\t\t\t\t\"address1prvad\" : \"\",\r\n\t\t\t\t\t\"cityprvad\" : \"\",\r\n\t\t\t\t\t\"zipCodeprvad\" : \"\"\r\n\t\t\t\t},\r\n\t\t\t\t\"mobileDeviceType\" : \"\",\r\n\t\t\t\t\"lastName\" : \"APPROVAL\",\r\n\t\t\t\t\"billinngCycle\" : \"\",\r\n\t\t\t\t\"firstName\" : \"JOE\",\r\n\t\t\t\t\"ipAddress\" : \"\",\r\n\t\t\t\t\"purchaseAmount\" : \"\",\r\n\t\t\t\t\"extensionPhoneNumber\" : \"\",\r\n\t\t\t\t\"driverLicenseState\" : \"\",\r\n\t\t\t\t\"sourceCode\" : \"\",\r\n\t\t\t\t\"mothersBirthDate\" : \"\",\r\n\t\t\t\t\"driverLicenseExpiryDate\" : \"\",\r\n\t\t\t\t\"dlSsoId\" : \"\",\r\n\t\t\t\t\"memberSinceDate\" : \"\",\r\n\t\t\t\t\"email\" : \"t@t.com\",\r\n\t\t\t\t\"reissueDate\" : \"\",\r\n\t\t\t\t\"modelIndicator\" : \"\",\r\n\t\t\t\t\"billingFirstName\" : \"\",\r\n\t\t\t\t\"residenceCode\" : \"\",\r\n\t\t\t\t\"timeAtJob\" : \"\",\r\n\t\t\t\t\"vehicleOwn\" : \"\",\r\n\t\t\t\t\"relativePhone\" : \"\",\r\n\t\t\t\t\"creditLineRqd\" : \"\",\r\n\t\t\t\t\"contractNumber\" : \"\",\r\n\t\t\t\t\"passportBirthCity\" : \"\",\r\n\t\t\t\t\"employerZip\" : \"\",\r\n\t\t\t\t\"cardDeptStrInd\" : \"\",\r\n\t\t\t\t\"blackBoxId\" : \"\",\r\n\t\t\t\t\"title\" : \"\",\r\n\t\t\t\t\"bankAccountCode\" : \"\",\r\n\t\t\t\t\"regionalBusinessCode\" : \"\",\r\n\t\t\t\t\"occupationCode\" : \"\",\r\n\t\t\t\t\"employerAddress\" : \"\",\r\n\t\t\t\t\"driverLicenseNumber\" : \"\",\r\n\t\t\t\t\"applicationType\" : \"\",\r\n\t\t\t\t\"accoutInfo\" : \"\",\r\n\t\t\t\t\"mortgageOrRentPay\" : \"\",\r\n\t\t\t\t\"extensionOverride\" : \"\",\r\n\t\t\t\t\"employerCity\" : \"\",\r\n\t\t\t\t\"middleName\" : \"\",\r\n\t\t\t\t\"suffix\" : \"\",\r\n\t\t\t\t\"ssnOverride\" : \"\",\r\n\t\t\t\t\"currentEmployer\" : \"\",\r\n\t\t\t\t\"relativeCode\" : \"\",\r\n\t\t\t\t\"routingNumber\" : \"\",\r\n\t\t\t\t\"cellPhone\" : \"\",\r\n\t\t\t\t\"frnLangIndicator\" : \"E\",\r\n\t\t\t\t\"checkingAccountNumber\" : \"\",\r\n\t\t\t\t\"memberType\" : \"\"\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\n                            ";
		
		RestClient client = new RestClient();
		return client.post("applyForCredit", payload);
	}
	
	@RequestMapping("/test")
	public String callPublicAPI() throws Exception {
		RestClient client = new RestClient("https://jsonplaceholder.typicode.com");
		return client.get("/posts/1");
	}

}