pipeline {
    agent any
    
    

    triggers {
        parameterizedCron('''
            57 15 * * * % BROWSER=chrome;ENVIRONMENT=qa
            58 15 * * * % BROWSER=edge;ENVIRONMENT=uat
            00 14 * * * % BROWSER=chrome;ENVIRONMENT=prod
        ''')
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