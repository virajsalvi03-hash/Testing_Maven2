pipeline {
    agent any
    
    triggers {
        parameterized('''40 15 * * * % BROWSER=chrome;ENVIRONMENT=qa
        42 15 * * * % BROWSER=edge;ENVIRONMENT=uat
        44 15 * * * % BROWSER=chrome;ENVIRONMENT=prod''')
    }
    
    parameters{
		choice{
			name: 'BROWSER',
			chioce: ['Chrome', 'edge','firefox'],
			description: 'Select the browser to run the tests'
		}
		choice{
			name: 'ENVIRONMENT',
			choice: ['prod','qa','uat']
			description: 'Select the environment to run the tests'
		}
	}

    tools {
        jdk 'Java_JDK'
        maven 'MAVEN'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/virajsalvi03-hash/Testing_Maven2.git',
                    branch: 'main'
            }
        }

         stage('Build & Test') {
            steps {
                bat "mvn clean test -Dbrowser=${params.BROWSER} -Denvironment=${params.ENVIRONMENT}"
            }
        }
    }
}