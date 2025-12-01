package cs4370.hciinsights.models;

import java.time.LocalDateTime;

public class Session {

    private int sessionId;
    private int participantId;
    private int studyId;
    private LocalDateTime scheduled;
    private String notes;
    private Integer score;

    public Session(int sessionId, int participantId, int studyId,
                   LocalDateTime scheduled, String notes, Integer score) {
        this.sessionId = sessionId;
        this.participantId = participantId;
        this.studyId = studyId;
        this.scheduled = scheduled;
        this.notes = notes;
        this.score = score;
    }

    public int getSessionId() { 
        return sessionId; 
    }
   
    public int getParticipantId() { 
        return participantId; 
    }
    
    public int getStudyId() { 
        return studyId; 
    }
    
    public LocalDateTime getScheduled() { 
        return scheduled; 
    }
    
    public String getNotes() { 
        return notes; 
    }
    
    public Integer getScore() { 
        return score; 
    }
}
