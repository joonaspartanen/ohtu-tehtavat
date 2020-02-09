
package ohtu;

public class Player {

    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public int getGoals() {
        return this.goals;
    }

    public int getAssists() {
        return this.assists;
    }

    @Override
    public String toString() {
        String points =  this.goals + " + " + this.assists + " = " + (this.goals + this.assists);
        String result = String.format("%-22s%-6s%14s", this.name, this.team, points);
        //return this.name + "\t" + this.team + "\t" + this.goals + " + " + this.assists + " = "
        //        + (this.goals + this.assists);
        return result;
    }

}
