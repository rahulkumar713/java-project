package com.online;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserInputService {

	@Autowired
	private QuestionRepo repo;
	@Autowired
	private QuizRepo quizRepo;

	@SuppressWarnings("deprecation")
	public int calculateScore(UserResponse submittedResponse) throws Exception {

		List<Response> submittedAns = submittedResponse.getRes();
		int score = 0;
		int quizId = submittedResponse.getId();
		Quiz currentQuiz = quizRepo.getById(quizId);
		List<QuestionEntity> validQuestionList = currentQuiz.getListques();

		Set<Integer> validQuestionIdList = validQuestionList.stream().map(ele -> ele.getId())
				.collect(Collectors.toSet());
		
		
       // System.out.println(validQuestionIdList);
		for (Response currentQuestion : submittedAns) {
			
			//System.out.println(validQuestionIdList.contains(currentQuestion.getId()));
			
			if (validQuestionIdList.contains(currentQuestion.getId())) {
				String correctAns = repo.getById(currentQuestion.getId()).getAnswer();

				if (correctAns.equalsIgnoreCase(currentQuestion.getResp())) {
					score++;
				}
			} else {
				throw new Exception("Question Id mismatch for this Quiz");
			}
		}
		return score;
	}

}
