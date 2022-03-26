import java.io.Serializable;

public class RecyclingCenter implements Serializable{

	private String code;
	private double tones;
	
	public RecyclingCenter(String code, double tones)
	{
		this.code = code;
		this.tones = tones;
	}

	public String getCode() {
		return code;
	}

	public double getTones() {
		return tones;
	}
}
