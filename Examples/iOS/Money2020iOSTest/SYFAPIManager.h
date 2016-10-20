//
//  SYFAPIManager.h
//  Money2020iOSTest
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/18/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

#import <Foundation/Foundation.h>

@interface SYFAPIManager : NSObject

typedef void (^apiCompletionBlock)(BOOL success, NSString *responseString, NSError *error);

+ (id)sharedManager;
-(void)makeRequest:(NSString*)forEndpoint completion:(apiCompletionBlock)completionBlock;

@end
