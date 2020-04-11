package Test_Plivo.APITesting;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Channel_PageGenrices {

	static Response res ;
	static RequestSpecification req;

	/**
	 * 
	 * @param CreateChannel
	 * @throws IOException
	 */
	public static void callPost(String CreateChannel) throws IOException {
		req=RestAssured.given();
		req.baseUri(ReadPropFile.getProValue("BaseURI"));
		req.basePath(ReadPropFile.getProValue(CreateChannel));
		req.header("Content-Type", "application/json");

	}
	/**
	 * 
	 * @param CreateChannel
	 * @param ChannelName
	 * @throws IOException
	 * @throws JSONException
	 */
	public static void createChannel(String CreateChannel ,String ChannelName)  {

		try {
			String res_name = "name_normalized";
			String responsename ="";

			callPost(CreateChannel);
			
			res = req.queryParam("token", ReadPropFile.getProValue("accesstoken"))
					.queryParam("name", ChannelName).post();

			JSONObject jsonObj = new JSONObject(res.body().asString());
			responsename =	jsonObj.getJSONObject("channel").getString(res_name);
			if(res.getStatusCode() == 200 && responsename.equals(ChannelName)) {
				System.out.println("Status code ="+res.getStatusCode() +"newly craeted channel name  "+responsename);
			}else {

				System.out.println("error in response " + res.getBody().asString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}		

	}
	/**
	 * 
	 * @param joinChannel
	 * @param ChannelName
	 * @throws IOException
	 * @throws JSONException
	 */
	public static void joinChannel(String joinChannel ,String ChannelName) {

		try {
			callPost(joinChannel);

			res = req.queryParam("token", ReadPropFile.getProValue("accesstoken"))
					.queryParam("name", ChannelName).post();

			JSONObject jsonObj = new JSONObject(res.body().asString());
			String subtype =jsonObj.getJSONObject("channel").getJSONArray("members").getString(0);
			if(res.getStatusCode() == 200) {
				System.out.println("Status code ="+res.getStatusCode() +
						"\n Channel Name	:"+ChannelName +
						"\n User Joined newly created Channel	:"+subtype );
			}else {

				System.out.println("error in response " + res.getBody().asString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}		


	}
	/**
	 * 
	 * @param renameChannel
	 * @param ChannelName
	 * @param newChannelName
	 * @throws JSONException
	 * @throws IOException
	 */
	public static void renameChannel(String renameChannel ,String ChannelName , String newChannelName) {

		try {
			String responsename ="";

			callPost(renameChannel);

			res = req.queryParam("token", ReadPropFile.getProValue("accesstoken"))
					.queryParam("channel", ChannelName).queryParam("name", newChannelName).
					post();

			System.out.println(res.getBody().prettyPrint());

			JSONObject jsonObj = new JSONObject(res.body().asString());
			responsename =	jsonObj.getJSONObject("channel").getString("name_normalized");
			if(res.getStatusCode() == 200 && responsename.equals(newChannelName)) {
				System.out.println("Status code ="+res.getStatusCode() +"newly Renamed channel name  "+newChannelName);
			}else {

				System.out.println("error in response " + res.getBody().asString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 
	 * @param Basepath_ListChannel
	 * @param RenameChanel
	 * @throws IOException
	 * @throws JSONException
	 */
	public static void channelValidation(String Basepath_ListChannel, String RenameChanel) {
		try {
			ArrayList<String> ls = new ArrayList<String>();


			req=RestAssured.given();
			req.baseUri(ReadPropFile.getProValue("BaseURI"));
			req.basePath(ReadPropFile.getProValue(Basepath_ListChannel));
			res = req.queryParam("token", ReadPropFile.getProValue("accesstoken")).get();

			JSONObject jsonObj = new JSONObject(res.body().asString());
			if(jsonObj.has("channels")) {
				JSONArray jsnArr = jsonObj.getJSONArray("channels");

				if(jsnArr.isNull(0) || jsnArr.equals(null)) {
					System.out.println("Response empty");
				}
				else {
					int len	 = jsonObj.getJSONArray("channels").length();
					for(int i=0;i<=len-1;i++)
						ls.add(jsonObj.getJSONArray("channels").getJSONObject(i).getString("name")); 
					for(String rNameChannel : ls) {
						if(rNameChannel.equals(RenameChanel)) {
							System.out.println("All Channels are listed " +
									"\n Validation done  Channel name has changed successfully" +
									"\n Renamed Channel   :-" +rNameChannel);
						}

						}
					}
					System.out.println("All Channels are listed " +ls.toString());
				}
			
			else {
				System.out.println("error in response :  " + res.getBody().asString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param ArchiveChannel
	 * @param channelName
	 * @throws IOException
	 */
	public static void archiveChannel(String ArchiveChannel , String channelName) {

		try {
			callPost(ArchiveChannel);
			res = req.queryParam("token", ReadPropFile.getProValue("accesstoken"))
					.queryParam("name", channelName).post();

			JsonPath jp =res.jsonPath();
			String status = jp.getJsonObject("ok").toString();
			if(status.equals("true")) {
				System.out.println("Channel successfully Archived " +res.getBody().prettyPrint() );
			}else {
				System.out.println("Channel not  Archived " +res.getBody().prettyPrint());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param unArchiveChannel
	 * @param channelName
	 * @throws IOException
	 */
	public static void unarchiveChannel(String unArchiveChannel , String channelName) {

		try {
			callPost(unArchiveChannel);
			res = req.queryParam("token", ReadPropFile.getProValue("accesstoken"))
					.queryParam("name", channelName).post();

			JsonPath jp =res.jsonPath();
			String status = jp.getJsonObject("ok").toString();
			if(status.equals("true")) {
				System.out.println("Channel successfully unArchived " +res.getBody().prettyPrint() );
			}else {
				System.out.println("Channel not  Archived " +res.getBody().prettyPrint());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
