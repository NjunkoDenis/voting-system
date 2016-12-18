package by.njunko.voting.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.njunko.voting.dao.CandidateDao;
import by.njunko.voting.model.Candidate;

@RestController
public class CandidateController {

	@Autowired
	private CandidateDao candidateDao;
	
	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public Map<String, Object>  getCandidates() {

		Map<String, Object> response = new HashMap<String, Object>();

		response.put("status", "success");
		response.put("message", null);
		response.put("data", candidateDao.getAllCandidates());

		return response;
	}

	@RequestMapping(value = "/vote/{id}", method = RequestMethod.PUT)
	public ResponseEntity voteForCandidate(@PathVariable("id") Integer id) {

		if(candidateDao.updateCandidate(id)) {

			return new ResponseEntity(HttpStatus.OK);

		} else {

			return  new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
