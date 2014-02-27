package MixMatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//does profileFive affect profile
//place 19 in others not catagories
//pairs 83 cant stude cause different drink
//!merc disappeared

//strat 1- fieldA == fieldA : unify
//strat 2- 4 closedFieldA = true : fieldA = (closedFieldA = false)
//strat 3- closedFieldA = fieldA : closedFieldBCD
//strat 4- fieldA != "" && fieldA != "" : closedFieldBCD
//strat 5- fieldABCD != "" : closedFieldABCD
public class MixMatchSolver
{
	class Profile
	{
		String fieldA = "";
		String fieldB = "";
		String fieldC = "";
		String fieldD = "";
		String[] allFieldA = {"19", "46", "54", "56", "83"};
		String[] allFieldB = {"chry", "kia", "merc", "saab", "stude"};
		String[] allFieldC = {"brandy", "cosmo", "lime", "mudslide", "shirley"};
		String[] allFieldD = {"aries", "capri", "leo", "libra", "scorpio"};

		boolean closedFieldAFlag = false;
		HashMap closedFieldA = new HashMap();
		boolean closedFieldBFlag = false;
		HashMap closedFieldB = new HashMap();
		boolean closedFieldCFlag = false;
		HashMap closedFieldC = new HashMap();
		boolean closedFieldDFlag = false;
		HashMap closedFieldD = new HashMap();
		
		Profile()
		{
			for (String a : allFieldA) {closedFieldA.put(a, false);}
			for (String b : allFieldB) {closedFieldB.put(b, false);}
			for (String c : allFieldC) {closedFieldC.put(c, false);}
			for (String d : allFieldD) {closedFieldD.put(d, false);}
		}
	}
	
	MixMatchSolver()
	{
		
	}
	
	void mergeProfiles(Profile p, Profile c)
	{
		if (c.fieldA == "" && p.fieldA != "") 
				{c.fieldA = p.fieldA;}
		if (c.fieldB == "" && p.fieldB != "") 
				{c.fieldB = p.fieldB;}
		if (c.fieldC == "" && p.fieldC != "") 
				{c.fieldC = p.fieldC;}
		if (c.fieldD == "" && p.fieldD != "") 
				{c.fieldD = p.fieldD;}
						
		if (c.closedFieldAFlag == false && 
				p.closedFieldAFlag == true)
				{c.closedFieldA = p.closedFieldA; p.closedFieldAFlag = true;}
		if (c.closedFieldBFlag == false && 
				p.closedFieldBFlag == true)
				{c.closedFieldB = p.closedFieldB; p.closedFieldBFlag = true;}
		if (c.closedFieldCFlag == false && 
				p.closedFieldCFlag == true)
				{c.closedFieldC = p.closedFieldC; p.closedFieldCFlag = true;}
		if (c.closedFieldDFlag == false && 
				 p.closedFieldDFlag == true)
				{c.closedFieldD = p.closedFieldD; p.closedFieldDFlag = true;}
	}
	
	String[] criteriaString = {"mudslide", "leo", "kia", "46", "cosmo"};
	ArrayList criteria = new ArrayList(Arrays.asList(criteriaString));
	void pickFive()
	{
		ArrayList valid = new ArrayList();
		
		String[] ages = {"19", "46", "54", "56", "83"};
		String[] cars = {"chry", "kia", "merc", "saab", "stude"};
		String[] drinks = {"brandy", "cosmo", "lime", "mudslide", "shirley"};
		String[] horoscopes = {"aries", "capri", "leo", "libra", "scorpio"};
		
		for (int n = 0; n < profileFive.size(); n++)
		{
			Profile p = (Profile) profileFive.get(n);
			for (int i = 0; i < criteria.size(); i++)
			{
				if (Arrays.asList(ages).contains(criteria.get(i)))
				{
					if ((p.fieldA == "") && ((Boolean) p.closedFieldA.get(criteria.get(i)) == false)) valid.add(criteria.get(i));
				}
				if (Arrays.asList(cars).contains(criteria.get(i)))
				{
					if ((p.fieldB == "") && ((Boolean) p.closedFieldB.get(criteria.get(i)) == false)) valid.add(criteria.get(i));
				}
				if (Arrays.asList(drinks).contains(criteria.get(i)))
				{
					if ((p.fieldC == "") && ((Boolean) p.closedFieldC.get(criteria.get(i)) == false)) valid.add(criteria.get(i));
				}
				if (Arrays.asList(horoscopes).contains(criteria.get(i)))
				{
					if ((p.fieldD == "") && ((Boolean) p.closedFieldD.get(criteria.get(i)) == false)) valid.add(criteria.get(i));
				}
			}
			if (valid.size() == 1)
			{
				if (Arrays.asList(ages).contains(valid.get(0)))
				{
					p.fieldA = (String) valid.get(0);
				}
				if (Arrays.asList(cars).contains(valid.get(0)))
				{
					p.fieldB = (String) valid.get(0);
				}
				if (Arrays.asList(drinks).contains(valid.get(0)))
				{
					p.fieldC = (String) valid.get(0);
				}
				if (Arrays.asList(horoscopes).contains(valid.get(0)))
				{
					p.fieldD = (String) valid.get(0);
				}
				criteria.remove(valid.get(0));
				finished(p);
				profileFive.remove(p); n--;
			}
		}
	}
	
   static ArrayList profileFive = new ArrayList();
	void pickFiveAlter(ArrayList profile)
	{
		ArrayList valid = new ArrayList();
		
		String[] ages = {"19", "46", "54", "56", "83"};
		String[] cars = {"chry", "kia", "merc", "saab", "stude"};
		String[] drinks = {"brandy", "cosmo", "lime", "mudslide", "shirley"};
		String[] horoscopes = {"aries", "capri", "leo", "libra", "scorpio"};
		
		for (int i = 0; i < criteria.size(); i++)
		{
			for (int n = 0; n < profileFive.size(); n++)
			{
				Profile p = (Profile) profileFive.get(n);
				
				if (Arrays.asList(ages).contains(criteria.get(i)))
				{
					if ((p.fieldA == "") && ((Boolean) p.closedFieldA.get(criteria.get(i)) == false)) valid.add(p);
				}
				if (Arrays.asList(cars).contains(criteria.get(i)))
				{
					if ((p.fieldB == "") && ((Boolean) p.closedFieldB.get(criteria.get(i)) == false)) valid.add(p);
				}
				if (Arrays.asList(drinks).contains(criteria.get(i)))
				{
					if ((p.fieldC == "") && ((Boolean) p.closedFieldC.get(criteria.get(i)) == false)) valid.add(p);
				}
				if (Arrays.asList(horoscopes).contains(criteria.get(i)))
				{
					if ((p.fieldD == "") && ((Boolean) p.closedFieldD.get(criteria.get(i)) == false)) valid.add(p);
				}	
			}
			if (valid.size() == 1)
			{
				Profile p = (Profile) valid.get(0);
				if (Arrays.asList(ages).contains(criteria.get(i)))
				{
					p.fieldA = (String) criteria.get(i);
				}
				if (Arrays.asList(cars).contains(valid.get(0)))
				{
					p.fieldB = (String) criteria.get(i);
				}
				if (Arrays.asList(drinks).contains(valid.get(0)))
				{
					p.fieldC = (String) criteria.get(i);
				}
				if (Arrays.asList(horoscopes).contains(valid.get(0)))
				{
					p.fieldD = (String) criteria.get(i);
				}
				criteria.remove(criteria.get(i));
				finished(p);
				profileFive.remove(p); i--;
			}
		}
	}
	
	void finishIt(ArrayList profile)
	{
		for (int n = 0; n < profile.size(); n++)
		{
			Profile p = (Profile) profile.get(n);
			
			if (!(p.fieldA != "" && p.fieldB != "" && p.fieldC != "" && p.fieldD != ""))
			{
				if (p.fieldA != "")
				{
					for (int i = n+1; i < profile.size(); i++)
					{
						Profile p2 = (Profile) profile.get(i);
						if (p2.fieldA != "")//if p age and p2 age filled than other values cannot match
						{
							if (p.fieldB != "") {p2.closedFieldB.put(p.fieldB, true); if (p2.fieldB != "") p.closedFieldB.put(p2.fieldB, true);}
							if (p.fieldC != "") {p2.closedFieldC.put(p.fieldC, true); if (p2.fieldC != "") p.closedFieldC.put(p2.fieldC, true);}
							if (p.fieldD != "") {p2.closedFieldD.put(p.fieldD, true); if (p2.fieldD != "") p.closedFieldD.put(p2.fieldD, true);}
							
							if (p2.fieldB != "") {p.closedFieldB.put(p2.fieldB, true); if (p.fieldB != "") p2.closedFieldB.put(p.fieldB, true);}
							if (p2.fieldC != "") {p.closedFieldC.put(p2.fieldC, true); if (p.fieldC != "") p2.closedFieldC.put(p.fieldC, true);}
							if (p2.fieldD != "") {p.closedFieldD.put(p2.fieldD, true); if (p.fieldD != "") p2.closedFieldD.put(p.fieldD, true);}
						}
					}
				}
				else 
				{
					for (Object key : p.closedFieldA.keySet())//!lime cannot share anything with lime
				{
					if ((boolean)p.closedFieldA.get(key))
					{
						for (int i = n+1; i < profile.size(); i++)
						{
							Profile p2 = (Profile) profile.get(i);
							if (p2.fieldA == (String) key)
							{
								if (p.fieldB != "") {p2.closedFieldB.put(p.fieldB, true); if (p2.fieldB != "") p.closedFieldB.put(p2.fieldB, true);}
								if (p.fieldC != "") {p2.closedFieldC.put(p.fieldC, true); if (p2.fieldC != "") p.closedFieldC.put(p2.fieldC, true);}
								if (p.fieldD != "") {p2.closedFieldD.put(p.fieldD, true); if (p2.fieldD != "") p.closedFieldD.put(p2.fieldD, true);}
								
								if (p2.fieldB != "") {p.closedFieldB.put(p2.fieldB, true); if (p.fieldB != "") p2.closedFieldB.put(p.fieldB, true);}
								if (p2.fieldC != "") {p.closedFieldC.put(p2.fieldC, true); if (p.fieldC != "") p2.closedFieldC.put(p.fieldC, true);}
								if (p2.fieldD != "") {p.closedFieldD.put(p2.fieldD, true); if (p.fieldD != "") p2.closedFieldD.put(p.fieldD, true);}
							}
						}
					}
				}
				}
				if (p.fieldB != "")
				{
					for (int i = n+1; i < profile.size(); i++)
					{
						Profile p2 = (Profile) profile.get(i);
						if (p2.fieldB != "")
						{
							if (p.fieldA != "") {p2.closedFieldA.put(p.fieldA, true); if (p2.fieldA != "") p.closedFieldA.put(p2.fieldA, true);}
							if (p.fieldC != "") {p2.closedFieldC.put(p.fieldC, true); if (p2.fieldC != "") p.closedFieldC.put(p2.fieldC, true);}
							if (p.fieldD != "") {p2.closedFieldD.put(p.fieldD, true); if (p2.fieldD != "") p.closedFieldD.put(p2.fieldD, true);}
							
							if (p2.fieldA != "") {p.closedFieldA.put(p2.fieldA, true); if (p.fieldA != "") p2.closedFieldA.put(p.fieldA, true);}
							if (p2.fieldC != "") {p.closedFieldC.put(p2.fieldC, true); if (p.fieldC != "") p2.closedFieldC.put(p.fieldC, true);}
							if (p2.fieldD != "") {p.closedFieldD.put(p2.fieldD, true); if (p.fieldD != "") p2.closedFieldD.put(p.fieldD, true);}
						}
					}
				}
				else
				{
					for (Object key : p.closedFieldB.keySet())
				{
					if ((boolean)p.closedFieldB.get(key))
					{
						for (int i = n+1; i < profile.size(); i++)
						{
							Profile p2 = (Profile) profile.get(i);
							if (p2.fieldB == (String) key)
							{
								if (p.fieldA != "") {p2.closedFieldA.put(p.fieldA, true); if (p2.fieldA != "") p.closedFieldA.put(p2.fieldA, true);}
								if (p.fieldC != "") {p2.closedFieldC.put(p.fieldC, true); if (p2.fieldC != "") p.closedFieldC.put(p2.fieldC, true);}
								if (p.fieldD != "") {p2.closedFieldD.put(p.fieldD, true); if (p2.fieldD != "") p.closedFieldD.put(p2.fieldD, true);}
								
								if (p2.fieldA != "") {p.closedFieldA.put(p2.fieldA, true); if (p.fieldA != "") p2.closedFieldA.put(p.fieldA, true);}
								if (p2.fieldC != "") {p.closedFieldC.put(p2.fieldC, true); if (p.fieldC != "") p2.closedFieldC.put(p.fieldC, true);}
								if (p2.fieldD != "") {p.closedFieldD.put(p2.fieldD, true); if (p.fieldD != "") p2.closedFieldD.put(p.fieldD, true);}
							}
						}
					}
				}
				}
				if (p.fieldC != "")
				{
					for (int i = n+1; i < profile.size(); i++)
					{
						Profile p2 = (Profile) profile.get(i);
						if (p2.fieldC != "")
						{
							if (p.fieldA != "") {p2.closedFieldA.put(p.fieldA, true); if (p2.fieldA != "") p.closedFieldA.put(p2.fieldA, true);}
							if (p.fieldB != "") {p2.closedFieldB.put(p.fieldB, true); if (p2.fieldB != "") p.closedFieldB.put(p2.fieldB, true);}
							if (p.fieldD != "") {p2.closedFieldD.put(p.fieldD, true); if (p2.fieldD != "") p.closedFieldD.put(p2.fieldD, true);}
							
							if (p2.fieldA != "") {p.closedFieldA.put(p2.fieldA, true); if (p.fieldA != "") p2.closedFieldA.put(p.fieldA, true);}
							if (p2.fieldB != "") {p.closedFieldB.put(p2.fieldB, true); if (p.fieldB != "") p2.closedFieldB.put(p.fieldB, true);}
							if (p2.fieldD != "") {p.closedFieldD.put(p2.fieldD, true); if (p.fieldD != "") p2.closedFieldD.put(p.fieldD, true);}
						}
					}
				}
				else
				{
					for (Object key : p.closedFieldC.keySet())
				{
					if ((boolean)p.closedFieldC.get(key))
					{
						for (int i = n+1; i < profile.size(); i++)
						{
							Profile p2 = (Profile) profile.get(i);
							if (p2.fieldC == (String) key)
							{
								if (p.fieldA != "") {p2.closedFieldA.put(p.fieldA, true); if (p2.fieldA != "") p.closedFieldA.put(p2.fieldA, true);}
								if (p.fieldB != "") {p2.closedFieldB.put(p.fieldB, true); if (p2.fieldB != "") p.closedFieldB.put(p2.fieldB, true);}
								if (p.fieldD != "") {p2.closedFieldD.put(p.fieldD, true); if (p2.fieldD != "") p.closedFieldD.put(p2.fieldD, true);}
								
								if (p2.fieldA != "") {p.closedFieldA.put(p2.fieldA, true); if (p.fieldA != "") p2.closedFieldA.put(p.fieldA, true);}
								if (p2.fieldB != "") {p.closedFieldB.put(p2.fieldB, true); if (p.fieldB != "") p2.closedFieldB.put(p.fieldB, true);}
								if (p2.fieldD != "") {p.closedFieldD.put(p2.fieldD, true); if (p.fieldD != "") p2.closedFieldD.put(p.fieldD, true);}
							}
						}
					}
				}
				}
				if (p.fieldD != "")
				{
					for (int i = n+1; i < profile.size(); i++)
					{
						Profile p2 = (Profile) profile.get(i);
						if (p2.fieldD != "")
						{
							if (p.fieldA != "") {p2.closedFieldA.put(p.fieldA, true); if (p2.fieldA != "") p.closedFieldA.put(p2.fieldA, true);}
							if (p.fieldB != "") {p2.closedFieldB.put(p.fieldB, true); if (p2.fieldB != "") p.closedFieldB.put(p2.fieldB, true);}
							if (p.fieldC != "") {p2.closedFieldC.put(p.fieldC, true); if (p2.fieldC != "") p.closedFieldC.put(p2.fieldC, true);}
							
							if (p2.fieldA != "") {p.closedFieldA.put(p2.fieldA, true); if (p.fieldA != "") p2.closedFieldA.put(p.fieldA, true);}
							if (p2.fieldB != "") {p.closedFieldB.put(p2.fieldB, true); if (p.fieldB != "") p2.closedFieldB.put(p.fieldB, true);}
							if (p2.fieldC != "") {p.closedFieldC.put(p2.fieldC, true); if (p.fieldC != "") p2.closedFieldC.put(p.fieldC, true);}
						}
					}
				}
				else
				{
					for (Object key : p.closedFieldD.keySet())
				{
					if ((boolean)p.closedFieldD.get(key))
					{
						for (int i = n+1; i < profile.size(); i++)
						{
							Profile p2 = (Profile) profile.get(i);
							if (p2.fieldD == (String) key)
							{
								if (p.fieldA != "") {p2.closedFieldA.put(p.fieldA, true); if (p2.fieldA != "") p.closedFieldA.put(p2.fieldA, true);}
								if (p.fieldB != "") {p2.closedFieldB.put(p.fieldB, true); if (p2.fieldB != "") p.closedFieldB.put(p2.fieldB, true);}
								if (p.fieldC != "") {p2.closedFieldC.put(p.fieldC, true); if (p2.fieldC != "") p.closedFieldC.put(p2.fieldC, true);}
								
								if (p2.fieldA != "") {p.closedFieldA.put(p2.fieldA, true); if (p.fieldA != "") p2.closedFieldA.put(p.fieldA, true);}
								if (p2.fieldB != "") {p.closedFieldB.put(p2.fieldB, true); if (p.fieldB != "") p2.closedFieldB.put(p.fieldB, true);}
								if (p2.fieldC != "") {p.closedFieldC.put(p2.fieldC, true); if (p.fieldC != "") p2.closedFieldC.put(p.fieldC, true);}
							}
						}
					}
				}
				}
			}
		}
	}
	
	void finishIt2()
	{
		for (int n = 0; n < profile.size(); n++)
		{
			Profile p = (Profile) profile.get(n);
			if (!(p.fieldA != "" && p.fieldB != "" && p.fieldC != "" && p.fieldD != ""))
			{
				int countAge = 0;
				int countCar = 0;
				int countDrink = 0;
				int countHoroscope = 0;
				Profile savAge = new Profile();
				Profile savCar = new Profile();
				Profile savDrink = new Profile();
				Profile savHoroscope = new Profile();
				for (int i = 0; i < profile.size(); i++)
				{
					Profile p2 = (Profile) profile.get(i);
					if (!(p2.fieldA != "" && p2.fieldB != "" && p2.fieldC != "" && p2.fieldD != "") && p!=p2)
					{
						if (p.fieldA!="" && (boolean)p2.closedFieldA.get(p.fieldA))
						{
							countAge++;
						}
						else savAge = p2;
						
						if (p.fieldB!="" && (boolean)p2.closedFieldB.get(p.fieldB))
						{
							countCar++;
						}
						else savCar = p2;
						
						if (p.fieldC!="" && (boolean)p2.closedFieldC.get(p.fieldC))
						{
							countDrink++;
						}
						else savDrink = p2;
						
						if (p.fieldD!="" && (boolean)p2.closedFieldD.get(p.fieldD))
						{
							countHoroscope++;
						}
						else savHoroscope = p2;
					}
				}
				int sub = 2;//for itself and potential match
				for (int i = 0; i < profile.size(); i++)
				{
					Profile p2 = (Profile) profile.get(i);
					if (p2.fieldA != "" && p2.fieldB != "" && p2.fieldC != "" && p2.fieldD != "")
					{
						sub++;
					}
				}
				if (countAge == profile.size()-sub) {mergeProfiles(p, savAge); profile.remove(p);n--;}
				else if (countCar == profile.size()-sub) {mergeProfiles(p, savCar); profile.remove(p);n--;}
				else if (countDrink == profile.size()-sub) {mergeProfiles(p, savDrink); profile.remove(p);n--;}
				else if (countHoroscope == profile.size()-sub) {mergeProfiles(p, savHoroscope); profile.remove(p);n--;}
			}
		}
	}
	
	//strat5
	void finished(Profile p)
	{
		if (p.fieldA != "" &&
			 p.fieldB != "" &&
			 p.fieldC != "" &&
			 p.fieldD != "")
		{
			for (Object check : profile)
			{
				Profile c = (Profile) check;
				if (c != p)
				{
					c.closedFieldA.put(p.fieldA, true);
					c.closedFieldB.put(p.fieldB, true);
					c.closedFieldC.put(p.fieldC, true);
					c.closedFieldD.put(p.fieldD, true);
				}
			}
		}
	}
	
	void finished2()
	{
		
		for (Object check : profile)
		{
			ArrayList valid = new ArrayList();
			
			Profile p = (Profile) check;
			for (Object key : p.closedFieldC.keySet())
			{
				if (!(Boolean) p.closedFieldC.get(key)) valid.add(key);//!lemon
			}
			if (valid.size() == 1) p.fieldA = (String) valid.get(0);
			
			
		}
	}
	
	void cancelOut()
	{
		for (Object check : profile)
		{
			Profile p = (Profile) check;
			
			int count = 0;
			String found = "";
			for (Object key : p.closedFieldA.keySet())
			{
				if ((boolean) p.closedFieldA.get((String) key))
				{
					count++;
				}
				else found = (String) key;
			}
			if (count == 4) p.fieldA = found;
			
			count = 0;
			found = "";
			for (Object key : p.closedFieldB.keySet())
			{
				if ((boolean) p.closedFieldB.get((String) key))
				{
					count++;
				}
				else found = (String) key;
			}
			if (count == 4) p.fieldB = found;
			
			count = 0;
			found = "";
			for (Object key : p.closedFieldC.keySet())
			{
				if ((boolean) p.closedFieldC.get((String) key))
				{
					count++;
				}
				else found = (String) key;
			}
			if (count == 4) p.fieldC = found;
			
			count = 0;
			found = "";
			for (Object key : p.closedFieldD.keySet())
			{
				if ((boolean) p.closedFieldD.get((String) key))
				{
					count++;
				}
				else found = (String) key;
			}
			if (count == 4) p.fieldD = found;
		}
	}
	
	//
	void testNotPairs(Profile p, Profile c)
	{
		boolean pass = false;
		for (Object key : p.closedFieldA.keySet())
		{
			if ((Boolean) p.closedFieldA.get(key) && (String) key == c.fieldA)
			{
				pass = true;
			}
		}
		for (Object key : p.closedFieldB.keySet())
		{
			if ((Boolean) p.closedFieldB.get(key) && (String) key == c.fieldB)
			{
				pass = true;
			}
		}
		for (Object key : p.closedFieldC.keySet())
		{
			if ((Boolean) p.closedFieldC.get(key) && (String) key == c.fieldC)
			{
				pass = true;
			}
		}
		for (Object key : p.closedFieldD.keySet())
		{
			if ((Boolean) p.closedFieldD.get(key) && (String) key == c.fieldD)
			{
				pass = true;
			}
		}
		if (pass)
		{
			if (c.fieldA != "") p.closedFieldA.put(c.fieldA, true);
			if (c.fieldB != "") p.closedFieldB.put(c.fieldB, true);
			if (c.fieldC != "") p.closedFieldC.put(c.fieldC, true);
			if (c.fieldD != "") p.closedFieldD.put(c.fieldD, true);
			
			if (p.fieldA != "") c.closedFieldA.put(p.fieldA, true);
			if (p.fieldB != "") c.closedFieldB.put(p.fieldB, true);
			if (p.fieldC != "") c.closedFieldC.put(p.fieldC, true);
			if (p.fieldD != "") c.closedFieldD.put(p.fieldD, true);
		}
	}
	
	Profile newProfile()
	{
		Profile p = new Profile();
		return p;
	}
	
	void editProfile(Profile p, String data)
	{	
		boolean notFlag = false;
		if (data.charAt(0) == '!') 
		{
			notFlag = true; 
			data = data.substring(1, data.length());//removes the !
		}
		
		if (Arrays.asList(p.allFieldA).contains(data))
		{
			if (!notFlag) p.fieldA = data;
			else {p.closedFieldA.put(data, true); p.closedFieldAFlag = true;}
		}
		if (Arrays.asList(p.allFieldB).contains(data))
		{
			if (!notFlag) p.fieldB = data;
			else {p.closedFieldB.put(data, true); p.closedFieldBFlag = true;}
		}
		if (Arrays.asList(p.allFieldC).contains(data))
		{
			if (!notFlag) p.fieldC = data;
			else {p.closedFieldC.put(data, true); p.closedFieldCFlag = true;}
		}
		if (Arrays.asList(p.allFieldD).contains(data))
		{
			if (!notFlag) p.fieldD = data;
			else {p.closedFieldD.put(data, true); p.closedFieldDFlag = true;}
		}
	}
	
	static ArrayList profile = new ArrayList();
	public static void main(String[] args)
	{
		MixMatchSolver test = new MixMatchSolver();
		
		String[] data = test.loadData();
		Profile p = null;
		for (int i = 0; i < data.length; i++)
		{
			if (i % 2 == 0)
			{
				p = test.newProfile();
				profile.add(p);
			}
			
			test.editProfile(p, data[i]);
			
			//Saves the first five profiles
			if (profile.size() == 5 && ((i+1) % 2) == 0) profileFive = new ArrayList(profile.subList(0, 4));
			
			if (profile.size() != 1 && ((i+1) % 2) == 0)//compares the 1st p with all the rest
			{
				for (Object check: profile)
				{
					Profile c = (Profile) check;
					if (p != c) 
					{
						test.testNotPairs(p, c);//????
						
						if ((p.fieldA == c.fieldA && p.fieldA != "") || 
							 (p.fieldB == c.fieldB && p.fieldB != "") || 
						    (p.fieldC == c.fieldC && p.fieldC != "") || 
						    (p.fieldD == c.fieldD && p.fieldD != "")) 
						{
							test.mergeProfiles(p, c);
							test.finished(c);
							profile.remove(p);
							break;
						}
					}
				}
			}
		}		
		test.print(profile);
		System.out.println("----------------------------------------");
		
		test.finishIt(profile);
		test.print(profile);
		System.out.println("----------------------------------------");
		
		test.cancelOut();
		test.print(profile);
		System.out.println("----------------------------------------");
		
		test.finishIt(profile);
		test.print(profile);
		System.out.println("----------------------------------------");
		
		test.finishIt2();
		test.print(profile);
		System.out.println("----------------------------------------");
		
		
		test.pickFive();
		test.print(profile);
		System.out.println("----------------------------------------");

		test.pickFiveAlter(profile);
		test.print(profile);
		System.out.println("----------------------------------------");
		
	}
	
	String center(String word, int length)
	{
		String finalWord = word;
		String space = " ";
		
		if (word.length() % 2 == 0)
		{
			if (length % 2 == 0)
			{
				int addNum = (length - word.length()) / 2;//x11x
				for (int i = 0; i < addNum; i++)
				{
					finalWord = space.concat(finalWord).concat(space);
				}
			}
			else
			{
				int addNum = ((length - word.length()) - 1) / 2;//xx11x
				finalWord = space.concat(finalWord);//put space afterwards if you want x11xx
				for (int i = 0; i < addNum; i++)
				{
					finalWord = space.concat(finalWord).concat(space);
				}
			}
		}
		else
		{
			if (length % 2 == 0)
			{
				int addNum = length - word.length();//xx1x
				finalWord = space.concat(finalWord);//put space afterwards if you want x1xx
				for (int i = 0; i < addNum; i++)
				{
					finalWord = space.concat(finalWord).concat(space);
				}
			}
			else
			{
				int addNum = (length - word.length()) / 2;//x1x
				for (int i = 0; i < addNum; i++)
				{
					finalWord = space.concat(finalWord).concat(space);
				}
			}
		}
		return finalWord;
	}
	
	void print(ArrayList profile)
	{
		System.out.println("   Age       Car      Drink   Horoscope");
		for (Object print : profile)
		{
			Profile p = (Profile) print;
			System.out.println("########################################");
			
			String line[] = {"", "", "", "", ""};
			
			if (p.fieldA == "") line[0] = line[0].concat("         #");
			else line[0] = line[0].concat(center(p.fieldA, 9) + "#");
			ArrayList allClosedAges = new ArrayList();
			for (Object key: p.closedFieldA.keySet())
			{
				if ((Boolean) p.closedFieldA.get(key) == true) allClosedAges.add("!" + (String) key);
			}
			for (int i = 0; i < allClosedAges.size(); i++)
			{
				line[i+1] = line[i+1].concat(center((String) allClosedAges.get(i), 9) + "#");
			}
			for (int i = allClosedAges.size()+1; i < 5; i++)
			{
				line[i] = line[i].concat("         #");
			}
			
			if (p.fieldB == "") line[0] = line[0].concat("         #");
			else line[0] = line[0].concat(center(p.fieldB, 9) + "#"); 
			ArrayList allClosedCars = new ArrayList();
			for (Object key: p.closedFieldB.keySet())
			{
				if ((Boolean) p.closedFieldB.get(key) == true) allClosedCars.add("!" + (String) key);
			}
			for (int i = 0; i < allClosedCars.size(); i++)
			{
				line[i+1] = line[i+1].concat(center((String) allClosedCars.get(i), 9) + "#");
			}
			for (int i = allClosedCars.size()+1; i < 5; i++)
			{
				line[i] = line[i].concat("         #");
			}
					
			if (p.fieldC == "") line[0] = line[0].concat("         #");
			else line[0] = line[0].concat(center(p.fieldC, 9) + "#");
			ArrayList allClosedDrinks = new ArrayList();
			for (Object key: p.closedFieldC.keySet())
			{
				if ((Boolean) p.closedFieldC.get(key) == true) allClosedDrinks.add("!" + (String) key);
			}
			for (int i = 0; i < allClosedDrinks.size(); i++)
			{
				line[i+1] = line[i+1].concat(center((String) allClosedDrinks.get(i), 9) + "#");
			}
			for (int i = allClosedDrinks.size()+1; i < 5; i++)
			{
				line[i] = line[i].concat("         #");
			}
			
			if (p.fieldD == "") line[0] = line[0].concat("         #");
			else line[0] = line[0].concat(center(p.fieldD, 9) + "#"); 
			ArrayList allClosedHoroscopes = new ArrayList();
			for (Object key: p.closedFieldD.keySet())
			{
				if ((Boolean) p.closedFieldD.get(key) == true) allClosedHoroscopes.add("!" + (String) key);
			}
			for (int i = 0; i < allClosedHoroscopes.size(); i++)
			{
				line[i+1] = line[i+1].concat(center((String) allClosedHoroscopes.get(i), 9) + "#");
			}
			for (int i = allClosedHoroscopes.size()+1; i < 5; i++)
			{
				line[i] = line[i].concat("         #");
			}
			
			for (String l : line)
			{
				if (!l.equalsIgnoreCase("         #         #         #         #")) System.out.println(l);
			}
		}
		System.out.println("########################################");
	}
	
	String[] loadData()
	{
		String[] data = 
		{
				"19", "scorpio",
				"leo","!lime",
				"54","!stude",
				"lime","stude",
				"brandy","!merc",
				"libra","!lime",
				"scorpio","!mudslide",
				"capri","brandy",
				"scorpio","chry",
				"83", "shirley",
				"shirley", "!saab",
				"56", "!capri"
		};
		return data;
	}
	
	/*
   		  The 19 year-old is the Scorpio. 
           The Leo doesn't drink lime rickeys. 
           The 54 year-old doesn't drive the Studebaker.
           The person who drinks lime rickeys drives the Studebaker.
           The person who drinks brandy sours doesn't drive the Mercedes.
           
           mud 2 !1345
           leo 3 !1245
           kia 5 !1234
           46  4
           cosmo 1 !45
           
           The 5 people were the person who drinks mudslides, the Leo, the driver of the Kia, 
           the 46 year-old, and the person who drinks cosmopolitans.
           		
           The Libra doesn't drink lime rickeys.
           The Scorpio doesn't drink mudslides.
           The Capricorn drinks brandy sours.
           The Scorpio drives the Chrysler.
           The 83 year-old drinks shirley temples.
           The person who drinks shirley temples doesn't drive the Saab.
           		
           The Aries is younger than the driver of the Saab.
           		
           The 56 year-old isn't the Capricorn.
           		//and the capricorn isnt 56, then again you search for both or either
 */
}
