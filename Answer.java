@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sessionId;
    private Long questionId;
    private String selectedOption;
    private boolean isCorrect;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for sessionId
    public Long getSessionId() {
        return sessionId;
    }

    // Setter for sessionId
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    // Getter for questionId
    public Long getQuestionId() {
        return questionId;
    }

    // Setter for questionId
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    // Getter for selectedOption
    public String getSelectedOption() {
        return selectedOption;
    }

    // Setter for selectedOption
    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    // Getter for isCorrect
    public boolean isCorrect() {
        return isCorrect;
    }

    // Setter for isCorrect
    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}

