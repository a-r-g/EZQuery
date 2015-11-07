/* 
 * The MIT License
 *
 * Copyright 2015 Andrew Gjerness.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ezquery;

//import statements
import java.sql.*;

/**
 * Utility Class for EZQuery
 * Used to access database and perform queries
 * @author Andrew Gjerness
 */
public class Utilities {

    //fields
    private Connection conn = null; // Connection object

    /**
     * Open a MySQL DB connection where url, username, and password are
     * passed into the method
     * @return connection status
     */
    public String openDB(String url, String user, String pass) {
        String connStatus = null;

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            connStatus = "Unable to load driver.";
        }//catch

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            connStatus = "Error connecting to database: " + e.toString();
        }//catch

        if (conn != null) {
            connStatus = "Successfully connected to database";
        }

        return connStatus;
    }// openDB

    /**
     * Close the connection to the DB
     * @return the status of the database connection
     */
    public String closeDB() {
        String connStatus = null;
        try {
            if (conn != null) {
                conn.close();
            }
            conn = null;
        } catch (SQLException e) {
            connStatus = "Failed to close database connection: " + e;
        }//catch

        if (conn == null) {
            connStatus = "Successfully disconnected from database";
        }
        return connStatus;
    }// closeDB

    /**
     * Executes sql query
     * @param sql the sql query
     * @return returns the Result object created based on the query
     */
    public Result sqlQuery(String sql) {
        ResultSet rs = null;
        Statement stmt = null;
        String c = null;
        ResultSetMetaData mdata = null;
        int updates;
        //create and execute statement
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            mdata = rs.getMetaData();
            c = sql;
            rs.next();

        } catch (SQLException e) {
            c = "" + e;
        }//catch
        Result r = new Result(c, rs, mdata);

        return r;
    }//sql

    /**
     * Executes sql update query
     * @param sql the sql query
     * @return returns the Result object created based upon the query
     */
    public Result sqlUpdate(String sql) {
        int u = 0;
        Statement stmt = null;
        String c = null;
        //create and execute statement
        try {
            stmt = conn.createStatement();
            u = stmt.executeUpdate(sql);
            c = sql;

        } catch (SQLException e) {
            c = "" + e;
        }//catch
        Result r = new Result(c, u);

        return r;
    }//sqlUpdate

    /**
     * Accessor for connection object
     * @return the connection object
     */
    public Connection getConn() {
        return conn;
    }//getConn

    /**
     * Mutator for connection object
     * @param conn the connection object
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }//setConn
}// Utilities class
