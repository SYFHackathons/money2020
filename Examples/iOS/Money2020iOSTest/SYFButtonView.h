//
//  SYFButtonView.h
//  Money2020iOSTest
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/18/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

#import <UIKit/UIKit.h>

@protocol SYFButtonDelegate <NSObject>

-(void)buttonWasTapped:(NSString*)withTitle;

@end

@interface SYFButtonView : UIView

-(void)handleViewChange;

@property (assign) id<SYFButtonDelegate> delegate;

@end
