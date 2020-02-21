pipeline { 
    agent any  
    tools { 
        maven 'Maven' 
        jdk '1.8' 
    }
    stages { 
    	stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('Build') { 
            steps { 
               sh 'mvn clean compile'
            }
        }
        stage('Test'){
        	steps {
        		sh 'mvn test'
        	}
        	post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}