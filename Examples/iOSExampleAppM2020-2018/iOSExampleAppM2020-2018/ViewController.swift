//
//  ViewController.swift
//  iOSExampleAppM2020-2018
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/19/18.
//  Copyright © 2018 Synchrony. All rights reserved.
//

import UIKit
import OAuthSwift

class ViewController: UIViewController {
    var oauthswift: OAuthSwift?
    var accessToken: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
    }

    @IBAction func getToken(_ sender: Any) {
//        First we need to use the OauthSwift library to establish our OAuth connection.  Put in your registered Consumer Key and your Consumer secret from the https://developer.syf.com/ portal below
        let oauthswift = OAuth2Swift(
            consumerKey:    "<<YOUR CONSUMER KEY HERE>>",
            consumerSecret: "<<YOUR CONSUMER SECRET HERE>>",
            authorizeUrl:   "https://api-stg.syf.com/oauth2/v1/authorize",
            accessTokenUrl: "https://api-stg.syf.com/oauth2/v1/token",
            responseType:   "token"
        )
        
        self.oauthswift = oauthswift
        
        let state = generateState(withLength: 20)
        
        let _ = oauthswift.authorize(deviceToken: "", grantType: "client_credentials",
            success: { credential in
                self.showAlert("Your token is \(credential.oauthToken) and it expires at \(credential.oauthTokenExpiresAt).  Use it or lose it!")
                self.accessToken = credential.oauthToken
        },
            failure: { error in
                self.showAlert(error.localizedDescription)
        })
    }
    
    @IBAction func useYourToken(_ sender: Any) {
        if ((self.accessToken?.count) != nil) {
//            Once we have our access token, we can use the APIs!  Below is just a small sample grabbing a customer's profile and showing it in an alert
            self.oauthswift?.client.get("https://api-stg.syf.com/m2020/customers/1/profile",
                                  success: { response in
                                    let dataString = response.string
                                    self.showAlert("You got data!\n\(dataString)")
            },
                                  failure: { error in
                                    self.showAlert("Looks like we had an error: \(error)")
            }
            )
        } else {
//            There must have been some issue getting your token, or maybe you didn't replace your consumer key/consumer secret in the code above?
            self.showAlert("Request a token first, please!")
        }
    }
    
    
    func showAlert(_ message: String) {
        let alertController = UIAlertController(title: "Money2020", message: message, preferredStyle: .alert)
        
        let alertAction = UIAlertAction(title: "Alright!", style: .default) { (UIAlertAction) in
            
        }
        
        alertController.addAction(alertAction)
        
        self.present(alertController, animated: true, completion: nil)
    }
    
}

