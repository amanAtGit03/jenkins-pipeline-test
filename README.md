# Jenkins Pipeline CI Project (Experiment 05)

This project demonstrates **Pipeline as Code** using Jenkins. It automates the software delivery process—from cloning code to building and testing—using a single Declarative Pipeline script.

## Project Structure
The project maintains the standard Maven directory layout used in Experiment 04:
- `src/main/java`: Application source code.
- `src/test/java`: Unit tests.
- `pom.xml`: Maven configuration for dependencies and build lifecycle.

## Steps Performed

### 1. Repository Setup
- Created a new GitHub repository named `jenkins-pipeline-test`.
- Pushed the Java source code and `pom.xml` to the `main` branch.

### 2. Jenkins Pipeline Configuration
- Created a **New Item** in Jenkins and selected the **Pipeline** project type.
- Configured the project to use a **Declarative Pipeline** script.

### 3. Pipeline Script Implementation
The following script was used to define the automation stages:
- **Agent**: Defined `agent any` to allow the script to run on any available Jenkins node.
- **Tools**: Configured the `maven` tool block to point to the global Maven installation (e.g., 'Maven 3.6').
- **Stages**:
    - **Checkout**: Clones the source code specifically from the `main` branch of the GitHub repository.
    - **Build**: Executes `mvn clean compile` using the Windows `bat` command to compile the Java code.
    - **Test**: Executes `mvn test` to run automated unit tests and verify code quality.
    - **Deploy**: Simulates an application deployment by echoing a status message to the console.
```groovy
pipeline {
    agent any
    
    tools {
        // This name must match your Jenkins Global Tool Configuration
        maven 'mvn-3.9' 
    }

    stages {
        stage('Checkout') { 
            steps {
                // Specifically pulling from the 'main' branch
                git branch: 'main', url: 'https://github.com/amanAtGit03/jenkins-pipeline-test.git' 
            }
        }
        
        stage('Build') {
            steps {
                // Compiles the code and clears old artifacts
                bat 'mvn clean compile' 
            }
        }

        stage('Test') {
            steps {
                // Runs the JUnit tests defined in AppTest.java
                bat 'mvn test' 
            }
        }

        stage('Deploy') {
            steps {
                // Simulates a deployment step
                echo 'Deploying application to the server...'
            }
        }
    }
}
```

### 4. Execution & Verification
- Manually triggered the build using the **Build Now** button.
- Verified the progress through the **Stage View** visualization, ensuring all stages turned green.
- Checked the **Console Output** to confirm that the Maven lifecycle (clean, compile, and test) completed with a `SUCCESS` status.

## Experiment Goals Achieved
- [x] Defined software delivery process as code using a Jenkinsfile/Pipeline script.
- [x] Integrated Maven build lifecycle within a Pipeline.
- [x] Successfully automated the "Checkout -> Build -> Test -> Deploy" workflow.

---
*Created as part of the SEPM Experiment 05 lab.*
