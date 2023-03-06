# Challenge_Auto_Test

To run locally, with maven command:

	1. test -Denvironment=local_chrome -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='@addNewAppointment' -Dcucumber.plugin="json:target/site/result.json" -Dcucumber.glue='demo'

To run the test with Jenkins, locally:

	1. Create a new pipeline with choices to election, between the choices put:
		@addNewAppointment
		@addSameAppointment
		@addAppointmentPastDate
		@addAppointmentOutWrkHours
		@deleteAppointment
		@Appointment
	
	2. In Pipeline point to main branch
	
	3. In Script Path field, put Jenkinsfile

To run the tests with Jenkins, in saucelabs cloud:

	1. In the serenity.conf change the username and accessKey
	2. In the Script Path field, put JenkinsFileCloud