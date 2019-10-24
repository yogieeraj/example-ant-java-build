# Java Project - Continuous Integration - Java Project Build
This example shows how to setup a continuous integration 'Build' pipeline for pure Java(ANT Based) Projects

## Creating an ANT Based Java Project:
**Prerequisites:**  
1) Make sure Netbeans IDE is installed  
2) Make sure Java JDK is installed  

***Note***: Versions of the tools to be used are not mentioned here since its up to the project teams to decide on the versions to be used.

**Creating an ANT based Java Project**  
1) Open the Netbeans IDE  
2) Go to File->New Project -> Java ->Java Class Library , click Next  
3) Select the location where you want to save the project and provide a name to your project  
4) Click on finish , this will create your project  
5) A file called build.xml will be created in the project root directory.   
6) Users need to add the required targets for clean and build in the build.xml as required by their project.   

Make sure your project builds properly and required artifacts are getting created.

|*Reference*  |
|:---|
|*For more information on how to use the ANT build system please refer the following https://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html, https://www.tutorialspoint.com/ant/index.htm , http://tutorials.jenkov.com/ant/ant-tutorial.html*|

## Procedure: Setting up Continuous Integration using Jenkins for a Bitbucket repository

### This document uses jargon vocabulary. For details, please refer to: [Integrating with Jenkins - Theory](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-theory)

### There is a set of prerequisites required before you proceed with the setup:
1. [Jenkins Project Linkage and Configuration](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-linkage) - **Needed only ONCE per Bitbucket project**
2. [Automatic Build Trigger from Bitbucket using Web-hooks](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-trigger)
3. [Creating a Docker Image](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-docker)

***Note***: Skip this step if you know that the linkage to the new Jenkins instance already exists.

*In the corporate DevOps Jenkins system, before you can run continuous builds on Jenkins, you need a corresponding Jenkins project created for your Bitbucket **Project**. If you do not know that it exists, please consult your project manager or supervisor. If it does exist, you can disregard this step. If it does not exist, the Bitbucket project admin needs to submit a job creation request to devops-help@microchip.com ([Confluence: Global DevOps](https://confluence.microchip.com/display/MSDTC/Request+Bitbucket+Build+Job+Setup+for+your+Bitbucket+Project)). Please point to the Bitbucket **project** and not to an individual repository in the email.*

### After setting up the above prerequisites, follow the steps below:

1. Copy the cloudprovider.yml file from the existing example repository into your bitbucket repository. Make sure you place the .yml file at the root of your repository.
    - Point the file to the correct Docker image location by amending the 'image' attribute.
        - You could get access to the partial location of your docker image by clicking on the desired version of the tool in artifactory and then observing the **Repository Path** field on the right tabbed window.
        - **Please ignore the "docker/" substring while using this location in the .yml file**
            - For example: Clicking on node-ant-jdk in the artifactory docker repository will yield in "docker/microchip/citd/bundles/node-ant-jdk/" as the repository path. Remove the "docker/" substring and use the path as "artifacts.microchip.com:7999/**ocker/microchip/citd/bundles/node-ant-jdk"
	- Change the 'name' attribute, under the 'metadata' and the 'containers' element, to a string of your choice. 
2. Copy the Jenkinsfilek8s from the existing example's repository into your bitbucket repository. Make sure you place the Jenkinsfilek8s at the root of your repository(Directory where your projects build script resides).
    - Update the label under kubernetes to reflect your project name (.X, java etc.). Updating the label with your project name is just a recommendation. It can consume any arbitrary value. 
    - Update the 'defaultContainer' attribute under kubernetes to match the 'name' attribute under the 'containers' element of the cloudprovider.yml file.
	- You may configure your default notification reviewers by amending the NOTIFICATION_EMAIL parameter for the success and failure conditions.
    - Scroll down to the 'Build'.
        - Here users have to specify the command to build their project depending on the build script they are using for their Java project
    - Scroll down to the 'post' stage:
	    - Here users can configure the mailing list and email messages to be sent after the successful or failed builds. 
        - If required , at the 'archiveArtifacts' declarative, you may archive required artifacts by adding a comma separated entry inside the double quotes.
            - For e.g. `archiveArtifacts artifacts: "example-ant-java-build/output/**, some-other-artifact", fingerprint: true`
            - 'archiveArtifacts' is not used in this particular example
3. At this point, make a dummy commit to the develop branch which should trigger a build and send you an email notifying the build result. If you receive the email successfully, CI is setup. If you do not, contact gaurang.gunde@microchip.com for assistance.

## Running this specific example project

### To run the build locally:
Setup the runtime environment manually (IDE, Compilers) along with environment variables
1. Using Netbeans IDE:
    1. Clean and Build
    2. Check the output console for the build result
2. Using command-line:
    1. Change directory to the root project folder where build.xml is located
    `cd ./example-ant-java-build`
    2. Execute the ant clean build command
    `ant clean build`
	
	Prerequisite for command line build
	1) Download and extract the Apache ant 
	2) Extract the zip file to a folder
	3) Add the ant bin folder path to the system path
	4) Make sure JAVA_HOME path variable is set to the JDK folder

### To run the build remotely:
The runtime environment is setup using a DockerFile. The docker image is available for use at [Artifactory](https://artifacts.microchip.com:7999)
1. Using JenkinsFile and .yml - The example JenkinsFile has three stages.
    The build is spawned on a Jenkins agent using the Kubernetes cluster (Linux nodes only)
    1. stage('Checkout') - Checkout your repository under test
    2. stage('Build') - Compile your Java project
    3. stage('Post') - Mail the build job link

    You could use this example JenkinsFile and .yml file for reference and use them in your project repository

**References:**  
- - -
**Continuous Integration - Testing and Deployment Strategy:** [Confluence: CITD](https://confluence.microchip.com/display/SOLUTIONS/Continuous+Integration+-+Testing+and+Deployment+Strategy)  
**Jenkins File Details:** [Jenkins File](./Jenkinsfilek8s.md)  
**Integrating with Jenkins - Theory:** [Element of Continuous Integration Theory](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-theory)  
**Information on Docker image:** [Creating a docker image](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-docker)  
**Automatic Build Trigger:** [Automatic Build Trigger from Bitbucket using Web-hooks](https://confluence.microchip.com/display/MSDTC/Automatically+Triggering+Build+Jobs)  
**Jenkins Project Linkage and Configuration:** [Jenkins Project Linkage and Configuration](https://confluence.microchip.com/display/SOLUTIONS/Integration+with+Jenkins+Remote+-+Theory+and+Prerequisites#IntegrationwithJenkinsRemote-TheoryandPrerequisites-linkage)  
- - -