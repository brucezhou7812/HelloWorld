pipeline{
  agent any
  parameters{
    string(name:'VERSIONNAME',defaultValue:'the first version',description:'this is the version name')
  }
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
      when{
        expression{
          BRANCH-NAME == 'dev'
        }
      }
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
      echo "version name is ${params.VERSIONNAME}"
    }
    failure{
      echo 'something is wrong'
    }
}
}
