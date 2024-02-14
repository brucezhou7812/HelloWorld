def buildApp(){
  echo 'building application'
}

def testApp(){
  echo 'testing application'
  echo "the version name is ${params.VERSIONNAME}"
  echo "the version is ${params.VERSION}"
}

def alwaysSection(){
  echo 'pipeline finished'
}
