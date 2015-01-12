#Fake Device Data
Xposed module to change the fields of android.os.build without rewriting the "build.prop".  
This app use those library. Thanks to @afollestad and @futuresimple  
https://github.com/afollestad/material-dialogs  
https://github.com/futuresimple/android-floating-action-button  

## How to use:
1. Launch the module, check the app that you want to impersonate.
2. Press the "PLUS" button, and then select "Fake Data Setting".
3. Enter the data to impersonate and checked.
   (Press back button the settings are saved.)
4. Press the "PLUS" button, and then select "save and exit"

## What you can do:
* Impersonate your device to other device.  
  (By changing the Build.DEVICE and Build.PRODUCT)
* Limit the target application to impersonate.  
  (e.g. "Google Play" only.)

## Caution:
You get a bootloop if you impersonate a system app (and some normal app).    
**If you don't know how to recovery from bootloop, should not use this module.**

## License:
Licensed under the Apache License, Version 2.0 (the "License").

## Change log:
* Ver 0.2
 - Show progress dialog while app loading.
 
* Ver 0.1
 - Project release.
