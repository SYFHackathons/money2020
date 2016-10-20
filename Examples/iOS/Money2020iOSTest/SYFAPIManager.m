//
//  SYFAPIManager.m
//  Money2020iOSTest
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/18/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

#import "SYFAPIManager.h"
#import "Constants.h"

@implementation SYFAPIManager

+ (id)sharedManager {
    static SYFAPIManager *sharedManager = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        sharedManager = [[self alloc] init];
    });
    return sharedManager;
}

-(NSString*)returnBodyString:(NSString*)forEndpoint {
    NSString *stringToReturn = @"";
    
    if ([forEndpoint isEqualToString:kAPIGetRewards]) {
        stringToReturn = @"{ \
        \"Header\": { \"trans_id\": \"demorewards\" },\
        \"gps_syf_profileid\": \"6ff47aed18048b7708dd84b47152ee75db535e0eaa90b46fc3b7dc20745780dd\" \
        }";
    } else if ([forEndpoint isEqualToString:kAPINextMostLikely]) {
        stringToReturn = @"{\"accountNum\": \"100009\"}";
    } else if ([forEndpoint isEqualToString:kAPIApplyForCredit]) {
        //change "lastname" to APPROVAL, DECLINE, and REFER to get a different response.
        stringToReturn = @"{\"apply\" : {\"applyRequest\" : {\
        \"authCosApplicantData\" : {\"lastNameapp\" : \"\",\"firstNameapp\" : \"\",\"middleInitialapp\" : \"\",\"suffixapp\" : \"\",\"ssn1\" : \"\",\"birthDateapp\" : \"\",\"driverLicenseNumberapp\" : \"\",\"driverLicenseStateapp\" : \"\",\"signatureIndicatorapp\" : \"\",\"titleapp\" : \"\",\"occupationCodeapp\" : \"\",\"incomeAnnualapp\" : \"\",\"address\" : {\"address2app\" : \"\",\"stateapp\" : \"\",\"address1app\" : \"\",\"cityapp\" : \"\",\"zipCodeapp\" : \"\"},\"membershipNumberapp\" : \"\",\"ssnOverrideapp\" : \"\",\"driverLicenseExpiryDateapp\" : \"\"},\"spouseDetails\" : {\"spFirstName\" : \"\",\"spMiddleName\" : \"\",\"spLastName\" : \"\",\"address\" : {\"address2spd\" : \"\",\"statespd\" : \"\",\"address1spd\" : \"\",\"cityspd\" : \"\",\"zipCodespd\" : \"\"}},\"merchantData\" : {\"clientDepartment\" : \"\",\"iovationRequestType\" : \"application\",\"operator\" : \"ECOM\",\"clientData\" : \"\",\"merchantNumber\" : \"0000000000010032\",\"country\" : \"US\",\"deviceType\" : \"T\",\"originalProductCode\" : \"010\",\"rewardsCode\" : \"\",\"membershipNumber\" : \"\",\"primaryGroup\" : \"000\",\"empAccountCode\" : \"Y\",\"salesPerson\" : \"213006748\",\"clientDataShare\" : \"\",\"sendEmail\" : \"\",\"referalCode\" : \"\",\"register\" : \"REGISTER\",\"clientId\" : \"TJX\",\"referCode\" : \"\",\"comment\" : \"\",\"secondaryGroup\" : \"000\"},\"primaryApplicant\" : {\"tempPassDays\" : \"\",\"longitude\" : \"\",\"cardIndSEDS\" : \"\",\"promoTrack\" : \"\",\"employerState\" : \"\",\"spCode\" : \"\",\"bankCardNumber\" : \"\",\"signatureIndicator\" : \"\",\"customerLoanTerm\" : \"\",\"passportIssuingCountry\" : \"\",\"swipeEdit\" : \"\",\"address\" : {\"address2\" : \"\",\"state\" : \"IL\",\"address1\" : \"21 KING ARTHUR CT\",\"city\" : \"FANTASY ISLAND\",\"zipCode\" : \"60750\"},\"plateCode\" : \"\",\"ssn\" : \"666010080\",\"permanentResidentCard\" : \"\",\"passportNumber\" : \"\",\"cardIndVISA\" : \"\",\"cardIndAMEX\" : \"\",\"mobileStoreDistance\" : \"\",\"bankCardType\" : \"\",\"employerName\" : \"\",\"redemptionAmount\" : \"\",\"timeAtHome\" : \"\",\"latitude\" : \"\",\"applicationCountry\" : \"\",\"homePhone\" : \"1234567891\",\"requestedlineOfCredit\" : \"\",\"relativeInfo\" : \"\",\"memberNumber\" : \"\",\"employerPhone\" : \"\",\"imageDocID\" : \"\",\"secLastName\" : \"\",\"optOutFlag\" : \"\",\"eBillEnrollment\" : \"\",\"cardIndMC\" : \"\",\"birthDate\" : \"19700605\",\"promoCode\" : \"\",\"incomeAnnual\" : \"12000000\",\"companyPhone\" : \"\",\"maidenName\" : \"\",\"authCosCode\" : \"\",\"insuranceCode\" : \"\",\"onlineLetter\" : \"\",\"billingLastName\" : \"\",\"caCivicNumber\" : \"\",\"previousAddress\" : {\"address2prvad\" : \"\",\"stateprvad\" : \"\",\"address1prvad\" : \"\",\"cityprvad\" : \"\",\"zipCodeprvad\" : \"\"},\"mobileDeviceType\" : \"\",\"lastName\" : \"APPROVAL\",\"billinngCycle\" : \"\",\"firstName\" : \"JOE\",\"ipAddress\" : \"\",\"purchaseAmount\" : \"\",\"extensionPhoneNumber\" : \"\",\"driverLicenseState\" : \"\",\"sourceCode\" : \"\",\"mothersBirthDate\" : \"\",\"driverLicenseExpiryDate\" : \"\",\"dlSsoId\" : \"\",\"memberSinceDate\" : \"\",\"email\" : \"t@t.com\",\"reissueDate\" : \"\",\"modelIndicator\" : \"\",\"billingFirstName\" : \"\",\"residenceCode\" : \"\",\"timeAtJob\" : \"\",\"vehicleOwn\" : \"\",\"relativePhone\" : \"\",\"creditLineRqd\" : \"\",\"contractNumber\" : \"\",\"passportBirthCity\" : \"\",\"employerZip\" : \"\",\"cardDeptStrInd\" : \"\",\"blackBoxId\" : \"\",\"title\" : \"\",\"bankAccountCode\" : \"\",\"regionalBusinessCode\" : \"\",\"occupationCode\" : \"\",\"employerAddress\" : \"\",\"driverLicenseNumber\" : \"\",\"applicationType\" : \"\",\"accoutInfo\" : \"\",\"mortgageOrRentPay\" : \"\",\"extensionOverride\" : \"\",\"employerCity\" : \"\",\"middleName\" : \"\",\"suffix\" : \"\",\"ssnOverride\" : \"\",\"currentEmployer\" : \"\",\"relativeCode\" : \"\",\"routingNumber\" : \"\",\"cellPhone\" : \"\",\"frnLangIndicator\" : \"E\",\"checkingAccountNumber\" : \"\",\"memberType\" : \"\"}}}}";
    }

    return stringToReturn;
}

-(void)makeRequest:(NSString*)forEndpoint completion:(apiCompletionBlock)completionBlock {
    NSString *urlAsString = [NSString stringWithFormat:@"%@%@",kAPIBaseURL,forEndpoint];
    
    NSCharacterSet *set = [NSCharacterSet URLQueryAllowedCharacterSet];
    NSString *encodedUrlAsString = [urlAsString stringByAddingPercentEncodingWithAllowedCharacters:set];
    
    NSURLSession *session = [NSURLSession sessionWithConfiguration:[NSURLSessionConfiguration defaultSessionConfiguration]];
    
    NSMutableURLRequest *request = [[NSMutableURLRequest alloc] initWithURL:[NSURL URLWithString:encodedUrlAsString]];
    [request addValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request addValue:kUsername forHTTPHeaderField:@"username"];
    [request addValue:kPassword forHTTPHeaderField:@"password"];
    
    NSString *bodyString = [self returnBodyString:forEndpoint];
    NSData *postData = [bodyString dataUsingEncoding:NSASCIIStringEncoding allowLossyConversion:YES];
    [request setHTTPBody:postData];
    
    [request setHTTPMethod:@"POST"];
    
    [[session dataTaskWithRequest:request
                completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
                    
                    NSLog(@"RESPONSE: %@",response);
                    NSLog(@"DATA: %@",data);
                    
                    if (!error) {
                        // Success
                        dispatch_async(dispatch_get_main_queue(), ^{
                            
                            if ([response isKindOfClass:[NSHTTPURLResponse class]]) {
                                NSError *jsonError;
                                NSDictionary *jsonResponse = [NSJSONSerialization JSONObjectWithData:data options:0 error:&jsonError];
                                if (!jsonResponse) {
                                    completionBlock(NO, @"", jsonError);
                                    NSLog(@"ERROR.  return!");
                                    return;
                                }
                                NSData * jsonData = [NSJSONSerialization  dataWithJSONObject:jsonResponse options:NSJSONWritingPrettyPrinted error:&jsonError];
                                NSString * jsonResponseString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
                                
                                if (jsonError) {
                                    // Error Parsing JSON
                                    completionBlock(NO, @"", jsonError);
                                } else {
                                    // Success Parsing JSON
                                    NSLog(@"jsonResponseString: %@",jsonResponseString);
                                    completionBlock(YES, jsonResponseString, nil);
                                }
                            }  else {
                                completionBlock(NO, @"", nil);
                            }
                        });
                    } else {
                        // Fail
                        NSLog(@"error : %@", error.description);
                        completionBlock(NO, @"", error);
                    }
                }] resume];
}

@end
