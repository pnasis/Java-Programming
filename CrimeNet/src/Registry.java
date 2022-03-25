import java.util.ArrayList;

public class Registry {

	private ArrayList<Communication> record = new ArrayList<>();
	private ArrayList<Suspect> suspects = new ArrayList<>();
	
	public ArrayList<Suspect> getSuspects() {
		return suspects;
	}

	public void setSuspects(ArrayList<Suspect> suspects) {
		this.suspects = suspects;
	}

	public void addSuspect(Suspect aSuspect)
	{
		suspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication)
	{
		int sus1 = -1;
		int sus2 = -1;
		int index = 0;
		for(Suspect s: suspects) {
			
			if(s.isNumInList(aCommunication.getNum1())) //checking if suspect's numbers contain Num1.
				sus1 = index;  //if true, we save the index of the Suspect.
			
			if(s.isNumInList(aCommunication.getNum2())) //checking if suspect's numbers contain Num2.
				sus2 = index;  //if true, we save the index of the Suspect.
			
			index++;
		}
		//We add in the first suspect's partners, the second one.
		suspects.get(sus1).addToPartners(suspects.get(sus2));
		//We add in the second suspect's partners, the first one.
		suspects.get(sus2).addToPartners(suspects.get(sus1));
		record.add(aCommunication); //We add the communication to the registry.
	}
	
	public Suspect getSuspectWithMostPartners()
	{
		int max=suspects.get(0).getPartners().size();
		Suspect susp = suspects.get(0);
		
		for(Suspect s: suspects)
		{
			if(max <= s.getPartners().size())
			{
				max = s.getPartners().size();
				susp = s;
			}
		}
		return susp;
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2)
	{
		int max=-1;
		PhoneCall most = (PhoneCall)record.get(0);
		for(Communication c: record)
		{
			if(c instanceof PhoneCall) {
				PhoneCall call=(PhoneCall)c;
				//If the numbers of the phone call are the same with the parameters:
				if(c.getNum1().equals(number1) && c.getNum2().equals(number2))
				{
					if(call.getDuration() > max)
					{
						max = call.getDuration();
						most = call;
					}
				}
			}
		}
		return most;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2)
	{
		ArrayList<SMS> sms = new ArrayList<>();
		
		for(Communication c: record)
		{
			if(c instanceof SMS)
			{
				SMS temp = (SMS) c;
				//If the numbers of the text message are the same with the parameters:
				if(c.getNum1().equals(number1) && c.getNum2().equals(number2))
				{
					if(temp.getMessage().contains("Bomb") || temp.getMessage().contains("Attack")
							|| temp.getMessage().contains("Explosives") || temp.getMessage().contains("Gun"))
					{
						sms.add(temp);
					}
				}
			}	
		}
		return sms;
	}
	
	public Suspect findSuspect(String number)
	{
		Suspect suspect = null;
		
		for(Suspect s: suspects)
		{
			if(s.isNumInList(number))
				suspect = s;
		}
		return suspect;
	}
}
