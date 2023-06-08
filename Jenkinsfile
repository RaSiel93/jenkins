def utils

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
                utils = load "${pwd()}/utils.groovy"

                utils.notify("build")

                sh 'node --version'

                utils.notify("finish")
            }
        }
    }
}
