### android-notes
Notes for Android: Google Admob, MoPub, StartApp, Build Wifi, Compile project... 

### import module
1. Open settings.gradle
2. include ':project'
3. dependencies {
    compile project(':project')
   }
   
### import .aar file
1. Copy .aar file to ../app/libs/
2. allprojects {
   repositories {
      jcenter()
      flatDir {
        dirs 'libs'
      }
   }
}
3. dependencies {
    compile(name:'cards', ext:'aar')
   }

### import .jar file
1. Copy .jar file to ../app/libs/
2. dependencies {
    compile files('libs/file.jar')
   }
   
### Build Wifi
Folder ..\Android\sdk\platform-tools<br>

adb devices<br>
adb tcpip 5555<br>
adb connect 192.168.*.*:5555<br>

adb -s 192.168.*.*:5555 usb

### Reset purchased
Open Android Studio -> Terminal<br>
adb shell pm clear com.android.vending


### PayPal
 - [**Donate 5 $**](https://www.paypal.me/hungdh/5usd): Thank's for creating this project, here's a coffee (or some beer) for you!
 - [**Donate 10 $**](https://www.paypal.me/hungdh/10usd): Wow, I am stunned. Let me take you to the movies!
 - [**Donate 15 $**](https://www.paypal.me/hungdh/15usd): I really appreciate your work, let's grab some lunch! 
 - [**Donate 25 $**](https://www.paypal.me/hungdh/25usd): That's some awesome stuff you did right there, dinner is on me!
 - [**Donate 50 $**](https://www.paypal.me/hungdh/50usd): I really really want to support this project, great job!
 - [**Donate 100 $**](https://www.paypal.me/hungdh/100usd): You are the man! This project saved me hours (if not days) of struggle and hard work, simply awesome!
 - Of course, you can also [**choose what you want to donate**](https://www.paypal.me/hungdh), all donations are awesome!
 
### About
Created by HuyHung Dinh<br>
GitHub: https://github.com/hu2di<br>
Email: hebitaxy@gmail.com
