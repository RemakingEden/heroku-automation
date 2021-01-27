# heroku-automation

heroku-automation is a suite of automated UI tests of the website http://the-internet.herokuapp.com/

## Installation

* Java 11
* Chrome browser
* Chromium webdriver for your version of the browser and OS
Find out existing chrome version by going to Menu -> About Chrome
* Download chromedriver from [here](https://chromedriver.chromium.org/), matching the version of the chrome and OS
Extract it from zip, and place the binary in the project's src/test/resource/driver directory, replacing the old one.

## Usage

```bash
cd heroku-automation
mvn test
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
