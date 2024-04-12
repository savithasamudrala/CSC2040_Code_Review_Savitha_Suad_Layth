import java.util.*;
public class ElectionSystem {
    private Election election;
    private int votes;

    public ElectionSystem() {
        election = new Election();
    }
    public void executeElection() {
        Random random = new Random();

        int numCandidates = random.nextInt(9) + 2;

        List<String> candidates = generateRandomCandidateNames(numCandidates);

        int p = random.nextInt(91) + 10;

        initialize(candidates, p);

        simulateVotes();

        System.out.println("Top 3 candidates after initial votes: " + getTopKCandidates(3));

        String riggedCandidate = candidates.get(random.nextInt(numCandidates));
        rigElection(riggedCandidate);

        System.out.println("Top 3 candidates after rigging the election: " + getTopKCandidates(3));

        System.out.println("Audit:");
        auditElection();
    }

    private List<String> generateRandomCandidateNames(int numCandidates) {
        List<String> names = new ArrayList<>();
        String[] firstNames = {"Marcus", "Cole", "Damon", "Anya", "Dominic"};
        String[] lastNames = {"Fenix", "Train", "Baird", "Stroud", "Santiago"};
        Random random = new Random();
        String first = firstNames[random.nextInt(5)];
        String last = lastNames[random.nextInt(5)];
        for (int i = 0; i < numCandidates; i++) {
            String name = first + " " + last;
            names.add(name);
        }
        return names;
    }

    private void simulateVotes() {
        Random random = new Random();
        for (int i = 0; i <votes; i++) {
            String candidate = election.getTopKCandidates(1).get(0);
            election.castVote(candidate);
        }
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
