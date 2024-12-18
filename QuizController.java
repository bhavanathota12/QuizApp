

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuizSession(@RequestBody User user) {
        QuizSession quizSession = quizService.startNewSession(user);
        return ResponseEntity.ok(quizSession);
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion(@RequestParam Long sessionId) {
        Question question = quizService.getRandomQuestion(sessionId);
        return ResponseEntity.ok(question);
    }

    @PostMapping("/answer")
    public ResponseEntity<AnswerResponse> submitAnswer(@RequestBody AnswerRequest answerRequest) {
        AnswerResponse answerResponse = quizService.submitAnswer(answerRequest);
        return ResponseEntity.ok(answerResponse);
    }

    @GetMapping("/results")
    public ResponseEntity<QuizResults> getQuizResults(@RequestParam Long sessionId) {
        QuizResults quizResults = quizService.getQuizResults(sessionId);
        return ResponseEntity.ok(quizResults);
    }
}

