def call() {

pipeline {
    agent any
    
    parameters {
        string(name: 'TRIGGER_JOB', defaultValue: 'no', description: 'Trigger downstream job? (yes/no)')
    }

    stages {
        stage('Trigger Downstream Job') {
            when {
                expression {
                    params.TRIGGER_JOB == 'yes'
                }
            }
            steps {
                script {
                    // Trigger downstream job with parameters and descriptions
                    def downstreamParams = [
                        [$class: 'StringParameterValue', name: 'PARAMETER_NAME', value: 'PARAMETER_VALUE', description: 'Description for PARAMETER_NAME']
                        // Add more parameters with descriptions if needed for the downstream job
                    ]
                    build job: 'Downstream_Job_Name', parameters: downstreamParams
                }
            }
        }
        // Add more stages for the upstream job if needed
    }
}

}