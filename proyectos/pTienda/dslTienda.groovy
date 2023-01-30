// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda PC Componentes')



    scm {
        git('https://github.com/morgadodesarrollador/jenkinsPTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('morgadodesarrollador')
                node / gitConfigEmail('morgadodesarrollador@gmail.com')
        }
    }
    triggers {
     //   scm('H/5 * * * *')
        githubPush()
    }
    
    steps {
        shell("bash install.sh")
    }
}