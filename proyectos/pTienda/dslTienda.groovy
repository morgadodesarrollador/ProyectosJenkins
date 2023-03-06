// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda del Corte Ingles')
    scm {
        git('https://github.com/morgadodesarrollador/jenkinsPTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('morgadodesarrollador')
                node / gitConfigEmail('morgadodesarrollador@gmail.com')
        }
    }
    triggers {
      //  scm('H/5 * * * *')
        githubPush()
    }
    
    steps {
        shell("bash parar.sh;  bash levantar.sh")
    }
}