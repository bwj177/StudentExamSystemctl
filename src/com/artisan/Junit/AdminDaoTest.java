package com.artisan.Junit;

import com.artisan.dao.*;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.artisan.model.Admin;

public class AdminDaoTest {

    private Connection con;
    private AdminDao adminDao;

    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/select_course", "root", "123456");
        adminDao = new AdminDao();


    }

    @After
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }

    @Test
    public void testLogin() throws SQLException {
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("123456");

        PreparedStatement ps = con.prepareStatement("select * from s_admin where name=? and password=?");
        ps.setString(1, admin.getName());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();

        Admin adminRst = null;
        if (rs.next()) {
            adminRst = new Admin();
            adminRst.setId(rs.getInt("id"));
            adminRst.setName(rs.getString("name"));
            adminRst.setPassword(rs.getString("password"));
            adminRst.setCreateDate(rs.getString("createDate"));
        }

        assertEquals("admin", adminRst.getName());
        assertEquals("123456", adminRst.getPassword());
    }

    @Test
    public void testEditPassword() throws SQLException {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("admin");
        admin.setPassword("123456");

        PreparedStatement ps1 = con.prepareStatement("select * from s_admin where id=? and password=?");
        ps1.setInt(1, admin.getId());
        ps1.setString(2, admin.getPassword());
        ResultSet rs1 = ps1.executeQuery();

        int id = 0;
        if (rs1.next()) {
            id = rs1.getInt("id");
        }

        PreparedStatement ps2 = con.prepareStatement("update s_admin set password = ? where id = ?");
        ps2.setString(1, "1234567");
        ps2.setInt(2, id);
        int rst = ps2.executeUpdate();

        assertEquals(1, rst);
    }

}