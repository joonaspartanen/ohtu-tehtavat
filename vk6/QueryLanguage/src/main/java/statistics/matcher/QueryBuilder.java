package statistics.matcher;

public class QueryBuilder {
  Matcher matcher;

  public QueryBuilder() {
    matcher = new All();
  }

  public Matcher build() {
    return matcher;
  }

  public QueryBuilder playsIn(String team) {
    this.matcher = new And(this.matcher, new PlaysIn(team));
    return this;
  }

  public QueryBuilder hasAtLeast(int value, String category) {
    this.matcher = new And(this.matcher, new HasAtLeast(value, category));
    return this;
  }

  public QueryBuilder hasFewerThan(int value, String category) {
    this.matcher = new And(this.matcher, new HasFewerThan(value, category));
    return this;
  }
}