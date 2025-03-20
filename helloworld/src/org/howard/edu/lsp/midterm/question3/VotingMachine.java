package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

public class VotingMachine {
    // Map to store candidates and their vote counts
    private Map<String, Integer> candidates;

    // Constructor
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting machine.
     *
     * @param candidateName The name of the candidate to add.
     */
    public void addCandidate(String candidateName) {
        if (!candidates.containsKey(candidateName)) {
            candidates.put(candidateName, 0); // Initialize vote count to 0
        }
    }

    /**
     * Casts a vote for a candidate.
     *
     * @param candidateName The name of the candidate to vote for.
     * @return true if the vote was successfully cast, false if the candidate does not exist.
     */
    public boolean castVote(String candidateName) {
        if (candidates.containsKey(candidateName)) {
            candidates.put(candidateName, candidates.get(candidateName) + 1); // Increment vote count
            return true;
        } else {
            return false; // Candidate does not exist
        }
    }

    /**
     * Determines the winner of the election.
     *
     * @return A string indicating the winner and their vote count.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        // Find the candidate with the most votes
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        if (winner != null) {
            return winner + " WINS with " + maxVotes + " votes!!";
        } else {
            return "No votes cast yet.";
        }
    }
}