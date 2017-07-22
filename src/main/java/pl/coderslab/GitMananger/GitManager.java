package pl.coderslab.GitMananger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.json.JSONArray;
import org.json.JSONException;


public class GitManager {
	
	//clones repository from given URL to localPath
	public static void cloneRepository(String remotePath, String localPath) throws InvalidRemoteException, TransportException, GitAPIException{
		Git.cloneRepository().setURI(remotePath)
        .setDirectory(new File(localPath)).call();
	}
	
	public static void fetchPullRequests(String login, String remoteRepoName, String pathOfRepoToBranch, String branchPrefix) throws MalformedURLException, JSONException, IOException{
		//fetches all pull requests via github API from given https://api.github.com/repos/LOGIN/REPO_NAME/issues"
		JSONArray jsons = new JSONArray(IOUtils.toString(new URL("https://api.github.com/repos/"+login+"/"+remoteRepoName+"/issues"), Charset.forName("UTF-8")));
		
		//test loop printing number of pull request and GitHub login where the pull came from
		for (int i = 0; i < jsons.length(); i++) {
			System.out.println(jsons.getJSONObject(i).get("number") + " " + jsons.getJSONObject(i).getJSONObject("user").get("login"));
		}
		
		int[] pullRequestIds = getIdsOfPullRequests(jsons);
		
		for (int i = 0; i < pullRequestIds.length; i++) {
			try {
				// executes git fetch from provided path after -C and creates a new branch for each pull request
				
				 Runtime.getRuntime().exec("git -C "+pathOfRepoToBranch+" fetch origin pull/"+pullRequestIds[i]+"/head:"+branchPrefix+pullRequestIds[i]);
				 System.out.println("branch tescik"+pullRequestIds[i]+ " created");
				 } catch (IOException e) {
				
				 e.printStackTrace();
				 }
			
		}
		
		
	}
	//creates an array with numbers(numbers != ids)  of pull requests from given JSONArray
	private static int[] getIdsOfPullRequests(JSONArray jsons) throws JSONException{
		int[] pullRequestIds = new int[jsons.length()];
		for (int i = 0; i < jsons.length(); i++) {
			pullRequestIds[i]=(int) jsons.getJSONObject(i).get("number");
		}
		return pullRequestIds;
		
	}
	
	

}
