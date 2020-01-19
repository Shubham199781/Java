package com.shubham.cliniqueManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDoctor {

	public void newEntry(Connection con, Statement stmt, BufferedReader br) throws Exception;

	public void update(Connection con, Statement stmt, BufferedReader br) throws IOException, SQLException;

	public void showTable(Connection con, Statement stmt) throws SQLException;

	public void showSpecificDetails(Connection con, Statement stmt, BufferedReader br) throws SQLException, IOException;

	public void delete(Connection con, Statement stmt, BufferedReader br) throws SQLException, IOException;

	public int options(BufferedReader br) throws NumberFormatException, IOException;

	public void manager(BufferedReader br, Connection con, Statement stmt) throws NumberFormatException, IOException, Exception;
}
