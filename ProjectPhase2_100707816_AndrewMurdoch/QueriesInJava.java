import java.sql.*;
import java.util.Properties;

public class QueriesInJava {
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
            Statement st = conn.createStatement();
            String q = "INSERT INTO \"Movie\" " +
                       "VALUES (1003, 'Shrek', '2001-04-22', 7.8, 60000000, 500000000, 155)";
            //st.executeQuery(q);

            String q1 = "INSERT INTO \"Award\" " +
                        "VALUES (1003, 'Oscars', 'Best Movie')";
            //st.executeQuery(q1);

            String q3 = "INSERT INTO \"Festival\" " +
                    "VALUES (1003, 'Sundance Film Festival')";
            //st.executeQuery(q3);

            String q4 = "INSERT INTO \"Location\" " +
                    "VALUES (1003, 'Ottawa', 'Ontario', 'Canada')";
            //st.executeQuery(q4);

            String q5 = "INSERT INTO \"Tickets\" " +
                    "VALUES (1000, 1001, 'Cineplex', 14.99, '3d', '2020-12-25', '12:00')";
            //st.executeQuery(q5);

            String q6 = "INSERT INTO \"Quote\" " +
                    "VALUES (1003, 1003, 'Get out me swamp!')";
            //st.executeQuery(q6);

            String q7 = "INSERT INTO \"University\" " +
                    "VALUES ('Carelton', True, 'red/white', 30100)";
            //st.executeQuery(q7);

            String q8 = "INSERT INTO \"UniDepartment\" " +
                    "VALUES (1003 ,'Carelton', 'Arts', 10000, 'Arts Faculty')";
            //st.executeQuery(q8);

            String q9 = "INSERT INTO \"Actor\" " +
                    "VALUES (1003, 1000, 1003, 'Lucas Gomez', '2000-10-24', 'green')";
            //st.executeQuery(q9);

            String q10 = "INSERT INTO \"Director\" " +
                    "VALUES (1003, 1000, 1003, 'Cooper Reid', '2000')";
            //st.executeQuery(q10);

            String q11 = "INSERT INTO \"Type\" " +
                    "VALUES ('Drama', 'imitation of some action')";
            //st.executeQuery(q11);

            String q12 = "INSERT INTO \"ActsIn\" " +
                    "VALUES (1003, 1003)";
            //st.executeQuery(q12);

            String q13 = "INSERT INTO \"Awards\" " +
                    "VALUES (1003, 1003)";
            //st.executeQuery(q13);

            String q14 = "INSERT INTO \"DirectorsIn\" " +
                    "VALUES (1003, 1003)";
            //st.executeQuery(q14);

            String q15 = "INSERT INTO \"Festivals\" " +
                    "VALUES (1003, 1003)";
            //st.executeQuery(q15);

            String q16 = "INSERT INTO \"Genres\" " +
                    "VALUES ('Drama', 1003)";
            //st.executeQuery(q16);

            String q17 = "INSERT INTO \"TicketsForMovie\" " +
                    "VALUES (1000, 1003, 1000)";
            //st.executeQuery(q17);

            // Insert by creating statements in JDBC one tuple to each table in a movie database (pass parameters as variables).
            String q19 = "INSERT INTO \"Movie\" " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(q19);
            ps.setInt(1, 1004);
            ps.setString(2, "Shrek2");
            ps.setDate(3, java.sql.Date.valueOf("2013-09-04"));
            ps.setFloat(4, 7.8f);
            ps.setInt(5, 60000000);
            ps.setInt(6, 500000000);
            ps.setInt(7, 155);
            //ps.executeQuery();

            String q20 = "INSERT INTO \"Award\" " +
                    "VALUES (?,?,?)";

            PreparedStatement ps1 = conn.prepareStatement(q20);
            ps1.setInt(1, 1004);
            ps1.setString(2, "Oscars");
            ps1.setString(3, "Best Producer");
            //ps1.executeQuery();

            String q21 = "INSERT INTO \"Festival\" " +
                    "VALUES (?,?)";

            PreparedStatement ps2 = conn.prepareStatement(q21);
            ps2.setInt(1, 1004);
            ps2.setString(2, "Festival");
            //ps2.executeQuery();

            String q22 = "INSERT INTO \"Location\" " +
                    "VALUES (?,?,?,?)";

            PreparedStatement ps3 = conn.prepareStatement(q22);
            ps3.setInt(1, 1004);
            ps3.setString(2, "York");
            ps3.setString(3, "Ontario");
            ps3.setString(4, "Canada");
            //ps3.executeQuery();

            String q23 = "INSERT INTO \"Tickets\" " +
                    "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps4 = conn.prepareStatement(q23);
            ps4.setInt(1, 1001);
            ps4.setInt(2, 1003);
            ps4.setString(3, "Cineplex");
            ps4.setFloat(4, 14.99f);
            ps4.setString(5, "3d");
            ps4.setDate(6, java.sql.Date.valueOf("2020-09-04"));
            ps4.setTime(7, new Time(1567296000000L));
            //ps4.executeQuery();

            String q24 = "INSERT INTO \"Quote\" " +
                    "VALUES (?,?,?)";

            PreparedStatement ps5 = conn.prepareStatement(q24);
            ps5.setInt(1, 1004);
            ps5.setInt(2, 1003);
            ps5.setString(3, "Donkey!!!");
            //ps5.executeQuery();

            String q25 = "INSERT INTO \"University\" " +
                    "VALUES (?,?,?,?)";

            PreparedStatement ps6 = conn.prepareStatement(q25);
            ps6.setString(1, "McGill");
            ps6.setBoolean(2, true);
            ps6.setString(3, "orange");
            ps6.setInt(4, 40000);
            //ps6.executeQuery();

            String q26 = "INSERT INTO \"UniDepartment\" " +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement ps7 = conn.prepareStatement(q26);
            ps7.setInt(1, 1004);
            ps7.setString(2, "McGill");
            ps7.setString(3, "Health");
            ps7.setInt(4, 12000);
            ps7.setString(5, "Health Faculty");
            //ps7.executeQuery();

            String q27 = "INSERT INTO \"Actor\" " +
                    "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps8 = conn.prepareStatement(q27);
            ps8.setInt(1, 1004);
            ps8.setInt(2, 1000);
            ps8.setInt(3, 1003);
            ps8.setString(4, "David McGee");
            ps8.setDate(5, java.sql.Date.valueOf("2020-09-04"));
            ps8.setString(6, "blue");
            //ps8.executeQuery();

            String q28 = "INSERT INTO \"Director\" " +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement ps9 = conn.prepareStatement(q28);
            ps9.setInt(1, 1004);
            ps9.setInt(2, 1000);
            ps9.setInt(3, 1004);
            ps9.setString(4, "Micheal Bay");
            ps9.setInt(5, 2000);
            //ps9.executeQuery();

            String q29 = "INSERT INTO \"Type\" " +
                    "VALUES (?,?)";

            PreparedStatement ps10 = conn.prepareStatement(q29);
            ps10.setString(1, "Thriller");
            ps10.setString(2, "Thrilling");
            //ps10.executeQuery();

            String q30 = "INSERT INTO \"ActsIn\" " +
                    "VALUES (?,?)";

            PreparedStatement ps11 = conn.prepareStatement(q30);
            ps11.setInt(1, 1004);
            ps11.setInt(2, 1004);
            //ps11.executeQuery();

            String q31 = "INSERT INTO \"Awards\" " +
                    "VALUES (?,?)";

            PreparedStatement ps12 = conn.prepareStatement(q31);
            ps12.setInt(1, 1004);
            ps12.setInt(2, 1004);
            //ps12.executeQuery();

            String q32 = "INSERT INTO \"DirectorsIn\" " +
                    "VALUES (?,?)";

            PreparedStatement ps13 = conn.prepareStatement(q32);
            ps13.setInt(1, 1004);
            ps13.setInt(2, 1004);
            //ps13.executeQuery();

            String q33 = "INSERT INTO \"Festivals\" " +
                    "VALUES (?,?)";

            PreparedStatement ps14 = conn.prepareStatement(q33);
            ps14.setInt(1, 1004);
            ps14.setInt(2, 1004);
            //ps14.executeQuery();

            String q34 = "INSERT INTO \"Genres\" " +
                    "VALUES (?,?)";

            PreparedStatement ps15 = conn.prepareStatement(q34);
            ps15.setString(1, "Thriller");
            ps15.setInt(2, 1004);
            //ps15.executeQuery();

            String q35 = "INSERT INTO \"TicketsForMovie\" " +
                    "VALUES (?,?,?)";

            PreparedStatement ps16 = conn.prepareStatement(q35);
            ps16.setInt(1, 1000);
            ps16.setInt(2, 1002);
            ps16.setInt(3, 1000);
            //ps16.executeQuery();

            // Create statements in JDBC for 4 self-chosen queries from Labs 6 and 7
            String query = "select \"MovieID\"\n" +
                    "from \"DirectorsIn\" natural join \"Director\"\n" +
                    "where \"Name\" = 'David Lynch'";

            Statement st1 = conn.createStatement();
            ResultSet rs1 = st.executeQuery(query);


            while (rs1.next()) {
                int s1 = rs1.getInt("MovieID");
                System.out.println("(" + s1 + ")");
            }

            String query1 = "select *\n" +
                    "from \"Director\"\n" +
                    "where \"Name\" like ? or \"Name\" like ?";

            PreparedStatement st2 = conn.prepareStatement(query1);
            st2.setString(1, "D%");
            st2.setString(2, "A%");
            ResultSet rs2 = st2.executeQuery();

            while (rs2.next()) {
                int s1 = rs2.getInt("DirectorID");
                int s2 = rs2.getInt("LocationBirthID");
                int s3 = rs2.getInt("University");
                String s4 = rs2.getString("Name");
                int s5 = rs2.getInt("Year of Birth");
                System.out.println("(" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ", " + s5 + ")");
            }

            String query2 = "select \"MovieID\", \"Genre\"\n" +
                    "from (select \"MovieID\", date_part('year', age(\"DateOfBirth\")) as age, \"Genre\"\n" +
                    "from (select *\n" +
                    "from \"Movie\" natural join \"Genres\"\n" +
                    "where \"Genre\" = 'Comedy') as subq natural join \"ActsIn\" natural join \"Actor\") as subq1\n" +
                    "where \"age\" < ?";

            PreparedStatement st3 = conn.prepareStatement(query2);
            st3.setInt(1, 40);
            ResultSet rs3 = st3.executeQuery();

            while (rs3.next()) {
                int s1 = rs3.getInt("MovieID");
                String s2 = rs3.getString("Genre");
                System.out.println("(" + s1 + ", " + s2 + ")");
            }

            String query3 = "select Count(\"EyeColour\") as \"Number of Actors\"\n" +
                    "from \"Actor\"\n" +
                    "group by \"EyeColour\" having \"EyeColour\" = ?";

            PreparedStatement st4 = conn.prepareStatement(query3);
            st4.setString(1, "green");
            ResultSet rs4 = st4.executeQuery();

            while (rs4.next()) {
                int s1 = rs4.getInt("Number of Actors");
                System.out.println("(" + s1 + ")");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
