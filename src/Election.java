import java.util.*;
public class Election {
    private Map<String, Integer> votes;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;

    public Election() {
        votes = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    }

    public void initializeCandidates(List<String> candidates) {
        for(String c: candidates){
            votes.put(c, 0);
        }
    }

    public void castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
            updateHeap();
        } else {
            System.out.println("Candidate not found");
        }
    }

    public void castRandomVote(String c){
        Random r = new Random();
        List<String> candidates = new ArrayList<> (votes.keySet());
        String can = candidates.get(r.nextInt(candidates.size()));
        castVote(can);
    }

    public void rigElection(String candidate) {
        int remainingVotes = maxHeap.size();
        for(String c: votes.keySet()){
            votes.put(c, 0);
        }
        for (int i = 0; i < remainingVotes; i++) {
            castVote(candidate);
        }
    }

    public List<String> getTopKCandidates(int k) {
        List<String> topCandidates = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> tempHeap = new PriorityQueue<>(maxHeap);
        for (int i = 0; i < k && !tempHeap.isEmpty(); i++) {
            topCandidates.add(tempHeap.poll().getKey());
        }
        return topCandidates;
    }

    public void auditElection() {
        for (Map.Entry<String, Integer> entry : maxHeap) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void updateHeap() {
        maxHeap.clear();
        maxHeap.addAll(votes.entrySet());
    }

}
