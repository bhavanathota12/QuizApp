

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private List<String> options;
    private String correctOption;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for questionText
    public String getQuestionText() {
        return questionText;
    }

    // Setter for questionText
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // Getter for options
    public List<String> getOptions() {
        return options;
    }

    // Setter for options
    public void setOptions(List<String> options) {
        this.options = options;
    }

    // Getter for correctOption
    public String getCorrectOption() {
        return correctOption;
    }

    // Setter for correctOption
    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}

