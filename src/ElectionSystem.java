import java.util.*;
public class ElectionSystem {
    private Election election;
    private int votes;

    public ElectionSystem() {
        election = new Election();
    }

    public void initialize(List<String> candidates, int p) {
        election.initializeCandidates(candidates);
        votes = p;
    }

    public void castVote(String c) {
        election.castVote(c);
        election.updateHeap();
    }

    public void rigElection(String c) {
        election.rigElection(c);
        election.updateHeap();
    }

    public List<String> getTopKCandidates(int k) {
        return election.getTopKCandidates(k);
    }

    public void auditElection() {
        election.auditElection();
    }
}
