@Service
public class QuizService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public QuizSession startNewSession(User user) {
        QuizSession quizSession = new QuizSession();
        quizSession.setUser(user);
        quizSession.setStartTime(LocalDateTime.now());
        return quizSessionRepository.save(quizSession);
    }

    public Question getRandomQuestion(Long sessionId) {
        List<Question> questions = questionRepository.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public AnswerResponse submitAnswer(AnswerRequest answerRequest) {
        Answer answer = new Answer();
        answer.setSessionId(answerRequest.getSessionId());
        answer.setQuestionId(answerRequest.getQuestionId());
        answer.setSelectedOption(answerRequest.getSelectedOption());
        answer.setCorrect(isCorrectAnswer(answerRequest));
        answerRepository.save(answer);

        AnswerResponse answerResponse = new AnswerResponse();
        answerResponse.setCorrect(answer.isCorrect());
        return answerResponse;
    }

    public QuizResults getQuizResults(Long sessionId) {
        List<Answer> answers = answerRepository.findBySessionId(sessionId);
        long correctCount = answers.stream().filter(Answer::isCorrect).count();
        long incorrectCount = answers.size() - correctCount;

        QuizResults quizResults = new QuizResults();
        quizResults.setTotalQuestions(answers.size());
        quizResults.setCorrectAnswers(correctCount);
        quizResults.setIncorrectAnswers(incorrectCount);
        quizResults.setAnswers(answers);
        return quizResults;
    }

    private boolean isCorrectAnswer(AnswerRequest answerRequest) {
        Question question = questionRepository.findById(answerRequest.getQuestionId()).orElseThrow();
        return question.getCorrectOption().equals(answerRequest.getSelectedOption());
    }
}

