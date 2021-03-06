# Foursquare Android Client [![BuddyBuild](https://dashboard.buddybuild.com/api/statusImage?appID=591aa40f8c7b370001464696&branch=master&build=latest)](https://dashboard.buddybuild.com/apps/591aa40f8c7b370001464696/build/latest?branch=master)
Displays results for locations using the Foursquare API

### Requirements
- Android Studio 2.3.2 and API 25 build tools and libraries installed

### Run instructions
1. Build the project using gradle `./gradlew build`
2. Deploy the app to a connected device `./gradlew installDebug`

### Design approach
The project is a simple app showing a list of venues for the searched location using the Foursquare API.

Despite being simple in features, I wanted the project to showcase the use of the MVP design pattern to improve the overall architecture of the app, allowing the behaviour of the app to be unit testable. The MVP pattern is especially useful in Android as the controller components (`Activity` and `Fragment`) are not easily unit testable, so the business logic must live in a class with no references to the Android framework.

Unit tests for the presenters can be found in the `app/src/test/java` directory.

Currently the app does not use a dependency injection library, and dependencies are passed manually in the constructor. With more time I would replace this with a proper DI library (e.g. Dagger 2).

[BuddyBuild](http://buddybuild.com/) Continuous Integration server has been set up to build the project and run tests automatically on each commit. The latest build status is displayed at the top of this readme file.

![Screenshot](https://github.com/jamesgoodwin/Foursquare-Android-Client/blob/master/screenshot2.png)
