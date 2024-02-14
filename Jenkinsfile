pipeline{
  agent any
  parameters{
    string(name:'VERSIONNAME',defaultValue:'the first version',description:'this is the version name')
    choice(name:'VERSION',choices:['1.1.0','1.2.0','1.3.0'],description:'version')
    booleanParam(name:'executeTest',defaultValue:true,description:'set testing execution')
  }
  stages{
    stage("init"){
      script{
        gv = load "script.groovy"
      }
    }
    stage("build"){
      steps{
        script{
          gv.buildApp();
        }
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
        script{
          gv.testApp();
        }
        withGradle(){
          sh './gradlew -v'
        }
      }
    }
  }
  post{
    always{
      script{
        gv.alwaysSection();
      }
    }
    failure{
      echo 'something is wrong'
    }
}
}
