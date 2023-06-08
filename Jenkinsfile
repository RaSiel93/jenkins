pipeline {
    agent { docker { image 'node:18.16.0-alpine' } }

    stages {
        stage('build') {
            steps {
                sh 'node --version'

                withCredentials([
                    string(credentialsId: 'TG_BOT_TOKEN', variable: 'TG_BOT_TOKEN'),
                    string(credentialsId: 'TG_CHAT_ID', variable: 'TG_CHAT_ID')
                ]) {
                    sh "curl -X POST -H 'Content-Type: application/json' https://api.telegram.org/bot${TG_BOT_TOKEN}/sendMessage -d '{\"chat_id\": \"${TG_CHAT_ID}\", \"text\": \"test\"}'"
                }
            }
        }
    }
}
