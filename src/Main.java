import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static final int DELIVERY_MATCH_ID = 0;
    public static final int DELIVERY_INNING = 1;
    public static final int DELIVERY_BATTING_TEAM = 2;
    public static final int DELIVERY_BOWLING_TEAM = 3;
    public static final int DELIVERY_OVER = 4;
    public static final int DELIVERY_BALL = 5;
    public static final int DELIVERY_BATSMAN = 6;
    public static final int DELIVERY_NON_STRIKER = 7;
    public static final int DELIVERY_BOWLER = 8;
    public static final int DELIVERY_IS_SUPER_OVER = 9;
    public static final int DELIVERY_WIDE_RUNS = 10;
    public static final int DELIVERY_BYE_RUNS = 11;
    public static final int DELIVERY_LEG_BYE_RUNS = 12;
    public static final int DELIVERY_NO_BALL_RUNS = 13;
    public static final int DELIVERY_PENALTY_RUNS = 14;
    public static final int DELIVERY_BATSMAN_RUNS = 15;
    public static final int DELIVERY_EXTRA_RUNS = 16;
    public static final int DELIVERY_TOTAL_RUNS = 17;
    public static final int DELIVERY_PLAYER_DISMISSED = 18;
    public static final int DELIVERY_DISMISSAL_KIND = 19;
    public static final int DELIVERY_FIELDER = 20;
    List<Match> readMatchData(String filePath) {
        List<Match> matches = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(filePath));
            while (buffReader.ready()) {
                List<String> singleLineData = new ArrayList<>(Arrays.asList(buffReader.readLine().split(",")));
                Match match = new Match();
                match.setId(singleLineData.get(0));
                match.setSeason(singleLineData.get(1));
                match.setCity(singleLineData.get(2));
                match.setDate(singleLineData.get(3));
                match.setTeam1(singleLineData.get(4));
                match.setTeam2(singleLineData.get(5));
                match.setTossWinner(singleLineData.get(4));
                match.setTossDecision(singleLineData.get(5));
                match.setResult(singleLineData.get(8));
                match.setWinner(singleLineData.get(10));
                match.setDlApplied(singleLineData.get(7));
                match.setWinByRuns(singleLineData.get(8));
                match.setWinByWickets(singleLineData.get(9));
                match.setPlayerOfTheMatch(singleLineData.get(10));
                match.setVenue(singleLineData.get(11));
                match.setUmpire1(singleLineData.get(12));
                match.setUmpire2(singleLineData.get(13));
                match.setUmpire3(singleLineData.get(14));
                matches.add(match);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        matches.remove(0);
        return matches;
    }

    List<Delivery> readDeliveryData(String filePath) {
        List<Delivery> deliveries = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(filePath));
            //skip first line
            buffReader.readLine();

            while (buffReader.ready()) {
                List<String> singleLineData = new ArrayList<>(Arrays.asList(buffReader.readLine().split(",")));
                Delivery delivery = new Delivery();
                delivery.setBattingTeam((singleLineData.get(2)));
                delivery.setBowlingTeam(singleLineData.get(3));
                delivery.setBatsMan(singleLineData.get(6));
                delivery.setNonStriker(singleLineData.get(7));
                delivery.setBowler(singleLineData.get(8));
                try {
                    delivery.setDismissalKind(singleLineData.get(19));
                    delivery.setPlayerDismissed(singleLineData.get(18));
                    delivery.setFielder(singleLineData.get(20));
                }catch ( IndexOutOfBoundsException e){

                }
                try {
                    Integer ball=Integer.parseInt(singleLineData.get(5));

                    delivery.setBall(ball);
                    //System.out.println(ball);

                    Integer matchId = Integer.parseInt(singleLineData.get(0));
                    delivery.setMatchId(matchId);
                    Integer inning = Integer.parseInt(singleLineData.get(1));
                    delivery.setInning(inning);
                    Integer over = Integer.parseInt(singleLineData.get(4));
                    delivery.setOver(over);
                    Boolean isSuperOver = Boolean.parseBoolean(singleLineData.get(8));
                    delivery.setSuperOver(isSuperOver);
                    Integer wideRuns = Integer.parseInt(singleLineData.get(10));
                    delivery.setWideRuns(wideRuns);
                    Integer byeRuns = Integer.parseInt(singleLineData.get(11));
                    delivery.setByeRuns(byeRuns);
                    Integer legByeRuns = Integer.parseInt(singleLineData.get(12));
                    delivery.setLegByeRuns(legByeRuns);
                    Integer noBallRuns = Integer.parseInt(singleLineData.get(13));
                    delivery.setNoBallRuns(noBallRuns);
                    Integer penaltyRuns = Integer.parseInt(singleLineData.get(14));
                    delivery.setPenaltyRuns(penaltyRuns);
                    Integer batsmanRuns = Integer.parseInt(singleLineData.get(15));
                    delivery.setBatsmanRuns(batsmanRuns);
                    Integer extraRuns = Integer.parseInt(singleLineData.get(16));
                    delivery.setExtraRuns(extraRuns);
                    Integer totalRuns = Integer.parseInt(singleLineData.get(17));
                    delivery.setTotalRuns(totalRuns);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                deliveries.add(delivery);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        deliveries.remove(0);
        return deliveries;
    }

    String getNumberOfMatchesPlayedPerYear() {
        List<Match> matchData = new Main().readMatchData("../ipl/matches.csv");
        Hashtable<String, Integer> mapOfMatch = new Hashtable<>();
        for (Match m : matchData) {
            if (mapOfMatch.containsKey(m.getSeason())) {
                Integer value = mapOfMatch.get(m.getSeason());
                mapOfMatch.put(m.getSeason(), value + 1);
            } else {
                mapOfMatch.put(m.getSeason(), 1);
            }


        }
        return mapOfMatch.toString();
    }

    String totalNumberOfMatchesWon() {
        Hashtable<String, Integer> mapOfData = new Hashtable<>();
        List<Match> matchData = new Main().readMatchData("../ipl/matches.csv");
        for (Match m : matchData) {
            // System.out.println(m.getResult());
            if (m.getResult().equals("normal")) {
                if (mapOfData.containsKey(m.getWinner())) {
                    Integer value = mapOfData.get(m.getWinner());
                    mapOfData.put(m.getWinner(), value + 1);
                } else {
                    mapOfData.put(m.getWinner(), 1);
                }
            }
        }

        return mapOfData.toString();
    }

    String getExtraRunConcededPerTeamIn2016() {
        Hashtable<String, String> mapOfMatch = new Hashtable<>();
        Hashtable<String, Integer> mapOfDelivery = new Hashtable<>();
        List<Match> matchData = new Main().readMatchData("../ipl/matches.csv");
        List<Delivery> deliveryData = new Main().readDeliveryData("../ipl/deliveries.csv");
        for (Match m : matchData) {
            if (m.getSeason().equals("2016")) {
                mapOfMatch.put(m.getId(), m.getSeason());
            }
        }
            String matchId = "";
            for (Delivery d : deliveryData) {
                try {
                    matchId = d.getMatchId().toString();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (mapOfMatch.get(matchId) == null) {
                    continue;
                }
                if (mapOfDelivery.containsKey(d.getBowlingTeam())) {
                    Integer runsToAdd = mapOfDelivery.get(d.getBowlingTeam());
                    mapOfDelivery.put(d.getBowlingTeam(), runsToAdd + d.getExtraRuns());
                } else {
                    mapOfDelivery.put(d.getBowlingTeam(), d.getExtraRuns());

                }
            }
        return mapOfDelivery.toString();
    }
    String getMostEconomicalBowlerIn2015(){
     Hashtable<String,Integer>runsGivenByBalller=new Hashtable<>();
     Hashtable<String,Integer>ballsBowledByBaller=new Hashtable<>();
     List<Match>matchData=new Main().readMatchData("../ipl/matches.csv");
     List<Delivery>deliveryData=new Main().readDeliveryData("../ipl/deliveries.csv");
     Hashtable<String,Integer>isAvailable=new Hashtable<>();
        for (Match m : matchData) {
            if (m.getSeason().equals("2015")) {
                try {
                    Integer season=Integer.parseInt(m.getSeason());
                    isAvailable.put(m.getId(),season );
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        for (Delivery d : deliveryData) {
             if(isAvailable.get(d.getMatchId().toString())!=null){

                 Integer ballsToAdd=0;
                 if(d.getWideRuns()+d.getNoBallRuns()==0){
                     ballsToAdd=1;
                 }
                 if(ballsBowledByBaller.containsKey(d.getBowler())){
                     Integer ballsTillNow=ballsBowledByBaller.get(d.getBowler());
                     ballsBowledByBaller.put(d.getBowler(),ballsToAdd+ballsTillNow);
                 }else {
                     ballsBowledByBaller.put(d.getBowler(),ballsToAdd);
                 }
                 Integer totalRuns=d.getBatsmanRuns()+d.getWideRuns()+d.getNoBallRuns();
                if( runsGivenByBalller.containsKey(d.getBowler())){
                    Integer runsTillNow=runsGivenByBalller.get(d.getBowler());
                    runsGivenByBalller.put(d.getBowler(),runsTillNow+d.getBatsmanRuns()+d.getWideRuns()+d.getNoBallRuns());
                 }else{
                    runsGivenByBalller.put(d.getBowler(),totalRuns);
                }

            }


        }
       // System.out.println(isAvailable);
        Double leastEconomy=Double.MAX_VALUE;
        Double highestEconomy=Double.MIN_VALUE;
        String economicBowlerName=null;
        String expensiveBowlerName=null;
        Double economy=0d;
        for (String bowler: runsGivenByBalller.keySet()) {
            Integer balls=ballsBowledByBaller.get(bowler);
            Integer runs=runsGivenByBalller.get(bowler);
            economy=(runs*6d/balls);
            if(economy<leastEconomy){
                economicBowlerName=bowler;
                leastEconomy=economy;
            }
            if(economy>highestEconomy){
                expensiveBowlerName=bowler;
                highestEconomy=economy;
            }

        }
        return "Least economy bowller -- "+economicBowlerName+"with the economy of "+leastEconomy;
    }
    String getMostCatchTaker(){
        Hashtable<String,Integer>mostCatches=new Hashtable<>();
        List<Delivery> deliveryData =new Main().readDeliveryData("../ipl/deliveries.csv");
        System.out.println("del data ="+deliveryData.get(10));
        for (Delivery d:deliveryData) {
            if(Objects.equals(d.getDismissalKind(), "caught")){
               // System.out.println("jbj");
               // System.out.println(d.getDismissalKind());

                try{
                    if(!mostCatches.containsKey(d.getFielder())){
                        mostCatches.put(d.getFielder(),1);
                    }else {
                        System.out.println(d.getFielder());
                        Integer value=mostCatches.get(d.getFielder());
                        mostCatches.put(d.getFielder(),value+1);
                    }

                }catch (NullPointerException e){

                }


            }
        }
        System.out.println(mostCatches);
        Integer mostNoOfCatches=Integer.MIN_VALUE;
        String  mostCatchTaker="";
        for (String fielderName : mostCatches.keySet() ) {
            if(mostCatches.get(fielderName)>mostNoOfCatches){
                mostNoOfCatches=mostCatches.get(fielderName);
                mostCatchTaker=fielderName;
            }
        }
        System.out.println(deliveryData.get(11).getDismissalKind());
        return "most number of catch by any player in overall ipl season--"+mostCatchTaker+"with "+mostNoOfCatches+" catches";
    }


        public static void main (String[] args){
            Main obj = new Main();
        System.out.println(obj.readMatchData("../ipl/matches.csv").get(0));
       System.out.println(obj.readDeliveryData("../ipl/deliveries.csv").get(1));
           System.out.println(obj.getNumberOfMatchesPlayedPerYear());
            System.out.println(obj.totalNumberOfMatchesWon());
           System.out.println(obj.getExtraRunConcededPerTeamIn2016());
           System.out.println(obj.getMostEconomicalBowlerIn2015());
            System.out.println(obj.getMostCatchTaker());
        }
    }

