#Fake Device Data
Xposed module to fake your device data without rewrite build.prop only for you selected app.  
This app use those library. Thanks to @afollestad and @futuresimple  
https://github.com/afollestad/material-dialogs  
https://github.com/futuresimple/android-floating-action-button  

##Installation instructions:
1. Install the module
2. Run Xposed Installer and enable the module "Fake Device Data"
3. Reboot the phone

## Features:
* replace android.os.build data (e.g. PRODUCT) with you edit text for selected app.

## Caution:
You get a bootloop when you enable fake for system app or some normal app.  
If you don't know how to recovery from bootloop, shouldn't use this module. 

## Change log:
* Ver 0.2
 - Show progress dialog while app loading.
 
* Ver 0.1
 - Project release.
