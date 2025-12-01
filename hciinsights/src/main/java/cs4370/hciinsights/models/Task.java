package cs4370.hciinsights.models;

public class Task {

    private final int taskId;
    private final int studyId;
    private final int taskOrder;
    private final String description;
    private final String successCriteria;
    private final int expectedCompTime;

    public Task(int taskId, int studyId, int taskOrder, String description,
                String successCriteria, int expectedCompTime) {

        this.taskId = taskId;
        this.studyId = studyId;
        this.taskOrder = taskOrder;
        this.description = description;
        this.successCriteria = successCriteria;
        this.expectedCompTime = expectedCompTime;

    }

    public int getTaskId() {
        return taskId;
    }

    public int getStudyId() {
        return studyId;
    }

    public int getTaskOrder() {
        return taskOrder;
    }

    public String getDescription() {
        return description;
    }

    public String getSuccessCriteria() {
        return successCriteria;
    }

    public int getExpectedCompTime() {
        return expectedCompTime;
    }

}