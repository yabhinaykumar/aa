pipeline {
    agent any

    stages {
        stage('Create file') {
            steps {
                // Create a new file called "hello.txt" in the Jenkins workspace directory
                writeFile file: 'hello.txt', text: 'Hello World!'
            }
        }

        stage('Upload to S3') {
            steps {
                // Upload the "hello.txt" file to an S3 bucket
                sh 'aws s3 cp hello.txt s3://abhinayy/'
            }
        }
    }
}