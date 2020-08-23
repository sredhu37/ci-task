def setGHStatusCheck(String checkName, String status, String description="No description available") {

}

def stageWithGHStatusCheck(String stageName, Closure closureFunction) {
    String stageStatus = 'PENDING'

    try {
        stage(stageName) {
            setGHStatusCheck(stageName, stageStatus, "Execution has started...")
            closureFunction()
        }
        stageStatus = 'SUCCESS'
    } catch(exc) {
        stageStatus = 'FAILURE'
    } finally {
        setGHStatusCheck(stageName, stageStatus)
    }
}

return this