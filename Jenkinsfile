pipeline { 
    agent any  
    tools { 
        maven 'Maven' 
        jdk '1.8' 
    }
    stages { 
        stage('Build') { 
            steps { 
               mvn clean compile
            }
        }
        stage('Test'){
        	steps {
        		mvn test
        	}
        }
    }
}