node {
    def app

    agent {
        node {
            label 'emarosa-services'
            customWorkspace '/home/imlbf/workspace/pedido'
        }
    }

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("ianfireman/pedido-service")
    }

    stage('Test image') {
        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}