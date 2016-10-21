//
//  ViewController.swift
//  Money2020Swift
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/20/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    let getRewardsButtonLabel = "getRewards"
    let nextMostLikelyButtonLabel = "nextMostLikelyPurchase"
    let applyForCreditButtonLabel = "applyForCredit"
    let clearButtonLabel = "Clear"
    
    @IBOutlet weak var SYFGetRewardsButton: UIButton!
    @IBOutlet weak var SYFNextMostLikelyButton: UIButton!
    @IBOutlet weak var SYFApplyForCreditButton: UIButton!
    @IBOutlet weak var SYFClearButton: UIButton!
    
    @IBOutlet weak var responseView: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.initializeView()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func initializeView() {
        self.SYFGetRewardsButton.setTitle(getRewardsButtonLabel, for: UIControlState.normal)
        self.SYFGetRewardsButton.addTarget(self, action:#selector(tapped(button:)), for: UIControlEvents.touchUpInside)
        
        self.SYFNextMostLikelyButton.setTitle(nextMostLikelyButtonLabel, for: UIControlState.normal)
        self.SYFNextMostLikelyButton.addTarget(self, action:#selector(tapped(button:)), for: UIControlEvents.touchUpInside)
        
        self.SYFApplyForCreditButton.setTitle(applyForCreditButtonLabel, for: UIControlState.normal)
        self.SYFApplyForCreditButton.addTarget(self, action:#selector(tapped(button:)), for: UIControlEvents.touchUpInside)
        
        self.SYFClearButton.setTitle(clearButtonLabel, for: UIControlState.normal)
        self.SYFClearButton.addTarget(self, action:#selector(tapped(button:)), for: UIControlEvents.touchUpInside)
    }

    func clearTextView() {
        self.responseView.text = ""
    }
    
    func tapped(button: UIButton) {
        if let buttonName = button.titleLabel?.text {
            self.updateResponseView(withString: "Loading...")
            self.makeRequest(forEndpoint: buttonName)
        }
    }
    
    func updateResponseView(withString: String) {
        DispatchQueue.main.async {
            self.responseView.text = withString
        }
    }
    
    func determine(bodyString: String?) -> String {
        var stringToReturn = ""
        if let bodyStringUnwrapped = bodyString {
            if bodyStringUnwrapped == getRewardsButtonLabel {
                stringToReturn = "{ \"Header\": { \"trans_id\": \"demorewards\" },\"gps_syf_profileid\": \"6ff47aed18048b7708dd84b47152ee75db535e0eaa90b46fc3b7dc20745780dd\"}"
            } else if bodyStringUnwrapped == nextMostLikelyButtonLabel {
                stringToReturn = "{\"accountNum\": \"100009\"}"
            }else if bodyStringUnwrapped == applyForCreditButtonLabel {
                //change "lastname" to APPROVAL, DECLINE, and REFER to get a different response.
                stringToReturn = "{\"apply\" : {\"applyRequest\" : {\"authCosApplicantData\" : {\"lastNameapp\" : \"\",\"firstNameapp\" : \"\",\"middleInitialapp\" : \"\",\"suffixapp\" : \"\",\"ssn1\" : \"\",\"birthDateapp\" : \"\",\"driverLicenseNumberapp\" : \"\",\"driverLicenseStateapp\" : \"\",\"signatureIndicatorapp\" : \"\",\"titleapp\" : \"\",\"occupationCodeapp\" : \"\",\"incomeAnnualapp\" : \"\",\"address\" : {\"address2app\" : \"\",\"stateapp\" : \"\",\"address1app\" : \"\",\"cityapp\" : \"\",\"zipCodeapp\" : \"\"},\"membershipNumberapp\" : \"\",\"ssnOverrideapp\" : \"\",\"driverLicenseExpiryDateapp\" : \"\"},\"spouseDetails\" : {\"spFirstName\" : \"\",\"spMiddleName\" : \"\",\"spLastName\" : \"\",\"address\" : {\"address2spd\" : \"\",\"statespd\" : \"\",\"address1spd\" : \"\",\"cityspd\" : \"\",\"zipCodespd\" : \"\"}},\"merchantData\" : {\"clientDepartment\" : \"\",\"iovationRequestType\" : \"application\",\"operator\" : \"ECOM\",\"clientData\" : \"\",\"merchantNumber\" : \"0000000000010032\",\"country\" : \"US\",\"deviceType\" : \"T\",\"originalProductCode\" : \"010\",\"rewardsCode\" : \"\",\"membershipNumber\" : \"\",\"primaryGroup\" : \"000\",\"empAccountCode\" : \"Y\",\"salesPerson\" : \"213006748\",\"clientDataShare\" : \"\",\"sendEmail\" : \"\",\"referalCode\" : \"\",\"register\" : \"REGISTER\",\"clientId\" : \"TJX\",\"referCode\" : \"\",\"comment\" : \"\",\"secondaryGroup\" : \"000\"},\"primaryApplicant\" : {\"tempPassDays\" : \"\",\"longitude\" : \"\",\"cardIndSEDS\" : \"\",\"promoTrack\" : \"\",\"employerState\" : \"\",\"spCode\" : \"\",\"bankCardNumber\" : \"\",\"signatureIndicator\" : \"\",\"customerLoanTerm\" : \"\",\"passportIssuingCountry\" : \"\",\"swipeEdit\" : \"\",\"address\" : {\"address2\" : \"\",\"state\" : \"IL\",\"address1\" : \"21 KING ARTHUR CT\",\"city\" : \"FANTASY ISLAND\",\"zipCode\" : \"60750\"},\"plateCode\" : \"\",\"ssn\" : \"666010080\",\"permanentResidentCard\" : \"\",\"passportNumber\" : \"\",\"cardIndVISA\" : \"\",\"cardIndAMEX\" : \"\",\"mobileStoreDistance\" : \"\",\"bankCardType\" : \"\",\"employerName\" : \"\",\"redemptionAmount\" : \"\",\"timeAtHome\" : \"\",\"latitude\" : \"\",\"applicationCountry\" : \"\",\"homePhone\" : \"1234567891\",\"requestedlineOfCredit\" : \"\",\"relativeInfo\" : \"\",\"memberNumber\" : \"\",\"employerPhone\" : \"\",\"imageDocID\" : \"\",\"secLastName\" : \"\",\"optOutFlag\" : \"\",\"eBillEnrollment\" : \"\",\"cardIndMC\" : \"\",\"birthDate\" : \"19700605\",\"promoCode\" : \"\",\"incomeAnnual\" : \"12000000\",\"companyPhone\" : \"\",\"maidenName\" : \"\",\"authCosCode\" : \"\",\"insuranceCode\" : \"\",\"onlineLetter\" : \"\",\"billingLastName\" : \"\",\"caCivicNumber\" : \"\",\"previousAddress\" : {\"address2prvad\" : \"\",\"stateprvad\" : \"\",\"address1prvad\" : \"\",\"cityprvad\" : \"\",\"zipCodeprvad\" : \"\"},\"mobileDeviceType\" : \"\",\"lastName\" : \"APPROVAL\",\"billinngCycle\" : \"\",\"firstName\" : \"JOE\",\"ipAddress\" : \"\",\"purchaseAmount\" : \"\",\"extensionPhoneNumber\" : \"\",\"driverLicenseState\" : \"\",\"sourceCode\" : \"\",\"mothersBirthDate\" : \"\",\"driverLicenseExpiryDate\" : \"\",\"dlSsoId\" : \"\",\"memberSinceDate\" : \"\",\"email\" : \"t@t.com\",\"reissueDate\" : \"\",\"modelIndicator\" : \"\",\"billingFirstName\" : \"\",\"residenceCode\" : \"\",\"timeAtJob\" : \"\",\"vehicleOwn\" : \"\",\"relativePhone\" : \"\",\"creditLineRqd\" : \"\",\"contractNumber\" : \"\",\"passportBirthCity\" : \"\",\"employerZip\" : \"\",\"cardDeptStrInd\" : \"\",\"blackBoxId\" : \"\",\"title\" : \"\",\"bankAccountCode\" : \"\",\"regionalBusinessCode\" : \"\",\"occupationCode\" : \"\",\"employerAddress\" : \"\",\"driverLicenseNumber\" : \"\",\"applicationType\" : \"\",\"accoutInfo\" : \"\",\"mortgageOrRentPay\" : \"\",\"extensionOverride\" : \"\",\"employerCity\" : \"\",\"middleName\" : \"\",\"suffix\" : \"\",\"ssnOverride\" : \"\",\"currentEmployer\" : \"\",\"relativeCode\" : \"\",\"routingNumber\" : \"\",\"cellPhone\" : \"\",\"frnLangIndicator\" : \"E\",\"checkingAccountNumber\" : \"\",\"memberType\" : \"\"}}}}"
            }
        }
        
        return stringToReturn
    }
    
    func convertStringToDictionary(text: String) -> [String:AnyObject]? {
        if let data = text.data(using: String.Encoding.utf8) {
            do {
                return try JSONSerialization.jsonObject(with: data, options: []) as? [String:AnyObject]
            } catch let error as NSError {
                print(error)
            }
        }
        return nil
    }
    
    func makeRequest(forEndpoint: String) {
        let request = NSMutableURLRequest(url: NSURL(string: "https://syf2020.syfwebservices.com/syf/\(forEndpoint)") as! URL)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.addValue("giveitatry", forHTTPHeaderField: "username")
        request.addValue("Sh0wT!me", forHTTPHeaderField: "password")
        
        let bodyString = self.determine(bodyString: forEndpoint)
        let bodyData = bodyString.data(using: .utf8)
        
        request.httpMethod = "POST"
        request.httpBody = bodyData
        
        print(NSString(data: request.httpBody!, encoding: String.Encoding.utf8.rawValue)!)
        print(request.allHTTPHeaderFields!)
        let task = URLSession.shared.dataTask(with: request as URLRequest) { data, response, error in
            print(data!)
            print(response!)
            guard error == nil else {
                print(error)
                return
            }
            guard let data = data else {
                print("Data is empty")
                return
            }
            
            let json = try! JSONSerialization.jsonObject(with: data, options: [])
            print(json)
            let jsonString = String(describing: json)
            
            self.updateResponseView(withString: jsonString)
        }
        
        task.resume()
    }

}

