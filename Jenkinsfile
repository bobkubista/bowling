pipeline { 
    agent any  
    tools { 
        maven 'Maven' 
        jdk '1.8' 
    }
    stages { 
        stage('Compile') { 
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