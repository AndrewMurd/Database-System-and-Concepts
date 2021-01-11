import java.sql.*;
import java.util.*;

public class Main {

    public static Connection connect(){
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:7777/MovieDatabase";

        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Andrew9449");

        try {
             conn = DriverManager.getConnection(url, props);
             System.out.println("Connected to " + url);

        }catch (Exception e) {
            System.out.println("Could not connect!");
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args){
        Connection conn = connect();

        try {
            // Insert by creating statements in JDBC one tuple to each table in a movie database (do not pass parameters as variables).
            String query = "INSERT INTO \"Award\" (\"AwardID\", \"Association\", \"Category\") VALUES\n" +
                            "\t(1003, 'Oscars','Best Movie'),\n";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {
                String movieTitle = rs.getString("Title");
                System.out.println("" + movieTitle);
            }

            rs.close();

            //Insert by creating statements in JDBC one tuple to each table in a movie database (pass parameters as variables).
            String query1 = "select * from movie where Title = ?";
            PreparedStatement ps = conn.prepareStatement(query1);

            ps.setString(1, "");

            ResultSet rs2 = ps.executeQuery();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
