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

//Import statements
import java.sql.*;

/**
 * Result Class
 * Object that holds data relating to the database query
 * @author Andrew Gjerness
 */
public class Result {

    //fields
    private final String sql;
    private ResultSet rs;
    private ResultSetMetaData md;
    private int updates;

    /**
     * Three argument constructor for Querying data
     * @param s Sql string
     * @param r ResultSet
     * @param m ResultSetMetaData
     */
    public Result(String s, ResultSet r, ResultSetMetaData m) {
        sql = s; //set sql to s
        rs = r;  //set rs to r
        md = m;  //set md to m
    }//constructor

    /**
     * Two argument constructor for updating/modifying database
     * @param s Sql string
     * @param u Number of updates executed
     */
    public Result(String s, int u) {
        sql = s;     //set sql to s
        updates = u; // set updates to u
    }//constructor

    /**
     * Accessor for resultset
     * @return resultset
     */
    public ResultSet getResultSet() {
        return rs;
    }//getResultSet

    /**
     * Accessor for the sql query
     * @return sql query
     */
    public String getSql() {
        return sql;
    }//getSql

    /**
     * Accessor for metadata
     * @return metadata
     */
    public ResultSetMetaData getMetaData() {
        return md;
    }//getUpdates

    /**
     * Accessor for updates
     * @return number of sql updates executed
     */
    public int getUpdates() {
        return updates;
    }//getUpdates
}//Result
