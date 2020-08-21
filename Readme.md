Google Meet Mute Button Functionality Validations ReadMe:

The java code will open an automated Google Chrome window , sign in to google accounts and enter a video call through a Google Meet link.
Once joined in , mute button will be toggled ON/OFF to test its functionality.

UI validation is automatable whereas the backend functionality is validated manually as it is not possible to trigger API to mute/unmute google meet call. 

External Jars used:
  1. Selenium 3.141.59
  2. ChromeDriver
  
Steps to run the code:
1. Download and setup above mentioned external jars.
2. Set TestNg in classpath.
3. Run testGoogleMeetMuteButtonFunctionality test case in class - GoogleMeetMuteButtonFunctionalityTest
