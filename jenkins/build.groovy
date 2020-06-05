pipeline {
	
	agent any
	
	options {
		buildDiscarder(logRotator(numToKeepStr: '1'))
		disableConcurrentBuilds()
		timestamps()
		parallelsAlwaysFailFast()
	}
	
	tools {
		maven 'maven-3.6.0'
		jdk 'jdk1.8'
		gradle 'gradle-5.6.2'
	}
	
	parameters {
		string(name: 'DEPLOY_ENV', defaultValue: 'dev', description: '')
		text(name: 'DEPLOY_TXT', defaultValue: 'One\nTwo\nThree\n', description: '')
		booleanParam(name: 'DEBUG_BUILD', defaultValue: true, description: '')
		choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
		password(name: 'PASSWORD', defaultValue: 'SECRET', description: '')
	}
	
	stages{
		stage('Build') {
			steps {
				
				echo "Env : ${params.DEPLOY_ENV}"
				echo "Text : ${params.DEPLOY_TXT}"
				echo "Build : ${params.DEBUG_BUILD}"
				echo "Choice : ${params.CHOICE}"
				echo "Pwd : ${params.PASSWORD}"
				
			
			}			
		}
	}
	
}