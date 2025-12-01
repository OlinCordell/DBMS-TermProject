package cs4370.hciinsights.models;

public class Result {

    private final int resultId;
    private final int sessionId;
    private final int taskId;
    private final boolean isComplete;
    private final Integer completionTime;
    private final Integer errors;
    private final String notes;

    public Result(int resultId, int sessionId, int taskId, boolean isComplete,
                  Integer completionTime, Integer errors, String notes) {
        this.resultId = resultId;
        this.sessionId = sessionId;
        this.taskId = taskId;
        this.isComplete = isComplete;
        this.completionTime = completionTime;
        this.errors = errors;
        this.notes = notes;
    }

    public int getResultId() { return resultId; }
    public int getSessionId() { return sessionId; }
    public int getTaskId() { return taskId; }
    public boolean getIsComplete() { return isComplete; }
    public Integer getCompletionTime() { return completionTime; }
    public Integer getErrors() { return errors; }
    public String getNotes() { return notes; }
}
