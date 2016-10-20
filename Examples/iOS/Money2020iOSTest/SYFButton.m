//
//  SYFButton.m
//  Money2020iOSTest
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/18/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

#import "SYFButton.h"
#import "UIImage+ImageWithColor.h"
#import "Constants.h"

@implementation SYFButton

-(instancetype) initWithTitle:(NSString *)buttonTitle {
    self = [super init];
    if (self) {
        [self setBackgroundImage:[UIImage imageWithColor:[UIColor SYFYellow]] forState:UIControlStateNormal];

        self.layer.cornerRadius = 5;
        self.clipsToBounds = YES;
        
        if ([buttonTitle length]) {
            [self setTitle:buttonTitle forState:UIControlStateNormal];
            [self setTitleColor:[UIColor SYFGray] forState:UIControlStateNormal]; //gray
            
            [self setBackgroundImage:[UIImage imageWithColor:[UIColor SYFGray]] forState:UIControlStateHighlighted];
            [self setTitleColor:[UIColor SYFYellow] forState:UIControlStateHighlighted]; //gray
        }
    }
    
    return self;
}


@end
