owner = "sredhu37"
repo = "ci-task"
commitHash = ""

def setGHStatusCheck(String checkName, String status, String description="No description available") {
    httpRequest (
        acceptType: 'APPLICATION_JSON',
        consoleLogResponseBody: true,
        authentication: 'sunny-github-credentials',
        contentType: 'APPLICATION_JSON',
        httpMode: 'POST',
        requestBody: """{
            "context": "${checkName}",
            "state": "${status}",
            "target_url": "${env.BUILD_URL}",
            "description": "${description}"
        }""",
        responseHandle: 'NONE',
        timeout: 10,
        url: "https://api.github.com/repos/${owner}/${repo}/statuses/${commitHash}"
    )
}

def stageWithGHStatusCheck(String stageName, Closure closureFunction) {
    String stageStatus = 'pending'

    try {
        stage(stageName) {
            setGHStatusCheck(stageName, stageStatus, "Execution has started...")
            closureFunction()
        }
        stageStatus = 'success'
    } catch(exc) {
        stageStatus = 'failure'
        currentBuild.result = 'FAILURE'
    } finally {
        setGHStatusCheck(stageName, stageStatus)
    }
}

return this