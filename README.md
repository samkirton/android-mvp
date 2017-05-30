### Opening the project

- Using Android Studio 2.2.2 open the project root build.gradle

	File -> Open -> /build.gradle

### Running the app

- Ensure the online build variant is selected

	View -> Tools Windows -> Build Variants ->  onlineDebug

- Select the run app icon

- Pick a device or simulator (The app is named "Forecast")

### Running the unit tests

-  Ensure the project window is open

	View -> Tools Windows -> Project

- In the project hierarchy right click

	Weather / app /  src / test / java

- Select Run 'Tests' in java

- Right click and select Run 'Tests' again if you receive an empty test suite warning.

### Android API level

Android API 15 was chosen to support 95%+ of devices that use google play.

### Clean architecture

The package structure follows the dependency rule in the following direction:
presenter -> repository -> system

### MVP

The presenter packages uses the Model View Presenter design pattern. The WeatherActivity displays data and propagates UI events to the WeatherPresenter. The WeatherPresenter interacts with the repository, handles any conditional logic and sends any results back to the WeatherView to be displayed in the WeatherActivity.


### Repository pattern

The repository pattern is used to decouple the API and its model from the MVP pattern, the presenter only cares about the entities in the system package.

### Build variants

A different ForecastApi is used in ApiModule.java for online or offline build variants.

The online build variant uses the retrofit ForecastApi to fetch the forecast from OpenWeatherMap. Alternatively, the offline build variant replaces ForecastApi with DummyForecastApi. DummyForecastApi parses a local JSON file and returns a weather response immediately for offline development.