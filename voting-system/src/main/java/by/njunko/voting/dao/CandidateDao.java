package by.njunko.voting.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.njunko.voting.db.DBWorker;
import by.njunko.voting.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class CandidateDao {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public Candidate getById(Integer id) {

		String query = "select * from db.candidates";

		return null;
	}

	public List<Candidate> getAllCandidates() {

		connection = new DBWorker().getConnection();

		List<Candidate> candidates = new ArrayList<Candidate>();

		String query = "select * from db.candidates";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()){

				Integer id = resultSet.getInt("id");
				String fullName = resultSet.getString("fullName");

				candidates.add(new Candidate(id, fullName));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				resultSet.close();
				statement.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return candidates;
	}

	public Boolean updateCandidate(Integer id){

		connection = new DBWorker().getConnection();



		String query = "update db.candidates set counterVotes = counterVotes + 1 where id = " + id;

		try {
			statement = connection.createStatement();

			statement.execute(query);

		} catch (SQLException e) {

			return false;

		} finally {

			try {

				statement.close();
				connection.close();

			} catch (SQLException e) {

				return false;
			}
		}

		return true;
	}
}
