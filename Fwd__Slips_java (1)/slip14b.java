import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	String nm;

	public xyz()
	{

		try
		{


			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://stud.accdb");
		}
		catch(Exception e)
		{
			System.out.print("e");
		}
	}
	public void display()
	{
		try
		{

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			nm=br.readLine();



			sql="select  from studTable where name='"+nm+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next())
			{
				System.out.print("\n Rollno \t name \t marks");
				do
				{
					System.out.print("\t"+rs.getInt("rollno")+"\t"+rs.getString("name")+"\t"+rs.getInt("marks"));

				}while(rs.next());
			}
			else
			{
				System.out.print("data does not  found");
			}
		}
		catch(Exception e)
		{
			System.out.print("e");
		}
	}


}

class slip13a
{
	public static void main(String args[])
	{
		xyz x=new xyz();

		x.display();
	}

}
