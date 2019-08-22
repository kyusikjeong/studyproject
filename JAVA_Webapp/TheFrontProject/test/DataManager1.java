

import java.io.*;
import java.text.*;
import java.util.*;


public class DataManager1
{
	private ArrayList memberList = new ArrayList();

	public void setMemberList(ArrayList memberList)
	{
		this.memberList = memberList;
	}

	public ArrayList getMemberList()
	{
		return memberList;
	}

	public void readMember()
	{
		File dir = new File("data");
		String [] fileList = dir.list();
		Arrays.sort(fileList);
		String fileName = fileList[fileList.length - 1];

		File file = new File(dir, fileName);
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String readData = in.readLine();
			while (readData != null)
			{
				StringTokenizer st = new StringTokenizer(readData, "`");
				String num = st.nextToken();
				String name = st.nextToken();
				int age = Integer.parseInt(st.nextToken());
				String addr = st.nextToken();
				String data = st.nextToken();

				Person p;
				if(num.charAt(0) == 'S')
				{
					p = new Student(num, name, age, addr, data);
				}
				else if(num.charAt(0) == 'T')
				{
					p = new Teacher(num, name, age, addr, data);
				}
				else
				{
					readData = in.readLine();
					continue;
				}

				memberList.add(p);
				readData = in.readLine();
			}
			in.close();
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
	}

	public void writeMember()
	{
		File file = new File("data", createFileName());
		try
		{
			FileWriter wr = new FileWriter(file);
			PrintWriter pw = new PrintWriter(wr);

			for(int i=0; i<memberList.size(); i++)
			{
				Person p = (Person)memberList.get(i);

				String writeString = p.getNum() + "``" + p.getName() + "``" + p.getAge() + "``" + p.getAddr() + "``" ;
				if(p instanceof Student)
				{
					Student s = (Student)p;
					writeString = writeString + s.getGrade();
				}
				else if(p instanceof Teacher)
				{
					Teacher t = (Teacher)p;
					writeString = writeString + t.getSubject();
				}
				else
				{
					continue;
				}

				pw.println(writeString);
			}
			pw.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException");
		}
	}

	private String createFileName()
	{
		Date today = new Date(); 
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss"); 
		return "Member_" + date.format(today) + ".dbf";
	}
}