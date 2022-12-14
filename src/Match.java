public class Match {
    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", season='" + season + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", tossWinner='" + tossWinner + '\'' +
                ", tossDecision='" + tossDecision + '\'' +
                ", result='" + result + '\'' +
                ", dlApplied='" + dlApplied + '\'' +
                ", winByRuns='" + winByRuns + '\'' +
                ", winByWickets='" + winByWickets + '\'' +
                ", playerOfTheMatch='" + playerOfTheMatch + '\'' +
                ", venue='" + venue + '\'' +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                ", umpire3='" + umpire3 + '\'' +
                '}';
    }

    private String id;
    private String season;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String dlApplied;
    private String winner;
    private String winByRuns;
    private String winByWickets;
    private String playerOfTheMatch;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDlApplied() {
        return dlApplied;
    }

    public void setDlApplied(String dlApplied) {
        this.dlApplied = dlApplied;
    }

    public String getWinByRuns() {
        return winByRuns;
    }

    public void setWinByRuns(String winByRuns) {
        this.winByRuns = winByRuns;
    }

    public String getWinByWickets() {
        return winByWickets;
    }

    public void setWinByWickets(String winByWickets) {
        this.winByWickets = winByWickets;
    }

    public String getPlayerOfTheMatch() {
        return playerOfTheMatch;
    }

    public void setPlayerOfTheMatch(String playerOfTheMatch) {
        this.playerOfTheMatch = playerOfTheMatch;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    public String getUmpire3() {
        return umpire3;
    }

    public void setUmpire3(String umpire3) {
        this.umpire3 = umpire3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
