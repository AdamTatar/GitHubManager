package pl.coderslab.GitMananger;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.json.JSONException;

public class Main {
	
	public static final String REMOTE_PATH_TO_COPY_FROM="https://github.com/arcyro/examRepo.git"; //github repo url
	public static final String LOCAL_PATH_TO_COPY_TO="/home/lukasz/testpaa";   // local adress where you want your repo to be cloned
	public static final String GITHUB_LOGIN = "LqLys";
	public static final String REPO_NAME = "jGitTest";
	public static final String REPO_TO_BRANCH = "/home/lukasz/sts/STSworkspace/jGitTest";
	public static final String BRANCH_PREFIX = "testBranch";
	
	public static void main(String[] args) {
		try {
			GitManager.cloneRepository(REMOTE_PATH_TO_COPY_FROM, LOCAL_PATH_TO_COPY_TO);
			System.out.println("repo cloned");
		} catch (GitAPIException e) {
			
			e.printStackTrace();
		}
		
		try {
			GitManager.fetchPullRequests(GITHUB_LOGIN, REPO_NAME, REPO_TO_BRANCH, BRANCH_PREFIX);
			System.out.println("pull requests grabbed, branches created");
		} catch (JSONException | IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
