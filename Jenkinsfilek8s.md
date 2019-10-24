**Jenkinsfilek8s:**
This file defines the CI pipeline.
Lets look into the contents of the Jenkinsfilek8s,

     'agent {
		kubernetes {
			label 'example-ant-java-build'
			defaultContainer 'citd-node-ant-jdk'
            yamlFile 'cloudprovider.yml'
        }
    }'
The agent section specifies where the entire Pipeline, or a specific stage, will execute in the Jenkins environment depending 
on where the agent section is placed. The section must be defined at the top-level inside the pipeline block, but stage-level 
usage is optional.Give a name to the node/agent using the label , name the docker container to be used ,
this container should have all the required softwares installed and then provide the name of the .yml file.
This yamlFile contains the information about the docker image, mainly name of the docker image and the path/link to the docker image.
	
    'stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
				execAnt("clean build")
            }
        }
		
    }'
	
The above lines defines the pipeline stages. Users needs to add the pipelines stages required for their projects.
Above lines defines 2 pipe line stages,
1)Checkout
2)Build

The checkout step will checkout code from source control. scm is a special variable which instructs the checkout step 
to clone the specific revision which triggered this Pipeline run.
	
For many projects the beginning of "work" in the Pipeline would be the "build" stage. Typically this stage of the Pipeline 
will be where source code is assembled, compiled, or packaged. The Jenkinsfile is not a replacement for an existing build 
tool such as GNU/Make, Maven, Gradle, etc, but rather can be viewed as a glue layer to bind the multiple phases of a project’s 
development lifecycle (build, test, deploy, etc) together.

In the above example ANT clean build command is executed to build our example java project.
	
	'post {
		success{
            mail to: "${env.GIT_COMMIT_EMAIL}, jayachandran.dharuman@microchip.com, Harish.Agari@microchip.com",
                subject: "Successful Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is right with ${env.BUILD_URL}"

        }
        failure {
            mail    to: "${env.GIT_COMMIT_EMAIL}, jayachandran.dharuman@microchip.com, Harish.Agari@microchip.com",
                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Pipeline failure. ${env.BUILD_URL}"
        }
    }'
	
The post section defines one or more additional steps that are run upon the completion of a Pipeline’s or stage’s run 
(depending on the location of the post section within the Pipeline).post can support any of of the following post-condition 
blocks: always, changed, fixed, regression, aborted, failure, success, unstable, unsuccessful, and cleanup. 
In our example we have used only 2 post condition blocks success and failure. In both cases it sends out a mail to the mentioned mail IDs.
In case of success it sends out a mail saying "Something is right with link to the Jenkins build result" and in case of failure it sends out a mail
saying "Something is wrong with the build".

Once user has his project setup and all the CI related files are in users projects root directory , now project is ready to be moved to the Bitbucket repository.
Create a Bitbucket repository for your project and move your project to the repository using a pull request.
As the user push the code to the repository , if everything is set properly , Jenkins will trigger the build , performs all the pipeline stages and user should get an email after all the pipeline stages are completed.


