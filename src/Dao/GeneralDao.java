package Dao;

import Utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao<GenericType> {
    Connection con = DatabaseUtil.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement stmt = null;
    private DepartmentDao departmentDao;

    public abstract String getInsertQuery();
    public abstract PreparedStatement prepareStatementForInsert(GenericType genericType, PreparedStatement pstmt) throws SQLException;
    public abstract String getUpdateQuery();
    public abstract PreparedStatement prepareStatementForUpdate(GenericType genericType, PreparedStatement pstmt) throws SQLException;
    public abstract String getSearchQuery();
    public abstract GenericType mapResultSetToGenericType(ResultSet rs) throws SQLException;
    public abstract String getDeleteQuery();
    public abstract GenericType deleteObj(GenericType genericType) throws SQLException;
    public abstract String getAllQuery();
    public abstract String getSearchByIdQuery();

    public GenericType insert(GenericType genericType){
        try{
            pstmt = con.prepareStatement(getInsertQuery());
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
        try {
            pstmt = con.prepareStatement(getUpdateQuery());
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

    public GenericType search(int id) {
        try {
            pstmt = con.prepareStatement(getSearchQuery());
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToGenericType(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public GenericType delete(int id, GenericType genericType) {
        try{
            pstmt= con.prepareStatement(getDeleteQuery());
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0) {
                return deleteObj(genericType);
            } else return null;
        } catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            try{
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<GenericType> getAll(){
        List<GenericType> genericTypes = new ArrayList<>();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(getAllQuery());
            while (rs.next()) {
                genericTypes.add(mapResultSetToGenericType(rs));
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        } finally{
            try{
                if(stmt != null) stmt.close();
                if(rs != null) rs.close();
                if(con != null) con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        } return genericTypes;
    }

    public List<GenericType> getObjectById(int id) throws SQLException {
        List<GenericType> genericTypes = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(getSearchByIdQuery());
            pstmt.setInt(1, id);
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    genericTypes.add(mapResultSetToGenericType(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
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
        return genericTypes;
    }
}