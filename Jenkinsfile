pipeline{
  agent any
  stages{
    stage("build"){
      steps{
        echo 'building the application'
        nodejs('NodeJS-21.1.0'){
          sh 'yarn install'
        }
      }
    }
    stage("test"){
      steps{
        echo 'testing the application'
        withGradle(){
          sh './gradlew -v'
        }
      }
    }
  }
  post{
    always{
      echo 'pipeline finished'
    }
    failure{
      echo 'something is wrong'
    }
}
}
