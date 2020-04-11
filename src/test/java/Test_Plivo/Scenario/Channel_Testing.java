package Test_Plivo.Scenario;
import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import Test_Plivo.APITesting.Channel_PageGenrices;
import Test_Plivo.APITesting.ReadPropFile;
public class Channel_Testing {
	/**
	*@Purpose testing_StackAPI_Channels
	*@since apl 10, 2020 10:29:30 AM
	*@author manickavasahan
	*@return void
	*@TestCaseID N/A
	*@TestCaseLink N/A
	*@Todo completed
	 */
	@Test
	public void testing_StackAPI_channels() throws IOException, JSONException {
		
		//Reading Channel name and New channel Name from property file
		String channelName = ReadPropFile.getProValue("channelName");
	 	String newChannelName =ReadPropFile.getProValue("newChannelName");
		
	 	//Create a new Channel 
	 	Channel_PageGenrices.createChannel("Basepath_CreateChannel",channelName);
	 	
		//Join the newly created Channel
		Channel_PageGenrices.joinChannel("Basepath_joinChannel",channelName);
		
		//Rename the Channel
	 	Channel_PageGenrices.renameChannel("Basepath_RenameChannel",channelName,newChannelName);
	 	
		//List all Channels and Validate if the Channel name has changed successfully
		Channel_PageGenrices.channelValidation("Basepath_ListChannel",newChannelName);
		
		//Archive the Channel
		Channel_PageGenrices.archiveChannel("Basepath_ArchiveChannel",channelName);
		
		// Validate if the Channel is archived or not by unArchiving Channel
		Channel_PageGenrices.unarchiveChannel("Basepath_UnArchiveChannel",channelName);
		
	}
	
	
}


