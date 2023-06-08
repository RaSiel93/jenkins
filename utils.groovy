def notify(msg) {
    wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: env['TG_BOT_TOKEN'], var: 'SECRET'], [password: env['TG_CHAT_ID'], var: 'SECRET']]]) {
        sh "curl -X POST -H 'Content-Type: application/json' https://api.telegram.org/bot${TG_BOT_TOKEN}/sendMessage -d '{\"chat_id\": \"${TG_CHAT_ID}\", \"text\": \"${JOB_NAME}: ${msg}\"}'"
    }
}

return this
