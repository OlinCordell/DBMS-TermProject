package cs4370.hciinsights.models;

public class Subtask {

    private final int subtaskId;
    private final int taskId;
    private final String description;
    private final int expectedCompTime;

    public Subtask(int subtaskId, int taskId, String description, Integer expectedCompTime) {
        this.subtaskId = subtaskId;
        this.taskId = taskId;
        this.description = description;
        this.expectedCompTime = expectedCompTime;
    }

    public int getSubtaskId() {
        return subtaskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getExpectedCompTime() {
        return expectedCompTime;
    }

}