# Foursquare Android Client [![BuddyBuild](https://dashboard.buddybuild.com/api/statusImage?appID=591aa40f8c7b370001464696&branch=master&build=latest)](https://dashboard.buddybuild.com/apps/591aa40f8c7b370001464696/build/latest?branch=master)
Displays results for locations using the Foursquare API

### Run instructions
1. Build the project using gradle `./gradlew build`
2. Deploy the app to a connected device `./gradlew installDebug`

### Design approach
The project is a simple app showing a list of venues for the searched location using the Foursquare API.

Despite being simple in features, I wanted the project to showcase the use of the MVP design pattern to improve the overall architecture of the app, allowing the behaviour of the app to be unit testable. The MVP pattern is especially useful in Android since the view components (`Activity` and `Fragment`) are not easily unit testable, so the business logic must be in a class with no direct dependency on the Android framework.

![BuddyBuild](https://github.com/jamesgoodwin/Foursquare-Android-Client/blob/master/screenshot2.png)
