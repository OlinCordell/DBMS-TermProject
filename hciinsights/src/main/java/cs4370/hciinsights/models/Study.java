package cs4370.hciinsights.models;

/**
 * Represents a study of the HCI Insights platform
 */
public class Study {
    
    /**
     * Unique identifier for the study.
     */
    private final int studyId;

    /**
     * Unique identifier for user who created the study.
     */
    private final int userId;

    /**
     * Title of the study.
     */
    private final String title;

    /**
     * Description of the study.
     */
    private final String description;

    /**
     * Platform of which the study occured on.
     */
    private final String platform;

    /**
     * Status of the study.
     */
    private final Status status;

    /**
     * Date when the study was created.
     */
    private final String created_at;

    /**
     * Constructs a study with the specified details.
     * 
     * @param studyId
     * @param userId
     * @param title
     * @param description
     * @param platform
     * @param status
     * @param created_at
     */
    public Study(int studyId, int userId, String title, String description, String platform, Status status, String created_at) {
        this.studyId = studyId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.platform = platform;
        this.status = status;
        this.created_at = created_at;
    }

    public int getStudyId() {
        return studyId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPlatform() {
        return platform;
    }

    public Status getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return created_at;
    }
}