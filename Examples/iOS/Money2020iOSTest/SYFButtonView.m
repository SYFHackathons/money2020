//
//  SYFButtonView.m
//  Money2020iOSTest
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/18/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

#import "SYFButtonView.h"
#import "SYFButton.h"
#import "Constants.h"

@interface SYFButtonView ()

@property (strong, nonatomic) SYFButton *getRewardsButton;
@property (strong, nonatomic) SYFButton *nextMostLikelyPurchaseButton;
@property (strong, nonatomic) SYFButton *applyForCreditButton;
@property (strong, nonatomic) SYFButton *clearTextButton;

@end

@implementation SYFButtonView

-(instancetype) init {
    self = [super init];
    if (self) {
        [self initializeView];
    }
    
    return self;
}

-(void) initializeView {
    self.getRewardsButton = [[SYFButton alloc] initWithTitle:kAPIGetRewards];
    [self.getRewardsButton addTarget:self action:@selector(buttonWasTapped:) forControlEvents:UIControlEventTouchUpInside];
    [self addSubview:self.getRewardsButton];
    
    self.nextMostLikelyPurchaseButton = [[SYFButton alloc] initWithTitle:kAPINextMostLikely];
    [self.nextMostLikelyPurchaseButton addTarget:self action:@selector(buttonWasTapped:) forControlEvents:UIControlEventTouchUpInside];
    [self addSubview:self.nextMostLikelyPurchaseButton];
    
    self.applyForCreditButton = [[SYFButton alloc] initWithTitle:kAPIApplyForCredit];
    [self.applyForCreditButton addTarget:self action:@selector(buttonWasTapped:) forControlEvents:UIControlEventTouchUpInside];
    [self addSubview:self.applyForCreditButton];
    
    self.clearTextButton = [[SYFButton alloc] initWithTitle:kClearButtonLabel];
    [self.clearTextButton addTarget:self action:@selector(buttonWasTapped:) forControlEvents:UIControlEventTouchUpInside];
    [self addSubview:self.clearTextButton];
    
    [self handleViewChange];
}

-(void)handleViewChange {
    int buttonHeight = 30;
    int edgeOffset = 10;
    float availWidth = [UIScreen mainScreen].bounds.size.width;
    int availHeight = (buttonHeight * 4) + (edgeOffset * 6);
    
    self.frame = CGRectMake(0, 0, availWidth, availHeight);
    
    [self.getRewardsButton sizeToFit];
    self.getRewardsButton.frame = CGRectMake((availWidth - self.getRewardsButton.frame.size.width)/2, edgeOffset, self.getRewardsButton.frame.size.width + (edgeOffset * 2), buttonHeight);
    
    [self.nextMostLikelyPurchaseButton sizeToFit];
    self.nextMostLikelyPurchaseButton.frame = CGRectMake((availWidth - self.nextMostLikelyPurchaseButton.frame.size.width)/2, self.getRewardsButton.frame.origin.y + buttonHeight + edgeOffset, self.nextMostLikelyPurchaseButton.frame.size.width + (edgeOffset * 2), buttonHeight);
    
    [self.applyForCreditButton sizeToFit];
    self.applyForCreditButton.frame = CGRectMake((availWidth - self.applyForCreditButton.frame.size.width)/2, self.nextMostLikelyPurchaseButton.frame.origin.y + buttonHeight + edgeOffset, self.applyForCreditButton.frame.size.width + (edgeOffset * 2), buttonHeight);
    
    [self.clearTextButton sizeToFit];
    self.clearTextButton.frame = CGRectMake((availWidth - self.clearTextButton.frame.size.width)/2, self.applyForCreditButton.frame.origin.y + buttonHeight + edgeOffset, self.clearTextButton.frame.size.width + (edgeOffset * 2), buttonHeight);
    
}

-(void)buttonWasTapped:(SYFButton*)sender {
    if ([sender isKindOfClass:[SYFButton class]]) {
        NSString *buttonTitle = ([sender.titleLabel.text length]) ? sender.titleLabel.text : kClearButtonLabel;
        if (self.delegate && [self.delegate respondsToSelector:@selector(buttonWasTapped:)]) {
            [self.delegate buttonWasTapped:buttonTitle];
        }
    }
}

@end
