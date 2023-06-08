// def utils

/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'node:18.16.0-alpine' } }

    environment {
        TG_BOT_TOKEN = vault path: 'secret/telegram', key: 'TG_BOT_TOKEN'
        TG_CHAT_ID = vault path: 'secret/telegram', key: 'TG_CHAT_ID'
    }

    stages {
        stage('build') {
            steps {
                // utils = load "${pwd()}/utils.groovy"

                // utils.notify("build")

                sh 'node --version'

                // utils.notify("finish")

                // curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage -d chat_id=${CHAT_ID}

                curl -X POST -H 'Content-Type: application/json' https://api.telegram.org/bot${TG_BOT_TOKEN}/sendMessage -d '{\"chat_id\": \"${TG_CHAT_ID}\", \"text\": \"test\"}'
            }
        }
    }
}
