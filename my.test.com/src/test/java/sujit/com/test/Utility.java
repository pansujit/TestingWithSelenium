package sujit.com.test;
/* this class has the supporing code and utility need for comapare and convert the data*/

public class Utility {
	String expectedBackgroundColor="#bd362f";
	String expectedColor="#ffffff";
	String expectedFontSize="16px";
	String expectedFontFamily="\"Roboto Condensed\",\"Helvetica Neue\",Helvetica,Arial,sans-serif";
	String expectedFontSize1="12px";
	String expextedFontSizeTextBox= "16px";
	String expectedTextAlignTextBox="left";
	public String testColor ="#ff0000";
	public String toolTip_Msg="cette valeur est obligatoire";
	public String base_URL="https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr";
	
	public String rgbtoHex(String test){
		
		String[] hexValue =test.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}
	}


