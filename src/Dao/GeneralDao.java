package Dao;

import Utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GeneralDao<GenericType> {
    Connection con = DatabaseUtil.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public abstract String getInsertQuerry();
    public abstract PreparedStatement prepareStatementForInsert(GenericType genericType, PreparedStatement pstmt) throws SQLException;
    public abstract String getUpdateQuerry();
    public abstract PreparedStatement prepareStatementForUpdate(GenericType genericType, PreparedStatement pstmt) throws SQLException;
    public abstract String getSearchQuerry();
    public abstract PreparedStatement prepareStatementForSearch(GenericType genericType, PreparedStatement pstmt, ResultSet rs) throws SQLException;

    public GenericType insert(GenericType genericType){
        String insertSQL = getInsertQuerry();
        try{
            pstmt = con.prepareStatement(insertSQL);
            pstmt=prepareStatementForInsert(genericType,pstmt);
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return genericType;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public GenericType update(GenericType genericType){
        String updateSQL = getUpdateQuerry();
        try {
            pstmt = con.prepareStatement(updateSQL);
            pstmt = prepareStatementForUpdate(genericType,pstmt);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return genericType;
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

    }

    public GenericType search(GenericType genericType){
        String searchSQL = getSearchQuerry();
        try {
            pstmt = con.prepareStatement(searchSQL);
            pstmt.setInt(1, student.getId());
            rs = pstmt.executeQuery();
            if (rs.next()) {

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

