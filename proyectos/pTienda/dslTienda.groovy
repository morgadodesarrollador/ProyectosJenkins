// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea hija que despliegue el propyecto Tienda')



    scm {
        git('https://github.com/morgadodesarrollador/jenkinsPTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('morgadodesarrollador')
                node / gitConfigEmail('morgadodesarrollador@gmail.com')
        }
    }
    triggers {
        githubPush()
    }
    
    steps {
        shell("bash install.sh")
    }
}