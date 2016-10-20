//
//  ViewController.m
//  Money2020iOSTest
//
//  Created by Handelman, Steven (Synchrony Financial) on 10/18/16.
//  Copyright © 2016 Handelman, Steven (Synchrony Financial). All rights reserved.
//

#import "ViewController.h"
#import "Constants.h"
#import "SYFButtonView.h"
#import "SYFAPIManager.h"
#import "MBProgressHUD.h"

@interface ViewController () <SYFButtonDelegate>

@property (strong, nonatomic) SYFButtonView *buttonView;
@property (strong, nonatomic) UITextView *responseView;
@property (strong, nonatomic) MBProgressHUD *HUD;

@end

@implementation ViewController

-(instancetype) init {
    self = [super init];
    if (self) {
        [self initializeViews];
    }
    return self;
}

- (void)viewWillTransitionToSize:(CGSize)size withTransitionCoordinator:(id<UIViewControllerTransitionCoordinator>)coordinator
{
    [coordinator animateAlongsideTransition:^(id<UIViewControllerTransitionCoordinatorContext> context) {
        [self handleViewChange];
        
     } completion:^(id<UIViewControllerTransitionCoordinatorContext> context) {
     }];
    
    [super viewWillTransitionToSize:size withTransitionCoordinator:coordinator];
}

-(void)initializeViews {
    self.buttonView = [[SYFButtonView alloc] init];
    self.buttonView.delegate = self;
    [self.view addSubview:self.buttonView];
    
    self.responseView = [[UITextView alloc] init];
    self.responseView.textColor = [UIColor whiteColor];
    self.responseView.font = [UIFont systemFontOfSize:16];
    self.responseView.backgroundColor = [UIColor SYFGray];
    self.responseView.editable = NO;
    [self.view addSubview:self.responseView];
    
    [self handleViewChange];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    self.title = @"Synchrony Financial Hackathon Demo";
}

-(void)handleViewChange {
    float availWidth = [UIScreen mainScreen].bounds.size.width;
    float availHeight = [UIScreen mainScreen].bounds.size.height;
    float offsetY = self.navigationController.navigationBar.frame.origin.y + self.navigationController.navigationBar.frame.size.height;
    
    [self.buttonView handleViewChange];
    self.buttonView.frame = CGRectMake(0, offsetY, self.buttonView.frame.size.width, self.buttonView.frame.size.height);
    self.responseView.frame = CGRectMake(0, self.buttonView.frame.origin.y + self.buttonView.frame.size.height, availWidth, availHeight - (self.buttonView.frame.origin.y + self.buttonView.frame.size.height));
}

-(void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self handleViewChange];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)clearTextView {
    self.responseView.text = @"";
}

-(void)updateResponseView:(NSString*)withString {
    dispatch_async(dispatch_get_main_queue(), ^{
        self.responseView.text = withString;
    });
}


#pragma mark - SYFButtonDelegate Methods

-(void)buttonWasTapped:(NSString *)withTitle {
//    NSLog(@"buttonWasTapped withTitle: %@",withTitle);
    
    if ([withTitle isEqualToString:kClearButtonLabel]) {
        [self clearTextView];
        return;
    }
    self.HUD = [MBProgressHUD showHUDAddedTo:self.view animated:YES];
    self.HUD.label.text = @"Loading...";
    
    if ([withTitle isEqualToString:kAPIGetRewards] || [withTitle isEqualToString:kAPIApplyForCredit] || [withTitle isEqualToString:kAPINextMostLikely]) {
        [[SYFAPIManager sharedManager] makeRequest:withTitle completion:^(BOOL success, NSString *responseString, NSError *error) {
            [self.HUD hideAnimated:YES];
            if (success) {
                [self updateResponseView:responseString];
            } else {
                NSLog(@"API failed.  TODO!");
            }
        }];
    }
}


@end
