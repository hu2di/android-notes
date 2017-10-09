# android-notes
Notes for Android: Google Admob, MoPub, StartApp, Build Wifi, Compile project... 

# import module
1. Open settings.gradle
2. include ':project'
3. dependencies {
    compile project(':project')
   }
   
# import .aar file
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

# import .jar file
1. Copy .jar file to ../app/libs/
2. dependencies {
    compile files('libs/file.jar')
   }
   
# Build Wifi
Folder ..\Android\sdk\platform-tools<br>

adb devices<br>
adb tcpip 5555<br>
adb connect 192.168.*.*:5555<br>

adb -s 192.168.*.*:5555 usb

# Reset purchased
Open Android Studio -> Terminal<br>
adb shell pm clear com.android.vending

# About
Created by HuyHung Dinh<br>
GitHub: https://github.com/hu2di<br>
Email: hebitaxy@gmail.com
