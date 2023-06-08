pipeline {
    agent { docker { image 'node:18.16.0-alpine' } }

    environment {
        TG_BOT_TOKEN = vault path: 'secret/telegram', key: 'TG_BOT_TOKEN'
        TG_CHAT_ID = vault path: 'secret/telegram', key: 'TG_CHAT_ID'
    }

    stages {
        stage('build') {
            steps {
                sh 'node --version'

                sh "curl -X POST -H 'Content-Type: application/json' https://api.telegram.org/bot${TG_BOT_TOKEN}/sendMessage -d '{\"chat_id\": \"${TG_CHAT_ID}\", \"text\": \"test\"}'"
            }
        }
    }
}
