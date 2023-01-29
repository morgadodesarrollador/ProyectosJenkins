// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda')



    scm {
        git('https://github.com/morgadodesarrollador/jenkinsPTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('morgadodesarrollador')
                node / gitConfigEmail('morgadodesarrollador@gmail.com')
        }
    }
    triggers {
        scm('H/2 * * * *')
        githubPush()
    }
    
    steps {
        shell("bash install.sh")
    }
}